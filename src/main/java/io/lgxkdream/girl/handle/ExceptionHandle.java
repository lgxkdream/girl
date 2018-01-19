package io.lgxkdream.girl.handle;

import io.lgxkdream.girl.domain.Result;
import io.lgxkdream.girl.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        Result<Object> result = new Result<>();
        if(e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            result.setCode(girlException.getCode());
            result.setMsg(girlException.getMessage());
            result.setData(null);
            return result;
        }
        LOGGER.error("【系统异常】", e);
        result.setCode(500);
        result.setMsg("未知错误");
        result.setData(null);
        return result;
    }

}
