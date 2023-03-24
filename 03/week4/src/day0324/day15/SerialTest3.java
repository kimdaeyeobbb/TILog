package day0324.day15;
import day0313.course.Student2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;


public class SerialTest3 {
   public static void main(String[] args) throws Exception{ 
      FileOutputStream fos = 
    		  new FileOutputStream("c:/iotest/test2.ser"); 
      ObjectOutputStream oos = 
    		  new ObjectOutputStream(fos);
      oos.writeObject(new Date());
      Thread.sleep(3000);
      oos.writeObject(new Date());
      // Date 객체는 이미 Serializable을 추가상속하고 있음

      Student2 st = new Student2("duke", 27, "Java프로그래밍");
      oos.writeObject(st);
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");      
   }
}



