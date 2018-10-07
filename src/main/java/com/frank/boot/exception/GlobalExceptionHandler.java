package com.frank.boot.exception;

import com.frank.boot.domain.system.ResultData;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.frank.boot.utils.SysContent.ERROR_CODE;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultData exceptionHandler(Exception e) {
        ResultData resultData = new ResultData();
        if(e instanceof NullPointerException ){
            resultData.setMsg("空指针异常");
            e.printStackTrace();
        }else if(e instanceof ArrayIndexOutOfBoundsException){
            resultData.setMsg("数组下标越界异常:"+e.getMessage());
            e.printStackTrace();
        }else if(e instanceof DuplicateKeyException ){
            resultData.setMsg("不允许重复添加数据");
        }else if(e instanceof SystemException){
        	resultData.setMsg(e.getMessage());
        }else{
        	e.printStackTrace();
            resultData.setMsg("发生未知错误！"+e.getLocalizedMessage());
        }
        // 异常打印便于排错
        resultData.setCode(ERROR_CODE);
        resultData.setSuccess(false);
        return resultData;
    }
}
