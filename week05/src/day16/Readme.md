# 03.27

# �Ϲ����� SQL ���

## SELECT

- JDBC ������ executeUpdate ���
  - return value: int�� (0�̸� ���ǿ� �´� �����Ͱ� ���� ��)
    - 0�� �ƴ� ��� �ش� ���ڸ�ŭ ������ ����. -> �׿� �´� �޽����� �������� ��


- select�� executeQuery() ���
  - return value: ResultSet


## DML

- Data Manuplation Language
- JDBC�� excuteUpdate()


- ����
  - INSERT
  - DELETE
  - UPDATE

### INSERT

- INSERT�� ���ܰ� �߻����� ������ INSERT ����. ���� �߻��� INSERT ������ ��
- executeUpdate�� INSERT ����ó���� ũ�� Ȱ����� ����

### DELETE

- WHERE ���� ���� ������ ��� �����͸� ����
- WHERE ���� �־ ���ǿ� �˸��� �༮���� �����ǰ� ���� �� ����

### UPDATE

- UPDATE�� SET�� �Բ� ����ϱ⵵ ��

```java
package day16.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class UpdateData {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("update student set score = ? where name = ?");
				// set��: �����ϰ� ���� �÷��� & ���� ������ �� ������ �� ����
			 // �������� �÷��� �Ѳ����� �ٲٰ� ������ set score =? , �÷���2 = ������ �� ó�� ����
				Scanner scan = new Scanner(System.in);){
			System.out.print("�л� �̸��� �Է��ϼ��� : ");
		    String name = scan.nextLine();
			System.out.print("�л� ������ �Է��ϼ��� : ");
			int score = Integer.parseInt(scan.nextLine());
			pstmt.setInt(1,  score);
		    pstmt.setString(2, name);
			int updateNum = pstmt.executeUpdate();
			// executeUpdate - ���ϰ��� �ǹ��ְ� ���̴� ��찡 ����
			// �л� ���̺� name - PK
			if (updateNum > 0) // ��� ���� ���� �Ǿ��� ���
				System.out.println("student ���̺��� " +updateNum + "�� ���� �Ϸ�");
			else 
				System.out.println("���� ����!!");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
```

## DDL

- JDBC�� excuteUpdate()

- ����
  - CREATE TABLE
  - DROP TABLE
  - ALTER TABLE

### CREATE TABLE

- ���ο� ���̺� ����

### DROP TABLE

- ���̺� ����

### ALTER TABLE

- ���̺��� �̹� ������� ���¿��� ���̺��� ��Ű���� �ٲ� �� �ʿ���

- ���̺� ���� ���� ����
  - ���� �÷� ����
  - ���� �÷� Ÿ�� ����
  - ���� ���� �߰�


- �ϰ��� �ϴ� �۾��� ����Ǵ� ��� ���� �Ұ�
  - ALTER TABLE�� ��ɰ� �̹� ����ִ� �����͵��� ���迡 �־� ALTER TABLE�ϱ� �������� ������ �ȵ�
  - ���̺� ���� �� PK�� �������� �ʾҴٰ� �ߺ� �����Ͱ� �̹� �� �ִ� ��� PK�� ������ �� ����

# Model View Controller ���� ����

- MVC �����̶� ��
- �� ����Ʈ ���߽� ���� ����ϴ� ����
- ������ �ַ� ����ϴ� MVC ������ DB ������ �ʼ������� ����
- �� ���α׷��� �������� �־��� ������ (UI ���߽� ���� ����ϴ� ����) => ���� ���� ����
- ȭ��� ����ڿ��� �������� ��� Ȥ�� ����ڰ� ���α׷��� �̿��ϸ� ������ϴ� �κ� , ���α׷� ������ ��� (���� ó��, �޿� ó��)���� ����Ͻ� ����(���� ����)�̶� �ϴµ�
�̷��� ����ڿ��� �������̽��� ����ϴ� ���α׷�, ����ڰ� ���ϴ� ����� �����ϴ� ���α׷��� �и����Ѽ� ������
- ���������� ���ü���� � ���� �� ����Ͻ��� ���ø����̼� ���߽� ��ɿ� ���� ���� ������ ����
  - �̷��� ��� �������̽� �κп� ���� ������ �پ��� ������ ���� ����/ ����Ͻ� ���� ���� ����� �����Ѵ�

- ������ �����ӿ�ũ�� MVC �������� �� ����Ʈ�� �����ϰԲ� �����Ǿ�����
- DB���� ���α׷� ���߽� MVC ������ �����ϸ� ������������ ������

## Model


- �𵨿� �ش�Ǵ� ���� ���� �𵨰� ������ �𵨷� ����

### ���� ��

- DAO, VO, ENTITY�� ���� �����̳� ������ ������ �������� �ʰ� �����Ͱ��� �����ϴ� ������ �ؾ� ��


