# 과제 1

```java

import java.util.Arrays;
class Trainee {
	private final String name;
    private final boolean isMale; // 성별
    private final int hak; // 학년
    private final int ban; // 반
    private final int score;	    

    public Trainee(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public boolean isMale() {
		return isMale;
	}
	public int getHak() {
		return hak;
	}
	public int getBan() {
		return ban;
	}
	public int getScore() {
		return score;
	}
	public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }
}
public class StreamLab {	
   public static void main(String args[]) {		
		Trainee[] sa = new Trainee[]{
	                new Trainee("나자바", true, 1, 1, 300),
	                new Trainee("김지미", false, 1, 1, 250),
	                new Trainee("김자바", true, 1, 1, 200),
	                new Trainee("이지미", false, 1, 2, 150),
	                new Trainee("남자바", true, 1, 2, 100),
	                new Trainee("안지미", false, 1, 2, 50),
	                new Trainee("황지미", false, 1, 3, 100),
	                new Trainee("강지미", false, 1, 3, 150),
	                new Trainee("이자바", true, 1, 3, 200),
	                new Trainee("나자바", true, 2, 1, 300),
	                new Trainee("김지미", false, 2, 1, 250),
	                new Trainee("김자바", true, 2, 1, 200),
	                new Trainee("이지미", false, 2, 2, 150),
	                new Trainee("남자바", true, 2, 2, 100),
	                new Trainee("안지미", false, 2, 2, 50),
	                new Trainee("황지미", false, 2, 3, 100),
	                new Trainee("강지미", false, 2, 3, 150),
	                new Trainee("이자바", true, 2, 3, 200)
	        };
	// 모든 문제들은 위의 배열 객체를 가지고 스트림 객체를 만든 다음에 해결한다.
        	// (1) Trainee 객체들을 화면에 출력한다.

	// (2) 성적이 높은 순으로 Trainee 객체들을 화면에 출력한다.

	// (3) 성적이 200 이상인 Trainee 객체들을 화면에 출력한다.

	// (4) 성적이 200 이상인 수강생들의 인원을 출력한다.
		
	// (5) 남학생의 Trainee 객체들을 화면에 출력한다.

	// (6) 남학생의 인원을 출력한다.

	// (7) 모든 학생들의 스코어만 출력한다.

	// (8) 모든 학생들의 스코어 합을 출력한다.
		
   }
}

```

# 과제 1 정답

```java
package day18.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Trainee {
    private final String name;
    private final boolean isMale; // 성별
    private final int hak; // 학년
    private final int ban; // 반
    private final int score;

    public Trainee(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }
}

public class StreamLab {
    public static void main(String args[]) {
        /* 배열 객체 */
        Trainee[] sa = new Trainee[]{
                new Trainee("나자바", true, 1, 1, 300),
                new Trainee("김지미", false, 1, 1, 250),
                new Trainee("김자바", true, 1, 1, 200),
                new Trainee("이지미", false, 1, 2, 150),
                new Trainee("남자바", true, 1, 2, 100),
                new Trainee("안지미", false, 1, 2, 50),
                new Trainee("황지미", false, 1, 3, 100),
                new Trainee("강지미", false, 1, 3, 150),
                new Trainee("이자바", true, 1, 3, 200),
                new Trainee("나자바", true, 2, 1, 300),
                new Trainee("김지미", false, 2, 1, 250),
                new Trainee("김자바", true, 2, 1, 200),
                new Trainee("이지미", false, 2, 2, 150),
                new Trainee("남자바", true, 2, 2, 100),
                new Trainee("안지미", false, 2, 2, 50),
                new Trainee("황지미", false, 2, 3, 100),
                new Trainee("강지미", false, 2, 3, 150),
                new Trainee("이자바", true, 2, 3, 200)
        };
        // 모든 문제들은 위의 배열 객체를 가지고 스트림 객체를 만든 다음에 해결한다.
        // 주로 filter, forEach, count, sum, average 등의 메서드를 이용해서 해결
        // 리턴값이 숫자인 경우 System.out.println을 사용해야 할 수도 있음


        // (1) Trainee 객체들을 화면에 출력한다.
        System.out.println("Trainee 객체들을 화면에 출력합니다");
        Arrays.stream(sa).forEach(System.out::println);


        // (2) 성적이 높은 순으로 Trainee 객체들을 화면에 출력한다.
        System.out.println("\n성적이 높은 순으로 Trainee 객체를 출력합니다");
        Arrays.stream(sa)
                .sorted(Comparator.comparing((Trainee t) -> t.getScore())
                        .reversed()
                        .forEach(System.out::println));

        // (3) 성적이 200 이상인 Trainee 객체들을 화면에 출력한다.
        System.out.println("\n성적이 200점 이상인 Trainee 객체들을 출력합니다");
      
        
        Stream<Trainee> traineeStream2 = Arrays.stream(sa);
        traineeStream2
                .map(x -> x)
                .filter(x -> x.getScore() >= 200)
                .forEach(x -> System.out.println(x));


        // (4) 성적이 200 이상인 수강생들의 인원을 출력한다.
        System.out.println("\n성적이 200점 이상인 수강생들의 인원을 출력합니다");
        System.out.println(
                Arrays.stream(sa)
                .filter(n -> n.getScore() >= 200)
                .count() + "명");

        // (5) 남학생의 Trainee 객체들을 화면에 출력한다.
        System.out.println("\n남학생의 Trainee 객체들을 화면에 출력합니다");
        Arrays.stream(sa)
                .filter(n -> n.isMale()
                        .forEach(System.out::println));
        
        // (6) 남학생의 인원을 출력한다.
        System.out.println("\n남학생의 인원을 출력합니다");
        
        System.out.println(
                Arrays.stream(sa)
                        .filter(n -> n.isMale())
                        .count()
                        + "명");


        // (7) 모든 학생들의 스코어만 출력한다.
        System.out.println("\n모든 학생들의 스코어만 출력합니다");
        Arrays.stream(sa)
                .forEach(x -> System.out.println(x.getName() + ": " +x.getScore())+"점");
        
        
        // (8) 모든 학생들의 스코어 합을 출력한다.
        System.out.println("\n모든 학생들의 스코어 합을 출력합니다");
        System.out.println(
                Arrays.stream(sa)
                        .mapToInt(x -> x.getScore())
                        .sum()
                        + "점");
    }
}
```