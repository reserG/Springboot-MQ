package com.springbootredis.redis;

public interface KeyPrefix {

    public int expireSeconds() ;

    public String getPrefix() ;

}
