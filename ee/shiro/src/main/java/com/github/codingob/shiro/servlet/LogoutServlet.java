package com.github.codingob.shiro.servlet;

import com.github.codingob.shiro.util.AccountUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@WebServlet(name = "Logout", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        AccountUtils.logout(req, res);
    }
}
