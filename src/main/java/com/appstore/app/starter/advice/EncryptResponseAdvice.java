package com.appstore.app.starter.advice;

import com.appstore.app.starter.anno.Encrypt;
import com.appstore.app.starter.config.EncryptProperties;
import com.appstore.app.starter.model.R;
import com.appstore.app.starter.utils.AESUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;

/**
 * @author ljz
 * 接口加密
 */
@EnableConfigurationProperties(EncryptProperties.class)
@RestControllerAdvice
public class EncryptResponseAdvice implements ResponseBodyAdvice<Object> {
    private ObjectMapper om = new ObjectMapper();
    @Resource
    EncryptProperties encryptProperties;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (encryptProperties.isGlobal()) {
            return true;
        }
        return returnType.hasMethodAnnotation(Encrypt.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        byte[] keyBytes = encryptProperties.getKey().getBytes();
        try {
            if (body != null) {
                return R.ok(AESUtils.encrypt("返回成功".getBytes(), keyBytes), AESUtils.encrypt(om.writeValueAsBytes(body), keyBytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error("未知错误");
    }
}