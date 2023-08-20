package com.zyl.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.common.utils.PageUtils;
import com.zyl.mall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 19:58:48
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

