package com.bmsmart.spring.boot.springboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 编码拦截器
 *
 * @param
 * @author XiaYaLing
 * @date 2018/4/24
 * @return
 */

/**
 * 处理全站乱码问题
 *
 * @param
 * @author XiaYaLing
 * @date 2018/4/26
 * @return
 */
@WebFilter(filterName = "characterEncodingFilter", urlPatterns = "/*")
@Slf4j
public class CharacterEncodingFilter implements Filter {
    private String charset = "UTF-8"; //默认编码设置为 UTF-8

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String charset = filterConfig.getInitParameter("characterEncoding");
        if (charset != null && !charset.equals("")) {
            this.charset = charset;
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding(charset); //只能处理post方式的请求乱码
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=" + charset);

        chain.doFilter(new CharacterEncodingHttpServletRequest(request), response);
    }

    /**
     * 使用包装设计模式处理get方式的请求乱码
     */
    class CharacterEncodingHttpServletRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;

        public CharacterEncodingHttpServletRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String value = request.getParameter(name);
            if (!"get".equalsIgnoreCase(request.getMethod())) { //如果是非get方法,直接返回
                return value;
            }
            if (value == null) {
                return null;
            }
            try {
                return value = new String(value.getBytes("iso8859-1"), request.getCharacterEncoding());
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void destroy() {
    }

}