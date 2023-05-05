package ArrayAndArrayList;

public class WeekdaysArrayTest {
    public static void main(String[] args) {

        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", "Saturday"};

        String mostChars = "";
        for (String weekday: weekdays) {
            if(weekday.length()>mostChars.length()){
                mostChars=weekday;
            }

        }
        System.out.println(mostChars);


        // reverse order array printing
        for (int i = weekdays.length-1; i > 0 ; i--) {
            System.out.print(weekdays[i]+ " ");

        }
    }
}
