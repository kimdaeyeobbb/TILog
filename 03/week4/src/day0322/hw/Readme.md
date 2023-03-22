# 과제풀이

```java
package day0322.hw;

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
        try(FileReader reader = new FileReader("c:/iotest/list.txt");
            // 읽고자하는 파일의 경로 지정
                BufferedReader br = new BufferedReader(reader);){
            String[] arr;
            String data;
            while(true){
                data = br.readLine();
                if(data == null){
                    break;
                }
                arr = data.split(",");
                URL req = new URL(" "+arr[1]+" ");
                InputStream is = req.openStream();
                // openStream 호출.
                // URL 클래스가 객체 생성될 때 지정된 URL 정보를 가지고 파싱을 함 (어느 서버에게 무엇을 요청할지)
                // openStream은 URL 클래스의 객체가 생성될 떄 전달된 인자를 가지고 어디에 무엇을 요청할지 파악함.
                // openStream이 호출되었을 때 미리 서버에게 요청해서 URI(서버에게 가는것. /image/1.jpg와 같은것)를 전달
                // 서버는 이것을 클라이언트에게 줌
                
                
                dataName = data.split(",")[0];
                fileName = path+"/"+dataName+".jpg";
                // 출력할 이미지 파일 이름
                
                FileOutputStream fos = new FileOutputStream(fileName);
                // FileOutputStream 객체 생성
                // try의 인자로 전달할 수 없음 (출력할 이미지 파일이름을 아래에 기재해야하므로)
                // 인자로 주고 싶으면 여기서 또 try - catch 를 써주어야 함
                
                /* 읽고 쓰기를 반복 */
                int input = 0;
                while(true){
                    input = is.read();  
                    // read메서드 호출시 서버가 응답이 느리면 기다리고 있음
                    // 응답이 오기 시작하면 쭈루룩 읽어와서  (아래줄에서 파일에 write)
                    
                    if (input == -1){ // 모두 읽고 쓰면 -1을 리턴
                        break;
                    }
                    fos.write(input);
                }
                fos.close();
                System.out.println(dataName+"이 성공적으로 저장되었습니다.");
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application"+"\\chrome.exe " + fileName);
            }
        } catch (MalformedURLException e){
            System.out.println("URL문자열 오류 : " + e.getMessage());
        } catch (IOException e){
            System.out.println("IO 오류 : " + e.getMessage());
        }
    }
}
```