package testVagrant;

import java.util.Calendar;

public class CalanderClass {

	public int countDays(int year, int month, String days) {
		days = days.toUpperCase();
		Calendar calendar = Calendar.getInstance();
		// Note that month is 0-based in calendar, bizarrely.
		calendar.set(year, month - 1, 1);
		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		int count = 0;
		for (int day = 1; day <= daysInMonth; day++) {
			calendar.set(year, month - 1, day);
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			switch (days) {
			case "MONDAY":
				if (dayOfWeek == Calendar.MONDAY) {
					count++;
				}
				break;
			case "TUESDAY":
				if (dayOfWeek == Calendar.TUESDAY) {
					count++;
				}
				break;
			case "WEDNESDAY":
				if (dayOfWeek == Calendar.WEDNESDAY) {
					count++;
				}
				break;
			case "THURSDAY":
				if (dayOfWeek == Calendar.THURSDAY) {
					count++;
				}
				break;
			case "FRIDAY":
				if (dayOfWeek == Calendar.FRIDAY) {
					count++;
				}
				break;
			case "SATURDAY":
				if (dayOfWeek == Calendar.SATURDAY) {
					count++;
				}
				break;
			case "SUNDAY":
				if (dayOfWeek == Calendar.SUNDAY) {
					count++;
				}
				break;
			}
		}
		return count;
	}
}
