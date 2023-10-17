package com.example.singingclubvotingproject.z_interceptor;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utio.UtioClass.JwtUtil;
import utio.UtioCode.Result;
import utio.UtioCode.ResultCode;
import utio.UtioY;


public class AccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        String password = request.getParameter("password");
//        System.out.println("传输的密钥:"+password);
//        System.out.println("步入拦截");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            // 如果是OPTIONS请求，则返回false
            System.out.println("跨域请求判断");
            return true;
        }

        // 在请求处理之前进行拦截处理
        // 获取请求的 URL
        String Authorization = request.getHeader("Authorization"); //获取请求密钥
//        System.out.println(Authorization);  // 判断是否已登录

    if(UtioY.JWT_PAnalysis(Authorization)==null) {
        response.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型
        response.getWriter().println(UtioY.JSON(Result.failure(ResultCode.LoginNO,"登入失败失效，请重新登入")));
        return false;
    }


        // 如果已登录，则继续进行请求处理
        return true;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        System.out.println("------请求处理之后---------");
        // 在请求处理之后进行拦截处理，但是在视图被渲染之前

//        logFileService.addLogFile("日志保存",request); //日志保存





    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println("------请求拦截 视图渲染之后---------");

        // 在请求处理之后进行拦截处理，且在视图被渲染之后
    }
}

//             如果未登录，重定向到登录页
//            response.sendRedirect("/no");
