# 과제 리뷰

## 1번

```java
package day0313.hw02;

import java.util.Scanner;
// 클래스가 public일 경우 생성자도 public인 것이 일반적 (default 일 경우 default)

class GradeExpr {
  private int jumsu[];

  GradeExpr(int jumsu[]) {
    this.jumsu = jumsu;
  }

  double getAverage() {
    return getTotal() / (double) jumsu.length;
  }
// 자바상 정수/정수는 -> 정수임
//  둘중 하나라도 double형이라면 나눗셈 연산을 했을 때 결과가 double형임

  int getTotal() {
    int sum = 0;
    for (int i = 0; i < jumsu.length; i++) {
      sum += jumsu[i];
    }
    return sum;
  }

  int getGoodScore() {
    int good = jumsu[0];
    for (int i = 0; i < jumsu.length; i++) {
      if (good < jumsu[i]) {
        good = jumsu[i];
      }
    }
    return good;
  }

  int getBadScore() {
    int bad = jumsu[0];
    for (int i = 0; i < jumsu.length; i++) {
      if (bad > jumsu[i]) {
        bad = jumsu[i];
      }
    }
    return bad;
  }
}

public class GradeTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int count = scanner.nextInt();
    int[] arr = new int[count];

    for (int i = 0; i < count; i++) {
      arr[i] = scanner.nextInt();
    }

    day0313.course.hw02.GradeExpr ge = new day0313.course.hw02.GradeExpr(arr);
    System.out.print("점수들 : ");
    for (int i = 1; i < arr.length; i++) {
      System.out.printf(", %d", arr[i]);

      System.out.println("총점 : " + ge.getTotal());
      System.out.println("평균 : " + ge.getAverage());
      System.out.println("최고 점수 : " + ge.getGoodScore());
      System.out.println("최저 점수 : " + ge.getBadScore());
    }
  }
}
```

- 생성자 호출을 못하는데 객체 생성을 어떻게 하나?
  - 팩토리 메서드를 이용 (객체 생성을 대신해줌)
  - new 연산자를 이용하는것보다 팩토리 메서드를 이용하는 경우가 많다.


## 2번

```JAVA
package day0313.hw02;

import java.util.Scanner;

class CalculatorExpr {
  private int num1;
  private int num2;

  CalculatorExpr(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  int getAddition() {
    return num1 + num2;
  }

  int getSubtraction() {
    if (num1 >= num2) {
      return num1 - num2;
    } else {
      return num2 - num1;
    }
  }

  int getMultiplication() {
    return num1 * num2;
  }

  double getDivision() {
    double result;
    if (num1 == 0) {
      result = (double) num1 / num2;
    } else if (num2 == 0) {
      result = (double) num2 / num1;
    } else {
      result = (double) num1 / num2;
    }
    return result;
  }
}

public class CalculatorTest {
  public static void main(String[] args) {

    int beingPlay = 1;
    while (beingPlay != 0) {
      Scanner sc = new Scanner(System.in);
      System.out.print("입력된 숫자 : ");
      int number1 = sc.nextInt();
      int number2 = sc.nextInt();
      if (beingPlay == 0) {
        break;
      } else {
        day0313.course.hw02.CalculatorExpr ce = new day0313.course.hw02.CalculatorExpr(number1, number2);
        System.out.println("덧셈 : " + ce.getAddition());
        System.out.println("뺄셈 : " + ce.getSubtraction());
        System.out.println("곱셈 : " + ce.getMultiplication());
        System.out.println("나눗셈 : " + ce.getDivision());
      }
      System.out.print("계속 하시곘습니까? (종료 하며려면 0입력): ");
      beingPlay = sc.nextInt();
    }
  }
}
```

- 클래스 다이어그램 앞에 아무 표시도 없으면 public 표시도 하면 안됨
- 자바 문자열 비교시 equals 메서드를 이용

