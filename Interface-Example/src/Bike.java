public class Bike implements Vehicle {

    int speed;
    int gear;

    @Override
    public void changeGear(int newGear) {

        gear = newGear;

    }

    @Override
    public void speedUp(int increment) {

        speed += increment;

    }

    @Override
    public void applyBreaks(int decrement) {

        speed -= decrement;

    }

    public void printStates() {

        System.out.println("Speed: " + speed + "\nGear: " + gear);

    }

}
