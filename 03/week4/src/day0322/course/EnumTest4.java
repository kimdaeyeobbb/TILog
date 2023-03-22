package day0322.course;
enum SeasonInit{
   SPRING("봄"), SUMMER("여름"), FALL("가을"), WINTER("겨울");
   private final String name;
   // 1. 상수의 값을 보관하기 위한 용도 (반드시 private final형 이어야 함)

   // 2. 상수값을 전달받는 생성자 메서드
   SeasonInit(String name){
      this.name = name;
   }

   // 1.과 2.가 있으면 Enum에 정의된 상수의 값을 바꿀 수 있음
   // 다른 값으로 초기화되는 상수를 사용할 수 있게 만들어준다!

   String returnName(){
      return name;
   }
}
public class EnumTest4 {
   public static void main(String args[]) {
      SeasonInit day[] = SeasonInit.values();
      for(SeasonInit value  : day)
         System.out.println(value);
      for(SeasonInit value  : day)
    	 System.out.println(value.returnName()); 
      SeasonInit season = SeasonInit.valueOf("SUMMER");
      System.out.println("SeasonInit.valueOf(\"SUMMER\") : " + season); // SUMMER 출력
      System.out.println(	"SeasonInit.valueOf(\"SUMMER\").returnName() : " + season.returnName());  // 여름 출력 
   }
}
