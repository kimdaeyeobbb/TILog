package day0317.hw;

import java.util.Random;
import java.lang.Exception;
import day0310.hw02.MethodLab7;

public class LottoGame {
    public static void main(String[] args) {
        LottoMachine lm = new LottoMachine();
        lm.createLottoNums();
        try{
            lm.checkLottoNums();
            MethodLab7.printArray(lm.getNums());
        } catch(Exception e){
            System.out.println(e.getMessage());  // 에러메시지
//            System.out.println(e.toString());  // 예외의 종류 & 에러메시지
//            e.printStackTrace();  // 예외의 종류 & 에러메시지 & 추적 내용
            return;
        }
    }
}

class LottoMachine {
    /* 멤버변수 */
    private int[] nums;

    public LottoMachine(){
        nums = new int[6];
    }

    public void createLottoNums(){
        Random random = new Random();  // 랜덤 객체 생성
        for (int i=0; i<6; i++){
            nums[i] = random.nextInt(20)+1;
        }
    }

    public void checkLottoNums() throws Exception{
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if(nums[i] == nums[j]){
                        throw new DuplicateException();
                    }
                }
            }
        }

    /* Getter */
    public int[] getNums() {
        return nums;
    }
}

