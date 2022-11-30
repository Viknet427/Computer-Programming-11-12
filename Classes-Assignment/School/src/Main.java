import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Alex", "Chen", 1));
        students.add(new Student("Emily", "Chen", 1));
        students.add(new Student("Tyrone", "Zheng", 12));
        students.add(new Student("Audrey", "Zeng", 5));
        students.add(new Student("Donald", "Tam", 6));
        students.add(new Student("Hubert", "Wolfeschlegelsteinhausenbergerdorff", 2));
        students.add(new Student("Neil", "Tu", 5));
        students.add(new Student("Terry", "Zeng", 2));
        students.add(new Student("Emily", "Watson", 10));
        students.add(new Student("Walter", "Chen", 3));

        teachers.add(new Teacher("Paul", "Pham", "Science"));
        teachers.add(new Teacher("Mark", "Panaligan", "PHE"));
        teachers.add(new Teacher("Alex", "Zeng", "Mandarin"));

        School school = new School("Windermere", 30, 20, teachers, students);

        school.getTeachers();
        school.getStudents();

        System.out.println();

        school.delStudent("Emily", "Watson", 10);
        school.delStudent("Neil", "Tu", 5);
        school.delTeacher("Paul", "Pham", "Science");

        school.getTeachers();
        school.getStudents();

    }

}
