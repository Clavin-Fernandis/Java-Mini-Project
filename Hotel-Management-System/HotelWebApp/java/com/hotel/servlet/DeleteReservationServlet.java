package com.hotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.ReservationDAO;

public class DeleteReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            // Prevent negative or zero ID
            if (id <= 0) {
                response.sendRedirect(
                        "reservationdelete.jsp?msg=invalid");
                return;
            }

            ReservationDAO dao =
                    new ReservationDAO();

            boolean status =
                    dao.deleteReservation(id);

            if (status)
                response.sendRedirect(
                 "reservationdelete.jsp?msg=success");
            else
                response.sendRedirect(
                 "reservationdelete.jsp?msg=fail");

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
              "reservationdelete.jsp?msg=error");
        }
    }
}