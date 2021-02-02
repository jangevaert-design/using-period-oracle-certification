import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

public class UsingPeriod {


  public static void main(String[] args) {

    LocalDate start = LocalDate.of(2017, Month.FEBRUARY, 1);
    LocalDate end = LocalDate.of(2017, Month.APRIL, 30);
    Period period = Period.ofWeeks(1);

    //start.toEpochDay();//  number of days since January 1 1970


    cleanAnimalCage(start, end);
    System.out.println();
    cleanAnimalCage(start, end, period);
    System.out.println();

    System.out.println(start.plus(period));
    System.out.println(LocalDateTime.now().plus(period));
//    System.out.println(LocalTime.now().plus(period));throws exception because LocalTime does not
//    have weeks.

    Period yearAndMonth = Period.ofYears(1).ofMonths(1);
    System.out.println(yearAndMonth);//prints P1M (Period 1 Month). Only the last method will be returned.

    Period yearsAndMonth = Period.of(1, 1, 3);
    System.out.println(yearsAndMonth);//prints P1Y1M3D



  }

  public static void cleanAnimalCage(LocalDate start, LocalDate end) {
    while (start.isBefore(end)) {
      System.out.println("Need to clean cage on date: " + start);
      start = start.plusMonths(1);//adding 1 month. This works just fine but is not very flexible.
      //we can better work with periods.
    }
  }

  public static void cleanAnimalCage(LocalDate start, LocalDate end, Period period) {
    while (start.isBefore(end)) {
      System.out.println("Need to clean cage on date: " + start);
      start = start.plus(period);
    }
  }


}
