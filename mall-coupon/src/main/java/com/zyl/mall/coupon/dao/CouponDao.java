package com.zyl.mall.coupon.dao;

import com.zyl.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 20:04:22
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
