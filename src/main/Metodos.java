package main;

import javax.swing.*;
import java.sql.*;

public class Metodos {

    public static void Connecting(){
        Connection cona;
        String url = "/Users/davidmoralesluis/Documents/DataBase/BDprogramacion.db";

        try {
            cona = DriverManager.getConnection("jdbc:sqlite:"+url);

            Statement dec = cona.createStatement();

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }



            if (cona!=null) {
                System.out.println("Conectado");
            }


            String insertar = "INSERT INTO Legend(Nombre,Equipo,Dorsal) VALUES(?,?,?)";

            PreparedStatement pre = cona.prepareStatement(insertar);{
                pre.setString(1, JOptionPane.showInputDialog("name?"));
                pre.setString(2, JOptionPane.showInputDialog("Equipo?"));
                pre.setString(3, JOptionPane.showInputDialog("Dorsal?"));
                pre.executeUpdate();
            }

            reSet = dec.executeQuery("Select * from Legend");

            while(reSet.next()){
                System.out.println(reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }

        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }


    }


}
