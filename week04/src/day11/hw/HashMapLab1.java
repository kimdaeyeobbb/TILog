package day11.hw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapLab1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        String country;
        Integer population;
        while(map.size()<5){
            System.out.print("나라이름을 입력하세요 : ");
            country = sc.next();

            System.out.print("인구 수를 입력하세요 : ");
            population = sc.nextInt();

            if (map.containsKey(country)){
                System.out.printf("나라명 %s는 이미 저장되었습니다.\n", country);
            } else {
                map.put(country, population);
                System.out.println("저장되었습니다.");
            }
        }
        String result = "입력된 데이터 : ";

        Set set2 = map.entrySet();
        Iterator iterator = set2.iterator();

        while(iterator.hasNext()){
            Entry<String, Integer> entry = (Entry)iterator.next();
            String key = (String)entry.getKey();
            int value = (Integer)entry.getValue();

            if(!iterator.hasNext()){
                result += key+"("+value+")";
            } else {
                result += key+"("+value+")"+", ";
            }
        }
        System.out.println("5개가 모두 입력되었습니다.");
        System.out.println(result);
        sc.close();
    }
}
