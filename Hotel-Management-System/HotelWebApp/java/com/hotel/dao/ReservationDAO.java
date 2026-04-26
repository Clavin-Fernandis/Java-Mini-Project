package com.hotel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hotel.model.Reservation;
import com.hotel.util.DBConnection;

public class ReservationDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Add Reservation
    public boolean addReservation(Reservation r) {
        boolean status = false;

        try {
            con = DBConnection.getConnection();

            String sql = "insert into Reservations values(?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, r.getReservationID());
            ps.setString(2, r.getCustomerName());
            ps.setString(3, r.getRoomNumber());
            ps.setString(4, r.getCheckIn());
            ps.setString(5, r.getCheckOut());
            ps.setDouble(6, r.getTotalAmount());

            int i = ps.executeUpdate();

            if(i > 0)
                status = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Display All Reservations
    public List<Reservation> getAllReservations() {

        List<Reservation> list = new ArrayList<>();

        try {
            con = DBConnection.getConnection();

            ps = con.prepareStatement("select * from Reservations");

            rs = ps.executeQuery();

            while(rs.next()) {

                Reservation r = new Reservation();

                r.setReservationID(rs.getInt(1));
                r.setCustomerName(rs.getString(2));
                r.setRoomNumber(rs.getString(3));
                r.setCheckIn(rs.getString(4));
                r.setCheckOut(rs.getString(5));
                r.setTotalAmount(rs.getDouble(6));

                list.add(r);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public boolean updateReservation(Reservation r){

        boolean status=false;

        try{
            con=DBConnection.getConnection();

            String sql="update Reservations set CustomerName=?, RoomNumber=?, CheckIn=?, CheckOut=?, TotalAmount=? where ReservationID=?";

            ps=con.prepareStatement(sql);

            ps.setString(1,r.getCustomerName());
            ps.setString(2,r.getRoomNumber());
            ps.setString(3,r.getCheckIn());
            ps.setString(4,r.getCheckOut());
            ps.setDouble(5,r.getTotalAmount());
            ps.setInt(6,r.getReservationID());

            int i=ps.executeUpdate();

            if(i>0)
                status=true;

        }catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }
    public boolean deleteReservation(int id){

        boolean status=false;

        try{
            con=DBConnection.getConnection();

            ps=con.prepareStatement(
            "delete from Reservations where ReservationID=?");

            ps.setInt(1,id);

            int i=ps.executeUpdate();

            if(i>0)
                status=true;

        }catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }
    public double getRevenue(){

        double total=0;

        try{
            con=DBConnection.getConnection();

            ps=con.prepareStatement(
            "select sum(TotalAmount) from Reservations");

            rs=ps.executeQuery();

            if(rs.next())
                total=rs.getDouble(1);

        }catch(Exception e){
            e.printStackTrace();
        }

        return total;
    }
    public List<Reservation> getReservationsByDate(String from, String to){

        List<Reservation> list=new ArrayList<>();

        try{
            con=DBConnection.getConnection();

            ps=con.prepareStatement(
            "select * from Reservations where CheckIn>=? and CheckOut<=?");

            ps.setString(1, from);
            ps.setString(2, to);

            rs=ps.executeQuery();

            while(rs.next()){

                Reservation r=new Reservation();

                r.setReservationID(rs.getInt(1));
                r.setCustomerName(rs.getString(2));
                r.setRoomNumber(rs.getString(3));
                r.setCheckIn(rs.getString(4));
                r.setCheckOut(rs.getString(5));
                r.setTotalAmount(rs.getDouble(6));

                list.add(r);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    public double getRevenueByDate(String from,String to){

        double total=0;

        try{
            con=DBConnection.getConnection();

            ps=con.prepareStatement(
            "select sum(TotalAmount) from Reservations where CheckIn>=? and CheckOut<=?");

            ps.setString(1,from);
            ps.setString(2,to);

            rs=ps.executeQuery();

            if(rs.next())
                total=rs.getDouble(1);

        }catch(Exception e){
            e.printStackTrace();
        }

        return total;
    }
    public String getMostBookedRoom(){

        String room="No Data";

        try{
            con=DBConnection.getConnection();

            ps=con.prepareStatement(
            "select RoomNumber from Reservations group by RoomNumber order by count(*) desc limit 1");

            rs=ps.executeQuery();

            if(rs.next())
                room=rs.getString(1);

        }catch(Exception e){
            e.printStackTrace();
        }

        return room;
    }
}