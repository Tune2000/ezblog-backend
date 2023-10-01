package com.easy.handler.security;

import com.alibaba.fastjson.JSON;
import com.easy.domain.ResponseResult;
import com.easy.enums.AppHttpCodeEnum;
import com.easy.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AccessDeniedHandler 授权失败处理器
 */
//自定义授权失败的处理器
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //输出异常信息
        accessDeniedException.printStackTrace();
        ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);

        //使用spring提供的JSON工具类，把上一行的result转换成JSON，然后响应给前端。WebUtils是我们写的类
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}