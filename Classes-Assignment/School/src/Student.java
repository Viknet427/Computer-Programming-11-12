public class Student {

    private String firstName;
    private String lastName;
    private int grade;

    private static int id;
    private int studentId;

    //Creates a student object
    Student(String firstName, String lastName, int grade) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        studentId = id;
        id++;

    }

    public String toString() {

        return "Student[Name = " + firstName + " " + lastName + ", Grade = " + grade + "]";

    }

    public String getFirstName() {

        return firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public int getGrade() {

        return grade;

    }

    public int getStudentId() {

        return studentId;

    }

}
