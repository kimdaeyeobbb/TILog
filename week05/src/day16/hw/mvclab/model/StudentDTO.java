package day16.hw.mvclab.model;

public class StudentDTO {
    private String name;
    private int score;

    public StudentDTO(){}
    public StudentDTO(String name){
        this.name = name;
    }

    public StudentDTO(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    @Override
    public String toString() {
        return "이름=" + name + " " +
                ", 성적=" + score;
    }


}
