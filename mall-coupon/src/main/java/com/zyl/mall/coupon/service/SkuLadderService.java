package com.zyl.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.common.utils.PageUtils;
import com.zyl.mall.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 20:04:22
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

