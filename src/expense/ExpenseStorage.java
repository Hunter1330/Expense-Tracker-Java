package expense;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExpenseStorage {

	public static void addExpense(String desc, double amt) {
		try {
			FileWriter file = new FileWriter("expenses.csv",true);
			BufferedWriter buffer = new BufferedWriter(file);

			Expense exp = new Expense(1, null, desc, amt);

			buffer.write(exp.toCSV());
			buffer.newLine();
			
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
