/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bms.controller;

import bms.DBConnection.DBConnection;
import bms.model.Transactions;
import java.sql.*;
import java.util.ArrayList;
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
    public static ArrayList<Transactions>getAllAmount(int pin) throws ClassNotFoundException, SQLException{
        String SQL = "Select * from Transactiondetails where type = 'deposit' and pin = '"+pin+"'";
        ArrayList<Transactions>toArray = new ArrayList<>();
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        while(rst.next()){
            toArray.add(new Transactions(rst.getInt("pin"), rst.getDate("date"), rst.getString("type"), rst.getDouble("amount")));
        }
        return toArray;
    }
}
