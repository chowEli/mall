package com.zyl.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.common.utils.PageUtils;
import com.zyl.mall.coupon.entity.SeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 20:04:22
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

