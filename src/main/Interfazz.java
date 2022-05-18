package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfazz implements ActionListener {


    JFrame ventana;
    JPanel panel;
    JLabel nome;
    JTextField tnome, tequipo, tdorsal;


    JButton borrar,insertar,modificar,conectar;



    String [] columnas={"Nombre","Apellido","Curso"};
    DefaultTableModel modelo = new DefaultTableModel();

    JTable tabla = new JTable (modelo);



    public void run(){

        ventana = new JFrame();
        ventana.setBounds(1200,50,600,600);
        ventana.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0,0,600,600);
        panel.setBackground(new Color(150, 150, 150));
        panel.setLayout(null);

        nome = new JLabel("NOME");
        nome.setBounds(40,40,100,30);
        nome.setBackground(Color.orange);

        tnome = new JTextField();

        tnome.setToolTipText("placeholder");

        tnome.setText("nomet");
        tnome.setBackground(new Color(254,254,254));
        tnome.setBounds(150,40,180,30);

        tequipo = new JTextField();
        tequipo.setText("Equipo");
        tequipo.setBackground(new Color(254,254,254));
        tequipo.setBounds(150,140,180,30);

        tdorsal = new JTextField();
        tdorsal.setText("dorsal");
        tdorsal.setBackground(new Color(254,254,254));
        tdorsal.setBounds(100,90,180,30);

        insertar = new JButton("AGREGAR TABOA");
        insertar.setBounds(380,140,180,30);

        tabla.setBounds(50,250,500,270);
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Curso");
        modelo.setColumnIdentifiers(columnas);





        panel.add(nome);
        panel.add(tnome);
        panel.add(tdorsal);
        panel.add(tequipo);
        panel.add(insertar);
        panel.add(tabla);


        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra Aplicacion cuando X;
        ventana.setVisible(true);

        insertar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
