package EnumConcepts;

enum DaysOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String name;

    DaysOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isWeekday() {
        // Write your code here to check if this day is a weekday
        return !isHoliday();
    }

    public boolean isHoliday() {
        // Write your code here to check if this day is a holiday
        switch (this) {
            case SATURDAY, SUNDAY:
                return true;
            default:
                return false;

        }
    }
}