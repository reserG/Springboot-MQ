package com.springbootmq;


import com.springbootmq.controller.TestController;
import com.springbootmq.entry.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Ttttest {
    @Autowired
    TestController mycont;

//    @Autowired
//    TestDao testDao;
    @Test
    public void print(){
        System.out.printf("elasticSearchConfig   "  );
    }

//    @Test
//    public void cglibProxy(){
//       CGlibtest cGlibtest = new CGlibtest();
//       TestDao cglibProxy = (TestDao) cGlibtest.createCGlib(testDao);
//       cglibProxy.method();
//    }

    @Autowired

//    @Test
//    public void jdkProxy(){
//        TestDD testDD = new TestDDImp();
//        MyJDKProxy myJDKProxy = new MyJDKProxy();
//        TestDD jdkProxy = (TestDD) myJDKProxy.creatProxyObj(testDD);
//        jdkProxy.test();
//    }

    @Test
    public void getBBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:BeanXml/TestBean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.getUserName());
    }
    @Test
    public  void sendMSG(){
        mycont.sendDireMSG("123");
    }
}
