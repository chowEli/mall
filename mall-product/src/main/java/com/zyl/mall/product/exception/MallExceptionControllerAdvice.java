package com.zyl.mall.product.exception;

import com.zyl.common.exception.BizCodeEnum;
import com.zyl.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理类
 */
@Slf4j
//@ResponseBody
//@ControllerAdvice
@RestControllerAdvice
public class MallExceptionControllerAdvice {

//    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
            Map<String,String> map = new HashMap<>();
            result.getFieldErrors().forEach((item)-> {
                //获取字段名称
                String fieldName = item.getField();
                //获取校验返回信息
                String message = item.getDefaultMessage();
                map.put(fieldName, message);
            });
        log.error("数据校验出现问题{}，异常类型{}",e.getMessage(),e.getClass());
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMessage()).put("data",map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable t){
        return R.error(BizCodeEnum.UNKONW_EXCEPTION.getCode(), BizCodeEnum.UNKONW_EXCEPTION.getMessage());
    }
}
