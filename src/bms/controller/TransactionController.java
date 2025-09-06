/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bms.controller;

import bms.DBConnection.DBConnection;
import bms.model.Transactions;
import java.sql.*;
/**
 *
 * @author acer
 */
public class TransactionController {
    public static boolean depositAmount(Transactions deposit) throws ClassNotFoundException, SQLException{
        String SQL = "Insert into Transactiondetails values (?,?,?,?)";
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(SQL);
        stm.setObject(1, deposit.getPin());
        stm.setObject(2, deposit.getDate());
        stm.setObject(3, deposit.getType());
        stm.setObject(4, deposit.getAmount());
        int res = stm.executeUpdate();
        return res>0;
    }
}
