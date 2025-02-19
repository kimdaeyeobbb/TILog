package day12.hw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountLab {
    public static void main(String[] args) {
        FileReader reader = null;
        BufferedReader br = null;
        try{
            reader = new FileReader("C:\\Users\\kimdy\\Desktop\\DY\\Git\\dktechin_TIL\\03\\week4\\src\\day0321\\hw\\yesterday.txt");
            br = new BufferedReader(reader);
            int count = 0;
            while(true){
                String data = br.readLine();
                if(data == null){
                    break;
                }
//                System.out.println(data);
                String[] strArr = data.split(" ");

                for (String el: strArr) {
                    //System.out.println(el);
                    if (el.contains("yesterday")){
                        count++;
                    }
                }
            }
            System.out.println("yesterday의 라는 단어는 "+count+"개 있습니다. ");
        } catch (FileNotFoundException fnfe){
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException ioe){
            System.out.println("파일을 읽을 수 없습니다.");
        } finally {
            try{
                br.close();
                reader.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
