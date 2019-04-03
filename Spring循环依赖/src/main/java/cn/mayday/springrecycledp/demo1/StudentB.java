package cn.mayday.springrecycledp.demo1;

/**
 * @description: TODO
 * @author: mayday
 * @date: 2019/4/1 23:25
 * @version: 1.0
 */
public class StudentB {

    private StudentC studentC ;

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }

    public StudentB() {
    }

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }
}