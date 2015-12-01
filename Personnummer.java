import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Personnummer {

	public static boolean isDigits(String date) {
		boolean isOnlyDigits = true;
		for (int i = 0; i < date.length(); i++) {
			if (!Character.isDigit(date.charAt(i))) {
				isOnlyDigits = false;
			}
		}
		return isOnlyDigits;
	}

	public static boolean isLengthValid(String date) {
		if (date.length() == 10 || date.length() == 12) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidDate(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			if (date.length() == 6) {
				formatter = DateTimeFormatter.ofPattern("yMMdd");
			}
			LocalDate today = LocalDate.now();
			String text = today.format(formatter);
			LocalDate todayDate = LocalDate.parse(text, formatter);
			LocalDate inputDate = LocalDate.parse(date, formatter);

			//checks that date is not in the future
			if (todayDate.isAfter(inputDate)) {
				return true;
			}
			return false;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static String isMaleOrFemale(String input) {
		int lastNumber = input.charAt(input.length() - 1);
		if (lastNumber % 2 != 0) {
			return "male";
		} else {
			return "female";
		}
	}

	public static boolean isControlNumberValid(String input) {
		String inputLastNumber = input.substring(input.length() - 1);
		if (input.length() == 12) {
			input = input.substring(2); // remove first two from year
		}
		input = input.substring(0, input.length() - 1);
		int total = 0;
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0 && Character.getNumericValue(input.charAt(i)) * 2 >= 10) {

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
		while (run) {
			//Inner While
			while (true) {
				String input = "";
				System.out.println("Skriv in ett personnummer.");
				System.out.println("Format: yyyymmdd-xxxx, yymmdd-xxxx med eller utan bindestreck (-)");
				System.out.println("Q för att avsluta programmet...");
				System.out.println("---------------------------------------");
				Scanner keyboard = new Scanner(System. in );
				input = keyboard.next().trim().replaceAll("-", "").toUpperCase();
				if (input.equals("Q")) {
					run = false;
					break;
				}
				String date = input.substring(0, input.length() - 4);
				if (!isLengthValid(input)) {
					System.out.println("Längden på det inmatade personnummret är fel, försök igen...");
					break;
				}
				if (!isDigits(input)) {
					System.out.println("Det finns bokstäver i personnummret, försök igen...");
					break;
				}
				if (!isValidDate(date)) {
					System.out.println("Datumet du angav är inte korrekt, försök igen...");
					break;
				}
				if (!isControlNumberValid(input)) {
					System.out.println("Kontrollnummret är inte korrekt, försök igen...");
					break;
				}

				//Validate all and give answer if its a correct Personnummer
				if (isLengthValid(input) && isDigits(input) && isControlNumberValid(input) && isValidDate(date)) {
					System.out.println(input + " " + "är ett korrekt personnummer.");
				}

			}
		}
	}

}
