package com.zyl.mall.coupon.dao;

import com.zyl.mall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 20:04:22
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
