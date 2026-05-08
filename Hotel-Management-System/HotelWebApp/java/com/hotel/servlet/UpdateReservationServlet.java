package com.hotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.ReservationDAO;
import com.hotel.model.Reservation;

public class UpdateReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            // Prevent negative or zero ID
            if (id <= 0) {
                response.sendRedirect(
                        "reservationupdate.jsp?msg=invalid");
                return;
            }

            Reservation r = new Reservation();

            r.setReservationID(id);
            r.setCustomerName(
                    request.getParameter("name"));
            r.setRoomNumber(
                    request.getParameter("room"));
            r.setCheckIn(
                    request.getParameter("checkin"));
            r.setCheckOut(
                    request.getParameter("checkout"));
            r.setTotalAmount(
                    Double.parseDouble(
                    request.getParameter("amount")));

            ReservationDAO dao =
                    new ReservationDAO();

            boolean status =
                    dao.updateReservation(r);

            if (status)
                response.sendRedirect(
                 "reservationupdate.jsp?msg=success");
            else
                response.sendRedirect(
                 "reservationupdate.jsp?msg=fail");

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
              "reservationupdate.jsp?msg=error");
        }
    }
}