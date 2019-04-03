package cn.mayday.springrecycledp.demo1;

/**
 * @description: TODO
 * @author: mayday
 * @date: 2019/4/1 23:24
 * @version: 1.0
 */
public class StudentA {

    private StudentB studentB;

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }

    public StudentA() {
    }

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }
}