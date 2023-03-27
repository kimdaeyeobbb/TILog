# 0324 ���� ����

# CreateBookLab

```java
package day16.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBookLab {
    public static void main(String[] args) {
        /* DB������ ���� ���� ���� */
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";


        try( /* DB ������ ���� ��ü ���� - Ŭ�������� �߰�����ؾ��� */
                Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();){
            /* ���̺� ���� ���� */
            stmt.executeUpdate("create table book " +
                    "(id int primary key auto_increment not null " +
                    ",title varchar(90)" +
                    ", price int" +
                    ", kind char(3))");
            System.out.println("book ���̺� ���� �Ϸ�!");
        } catch (SQLException sel){
            System.out.println("���� �߻�! ���� �޽���: " +sel);
        }
    }
}

```

- ���̺� ���� ������ �� ������ �����ϸ� �������� ����


# InsertBookLab

```java
package day16.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBookLab {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        int cnt=0;
        try(Connection conn = DriverManager.getConnection(url, user, passwd);
            PreparedStatement pstmt = conn.prepareStatement("insert into book(title,price,kind) values (?,?,?)");
            Scanner sc = new Scanner(System.in);){
            start: while(true){    // �ݺ����� start ��� ���� ����
                /* ������� ���� �Է¹��� */
                System.out.print("�������� �Է��ϼ��� : ");
                String title = sc.nextLine();
                System.out.print("������ �Է��ϼ��� : ");
                int price = Integer.parseInt(sc.nextLine());
                
                /* ���� �з��� ���� ���� �Է� */
                System.out.println("���� �з��� ���� ���ڸ� �Է��ϼ���.");
                System.out.println("1. ���α׷��� ���");
                System.out.println("2. �� ���α׷���");
                System.out.println("3. ������");
                System.out.println("4. �����ͺ��̽�");
                System.out.println("5. ������");
                System.out.println("���� (1~5) : ");
                
                System.out.println("������ �ԷµǾ����ϴ�.");

                int kind = sc.nextInt();
                sc.nextLine();  // �Է¹��� û��
                if (kind > 5 || kind < 1){
                    System.out.println("�߸��� �Է��Դϴ�. ��������� �ٽ� �Է��ϼ���");
                    continue;  // �ٽ� while�� ���� �ö󰡵��� ���� (��������� �ٽ� �Է�)
                }
                
                /* ���� �� �ݿ� */
                pstmt.setString(1,title);
                pstmt.setInt(2, price);
                pstmt.setString(3, "b0"+String.valueOf(kind)); 
                pstmt.executeUpdate();
                System.out.println("\nbook ���̺� ������ ���� �Ϸ�");
                cnt++;
                while(true){
                    System.out.println("��� �Է��Ͻðڽ��ϱ�? (y/n) ");
                    String aws = sc.nextLine();
                    if (aws.equalsIgnoreCase("n")){
                        System.out.println(cnt+"���� ������ �Է� �Ϸ�!");
                        break start;  // start��� ���� ������ �ݺ����� ����
                    } else if (aws.equalsIgnoreCase("y")) {
                        System.out.println();
                        break;  // �� while���� ����
                    } else {
                        System.out.println("y�� n �� �� �ϳ��� �Է��ϼ���");
                        System.out.println("y�� ����ϰ� n�� �׸��ϱ� �Դϴ�.");
                    }
                }
            }
        } catch (SQLException se){
            System.out.println("���� �߻� : "+se.getMessage());
            se.printStackTrace(); // �ݽ��� ���� ���
        }  // try-catch ������ ����Ͽ����Ƿ� close�� �ڵ����� ����
    }
}

```

- ?�� �������� title,price,kind�� ���� ����
- b01 ~ b05 
  - b0��� ���ڿ� ���հ� int���� kind�� �����ϴ� ���̵�� ��Ȱ�� ����

- executeUpdate()
  - ���α׷� ������ ������ �߿���
  - �������� ������ ���ø��ϰ� ������ ���� �ʴ� ����!

