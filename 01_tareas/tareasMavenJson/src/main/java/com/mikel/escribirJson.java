package com.mikel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import sun.nio.cs.StandardCharsets;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class escribirJson {

    public static void main(String[] args) throws IOException {

        List<Tarea> tareas = Arrays.asList(new Tarea("edwdew", false), new Tarea("edwdeeeew", false));

        //  String json = new Gson().toJson(tareas);

        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(tareas);

        FileOutputStream fos = new FileOutputStream("tareas.json");


        Writer w = new BufferedWriter(new OutputStreamWriter(fos));
        w.write(json);
        w.flush();
        w.close();


        Tarea[] t=gson.fromJson(json,Tarea[].class);

        for (Tarea tar:t) {
            System.out.println(tar);
        }


    }
}
