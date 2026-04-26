package com.hotel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.hotel.dao.ReservationDAO;
import com.hotel.model.Reservation;

public class ReportCriteriaServlet extends HttpServlet{

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException,IOException{

String from=request.getParameter("fromdate");
String to=request.getParameter("todate");

ReservationDAO dao=new ReservationDAO();

List<Reservation> list=
dao.getReservationsByDate(from,to);

double revenue=
dao.getRevenueByDate(from,to);

String room=
dao.getMostBookedRoom();

request.setAttribute("data",list);
request.setAttribute("rev",revenue);
request.setAttribute("room",room);

RequestDispatcher rd=
request.getRequestDispatcher("report_result.jsp");

rd.forward(request,response);

}
}