package com.www.acorn.interceptor;

import com.www.acorn.exception.TokenRuntimeException;
import com.www.acorn.mapper.MyUserMapper;
import com.www.acorn.tool.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MyUserMapper userMapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1、从请求头中获取token
        String token = request.getHeader("token");

        // 2、判断 token 是否存在
        if (token == null ||"".equals(token)) {
            System.out.println("未登录");
            // 这里可以自定义 抛出 token 异常
            throw new TokenRuntimeException("未登录");
        }

        // 3、解析token
        Claims claim = jwtUtils.getClaimsByToken(token);

        if (null == claim) {
            System.out.println("token 解析错误");
            // 这里可以自定义 抛出 token 异常
            throw  new TokenRuntimeException("token 解析错误");
        }

        // 4、判断 token 是否过期
        Date expiration = claim.getExpiration();
        boolean tokenExpired = jwtUtils.isTokenExpired(expiration);
        if (tokenExpired) {
            System.out.println("token已过期，请重新登录");
            // 这里可以自定义 抛出 token 异常
            throw new TokenRuntimeException("token已过期，请重新登录");
        }

        // 5、 从 token 中获取用户信息
        String subject = claim.getSubject();

        // 6、去数据库中匹配 id 是否存在
        List<Map> userId = userMapper.findUserId(subject);
//        List<Map> userId =new ArrayList<>();

        if (userId.isEmpty()) {
            System.out.println("用户不存在");
            // 这里可以自定义 抛出 token 异常
            throw new TokenRuntimeException("用户不存在");
        }

        // 7、成功后 设置想设置的属性，比如员工姓名
        request.setAttribute("userId", subject);



        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
