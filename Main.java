public class Calendar {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Calendar <month> <year>");
            return;
        }
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        int[][] calendar = generateCalendar(month, year);
        printCalendar(calendar);
    }

    public static int[][] generateCalendar(int month, int year) {
        int[][] calendar = new int[6][7];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = 1;
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                if (i == 0 && j < firstDayOfWeek - 1) {
                    calendar[i][j] = 0;
                } else if (day > daysInMonth) {
                    calendar[i][j] = 0;
                } else {
                    calendar[i][j] = day;
                    day++;
                }
            }
        }
        return calendar;
    }

    public static void printCalendar(int[][] calendar) {
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            System.out.printf("%3s", day);
        }
        System.out.println();
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                if (calendar[i][j] == 0) {
                    System.out.printf("%3s", "");
                } else {
                    System.out.printf("%3d", calendar[i][j]);
                }
            }
            System.out.println();
        }
    }

}