- DAO ��ü (Data Access Object)
  - ������ ���� �ڵ带 ��� �ִ� ��ü
  - DB ���� ���� ��ü
  - DB ������ �����ϴ� Ŭ���� �۸�� `~DAO`�÷� �۸�
  - �䰡 ����ڷκ��� �Է¹��� ������ ��Ʈ�ѷ� Ȥ�� �𵨿� �ѱ� �� �ϳ��ϳ� �����ϱ� ���ٴ� ��ü�� ��� ��ü�� �����ϴ� ���� ȿ���� (�̷� �� DAO ���)


- VO
  - Value Object
  - `��`�� (readonly�θ� ��밡��)
  - ������ ���� �д� �뵵�θ� ����� �� ����
  - �����ϴ� ����� �ִ� ������ ���� VO��� �ؼ��� �ȵ�


- DTO
  - ���� �а� ������ �� ����
  

- Entity
  - DB ���̺�� ���εǴ� ������ ��
  - JPA���� ��ƼƼ�� �����
  - DB �������� Ư���� ������ ����



- �Խ��� ������
  - �Խ��� �ۼ��ڸ�
  - �Խ��� �� ����
  - �Խ��� �� �ۼ� ��¥
  - �̸� �ϳ��� ���� Ŭ������ ������ ��
  


## View 


- ����� �������̽�
- ����ڿ��� �������̽��� ����ϴ� ���α׷��� `��(View)`�� �� (����ڿ��� ģ���ϰ� ó�� ����� ��Ÿ��)


## Controller

- DB�� ���� CRUD �۾��� �ʿ�� �� �� ��Ʈ�ѷ��� ���� ��û��
- ��Ʈ�ѷ��� ������ ���� �Һи��� �� ���� 
  - �̶� ��Ʈ�ѷ��� ������ �信�� DAO �����ϰԲ� �ٷ� �����ϴ� ��쵵 ����

<br>

# DAO

- DB ������ ����ؾ� ��

# VO

- �����Ͱ��� �����Ͽ��� �����ϴ� ����

# DTO

- �����Ͱ��� �����Ͽ��� �����ϴ� ����


<br>


# ���׸� Ÿ��

- �������� ���� Ÿ���� �Ű������� ������ Ŭ������ �������̽�
- ����ο� `<>` ��ȣ�� �ٰ� �� ���̿� Ÿ�� �Ķ����(�Ű�����)���� ��ġ��

```java
public class ClassName <A, B, ...> { ... }
public interface InterfaceName <A, B, ...> { ... }
```

- Ÿ�� �Ķ���ʹ� �Ϲ������� �빮�� ���ĺ� �� ���ڷ� ǥ����
- �ܺο��� ���׸� Ÿ���� ����ϱ� ���ؼ��� Ÿ�� �Ķ���Ϳ� ��ü���� Ÿ���� ������
<br> (�������� ������ �Ϲ������� Object Ÿ���� ����)


# ���ϵ�ī�� Ÿ�� �Ķ����

- ���׸� Ÿ���� �Ű����̳� ���� Ÿ������ ����� �� ������ �ִ� ��� Ÿ������ ��ü�� �� �ִ� Ÿ�� �Ķ����
- `?` ��ȣ�� ǥ���� (`?`�� ���� ������ �� �� �ְԲ� �������)
- API document�� ���ϵ�ī�� Ÿ�� �Ķ���͸� ����� �޼������ ����


- ����

```
// ��Ӱ��赵
Person > Worker 
Person > Student > HighStudent & MiddleStudent
```


```java
����Ÿ�� �޼���� (���׸�Ÿ��<? extends Student> ����) { ... }
// Student�� Student�� ����� �ֵ鸸(Student�� �ڼ�) ���׸� Ÿ���� �Ķ���ͷ� ����        
        
����Ÿ�� �޼���� (���׸�Ÿ��<? super Worker> ����) { ... }
// � Ŭ������ �����ؼ� �ش� Ŭ����Ÿ���� ������ ���� ���� �����ϰ� ���� �� super�� ���
// Worker�� Worker�� ������ Person�� ����

        
����Ÿ�� �޼���� (���׸�Ÿ��<?> ����) { ... }
// 
```

- ���׸� Ÿ��
  - Ŭ������ �������̽��� ������� �� Ŭ������ Ȥ�� �������̽��� �ڿ� `<Ÿ�� �Ķ����>`�� ����� ��
  - AraayList, LinkedList ���� �ش�� 
  - ���׸� Ÿ���� �Ű����� Ÿ������ ������ �� `ArrayList<Friend>`, `ArrayList<String>`, `ArrayList<StudentDTO>`, `ArrayList<Integer>`��� ���� ��ü Ÿ�� ���� �������� � Ÿ�������� ����
