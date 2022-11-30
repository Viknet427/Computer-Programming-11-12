public class Main {

    public static void main(String[] args) {

        Courses[] courses = new Courses[2];
        courses[0] = new Courses("Math", 86);
        courses[1] = new Courses("Science", 94);

        Student student = new Student("Hubert", courses);

        student.getSubjects();
        System.out.println(student.getAverageGrade() + "%\n");

        student.addCourse("Social Studies", 78);
        student.getSubjects();
        System.out.println(student.getAverageGrade() + "%\n");

        System.out.println(student.toString());
        for (Courses course : courses) {

            System.out.println(course.toString());

        }

        Student student1 = new Student("Terry", courses);
        System.out.println(student1.toString());

    }

}
