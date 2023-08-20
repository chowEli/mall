package com.zyl.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、整合Mybatis-Plus
 * 		1）、导入依赖：直接在公共项目中引用mall-common
 * 			<dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.5.3.2</version>
 *         </dependency>
 * 		2）、配置
 * 			1、配置数据源
 * 				1）、导入数据库驱动：直接导入公共项目中mall-common
 * 			<dependency>
 * 			    <groupId>com.mysql</groupId>
 * 			    <artifactId>mysql-connector-j</artifactId>
 * 			    <version>8.0.33</version>
 * 			</dependency>
 * 				2）、在application.yml文件中配置数据源的相关信息
 * 			2、配置Mybatis-Plus
 * 				1）、使用@MapperScan指定扫描的mapper接口路径
 * 				2）、告诉Mybatis-Plus在application.yml文件中配置mapper映射文件的路径
 * 				3)、在application.yml文件中配置主键自增
 *
 */

@MapperScan("com.zyl.mall.product.dao")
@SpringBootApplication
public class MallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallProductApplication.class, args);
	}

}
