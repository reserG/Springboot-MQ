package com.springbootredis.config;//package com.springbootalldemo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationProperties(prefix="es")
//public class ElasticSearchConfig {
////*#Es地址
////es.hostName=127.0.0.1
////
////#Es端口号
////es.transport=9300
////
////#配置es的集群名称，默认是elasticsearch，es会自动发现在同一网段下的es，如果在同一网段下有多个集群，就可以用这个属性来区分不同的集群
////es.clusterName=elasticsearch
//// */
//
//    public String getHostName() {
//        return hostName;
//    }
//
//    public void setHostName(String hostName) {
//        this.hostName = hostName;
//    }
//
//    public int getTransport() {
//        return transport;
//    }
//
//    public void setTransport(int transport) {
//        this.transport = transport;
//    }
//
//    public String getClusterName() {
//        return clusterName;
//    }
//
//    public void setClusterName(String clusterName) {
//        this.clusterName = clusterName;
//    }
//
//    private String hostName;
//    private int transport;
//    private String clusterName;
//
//    @Override
//    public String toString() {
//        return "ElasticSearchConfig{" +
//                "hostName='" + hostName + '\'' +
//                ", transport=" + transport +
//                ", clusterName='" + clusterName + '\'' +
//                '}';
//    }
//}
