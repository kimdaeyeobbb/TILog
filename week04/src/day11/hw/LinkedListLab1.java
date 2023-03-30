package day11.hw;

import java.util.LinkedList;

class Person{
    private String name;
    Person (String name){
        this.name = name;
    }

    public String getInfo(){
        return name;
    }
}

class Friend extends Person{
    private String phoneNum;
    private String email;

    Friend(String name, String phoneNum, String email){
        super(name);
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " " + phoneNum + " " + email;
    }
}


public class LinkedListLab1 {
    public static void main(String[] args) {
        LinkedList<Friend> list = new LinkedList<Friend>();
        list.add(new Friend("김하나", "010-111-1111", "hana@hanmail.net"));
        list.add(new Friend("박두리", "010-222-2222", "two@hanmail.net"));
        list.add(new Friend("이세찌", "010-333-3333", "three@hanmail.net"));
        list.add(new Friend("정네찌", "010-444-4444", "four@hanmail.net"));
        list.add(new Friend("송다섯", "010-555-5555", "five@hanmail.net"));
        for (Friend el: list){
            System.out.println(el.getInfo());
        }
//
//        String[] names= {}
//        String[] phoneNums ={}
//        String[] emails ={}
    }
}
