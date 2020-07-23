package com.troy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelayServlet
 */
public class DelayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  response.setContentType("text/html");
		  java.io.PrintWriter out = response.getWriter();
		  out.println("<html><head><title>TROY ACS</title></head><body>");
		  out.println("<h2> <center> Servlet to generate stuck thread, for 100Sec </center> </h2> <hr>");
		  out.flush();
		  try {
			Thread.sleep(100 * 1000);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
