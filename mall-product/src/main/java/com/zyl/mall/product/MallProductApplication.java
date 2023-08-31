package com.zyl.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
 * 2、配置Mybatis-Plus
 * 		1）、使用@MapperScan指定扫描的mapper接口路径
 * 		2）、告诉Mybatis-Plus在application.yml文件中配置mapper映射文件的路径
 * 		3)、在application.yml文件中配置主键自增
 *
 *
 *3、JSR303校验
 *		1）、给Bean添加校验注解：import javax.validation.constraints，并定义自己的message提示
 *		2）、开启校验功能@Valid
 *		   	效果：校验错误以后会有默认的响应
 *		3）、给校验的bean后面紧跟一个BindingResult，就可以获取到校验的结果
 *		4）、分组校验(多场景的复杂校验)
 *			1>、@NotBlank( message="品牌名不能为空",groups = {AddGroup.class,UpdateGroup.class})
 *			给校验注解标注什么情况需要进行校验
 *			2>、使用@Validated(AddGroup.class) 替换 @Valid，这样就可以指定分组
 *			3>、默认没有指定分组的校验注解例如@NotNull，在controller指定分组校验的情况下不生效（第2步）
 *		5）、自定义校验
 *			1>、编写一个自定义的校验注解
 *			2>、编写一个自定义的校验器
 *			3>、关联自定义的校验器和自定义校验注解
 *
 *
 *
 *4、统一的异常处理
 * @ControllerAdvice
 * 		1）、编写异常处理类，使用@ControllerAdvice
 * 		2）、使用@ExceptionHandle标注方法可以处理的异常
 *
 *
 */

//开启naocs注册发现
@EnableDiscoveryClient
@MapperScan("com.zyl.mall.product.dao")
@SpringBootApplication
public class MallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallProductApplication.class, args);
	}

}
