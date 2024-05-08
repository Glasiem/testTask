import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Testing on example
        DateSorter dateSorter = new DateSorter();
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2004,07,01));
        dates.add(LocalDate.of(2005,01,02));
        dates.add(LocalDate.of(2007,01,01));
        dates.add(LocalDate.of(2032,05,03));
        dates = (List<LocalDate>) dateSorter.sortDates(dates);
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dates.get(i).toString());
        }
    }
}