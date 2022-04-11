package com.www.acorn.advice;

import com.www.acorn.dto.UniversalityDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 用来处理全局的异常
     * @param e
     * @param response
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    UniversalityDto handleControllerException (Throwable e, HttpServletResponse response, HttpServletRequest request){
        String contentType =request.getContentType();
        System.out.println(contentType);

        UniversalityDto uld = new UniversalityDto();
        Map map=new HashMap<String,String>();

        uld.setCode(500);
        uld.setData(map);
        uld.setMsg("请求异常");
        uld.setSucceedFlag(false);

        return  uld;

    }

    /**
     * 处理@Validated参数校验失败异常
     * @param exception 异常类
     * @return 响应
     */
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Result exceptionHandler(MethodArgumentNotValidException exception){
//        BindingResult result = exception.getBindingResult();
//        StringBuilder stringBuilder = new StringBuilder();
//        if (result.hasErrors()) {
//            List<ObjectError> errors = result.getAllErrors();
//            if (errors != null) {
//                errors.forEach(p -> {
//                    FieldError fieldError = (FieldError) p;
//                    log.warn("Bad Request Parameters: dto entity [{}],field [{}],message [{}]",fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
//                    stringBuilder.append(fieldError.getDefaultMessage());
//                });
//            }
//        }
//        return ResultUtil.validatedException(stringBuilder.toString());
//    }



}
