package expense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseStorage {

	static String fileName = "expenses.csv";

	public static void addExpense(String desc, double amt) {
		try {
			FileWriter file = new FileWriter(fileName, true);
			BufferedWriter buffer = new BufferedWriter(file);

			Expense exp = new Expense(desc, amt);

			buffer.write(exp.toCSV());
			buffer.newLine();

			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getNextId() {
		int num = 0;
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(file);
			while (buffer.ready()) {
				String out = buffer.readLine();
				String[] arr = out.split(",");
				num = Integer.parseInt(arr[0]);
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num + 1;
	}

	public static void displayExpense(String compare) {
		try {
			double total = 0;
			FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(file);
			System.out.printf("%-5s %-12s %-20s %-10s\n", "ID", "Date", "Description", "Amount");
			System.out.println("-----------------------------------------------------------");
			while (buffer.ready()) {
				String out = buffer.readLine();
				String[] arr = out.split(",");
				if (arr[1].startsWith(compare)) {
					System.out.printf("%-5s %-12s %-20s %-10s\n", arr[0], arr[1], arr[2], arr[3]);
					total += Double.parseDouble(arr[3]);
				}
			}
			System.out.println("-----------------------------------------------------------");
			System.out.printf("%-18s %-20s %-10s\n", "", "Total :", Double.toString(total));
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deleteId(int id) {
		try {
			List<Expense> expenses = getAllExpence();
			List<Expense> afterDelete = new ArrayList<Expense>();

			for (Expense e : expenses) {
				if (e.getId() != id) {
					afterDelete.add(e);
				}
			}

			addAllExpence(afterDelete);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	private static void addAllExpence(List<Expense> afterDelete) {
		try {
			FileWriter file = new FileWriter(fileName, false);
			BufferedWriter buffer = new BufferedWriter(file);
			for (Expense e : afterDelete) {
				buffer.write(e.toCSV());
				buffer.newLine();
			}
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Expense> getAllExpence() {
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(file);
			while (buffer.ready()) {
				String out = buffer.readLine();
				String[] arr = out.split(",");

				Expense e = new Expense(Integer.parseInt(arr[0]), LocalDate.parse(arr[1]), arr[2],
						Double.parseDouble(arr[3]));

				expenses.add(e);
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return expenses;
	}

}
