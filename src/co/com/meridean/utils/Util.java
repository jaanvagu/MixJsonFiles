package co.com.meridean.utils;


import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;

import java.io.*;
import java.util.*;

public class Util {

    private File file;
    private FileWriter writer;
    private FileReader reader;
    private BufferedWriter bufferWriter;
    private BufferedReader bufferedReader;


    public void mixJsonFiles(String pathFileA, String pathFileB) {

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement;
        JsonArray jsonArrayA;
        JsonArray jsonArrayB;
        JsonArray jsonResult = new JsonArray();
        String nameOutputFile;

        try{
            file = new File(pathFileA);
            nameOutputFile = file.getName();
            reader = new FileReader(file);
            jsonElement = jsonParser.parse(reader);
            jsonArrayA = jsonElement.getAsJsonArray();

            file = new File(pathFileB);
            reader = new FileReader(file);
            jsonElement = jsonParser.parse(reader);
            jsonArrayB = jsonElement.getAsJsonArray();

            jsonResult.addAll(jsonArrayB);
            jsonResult.addAll(jsonArrayA);

            createTextFile(nameOutputFile);
            writeLineInFile(jsonResult.toString());
            closeTextFile();

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createTextFile(String name){
        try{
            file = new File("json_output/" + name);
            writer = new FileWriter(file);
            bufferWriter = new BufferedWriter(writer);
        } catch (Exception e){
            System.err.println("Problema creando file" + e.getMessage());
        }
    }

    public void closeTextFile(){
        try{
            bufferWriter.close();
        }
        catch(Exception e){
            System.err.println("Error al cerrar Archivo texto: " + e.getMessage());
        }
    }

    public void writeLineInFile(String line){
        try{
            bufferWriter.write(line);
            bufferWriter.newLine();
        }
        catch(Exception e){
            System.err.println("Error al escribir linea Archivo texto: " + e.getMessage());
        }
    }

    public static float getPecentageFromAmountOfTotal(float amount, float total) {

        float percentage = 0f;
        if(total != 0) {
            percentage = (amount / total) * 100f;
        }

        return percentage;
    }

}