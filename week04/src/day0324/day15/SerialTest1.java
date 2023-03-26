package day0324.day15;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
public class SerialTest1 {
   public static void main(String[] args) throws Exception{ 
      FileOutputStream fos = 
    		  new FileOutputStream("c:/iotest/test1.ser");
      // 출력모드로 오픈. 바이트스트림 사용. 파일의 확장자가 딱 정해져 있지는 않지만 serializable의 약어로 ser을 많이 사용 (txt는 사용불가)
      //
      ObjectOutputStream oos = 
    		  new ObjectOutputStream(fos);

      oos.writeObject(new Date());
      // Date의 객체에 객체직렬화해서 write -> 시리얼라이자블을 추가상속하고 있음을 알 수 있음

      Thread.sleep(3000);
      oos.writeObject(new Date());

//
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");      
   }
}



