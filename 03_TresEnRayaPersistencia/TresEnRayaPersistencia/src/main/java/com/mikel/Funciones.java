package com.mikel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Funciones {

    private static int turno=0;
    private static int movimientos=0;

    private static boolean click1=false;
    private static boolean click2=false;
    private static boolean click3=false;
    private static boolean click4=false;
    private static boolean click5=false;
    private static boolean click6=false;
    private static boolean click7=false;
    private static boolean click8=false;
    private static boolean click9=false;


    private static int[][] array={{5,5,5},{5,5,5},{5,5,5}};

    private static List<Integer> listaGanador1=new ArrayList<Integer>();
    private static List<Integer> listaGanador2=new ArrayList<Integer>();




    public static void terminarJuego(){
        System.exit(0);
    }

    public static boolean comprobarEmpate(){
        if (movimientos>8 && !hayGanador(array)){
            JOptionPane.showMessageDialog(Inicio.tresEnRaya.getPanel(),"Empate!!!!", "3 en raya", JOptionPane.PLAIN_MESSAGE);

            return true;
        }else {return false;}}

    public static void ganaO(){
        JOptionPane.showMessageDialog(Inicio.tresEnRaya.getPanel(),"Gana el O!!!!", "3 en raya", JOptionPane.PLAIN_MESSAGE);

        listaGanador1.add(1);
        listaGanador2.add(0);


        limpiar();

        int uno=0;
        int dos=0;

        for (int i = 0; i < listaGanador1.size(); i++) {
            if(listaGanador1.get(i)==1) uno++;
        }
        for (int i = 0; i < listaGanador2.size(); i++) {
            if(listaGanador2.get(i)==1) dos++;
        }


        Inicio.tresEnRaya.getPuntosJugador1().setText(String.valueOf(uno));
        Inicio.tresEnRaya.getPuntosJugador2().setText(String.valueOf(dos));



        // terminarJuego();
    }

    private static void limpiar() {

        click1=false;
        click2=false;
        click3=false;
        click4=false;
        click5=false;
        click6=false;
        click7=false;
        click8=false;
        click9=false;


        Inicio.tresEnRaya.getButton1().setText("");
        Inicio.tresEnRaya.getButton2().setText("");
        Inicio.tresEnRaya.getButton3().setText("");
        Inicio.tresEnRaya.getButton4().setText("");
        Inicio.tresEnRaya.getButton5().setText("");
        Inicio.tresEnRaya.getButton6().setText("");
        Inicio.tresEnRaya.getButton7().setText("");
        Inicio.tresEnRaya.getButton8().setText("");
        Inicio.tresEnRaya.getButton9().setText("");


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {


            array[i][j] = 5;
        }}
        turno=0;

        movimientos=0;




    }

    public static void ganaX(){
        JOptionPane.showMessageDialog(Inicio.tresEnRaya.getPanel(),"Gana la X!!!!", "3 en raya", JOptionPane.PLAIN_MESSAGE);
        listaGanador1.add(0);
        listaGanador2.add(1);

        limpiar();
        int uno=0;
        int dos=0;

        for (int i = 0; i < listaGanador1.size(); i++) {
            if(listaGanador1.get(i)==1) uno++;
        }
        for (int i = 0; i < listaGanador2.size(); i++) {
            if(listaGanador2.get(i)==1) dos++;
        }


        Inicio.tresEnRaya.getPuntosJugador1().setText(String.valueOf(uno));
        Inicio.tresEnRaya.getPuntosJugador2().setText(String.valueOf(dos));

        //  terminarJuego();
    }

    public static boolean hayGanador(int[][] t) {

        // Primero un jugador y luego el otro
        for (int i = 0; i < 2; i++) {

            // Filas
            if (t[0][0] == i && t[0][1] == i && t[0][2] == i) {
                return true;
            }
            if (t[1][0] == i && t[1][1] == i && t[1][2] == i) {
                return true;
            }
            if (t[2][0] == i && t[2][1] == i && t[2][2] == i) {
                return true;
            }

            // Columnas
            for (int j = 0; j < 3; j++ ) {
                if (t[0][j] == i && t[1][j] == i && t[2][j] == i) {
                    return true;
                }
            }

            // Diagonales
            if (t[0][0] == i && t[1][1] == i && t[2][2] == i) {
                return true;
            }
            if (t[0][2] == i && t[1][1] == i && t[2][0] == i) {
                return true;
            }
        }

        // No hay ganador
        return false;
    }

    //3 en raya 1

    public static void click1() {
        if (turno==0 && click1==false){
            Inicio.tresEnRaya.getButton1().setText("O");

            array[0][0]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click1==false){
            Inicio.tresEnRaya.getButton1().setText("X");
            array[0][0]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click1=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click2() {
        if (turno==0 && click2==false){
            Inicio.tresEnRaya.getButton2().setText("O");

            array[0][1]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click2==false){
            Inicio.tresEnRaya.getButton2().setText("X");
            array[0][1]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click2=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click3() {
        if (turno==0 && click3==false){
            Inicio.tresEnRaya.getButton3().setText("O");

            array[0][2]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click3==false){
            Inicio.tresEnRaya.getButton3().setText("X");
            array[0][2]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click3=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click4() {
        if (turno==0 && click4==false){
            Inicio.tresEnRaya.getButton4().setText("O");

            array[1][0]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click4==false){
            Inicio.tresEnRaya.getButton4().setText("X");
            array[1][0]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click4=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click5() {
        if (turno==0 && click5==false){
            Inicio.tresEnRaya.getButton5().setText("O");

            array[1][1]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click5==false){
            Inicio.tresEnRaya.getButton5().setText("X");
            array[1][1]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click5=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click6() {
        if (turno==0 && click6==false){
            Inicio.tresEnRaya.getButton6().setText("O");

            array[1][2]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click6==false){
            Inicio.tresEnRaya.getButton6().setText("X");
            array[1][2]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click6=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click7() {
        if (turno==0 && click7==false){
            Inicio.tresEnRaya.getButton7().setText("O");

            array[2][0]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click7==false){
            Inicio.tresEnRaya.getButton7().setText("X");
            array[2][0]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click7=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click8() {
        if (turno==0 && click8==false){
            Inicio.tresEnRaya.getButton8().setText("O");

            array[2][1]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click8==false){
            Inicio.tresEnRaya.getButton8().setText("X");
            array[2][1]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click8=true;

        if (comprobarEmpate()) terminarJuego();
    }

    public static void click9() {
        if (turno==0 && click9==false){
            Inicio.tresEnRaya.getButton9().setText("O");

            array[2][2]=0;
            if (hayGanador(array)){ganaO();}
            turno++;
            movimientos++;
        }else if (turno==1 && click9==false){
            Inicio.tresEnRaya.getButton9().setText("X");
            array[2][2]=1;
            if (hayGanador(array)){
                ganaX();}
            turno--;
            movimientos++;
        }

        click9=true;

        if (comprobarEmpate()) terminarJuego();
    }


}
