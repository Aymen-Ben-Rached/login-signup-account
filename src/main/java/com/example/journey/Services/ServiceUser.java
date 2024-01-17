package com.example.journey.Services;

import com.example.journey.Entities.User;
import com.example.journey.Utils.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceUser implements IService<User>{
    private Connection con = DataSource.getInstance().getCon();
    private Statement ste;

    public ServiceUser() {
        try {
            ste = con.createStatement();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean validateLogin(String email, String password) {
        String verifyLogin = "SELECT count(1) FROM `user` WHERE `email` = '"+email+"' AND `password` = '"+password+ "';";
        try{

            ResultSet queryResult = ste.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(User user) throws SQLException {
        String sql = "INSERT INTO User (id, firstname , lastname, email , password) VALUES (NULL, '"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getEmail()+"', '"+user.getPwd()+"');  ";
        ste.executeUpdate(sql);
        System.out.println("User Ajouté !");
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "UPDATE User SET email = '"+user.getEmail()+ "', firstname = '" +user.getFirstName()+"', lastname = '"+user.getLastName()+"', password = '"+ user.getPwd()+"' WHERE id = "+1;
        ste.executeUpdate(sql);
        System.out.println("MAJ");
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public ArrayList<User> readAll() throws SQLException {
        return null;
    }

    @Override
    public User get(int id) throws SQLException {
        return null;
    }
}
