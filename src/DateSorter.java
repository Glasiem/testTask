import java.time.LocalDate;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> datesWithR = new ArrayList<>(); //creating two arrays that we will sort. One with dates with an 'r' in the month
        List<LocalDate> datesWithoutR = new ArrayList<>(); // Second with dates without an 'r' in the month

        for (int i = 0; i < unsortedDates.size(); i++) { //iterating through all dates
            int month = unsortedDates.get(i).getMonth().getValue(); // writing down int value of the month for convenience
            if (month < 9 && month > 4){ //The only months without an 'r' are May, June, July and August, so their numbers are 5-8
                datesWithoutR.add(unsortedDates.get(i)); // If this month is one of them then adding this date into the second array
            }
            else {
                datesWithR.add(unsortedDates.get(i)); // Else we add this date into the first array
            }
        }

        datesWithR.sort(((o1, o2) -> sortDates(o1,o2,true))); //Sorting ascending dates with an 'r'
        datesWithoutR.sort(((o1, o2) -> sortDates(o1,o2,false))); //Sorting descending dates without an 'r'

        List<LocalDate> sortedDates = new ArrayList<>();
        sortedDates.addAll(datesWithR); //Adding dates with an 'r' to the beginning of sorted array
        sortedDates.addAll(datesWithoutR); //Adding dates without an 'r' to the end of sorted array

        return sortedDates;
    }

    private int sortDates(LocalDate date1, LocalDate date2, Boolean isAscending){
        //Converting dates into integer format
        int dateAsInt1 = date1.getYear()*10000 + date1.getMonthValue()*100 + date1.getDayOfMonth();
        int dateAsInt2 = date2.getYear()*10000 + date2.getMonthValue()*100 + date2.getDayOfMonth();

        if (isAscending) { //if we need ascending order
            return dateAsInt1 - dateAsInt2;
        }
        else { //if we need descending order
            return dateAsInt2 - dateAsInt1;
        }
    }
}