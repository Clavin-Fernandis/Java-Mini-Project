package com.hotel.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.hotel.dao.ReservationDAO;
import com.hotel.model.Reservation;

public class UpdateReservationServlet extends HttpServlet{

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException,IOException{

Reservation r=new Reservation();

r.setReservationID(Integer.parseInt(request.getParameter("id")));
r.setCustomerName(request.getParameter("name"));
r.setRoomNumber(request.getParameter("room"));
r.setCheckIn(request.getParameter("checkin"));
r.setCheckOut(request.getParameter("checkout"));
r.setTotalAmount(Double.parseDouble(request.getParameter("amount")));

ReservationDAO dao=new ReservationDAO();

dao.updateReservation(r);

response.sendRedirect("index.jsp");

}
}