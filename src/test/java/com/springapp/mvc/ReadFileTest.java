package com.springapp.mvc;

import java.io.*;

/**
 * Created by cherry on 15/7/22.
 */
public class ReadFileTest {
    public final static String FILEDIR = "/Users/cherry/Downloads/";
    public final static String FILENAME = "fileTest.txt";
    public final static String OUTPUTFILENAME = "fileTest1.txt";
    public static final void main(String[] args){
        File testFile = new File(FILEDIR+FILENAME);
        File outputFile = new File(FILEDIR+OUTPUTFILENAME);
        if(!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {

//            BufferedReader br = new BufferedReader(new FileReader(testFile));
//            for (String line = null; (line = br.readLine())!=null ; ) {
//                System.err.println(line);
//            }
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(testFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile));
            byte[] buffer = new byte[1024];
            for (int len = 0;(len = bis.read(buffer,0,1024))>0;) {
                bos.write(buffer,0,len);
                bos.flush();
            }
            bos.close();
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
