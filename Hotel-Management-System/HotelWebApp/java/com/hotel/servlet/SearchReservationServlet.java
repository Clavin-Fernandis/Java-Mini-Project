package com.hotel.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import com.hotel.dao.ReservationDAO;
import com.hotel.model.Reservation;

public class SearchReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        ReservationDAO dao = new ReservationDAO();

        List<Reservation> list =
                dao.searchReservations(keyword);

        request.setAttribute("data", list);

        RequestDispatcher rd =
                request.getRequestDispatcher("reservationdisplay.jsp");

        rd.forward(request, response);
    }
}