package mybatis.Filter;

import Utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){
        System.out.println("初始化过滤器");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        String RequestURI = req.getRequestURI();// 获取请求的URI

        if(RequestURI.contains("login")){
            chain.doFilter(request,response);
        }//判断是否是登录请求，如果是就直接放行

        String token = req.getHeader("token");// 获取请求头中的令牌

        if(token== null||token.isEmpty()){
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return ;
        }//判断令牌是否存在

        try{
            JwtUtils.parseToken(token);
            chain.doFilter(request,response);
        }catch (Exception e){
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }//解析令牌是否合法

        chain.doFilter(request,response);//放行

    }
    @Override
    public void destroy(){
        System.out.println("过滤器销毁");
    }
}
