public class Student {

    private String firstName;
    private Courses[] courses;
    private static int id;
    private int studentId;

    Student(String firstName, Courses[] courses) {

        this.firstName = firstName;
        studentId = id;
        id++;
        this.courses = courses;

    }

    public String getFirstName() {

        return firstName;

    }

    public Courses[] getCourses() {

        return courses;

    }

    public int getStudentId() {

        return studentId;

    }

    public String toString() {

        return "Student[Student ID = " + studentId + ", Name = " + firstName + "]";

    }

    public void addCourse(String subjectName, int studentGrade) {

        Courses[] temp = new Courses[courses.length+1];
        System.arraycopy(courses, 0, temp, 0, courses.length);

        temp[temp.length-1] = new Courses(subjectName, studentGrade);
        courses = temp;

    }

    public int getAverageGrade() {

        int total = 0;

        for (Courses course : courses) {

            total += course.getStudentGrade();

        }

        return total/courses.length;

    }

    public void getSubjects() {

        for (Courses course : courses) {

            System.out.println(course.getSubjectName());

        }

    }

}
