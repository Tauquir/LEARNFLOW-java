package internship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private String studentId;
    private String name;
    private List<Course> courses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }

}

class Course {
    private String courseId;
    private String name;
    private Map<Student, Integer> grades;

    public Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Map<Student, Integer> getGrades() {
        return grades;
    }

    public void assignGrade(Student student, int grade) {
        grades.put(student, grade);
    }

}

class Transcript {
    public static void generateTranscript(Student student) {
        System.out.println("Transcript for " + student.getName() + " (ID: " + student.getStudentId() + ")");
        System.out.println("Courses:");

        for (Course course : student.getCourses()) {
            System.out.println(course.getName() + ": " + getGrade(student, course));
        }
        System.out.println();

    }

    private static String getGrade(Student student, Course course) {
        Integer grade = course.getGrades().get(student);
        return (grade != null) ? grade.toString() : "N/A";
    }
}

public class StudentInformationSystem {
    public static void main(String[] args) {

        Student student1 = new Student("001", "Tauquir");
        Student student2 = new Student("002", "Muzammil");

        Course mathCourse = new Course("MATH101", "Introduction to Mathematics");
        Course historyCourse = new Course("HIST101", "World History");

        student1.enrollCourse(mathCourse);
        student2.enrollCourse(mathCourse);
        student1.enrollCourse(historyCourse);
        student2.enrollCourse(historyCourse);

        mathCourse.assignGrade(student1, 90);
        mathCourse.assignGrade(student2, 95);
        historyCourse.assignGrade(student1, 85);
        historyCourse.assignGrade(student2, 75);

        Transcript.generateTranscript(student1);
        Transcript.generateTranscript(student2);
    }
}

