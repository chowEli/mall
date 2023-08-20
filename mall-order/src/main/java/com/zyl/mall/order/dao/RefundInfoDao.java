package com.zyl.mall.order.dao;

import com.zyl.mall.order.entity.RefundInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 19:58:48
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {
	
}
