package main;

import javax.swing.*;
import java.io.File;
import java.sql.*;

public class Metodos {


    public static void Connecting(){
        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
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
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public static void update(){

        try {
            Connection conex = DriverManager.getConnection("jdbc:sqlite:"+"/Users/davidmoralesluis/Documents/DataBase/BDprogramacion.db");

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("UPDATE Legend SET Nombre=?,Equipo=?,Dorsal=? WHERE ID=?");
            {
                pre.setString(4, JOptionPane.showInputDialog("ID??"));
                pre.setString(1, JOptionPane.showInputDialog("Intro Nombre"));
                pre.setString(2, JOptionPane.showInputDialog("Intro Equipo"));
                pre.setString(3, JOptionPane.showInputDialog("Intro Dorsal"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public static void borrar(){

        try {
            Connection conex = DriverManager.getConnection("jdbc:sqlite:"+"/Users/davidmoralesluis/Documents/DataBase/BDprogramacion.db");

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("DELETE FROM Legend WHERE ID=?");
            {
                pre.setString(1, JOptionPane.showInputDialog("ID??"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
