package com.zyl.mall.member.feign;

import com.zyl.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是一个声明式的远程调用
 */
@FeignClient("mall-coupon")  //注意要写要远程调用服务的名称
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R coupons();


}
