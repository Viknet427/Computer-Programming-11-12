public class Cars {

    private String color;
    private int id;
    private int curentSpeed;
    private String name;

    //Constructors
    Cars(String color, int id, int curentSpeed, String name) {

        this.color = color;
        this.id = id;
        this.curentSpeed = curentSpeed;
        this .name = name;

    }

    //Methods
    public void setColor(String color) {

        this.color = color;

    }

    public String getColor() {

        return color;

    }

    public void setCurentSpeed(int speed) {

        if (speed < 0) {

            speed = 0;

        }
        else {

            this.curentSpeed = speed;

        }

    }

    public String toString() {

        return "Make: " + name + " Color: " + color;

    }

}