```java
package day0313.hw02;

import java.util.Scanner;

class CalculatorExpr {
  private int num1;
  private int num2;

  CalculatorExpr(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  int getAddition() {
    return num1 + num2;
  }

  int getSubtraction() {
    if (num1 >= num2) {
      return num1 - num2;
    } else {
      return num2 - num1;
    }
  }

  int getMultiplication() {
    return num1 * num2;
  }

  double getDivision() {
    double result;
    if (num1 == 0) {
      result = (double) num1 / num2;
    } else if (num2 == 0) {
      result = (double) num2 / num1;
    } else {
      result = (double) num1 / num2;
    }
    return result;
  }
}

public class CalculatorTest {
  public static void main(String[] args) {

    int beingPlay = 1;
    while (beingPlay != 0) {
      Scanner sc = new Scanner(System.in);
      System.out.print("입력된 숫자 : ");
      int number1 = sc.nextInt();
      int number2 = sc.nextInt();
      if (beingPlay == 0) {
        break;
      } else {
        day0313.course.hw02.CalculatorExpr ce = new day0313.course.hw02.CalculatorExpr(number1, number2);  // 계속 추가적으로 생성자 사용하므로 잘못됨
        System.out.println("덧셈 : " + ce.getAddition());
        System.out.println("뺄셈 : " + ce.getSubtraction());
        System.out.println("곱셈 : " + ce.getMultiplication());
        System.out.println("나눗셈 : " + ce.getDivision());
      }
      System.out.print("계속 하시곘습니까? (종료 하며려면 0입력): ");
      beingPlay = sc.nextInt();
    }
  }
}
```

```java
package day0313.hw02;

import java.util.Scanner;

class CalculatorExpr {
  private int num1;
  private int num2;

  CalculatorExpr(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  int getAddition() {
    return num1 + num2;
  }

  int getSubtraction() {
    if (num1 >= num2) {
      return num1 - num2;
    } else {
      return num2 - num1;
    }
  }

  int getMultiplication() {
    return num1 * num2;
  }

  double getDivision() {
    double result;
    if (num1 == 0) {
      result = (double) num1 / num2;
    } else if (num2 == 0) {
      result = (double) num2 / num1;
    } else {
      result = (double) num1 / num2;
    }
    return result;
  }
}

public class CalculatorTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    day0313.course.hw02.CalculatorExpr ce = new day0313.course.hw02.CalculatorExpr(number1, number2);

    int beingPlay = 1;
    while (beingPlay != 0) {
      System.out.print("입력된 숫자 : ");
      int number1 = sc.nextInt();
      int number2 = sc.nextInt();


      if (beingPlay == 0) {
        break;
      } else {
        System.out.println("덧셈 : " + ce.getAddition());
        System.out.println("뺄셈 : " + ce.getSubtraction());
        System.out.println("곱셈 : " + ce.getMultiplication());
        System.out.println("나눗셈 : " + ce.getDivision());
      }
      System.out.print("계속 하시곘습니까? (종료 하며려면 0입력): ");
      beingPlay = sc.nextInt();
    }
  }
}
```

- 생성자는 한번만 생성하고 값만 바꿔치기해야 효율적임. 잘 고민해서 고쳐볼것

```java
package day0313.hw02;

import java.util.Scanner;

class CalculatorExpr {
  private int num1;
  private int num2;

  CalculatorExpr(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  int getAddition() {
    return num1 + num2;
  }

  int getSubtraction() {
    if (num1 >= num2) {
      return num1 - num2;
    } else {
      return num2 - num1;
    }
  }

  int getMultiplication() {
    return num1 * num2;
  }

  double getDivision() {
    double result;
    if (num1 == 0) {
      result = (double) num1 / num2;
    } else if (num2 == 0) {
      result = (double) num2 / num1;
    } else {
      result = (double) num1 / num2;
    }
    return result;
  }
}

public class CalculatorTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num1, num2;
    System.out.println("숫자 두개를 입력하세요.");
    num1 = sc.nextInt();
    num2 = sc.nextInt();
    day0313.course.hw02.CalculatorExpr ce = new day0313.course.hw02.CalculatorExpr(num1, num2);
    System.out.print("입력된 숫자 : %d, %d\n", num1, num2);
    System.out.printf("덧셈 : %d\n" + ce.getAddition());
    System.out.printf("뺄셈 : %d\n" + ce.getSubtraction());
    System.out.printf("나눗셈 : %.2f\n" + ce.getDivision());
    System.out.printf("곱셈 : %d\n" + ce.getMultiplication());

    int beingPlay = 1;
    while (beingPlay != 0) {
      if (beingPlay == 0) {
        sc.close();
        break;
      } else {
        System.out.println("숫자 두개를 입력하세요.");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        1
        System.out.printf("덧셈 : %d\n" + ce.getAddition());
        System.out.printf("뺄셈 : %d\n" + ce.getSubtraction());
        System.out.printf("나눗셈 : %.2f\n" + ce.getDivision());
        System.out.printf("곱셈 : %d\n" + ce.getMultiplication());
      }
      System.out.print("계속 하시곘습니까? (종료 하며려면 0입력): ");
      beingPlay = sc.nextInt();
    }
    sc.close();
  }
}
```