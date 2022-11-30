public class Teacher {

    private String firstName;
    private String lastName;
    private String subject;

    //Creates a teacher object
    Teacher(String firstName, String lastName, String subject) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;

    }

    public String toString() {

        return "Teacher[Name = " + firstName + " " + lastName + ", Subject = " + subject + "]";

    }

    public String getFirstName() {

        return firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public String getSubject() {

        return subject;

    }

}
