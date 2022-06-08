package DesignMode.principle.dependenceInversion;

import org.checkerframework.checker.units.qual.C;

/**
 * @author Chris Yang
 * created 2022-05-24 16:31
 **/
public class dependenceInversion {
    public static void main(String[] args) {
        Student student = new Student();
        student.setCourse(new JavaCourse());
        student.studyImoocCourse();
    }
}


interface Course{
    void studyCourse();
}

class JavaCourse implements Course{

    @Override
    public void studyCourse() {
        System.out.println("I'm learning Java");
    }
}

class PythonCourse implements Course{

    @Override
    public void studyCourse() {
        System.out.println("I'm learning Python");
    }
}

class Student{

    private Course Course;

    public void setCourse(Course Course) {
        this.Course = Course;
    }

    public void studyImoocCourse(){
        Course.studyCourse();
    }
}

