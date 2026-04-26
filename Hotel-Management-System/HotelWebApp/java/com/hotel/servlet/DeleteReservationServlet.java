package com.hotel.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.hotel.dao.ReservationDAO;

public class DeleteReservationServlet extends HttpServlet{

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException,IOException{

int id=Integer.parseInt(
request.getParameter("id"));

ReservationDAO dao=new ReservationDAO();

dao.deleteReservation(id);

response.sendRedirect("index.jsp");

}
}