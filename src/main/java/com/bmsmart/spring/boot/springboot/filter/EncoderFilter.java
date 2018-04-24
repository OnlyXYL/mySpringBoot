package com.bmsmart.spring.boot.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 编码拦截器
 *
 * @param
 * @author XiaYaLing
 * @date 2018/4/24
 * @return
 */
@WebFilter(filterName = "encoderFilter", urlPatterns = "/*")
public class EncoderFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resposne, FilterChain filter)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("sessionId\n" + req.getSession().getId());
        System.out.println(req.getRemoteAddr() + "设定编码");
        request.setCharacterEncoding("UTF-8");
        filter.doFilter(request, resposne);
    }

    @Override
    public void init(FilterConfig filter) throws ServletException {
        System.out.println("画面初期化");
    }
}