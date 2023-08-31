package com.zyl.mall.thirdparty;


import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 使用OSS
 * 1、引入oss-start
 * 2、配置key、endpoit相关信息
 * 3、使用OSSClient进行相关操作
 */
@SpringBootTest
class MallThirdPartyApplicationTests {


	//这里报错的话，需要在dependencyManagement中配置aliyun-spring-boot-dependencies
	@Autowired
	OSSClient ossClient;


	@Test
	public void test() throws Exception {

//        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-chengdu.aliyuncs.com";
//        // 填写RAM用户的访问密钥（AccessKey ID和AccessKey Secret）。
//        String accessKeyId = "LTAI5tQovvNT47zweNJx9Zdx";
//        String accessKeySecret = "eYhFAtzrQbw5aiCdSqlYe6l202kO2S";
//
		String bucketName = "mall-zyl-zj";
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


		// 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
		String objectName = "bbbb.jpg";
		// 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
		// 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
		String filePath = "E:\\地址\\新办\\南明区四方通讯店\\微信图片_20230405204154.jpg";

		InputStream inputStream = new FileInputStream(filePath);
		ossClient.putObject(bucketName,objectName,inputStream);


		System.out.println("上传成功");
	}

	@Test
	void contextLoads() {

	}

}
