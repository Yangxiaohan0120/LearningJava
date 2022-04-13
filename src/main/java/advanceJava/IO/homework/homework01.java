package advanceJava.IO.homework;

import advanceJava.IO.Writer.BufferedWriter_;

import java.io.*;

/**
 * @author Chris Yang
 * created 2022-04-13 20:15
 **/
public class homework01 {
    public static void main(String[] args) {
        String path = "/Users/yxh/Downloads";
        File file = new File(path,"mytemp");

        if(!file.exists()){
            file.mkdir();
        }

        File newFile = new File(file,"newFile.txt");
        try{
            if(!newFile.exists()){
                newFile.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
            bufferedWriter.write("hello,world!");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
