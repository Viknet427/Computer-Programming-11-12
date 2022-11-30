public class Time {

    private int hour;
    private int minute;
    private int second;

    Time (int hour, int minute, int second) {

        setHour(hour);
        setMinute(minute);
        setSecond(second);

    }

    public int getHour() {

        return hour;

    }

    public int getMinute() {

        return minute;

    }

    public int getSecond() {

        return second;

    }

    public void setHour(int hour) {

        while (hour >= 24) {

            hour -= 24;

        }

        this.hour = hour;

    }

    public void setMinute(int minute) {

        while (minute >= 60) {

            minute -= 60;
            hour++;

        }

        setHour(hour);

        this.minute = minute;

    }

    public void setSecond(int second) {

        while (second >= 60) {

            second -= 60;
            minute++;

        }

        setMinute(minute);

        this.second = second;

    }

    //Sets the time
    public void setTime(int hour, int minute, int second) {

        setHour(hour);
        setMinute(minute);
        setSecond(second);

    }

    //toString method
    public String toString() {

        String hour = String.valueOf(this.hour);
        String minute = String.valueOf(this.minute);
        String second = String.valueOf(this.second);

        if (this.hour < 10) {

            hour = "0" + this.hour;

        }

        if (this.minute < 10) {

            minute = "0" + this.minute;

        }

        if (this.second < 10) {

            second = "0" + this.second;

        }

        return hour + ":" + minute + ":" +  second;

    }

    //Shows the time ahead one second
    public Time nextSecond() {

        second++;

        if (second == 60) {

            second = 0;
            minute++;

            if (minute == 60) {

                minute = 0;
                hour++;

                if (hour == 24) {

                    hour = 0;

                }

            }

        }

        return new Time(hour, minute, second);

    }

    //Shows the time back one second
    public Time previousSecond() {

        second--;

        if (second == -1) {

            second = 59;
            minute--;

            if (minute == -1) {

                minute = 59;
                hour--;

                if (hour == -1) {

                    hour = 23;

                }

            }

        }

        return new Time(hour, minute, second);

    }

}
