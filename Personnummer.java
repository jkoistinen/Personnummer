// https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html#package.description
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
/*
Kontrollsiffran
Sista siffran i personnumret är en kontrollsiffra. Den räknas ut maskinellt med ledning av födelsetiden och födelsenumret.

Här följer ett exempel på hur man kan räkna fram kontrollsiffran (enligt den s.k. modulus-10-metoden med vikterna 1 och 2):

1. Siffrorna i födelsetiden och födelsenumret multipliceras växelvis med 2 och 1.

6 4 0 8 2 3 – 3 2 3
2 1 2 1 2 1    2 1 2
12,4,0,8,4,3, 6,2,6

2. Lägg ihop siffrorna i produkterna. Obs! 12 räknas som 1+2
1+2+4+0+8+4+3+6+2+6=36

3. Entalssiffran (6) i siffersumman dras från talet 10. 10-6=4.

Restsiffran (4) blir kontrollsiffra vilket gör att personnumret i exemplet blir 640823-3234.
Är restsiffran 10, blir kontrollsiffran 0.
 */

 public class Personnummer {

   public static boolean isDateValid(int year, int month, int day) {
    boolean dateIsValid = true;
    try {
        LocalDate.of(year, month, day);
    } catch (DateTimeException e) {
        dateIsValid = false;
    }
    return dateIsValid;
}

   public static void main(String[] args) {

     // Exempel på inmatning 850311-1234, 8503111234 eller 198503111234, 19850311-1234
     // Datum delen av personnummret ska alltid formateras till: 850311
     // År kan vara 1899.
     // Kontrollera längden på datum del av input, 19850311 = 8, 850311 = 6, därefter ta bort två första tecken om datum del är 8.
     

     //Ta bort - tecken om det finns

     //Kontrollera att allt är siffror

     //Kontrollera att födelsedatumet inte är ifrån framtiden

     //Existerar datumet

     //Validera kontrollsiffran

     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
     String formatter = dateTimeFormatter.format();
     System.out.println("DateTimeFormatter : " + formatter);



     System.out.println(isDateValid(2001,01,01));

   }

 }
