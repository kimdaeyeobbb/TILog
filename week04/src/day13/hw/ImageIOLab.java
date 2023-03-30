package day13.hw;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStream;

public class ImageIOLab {
    public static void main(String[] args) {

        String path = "C:/iotest/myimage";
        File isDir = new File(path);
        if(!isDir.exists()){
            isDir.mkdirs();
        }

        FileReader reader = null;
        BufferedReader br = null;

        try{
            reader = new FileReader("C:\\Users\\kimdy\\Desktop\\DY\\Git\\dktechin_TIL\\03\\week4\\src\\day0322\\hw\\list.txt");
            br = new BufferedReader(reader);
            int count = 0;

            URL req;
            String fileName;
            String dataName;
            FileOutputStream fos;

            while(true){
                String data = br.readLine();
                if(data == null){
                    break;
                }
                req  = new URL(data.split(",")[1]);
                InputStream is = req.openStream();
                dataName = data.split(",")[0];
//                System.out.println(data.split(",")[0]);

                fileName = "c:/iotest/myimage/"+dataName+".jpg";
                fos = new FileOutputStream(fileName);

                int input = 0;
                while(true){
                    input = is.read();
                    if (input == -1){
                        break;
                    }
                    fos.write(input);
                }

                System.out.println(dataName+"이 성공적으로 저장되었습니다.");
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application"+"\\chrome.exe " + fileName);
            fos.close();
            }
        } catch (MalformedURLException e){
            System.out.println("URL문자열 오류 : " + e.getMessage());
        } catch (IOException e){
            System.out.println("IO 오류 : " + e.getMessage());
        }
    }
}
