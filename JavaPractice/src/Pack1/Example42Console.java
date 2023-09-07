package Pack1;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Example42Console {
    public static void main(String[] args) {
        System.out.println("\nTwinkle, twinkle, little star, \n\tHow I wonder what you are! \n\t\tUp above the world so high, \n\t\tLike a diamond in the sky. \nTwinkle, twinkle, little star, \n\tHow I wonder what you are!\n\n");
        int n = 5;
        System.out.printf("%d + %d%d  + %d%d%d\n", n, n, n, n, n, n);

//-----------------------------------
        System.out.format("\nCurrent Date time: %tc%n\n", System.currentTimeMillis());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        simpleDateFormat.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("IST")));

        System.out.println("Now SimpleDateFormat is: "+simpleDateFormat.format(System.currentTimeMillis()));

        //--------------------------------------
        Console cons;
        if ((cons = System.console()) != null) {
            char[] pass_ward = null;
            try {
                pass_ward = cons.readPassword("Input your Password:");
                System.out.println("Your password was: " + new String(pass_ward));
            } finally {
                if (pass_ward != null) {
                    java.util.Arrays.fill(pass_ward, ' ');
                }
            }
        } else {
            throw new RuntimeException("Can't get password...No console");
        }



    }
}
