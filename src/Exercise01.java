import java.io.FileNotFoundException;

public class Exercise01 {
    public static void main(String[] args) {

    }
    private int hours;
    private int minutes;

    // constructs a time span with the given interval.
    // pre: hours >= 0 && minutes >=0
    public Exercise01(int hours, int minutes) {
        this.hours = 0;
        this.minutes = 0;
        add(hours, minutes);
    }
    // adds the given interval to this time span.
    //pre: hours >= 0 && minutes >=0
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException();
        }
        this.hours += hours;
        this.minutes += minutes;

        //converts each 60 minutes into one hour
        this.hours += this.minutes / 60;
        this.minutes = this.minutes % 60;
    }
    // returns a string for this time span, such as "6h 15m"
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}

















