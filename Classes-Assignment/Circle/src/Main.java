public class Main {

    public static void main(String[] args) {

        Circle def = new Circle();

        System.out.println(def.getRadius());

        def.setRadius(2.71);
        System.out.println(def.getRadius());

        System.out.println(def.getArea());
        System.out.println(def.getCircumference());

        System.out.println(def.toString() + "\n");

        Circle custom = new Circle(6);

        System.out.println("Radius: " + custom.getRadius());

        custom.setRadius(7);
        System.out.println("New Radius: " + custom.getRadius());

        System.out.println("Area: " + custom.getArea());
        System.out.println("Circumference: " + custom.getCircumference());

        System.out.println(custom.toString());

    }

}
