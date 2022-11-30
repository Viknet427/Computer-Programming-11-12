public class Main {

    public static void main(String[] args) {

        System.out.println("Initial time");
        Time time = new Time(23,59,59);
        System.out.println(time);

        System.out.println("Next second");
        time.nextSecond();
        System.out.println(time);

        System.out.println("Previous second");
        time.previousSecond();
        System.out.println(time);

        System.out.println("Set seconds to 79");
        time.setSecond(79);
        System.out.println(time);

        System.out.println("Set minutes to 79");
        time.setMinute(79);
        System.out.println(time);

        System.out.println("Set hours to 43");
        time.setHour(43);
        System.out.println(time);

        System.out.println("Time set to 54, 90, 74");
        time.setTime(54,90,74);
        System.out.println(time);

    }

}
