package com.zyl.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.common.utils.PageUtils;
import com.zyl.mall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 20:22:19
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

