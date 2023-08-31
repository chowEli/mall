package com.zyl.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1、想要远程调用别的服务
 *  1）、引入open-feign的依赖
 *  2）、编写一个接口，告诉springCloud这个接口需要远程调用服务使用@FeignClient("mall-coupon“)，注解里面是需要调用的远程服务
 *  3）、接口中定义要调用的方法，一一对应原方法的签名，每一个方法都是调用远程服务的哪一个方法
 *  4）、启动类开启远程调用服务@EnableFeignClients(basePackages = "com.zyl.mall.member.feign")，basePackages参数扫描所有@FeignClient注解的包路径
 */

@EnableFeignClients(basePackages = "com.zyl.mall.member.feign") //开启远程调用服务
@EnableDiscoveryClient //开启服务注册与发现
@SpringBootApplication
public class MallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMemberApplication.class, args);
    }

}
