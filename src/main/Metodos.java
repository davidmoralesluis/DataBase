package main;

import javax.swing.*;
import java.sql.*;

public class Metodos {


    public static void Connecting(){

        try {
            Connection conex = DriverManager.getConnection("jdbc:sqlite:"+"/Users/davidmoralesluis/Documents/DataBase/BDprogramacion.db");

            Statement dec = conex.createStatement();

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }


            if (conex!=null) {
                System.out.println("Conectado");
            }



        }catch (SQLException ex) {
            System.err.println("Error al conectar a la BD\n"+ex.getMessage());
        }


    }

    public static void insertar(){

        try {
            Connection conex = DriverManager.getConnection("jdbc:sqlite:"+"/Users/davidmoralesluis/Documents/DataBase/BDprogramacion.db");

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("INSERT INTO Legend(Nombre,Equipo,Dorsal) VALUES(?,?,?)");
            {
                pre.setString(1, JOptionPane.showInputDialog("name?"));
                pre.setString(2, JOptionPane.showInputDialog("Equipo?"));
                pre.setString(3, JOptionPane.showInputDialog("Dorsal?"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public static void update(){

        try {
            Connection conex = DriverManager.getConnection("jdbc:sqlite:"+"/Users/davidmoralesluis/Documents/DataBase/BDprogramacion.db");

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("UPDATE Legend SET(Nombre,Equipo,Dorsal) VALUES(?,?,?)");
            {
                pre.setString(1, JOptionPane.showInputDialog("name?"));
                pre.setString(2, JOptionPane.showInputDialog("Equipo?"));
                pre.setString(3, JOptionPane.showInputDialog("Dorsal?"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
