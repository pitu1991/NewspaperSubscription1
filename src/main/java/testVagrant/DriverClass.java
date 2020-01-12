package testVagrant;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Map;
import java.util.Scanner;
import java.util.Calendar;

import testVagrant.DataFromExcelClass;

public class DriverClass {

	private static Scanner ss;
	private static String values;
	private static String temp;

	static String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CalanderClass Cal = new CalanderClass();
		ss = new Scanner(System.in);

		System.out.println("Enter the Month of the subscrption: ");
		int month = ss.nextInt();
		System.out.println("Enter the Month of the subscrption: ");
		int year = ss.nextInt();
		System.out.println("Enter the name of newspaper subscrption : ");
		values = ss.next();
		String[] spl = values.split(",");

		for (int i = 0; i < spl.length; i++) {
			Double sim = 0.0;
			Double sum = null;
			for (int j = 0; j < days.length; j++) {
				String val = null;
				temp = days[j];
				int daysCount = Cal.countDays(year, month, temp);
				for (int k = 1; k <= daysCount; k++) {
					val = DataFromExcelClass.getMapData(spl[i]).get(temp);
					sum = Double.valueOf(val);
					sum = sum * k;
				}
				sim += sum;
			}
			System.out.println("Monthly total cost of " + spl[i] + " is : " + sim);
		}

	}

}
