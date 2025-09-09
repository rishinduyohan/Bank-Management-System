/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bms.controller;

import bms.DBConnection.DBConnection;
import bms.model.Account;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author acer
 */
public class AccountController {
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
    public static Account getAccount(String cardnumber,int pin) throws ClassNotFoundException, SQLException{
        String SQL = "Select * from accountdetails where cardnumber='"+cardnumber+"' and pin='"+pin+"'";
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet res = stm.executeQuery(SQL);
        if(res.next()){
            String nic = res.getString("nic");
            String accType = res.getString("accountType");
            String Services  = res.getString("services");
            return new Account(nic, accType, cardnumber, pin, Services);
        }
        return null;
    }
    public static Account getAccount(int pin) throws ClassNotFoundException, SQLException{
        String SQL = "Select * from accountdetails where pin='"+pin+"'";
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet res = stm.executeQuery(SQL);
        if(res.next()){
            String cardnumber = res.getString("cardNumber");
            String nic = res.getString("nic");
            String accType = res.getString("accountType");
            String Services  = res.getString("services");
            return new Account(nic, accType, cardnumber, pin, Services);
        }
        return null;
    }
    public static boolean updatePIN(Account acc,int pin) throws ClassNotFoundException, SQLException{
        int oldPin = acc.getPin();
        String SQL = "Update accountdetails set pin='"+pin+"' where pin='"+oldPin+"'";
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        return stm.executeUpdate(SQL)>0;
    }
}
