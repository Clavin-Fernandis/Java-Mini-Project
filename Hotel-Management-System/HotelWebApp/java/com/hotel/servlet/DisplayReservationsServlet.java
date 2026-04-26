package com.hotel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.hotel.dao.ReservationDAO;
import com.hotel.model.Reservation;

public class DisplayReservationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        ReservationDAO dao = new ReservationDAO();

        List<Reservation> list =
            dao.getAllReservations();

        request.setAttribute("data", list);

        RequestDispatcher rd =
            request.getRequestDispatcher("reservationdisplay.jsp");

        rd.forward(request, response);
    }
}