package com.lyc.dao;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * Created by lyc on 2017/11/28.
 * email 984006207@qq.com
 */
public class Handler implements HandlerMethodArgumentResolver {
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(FormModel.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println(parameter.getParameterName());

        FormModel formModel = parameter.getParameterAnnotation(FormModel.class);
        HttpServletRequest httpServletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        String a = httpServletRequest.getParameter(parameter.getParameterName());
        httpServletRequest.getSession().setAttribute("aaaa","aaaa");
        System.out.println("======"+a);
       /* Annotation[] a = parameter.getParameterAnnotations();
        for(Annotation annotation:a){
            System.out.println(a.getClass().getName());

        }*/

        int[] b = {1,2,3};
        return "12112434";
    }
}
