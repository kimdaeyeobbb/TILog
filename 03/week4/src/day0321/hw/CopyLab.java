package day0321.hw;

import java.io.*;
import java.time.LocalDate;

public class CopyLab {
    public static void main(String[] args) {

        // 쓰기
        FileWriter writer = null;
        String path = "c:/iotest";
        File isDir = new File(path);
        if(!isDir.exists()){
            isDir.mkdirs();
        }

        /* 오늘 날짜 구하기 */
        LocalDate ld = LocalDate.now();
        int yearNum = ld.getYear();
        int monthNum = ld.getMonthValue();
        int dateNum = ld.getDayOfMonth();

        try (FileReader reader = new FileReader("C:\\Users\\kimdy\\Desktop\\DY\\Git\\dktechin_TIL\\03\\week4\\src\\day0321\\hw\\sample.txt");
            BufferedReader br = new BufferedReader(reader);){
            writer = new FileWriter("c:/iotest/sample_"+yearNum +"_"+ monthNum + "_" + dateNum+".txt", true);
            PrintWriter out = new PrintWriter(writer);
            while(true){
                String data = br.readLine();
                if(data == null){
                    break;
                }
                writer.write(data);
                writer.write("\n");
                //System.out.println("데이터 : "+data);
            }
            System.out.println("저장 완료되었습니다.");
        } catch (FileNotFoundException fnfe){
            System.out.println("sample.txt 파일을 찾을 수 없습니다.");
        } catch (IOException ioe){
            System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
        } finally {
            try{
                if(writer != null){
                    writer.close();
                }
            } catch (Exception e){
                System.out.println("파일을 닫는동안 오류 발생!");
            }
        }
    }
}
