package com.hotel.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.hotel.dao.ReservationDAO;

public class ReportServlet extends HttpServlet{

protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException,IOException{

ReservationDAO dao=new ReservationDAO();

double revenue=dao.getRevenue();

request.setAttribute("rev", revenue);

RequestDispatcher rd=
request.getRequestDispatcher("reports.jsp");

rd.forward(request,response);

}
}