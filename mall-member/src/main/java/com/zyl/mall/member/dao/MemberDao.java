package com.zyl.mall.member.dao;

import com.zyl.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author chowEli
 * @email chow.eli.zj@gmail.com
 * @date 2023-08-20 20:09:26
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
