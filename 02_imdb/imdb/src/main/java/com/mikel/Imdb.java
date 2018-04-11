package com.mikel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.io.*;
import java.util.*;

public class Imdb {
    private JTable table1;
    private JPanel panel1;
    private JSpinner spinner1;


    public Imdb() throws IOException {

        JFrame frame = new JFrame("Imdb");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Integer[] years = new Integer[10];
        int year = 2016;
        for (int i = 0; i < 10; i++) {
            years[i] = year;
            year--;
        }

        SpinnerListModel spinnerModel = new SpinnerListModel(years);
        spinner1.setModel(spinnerModel);


        //  BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("src/IMDB-Movie-Data.csv"));

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/IMDB-Movie-Data.csv")));
        List<List<String>> archivo = new ArrayList<List<String>>();


            do {
                int k = 0;

                archivo.add(new ArrayList<String>());

                while (br.readLine()!=(",") || br.readLine()!=("\n") ){
                    archivo.get(k).add(br.readLine());
                  //  br.readLine().split(",");
                    System.out.println(archivo.get(k).size());
                }
                k++;
            } while (br.readLine()!="\n\n");

        br.close();

        TableModel tableModel = new TableModel() {
            public int getRowCount() {
                return 0;
            }

            public int getColumnCount() {
                return 0;
            }

            public String getColumnName(int columnIndex) {
                return null;
            }

            public Class<?> getColumnClass(int columnIndex) {
                return null;
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }

            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            }

            public void addTableModelListener(TableModelListener l) {

            }

            public void removeTableModelListener(TableModelListener l) {

            }
        };


        System.out.println(archivo.size());
        System.out.println(archivo.get(0).size());
        System.out.println("hola");
        for (int i = 0; i < archivo.size(); i++) {
            for (int j = 0; j < archivo.get(0).size(); j++) {


                tableModel.setValueAt(archivo.get(i).get(j), i, j);

            }
        }

        table1 = new JTable(tableModel);


    }


}
