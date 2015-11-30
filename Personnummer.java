import java.time.LocalDate;
import java.time.DateTimeException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import java.util.Calendar;
import java.util.Date;

 public class Personnummer {

   public static boolean isDigits(String date) {
     boolean isOnlyDigits = true;
     for(int i = 0; i < date.length(); i++) {
       if (!Character.isDigit(date.charAt(i))) {
         isOnlyDigits = false;
       }
     }
     return isOnlyDigits;
   }

   public static boolean isLengthValid(String date) {
     if(date.length() == 10 || date.length() == 12) {
       return true;
     } else {
       return false;
     }
   }

   public static boolean isValidDate(String date) {
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    if(date.length() == 6) {
      df = new SimpleDateFormat("yyMMdd");
    }
    try {
        df.parse(date);
        return true;
    } catch (ParseException e) {
        return false;
    }
}
    public static boolean isFromFutureDate(String date) {
      return false;
    }

//    public static boolean isDateValidAndNotFromFuture(String date) {
//     boolean dateIsValid = true;
//     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyddMM");
//     LocalDate dateTime = LocalDate.parse(date, formatter);
//     try {
//         LocalDate.of(dateTime);
//     } catch (DateTimeException e) {
//         dateIsValid = false;
//     }
//     return dateIsValid;
// }

  public static String isMaleOrFemale(String input) {
     int lastNumber = input.charAt(input.length()-1);
    if (lastNumber % 2 != 0) {
      return "male";
    } else {
      return "female";
    }
    }

  public static boolean isControlNumberValid(String input) {
    String inputLastNumber = input.substring(input.length() - 1);
    if(input.length() == 12) {
      input = input.substring(2); // remove first two from year
    }
    input = input.substring(0, input.length()-1);
    int total = 0;
    for (int i = 0; i < input.length(); i++) {
      if(i % 2 == 0 && Character.getNumericValue(input.charAt(i)) * 2 >= 10) {

        int splitIt = Character.getNumericValue(input.charAt(i)) * 2;
        int firstInt = splitIt / 10;
        int secondInt = splitIt % 10;
        total = total + firstInt + secondInt;
      } else if (i % 2 == 0) {
        total = total + Character.getNumericValue(input.charAt(i)) * 2;
      } else {
        total = total + Character.getNumericValue(input.charAt(i)) * 1;
      }
    }
    int calculatedControlNumber = 10 - (total % 10);
    int controlNumberFromInput = Integer.parseInt(inputLastNumber);

    if (calculatedControlNumber == controlNumberFromInput) {
      return true;
    } else {
      return false;
    }
  }

   public static void main(String[] args) {
while(true){
     String input = "";
     System.out.println("Skriv in ett personnummer...");
     System.out.println("Format: yyyymmdd-xxxx, yymmdd-xxxx med eller utan bindestreck (-)");
     Scanner keyboard = new Scanner(System. in );
     input = keyboard.next().trim().replaceAll("-", "").toUpperCase();
     String date = input.substring(0, input.length() - 4);

    System.out.println("dateIs:"+date);
    System.out.println("isLengthValid:"+isLengthValid(input));
    System.out.println("isDigits:"+isDigits(input));
    System.out.println("isMaleOrFemale:"+isMaleOrFemale(input));
    System.out.println("isControlNumberValid:"+isControlNumberValid(input));
    System.out.println("isValidDate:"+isValidDate(date));


}
   }

 }