- try-catch ������ ����Ͽ����Ƿ� close�� �ڵ����� ����
- printStackTrace()
  - �޼��� ��ü�� ����� ����

## InsertBookLab �ڵ�2

```java

```

- while�� �ȿ��� ���� �����ϱ� ���� �ۿ� �����ϴ°� ����
  - �ݺ����� �����ϴ� ���� ������ ����ؼ� �����ȴٸ� �������� �޸𸮸� �Һ��ϰ� �Ǵ� ���̱� �����̴�

- �ϳ��� �࿡ `\n`�� �Է��ϱ� ���� �ڵ� ��ü�� �и����Ѽ� �Է��ϴ� ���� ����
- switch���� �̿��ϱ⺸�� ���ڸ� �и���Ű�� ���� ����
- ������ case ���� break���� ���� �ʴ� ���� ����ϴ�(������ ������ case�� ���� �� ������ ����)
- continue�� �Ƚᵵ �Ǵ� ��Ȳ���� ����ϴ� ���� �������� �ʴ�


# SelectBookLab

```java

public class SelectBookLab {
  public static void main(String[] args) {
      
      
    case 3: case 4: case 5: case 6:
        String str1 = "select title"
  }
}
```

- preparedStatement
  - �̸� ��� ���
  - �� sql ��� ������ ��ü�� ������ �����ؾ� ��
  - [���Ĺ���](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/PreparedStatement.html)


# SelectBookLab �ڵ�2

```java

```


```java
Statement stmt = conn.createStatement();
```  
- �����ϴ� ��ɾ��� ������ ����
- 7���� ��찡 ��� resultSet ��ü�� �����ǹǷ� �̸� resultSet�� ������
- executeQuery�� case�� ���ο��� �����Ŵ
- ��¹���� 3���� ����
- �ؽ��� ��ü�� �̿��ؼ� ������ �����Ǿ��ִ� ���� key�� �ξ���
- �� �ڵ�� while�� ���� break�� �����Ƿ� 1���� ����ϰ� ������ ������ �ִ�. break�� else���� �־��־�� �Ѵ�.
- resultSet ��ü�� try-catch�� �־����� ������ �ڵ����� close ���� ����
- Connection ��ü�� �� close ���־�� ��

# SelectBookLab �ڵ�3

```java

```

- keep ������ Y�� ���� while���� ���� (�ٲ�� ����)
  - ���ѷ����� ���ٰ� break�� �ɾ��ִ� ���� �ƴ�!

- ������ �÷����� *�� ������������ �ϳ��ϳ� ���� �� ��
- case���� ��ȣ�� ������ �ʿ�� ����
- �� �ڵ��� default������ continue�� �ʿ���.
- NumberFormatException
  - �߰� ����ó���� ��. ���� ����غ� ��


# SelectBookLab �ڵ�4

```java

```

# SelectBookLab �ڵ�5

```java

```

- enum�� �����
  - b01~b05�� ���� ����� ����
  - �����Ͱ��� �������� ������ ������� ������� ��

- ������ ������ ���� returnKind �޼����� ������
- ������ sql ����� String�� �迭�� ������
  - �̰��� mybatis�� 
    - ������ sql����� �ڹ� �ڵ忡�� �и���Ű�� �� (���⼭�� string�� �迭�� ������)
    - �ַ� xml ������ �ۼ��صΰ� �о���� ��

- ����ڿ��� �޴��� �������� ���� �����Ƿ� ������ �ʿ���
- �����Ͱ� ��� �����Ǿ� �ֳĿ� ���� ����� �޶����Ƿ� ���ǹ����� `rs.next()`�� ��� ������ְ� ����
- ��� ���� �� ����?
  - ����� ���� �ϳ��� �����Ƿ� ���� �����Ͱ� ������ `!rs.next()`�� �̿��ؼ� ���� Ȯ����
  
- �������� catch ������� ������ ������ ���� ���� ������ ���� ������ ��ġ��Ű�� �ڼ��� ������ ��ġ���Ѿ���
  - ���⼱ Exception�� ��� ����Ŭ������ �ְ� �����̹Ƿ� ���� �������� �;���
  - 