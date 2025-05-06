package expense;

public class ExpenseTracker {

	public static void main(String[] args) {

		switch (args[0]) {
		case "add": {
			if (args.length < 2) {
				System.out.println("Usage: java -cp src expense.ExpenseTracker add <description> <amount>");
			} else {
				ExpenseStorage.addExpense(args[1], Double.parseDouble(args[2]));
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + args[0]);
		}
	}

}
