package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符串统一设置为utf-8
 */
public class EncodingFilter implements Filter {

    public EncodingFilter (){
        System.out.println("filter构造方法……");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化……");
    }

    /**
     * 对所有页面进行拦截，进行字符串转化
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");//将所有请求设置为utf-8
        servletResponse.setContentType("text/html;charset=utf-8");//相应报文设置为utf-8
        filterChain.doFilter(servletRequest,servletResponse);//拦截
    }

    @Override
    public void destroy() {
        System.out.println("销毁……");
    }
}
