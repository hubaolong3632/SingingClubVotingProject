package com.example.singingclubvotingproject.Except;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import utio.UtioCode.Result;
import utio.UtioCode.ResultCode;

@ControllerAdvice  //这个类用于集中处理所有错误
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Result Exception(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
        return Result.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR,"发生了错误-- 状态："+e.getMessage());
    }


}
