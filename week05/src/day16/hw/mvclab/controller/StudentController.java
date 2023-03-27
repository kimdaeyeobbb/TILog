package day16.hw.mvclab.controller;

import day16.hw.mvclab.model.StudentDAO;
import day16.hw.mvclab.model.StudentDTO;

public class StudentController {
    StudentDAO crud = new StudentDAO();

    /* Create */
    public void insert(String name, int score){
        StudentDTO stdo = new StudentDTO(name, score);
        if(crud.insertStudent(stdo)){
            System.out.println("입력 성공");
        } else {
            System.out.println("입력 실패");
        }
    }

    /* Read */
    public void printAll(){
        for (StudentDTO el: crud.getAllStudent()) {
            System.out.println(el);
        }
    }

    public void printScore(String name){
        int score = crud.getScore(new StudentDTO(name));
        if (score < 0){
            System.out.printf("%s학생은 존재하지 않습니다", name);
        } else {
            System.out.printf("%s학생의 점수는 %d점 입니다" , name, score);
        }
    }

    /* Update */
    public void update(String name, int score){
        if (crud.updateStudent(new StudentDTO(name, score))){
            System.out.printf("%s힉셍의 점수를 변경했습니다",name);
        } else {
            System.out.printf("%s학생은 존재하지 않습니다", name);
        }
    }

    /* Delete */
    public void delete(String name){
        if(crud.deleteStudent(new StudentDTO(name))){
            System.out.printf("%s학생의 데이터를 삭제했습니다", name);
        } else {
            System.out.printf("%s학생은 존재하지 않습니다", name);
        }
    }
}
