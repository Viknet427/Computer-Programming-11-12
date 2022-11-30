import java.util.ArrayList;

public class School {

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    private String name;
    private int numOfRooms;
    private int numOfSubjects;

    //Creates a school with the name, students and teachers
    School(String name, int numOfRooms, int numOfSubjects, ArrayList<Teacher> teachers, ArrayList<Student> students) {

        this.name = name;
        this.numOfRooms = numOfRooms;
        this.numOfSubjects = numOfSubjects;

        this.teachers = teachers;
        this.students = students;

    }

    public String getName() {

        return name;

    }

    public int getNumOfRooms() {

        return numOfRooms;

    }

    public int getNumOfSubjects() {

        return numOfSubjects;

    }

    public void setNumOfRooms(int numOfRooms) {

        this.numOfRooms = numOfRooms;

    }

    public void setNumOfSubjects(int numOfSubjects) {

        this.numOfSubjects = numOfSubjects;

    }

    //Adds a teacher
    public void addTeacher(String firstName, String lastName, String subject) {

        teachers.add(teachers.size(), new Teacher(firstName, lastName, subject));

    }

    //Adds a student
    public void addStudent(String firstName, String lastName, int grade) {

        students.add(students.size(), new Student(firstName, lastName, grade));

    }

    //Deletes a teacher
    public void delTeacher(String firstName, String lastName, String subject) {

        ArrayList<Teacher> teachers1 = teachers;

        for (Teacher teacher : teachers1) {

            if (teacher.getFirstName().equals(firstName)) {

                if (teacher.getLastName().equals(lastName)) {

                    if (teacher.getSubject().equals(subject)) {

                        teachers1.remove(teacher);
                        break;

                    }

                }

            }

        }

        teachers = teachers1;

    }

    //Deletes a student
    public void delStudent(String firstName, String lastName, int grade) {

        ArrayList<Student> students1 = students;

        for (Student student : students1) {

            if (student.getFirstName().equals(firstName)) {

                if (student.getLastName().equals(lastName)) {

                    if (student.getGrade() == grade) {

                        students1.remove(student);
                        break;

                    }

                }

            }

        }

        students = students1;

    }

    public String getTeachers() {

        for (Teacher teacher : teachers) {

            System.out.println(teacher.toString());

        }

        return null;

    }

    public String getStudents() {

        for (Student student : students) {

            System.out.println(student.toString());

        }

        return null;

    }

}
