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
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
      if(date.length() == 6) {
        formatter = DateTimeFormatter.ofPattern("yyMMdd");
      }

      LocalDate today = LocalDate.now();
      System.out.println(today.format(formatter));

      LocalDate inputDate = LocalDate.parse(date, formatter);
      System.out.println(inputDate.format(formatter));

      if(inputDate.isAfter(today)){
        System.out.println("Future date!");
      }


      //String text = today.format(formatter);
      //LocalDate parsedDate = LocalDate.parse(text, formatter);
      //"PARSED DATE:"+parsedDate);

      return false;
    }

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
     boolean run = true;
     //Outer While
    while(run){
       //Inner While
    while(true){
     String input = "";
     System.out.println("Skriv in ett personnummer.");
     System.out.println("Format: yyyymmdd-xxxx, yymmdd-xxxx med eller utan bindestreck (-)");
     System.out.println("Q för att avsluta programmet...");
     Scanner keyboard = new Scanner(System. in );
     input = keyboard.next().trim().replaceAll("-", "").toUpperCase();
     if(input.equals("Q")){
       run = false;
       break;
     }
     String date = input.substring(0, input.length() - 4);
     isFromFutureDate(date);
    if(!isLengthValid(input)) {
      System.out.println("Längden på det inmatade personnummret är fel, försök igen...");
      break;
    }
    if(!isDigits(input)) {
      System.out.println("Det finns bokstäver i personnummret, försök igen...");
      break;
    }
    if(!isControlNumberValid(input)) {
      System.out.println("Kontrollnummret är inte korrekt, försök igen...");
      break;
    }
    //String date = input.substring(0, input.length() - 4);
    //System.out.println("isLengthValid:"+isLengthValid(input));
    //System.out.println("dateIs:"+date);
    //System.out.println("isDigits:"+isDigits(input));
    //System.out.println("isMaleOrFemale:"+isMaleOrFemale(input));
    //System.out.println("isControlNumberValid:"+isControlNumberValid(input));
    //System.out.println("isValidDate:"+isValidDate(date));
    //isFromFutureDate(date);
    //Validate all and give answer if its a correct Personnummer
    if(isLengthValid(input) && isDigits(input) && isControlNumberValid(input)){
      System.out.println(input+" "+"är ett korrekt personnummer.");
    }

}
}
   }

 }
