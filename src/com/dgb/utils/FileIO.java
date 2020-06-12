package com.dgb.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void writeFile(int row){
        try {
            FileWriter fw = new FileWriter(Constants.FILE_IO);
            fw.write(row);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int readFile(){
        try {
            FileReader fr=new FileReader(Constants.FILE_IO);
            int rownum = fr.read();
            fr.close();
            return rownum;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
