package day0320.hw;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class HashSetLab1 {
    public static void main(String[] args) {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<Integer>();

        while(set.size()<10){
            int randNum = random.nextInt(21)+10;
            set.add(randNum);
        }
        String result = "오늘의 로또 번호 : ";
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            if(!iterator.hasNext()){
                result += i;
            } else {
                result += i + ", ";
            }
        }

        System.out.println(result);
    }
}
