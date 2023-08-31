package com.zyl.common.exception;

/**
 * 错误码和错误信息定义类
 *
 * 1.错误码定义规则为 5 为数字
 * 2.前两位表示业务场景，最后三位表示错误码。例如: 100001。10:通用 001:系统未知异常
 * 3.维护错误码后需要维护错误描述，将他们定义为枚举形式错误码列表:
 * 10: 通用
 *      001:参数格式校验
 * 11: 商品
 * 12: 订单
 * 13: 购物车
 * 14: 物流
 */
public enum BizCodeEnum {

    UNKONW_EXCEPTION(10000,"未知异常"),
    VALID_EXCEPTION(10001,"参数格式校验");

    private int code;
    private String message;

    BizCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
