package cn.mayday.springrecycledp.demo1;

/**
 * @description: TODO
 * @author: mayday
 * @date: 2019/4/1 23:25
 * @version: 1.0
 */
public class StudentC {

    private StudentA studentA;

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }

    public StudentC() {
    }

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }
}