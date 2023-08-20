package com.zyl.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.common.utils.PageUtils;
import com.zyl.mall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 20:09:26
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

