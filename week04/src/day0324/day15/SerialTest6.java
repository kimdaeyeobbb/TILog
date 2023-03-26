package day0324.day15;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialTest6 {
   public static void main(String[] args) throws Exception{ 
      FileInputStream fis = 
    		  new FileInputStream("c:/iotest/test3.ser"); 
      ObjectInputStream ois = new ObjectInputStream(fis); 
      StepDTO dto = (StepDTO)ois.readObject();
      System.out.println("Student객체 데이터 : ");
      System.out.println(dto.getStepId());  // transient 제어자를 붙여서 읽을 떄에는 기본값 null 출력
      System.out.println(dto.getPassword()); // transient 제어자를 붙였으므로 객체직렬화 대상에서 벗어나서 읽어들일 떄에는 기본값 0을 출력
      System.out.println(dto.getAge());
      System.out.println(dto.getScore());
      ois.close();
      fis.close();
   }
}