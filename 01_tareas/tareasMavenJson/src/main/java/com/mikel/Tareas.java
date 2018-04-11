package com.mikel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tareas {
    private JPanel panel;
    private JButton añadirNuevaButton;
    private JButton verPendientesButton;
    private JButton verCompletadasButton;
    private JTextField textField1;
    private JPanel panelNueva;
    private JPanel panelPendientes;
    private JPanel panelCompletadas;
    private JList list1;
    private JList list2;
    private JPanel panelNuevoBoton;
    private JPanel panelCompletadasBoton;
    private JPanel panelPendientesBoton;
    private JButton añadirButton;
    private JScrollPane scrollPane;
    private JScrollBar scrollBar1;
    private List<Tarea> tareas;
    private boolean botonClick=false;
    public DefaultListModel listModel = new DefaultListModel();
    Tarea[] t;

    public Tareas() {

        final JFrame frame = new JFrame("Tareas");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        panelNueva.setVisible(false);
        panelPendientes.setVisible(false);
        panelCompletadas.setVisible(false);
        panelNuevoBoton.setPreferredSize(panelCompletadasBoton.getPreferredSize());
        panelPendientesBoton.setPreferredSize(panelNuevoBoton.getPreferredSize());

        verPendientesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (botonClick==true) {

                    panelPendientes.setVisible(true);
                    panelNueva.setVisible(false);
                    panelCompletadas.setVisible(false);


                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String json = gson.toJson(tareas);


                    t = gson.fromJson(json, Tarea[].class);

                  //  scrollPane.setViewportView(list2);
                    //listModel.setSize(300);
                    ;


                        for (int i = 0; i < t.length; i++) {
listModel.add(i,t[i]);
                       //    listModel.add(i,list2.getModel().getElementAt(i));

                            System.out.println(listModel.getElementAt(i));

                        }
                    list2.setModel(listModel);
frame.pack();
                }


            }
        });

        añadirNuevaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panelNueva.setVisible(true);
                panelPendientes.setVisible(false);
                panelCompletadas.setVisible(false);
            }
        });
        verCompletadasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panelCompletadas.setVisible(true);
                panelNueva.setVisible(false);
                panelPendientes.setVisible(false);


            }
        });
        añadirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

botonClick=true;
                tareas = new ArrayList<Tarea>();

                tareas.add(new Tarea(textField1.getText(), false));


                //         Arrays.asList(new Tarea(textField1.getText(), false), new Tarea("edwdeeeew", false));

                //  String json = new Gson().toJson(tareas);

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(tareas);

                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream("tareas.json");
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }


                Writer w = new BufferedWriter(new OutputStreamWriter(fos));
                try {
                    w.write(json);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    w.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    w.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "t=" + Arrays.toString(t) +
                '}';
    }
}
