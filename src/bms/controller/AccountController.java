/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bms.controller;

import bms.DBConnection.DBConnection;
import bms.model.Account;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
