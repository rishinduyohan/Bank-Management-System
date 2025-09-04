/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bms.controller;
import bms.DBConnection.DBConnection;
import bms.model.Account;
import java.sql.*;
import bms.model.User;

public class UserController {
    public static boolean addUser(User user) throws ClassNotFoundException, SQLException{
        String SQL = "Insert into userdetails values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(SQL);
        stm.setObject(1, user.getName());
        stm.setObject(2, user.getFname());
        stm.setObject(3, user.getDob());
        stm.setObject(4, user.getGender());
        stm.setObject(5, user.getEmail());
        stm.setObject(6, user.getStatus());
        stm.setObject(7, user.getAddress());
        stm.setObject(8, user.getCity());
        stm.setObject(9, user.getState());
        stm.setObject(10, user.getPhone());
        stm.setObject(11, user.getNic());
        int res = stm.executeUpdate();
        return res>0;
    }
    public static boolean addAccount(Account account) throws ClassNotFoundException, SQLException{
        String SQL = "Insert into accountdetails values (?,?,?,?,?)";
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(SQL);
        stm.setObject(1, account.getNic());
        stm.setObject(2, account.getAccType());
        stm.setObject(3, account.getCardNumber());
        stm.setObject(4, account.getPin());
        stm.setObject(5, account.getServices());
        int res = stm.executeUpdate();
        return res>0;
    }
}
