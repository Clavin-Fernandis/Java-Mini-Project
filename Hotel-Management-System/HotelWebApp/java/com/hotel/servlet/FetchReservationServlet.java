package com.hotel.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.hotel.dao.ReservationDAO;
import com.hotel.model.Reservation;

public class FetchReservationServlet extends HttpServlet{

protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException,IOException{

int id = Integer.parseInt(request.getParameter("id"));

ReservationDAO dao = new ReservationDAO();

Reservation r = dao.getReservationById(id);

request.setAttribute("data", r);

RequestDispatcher rd =
request.getRequestDispatcher("reservationdelete.jsp");

rd.forward(request, response);

}
}