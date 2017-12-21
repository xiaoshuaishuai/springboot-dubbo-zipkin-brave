package com.github.xiao.spring.boot.zipkin.dubbo.customer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/demoServlet/*", description = "测试brave收集servlet请求数据")
public class DemoServlet extends HttpServlet {
	/**  
	*/
	private static final long serialVersionUID = 4104455800568517107L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>hello zipkin...</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
