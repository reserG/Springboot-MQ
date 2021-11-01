package com.springbootredis.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.springbootredis.redis.DemoKey;
import com.springbootredis.redis.RedisService;
import com.springbootredis.redis.Userkey;
import com.springbootredis.utils.BloomFliter;
import com.springbootredis.utils.BloomFliterUtil;
import com.springbootredis.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/test")
public class TestController {

    BloomFliterUtil<String> bloomFliterUtil = new BloomFliterUtil<>(
            (Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8).putString(from, Charsets.UTF_8), 150000, 0.00001);
    @Autowired
    private BloomFliter bloomFliter;
    @Autowired
    private SnowFlakeUtil snowFlakeUtil;
    @Autowired
    RedisService redisService;

    @ResponseBody
    @RequestMapping(value = "/addKey", method = RequestMethod.GET)
    public void redisBloomFilterSetKey() {
        //List<String> allResourceId = redisBloomFilter.getAllResourceId();
        String id = "";
        for (int i = 0; i < 2; i++) {
//            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            id = snowFlakeUtil.nextId();
            System.out.println("id:" + id);
            redisService.set(DemoKey.hasExSeconds,id,id);
            //将所有的资源id放入到布隆过滤中器
            bloomFliter.addByBloomFilter(bloomFliterUtil, "bloom",id);
            System.out.println(bloomFliter.includeByBloomFilter(bloomFliterUtil,"bloom",id));
        }
        System.out.println("add key success");
        //return new ResponseResult(ResponseEnum.SUCCESS);
    }

    @ResponseBody
    @RequestMapping(value = "/getKey", method = RequestMethod.GET)
    public void redisBloomFilterGetKey(@RequestParam("key") String key) {
//        System.out.println( "key " + bloomFliter.includeByBloomFilter(bloomFliterUtil,"bloom",key));

        boolean mightContain = bloomFliter.includeByBloomFilter(bloomFliterUtil, "bloom", key);
        if (!mightContain) {
            System.out.println("错误!不存在Key : " + mightContain);
            // return new QueryResult<>(ResCenterEnum.RESOURCE_EXSIT,"");
        } else{
            System.out.println("存在Key " + key + " value : " + redisService.get(DemoKey.hasExSeconds,key,String.class));

        }
        // return new ResponseResult(ResponseEnum.SUCCESS);
    }


}
