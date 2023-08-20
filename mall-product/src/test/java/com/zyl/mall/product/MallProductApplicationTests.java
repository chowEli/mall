package com.zyl.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyl.mall.product.entity.BrandEntity;
import com.zyl.mall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
class MallProductApplicationTests {

	@Autowired
	BrandService brandService;


	@Test
	void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setName("huawei");
//		brandService.save(brandEntity);
//		System.out.println("保存成功。。。");

//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("华为");
//
//		brandService.updateById(brandEntity);
//		System.out.println("修改成功。。。");

		List<BrandEntity> brands = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
		brands.forEach((item)->{
			System.out.println(item);
		});

	}

}
