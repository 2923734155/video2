package com.wwd.video.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

@ControllerAdvice
//增强控制器：全局的异常处理类，
@ResponseBody
public class CommonException {
    //    针对那个异常的异常处理器
    @ExceptionHandler(ConstraintViolationException.class)

    public JsonResult constraintViolationException(ConstraintViolationException ex){
//验证不通过的信息
//处置异常 iterator迭代器
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();

        String message =null;
        if (iterator.hasNext()){
//            取出异常
            message = iterator.next().getMessage();
            System.out.println(message);

        }
        return new JsonResult(0,0,message);
    }

}
