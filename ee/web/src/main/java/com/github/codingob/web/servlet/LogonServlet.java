package com.github.codingob.web.servlet;

import com.github.codingob.web.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 *
 * @author codingob
 * @version 1.0.0
 * @since JDK1.8
 */
@WebServlet(name = "Logon", value = "/logon")
public class LogonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/logon.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String tip = "tip";
        AuthService.logon(req);
        if (req.getAttribute(tip) == null) {
            res.sendRedirect("login");
        } else {
            req.getRequestDispatcher("/jsp/logon.jsp").forward(req, res);
        }
    }
}
