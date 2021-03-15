import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date currentDate;
        try {
            currentDate = readDate(args[0]);
        } catch (NumberFormatException e){
            System.out.println("First argument should be a date in format DD.MM.YYYY");
            return;
        } catch (IllegalArgumentException d){
            System.out.println(d);
            return;
        }

        String param = (args.length > 1) ? args[1] : "0";
    }

    private static Date readDate(String args) throws IllegalArgumentException{
        String[] date = args.split("\\.");

        int day,month,year;

        day = Integer.parseInt(date[0]);
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Illegal day format. day should be in range [1; 31]");
        }

        month = Integer.parseInt(date[1]);
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Illegal month format. Month should be in range [1; 12]");
        }

        year = Integer.parseInt(date[2]);
        if (year < 1900 || year > 2100) {
            throw new IllegalArgumentException("Illegal year format. Year should be in range [1900; 2100]");
        }

        if (month == 2 && day > 28 && year % 4 != 0) {
            throw new IllegalArgumentException("This month have only 28 days");
        }
        else if (month == 2 && year % 4 == 0 && day > 29) {
            throw new IllegalArgumentException("This month have only 29 days");
        }

        if (month < 8) {
            if (month % 2 == 0 && day > 30 ) {
                throw new IllegalArgumentException("This month have only 30 days");
            }
        }
        else if (month % 2 == 1 && day > 30 ) {
            throw new IllegalArgumentException("This month have only 30 days");
        }

        return new Date(year - 1900, month - 1 , day,10,0);
    }
    }
}
