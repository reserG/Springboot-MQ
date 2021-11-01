package com.springbootredis.redis;

public class DemoKey extends BasePrefix{
    private DemoKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    private DemoKey(String prefix) {
        super(prefix);
    }
    public static DemoKey hasExSeconds = new DemoKey(60 * 15,"demo");
    public static DemoKey noHasExSeconds = new DemoKey("demo");

}
