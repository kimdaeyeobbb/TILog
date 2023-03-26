package day0317.hw;
import java.util.Random;

import day0310.hw02.MethodLab7;

class LottoMachine {
    /* 멤버변수 */
    private int[] nums;

    public LottoMachine(){
        nums = new int[6];
    }

    public void createLottoNums(){
        Random random = new Random();  // 랜덤 객체 생성
        for (int i=0; i<nums.length; i++){
            nums[i] = random.nextInt(20)+1;
        }
    }
    /* 중복값 확인 */
    public void checkLottoNums() throws DuplicateException{
        for (int i=0; i<nums.length+1; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                        throw new DuplicateException();
                    }
                }
            }
        }

    /* Getter */
    public int[] getNums() {
        return nums;  // 실제 리턴되는 것은 힙에있는 배열객체의 참조값 -> printArray 메서드에 전달해서 출력
    }
}

public class LottoGame {
    public static void main(String[] args) {
        LottoMachine lm = new LottoMachine();
        lm.createLottoNums();
        System.out.print("로또 번호 확인 : ");
        MethodLab7.printArray(lm.getNums());
        try{
            lm.checkLottoNums();
            MethodLab7.printArray(lm.getNums());
        } catch(DuplicateException e){
            // catch 블록 내 변수가 어떤 타입인지에 따라서 catch 블록에서 처리할 수 있는 예외의 종류가 정해짐
            // DuplicateException 형과 그 자손객체까지는 전달받을 수 있음 (다형성)

            System.out.println(e.getMessage());  // 에러메시지
//            System.out.println(e.toString());  // 예외의 종류 & 에러메시지
//            e.printStackTrace();  // 예외의 종류 & 에러메시지 & 추적 내용
//            return;  // 불필요
        }
    }
}