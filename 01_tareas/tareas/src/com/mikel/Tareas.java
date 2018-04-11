package com.mikel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    public Tareas() {

        JFrame frame = new JFrame("Tareas");
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
                panelPendientes.setVisible(true);
                panelNueva.setVisible(false);
                panelCompletadas.setVisible(false);

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






            }
        });
    }




}
