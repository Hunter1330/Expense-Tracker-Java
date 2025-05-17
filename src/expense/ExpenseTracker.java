package expense;

public class ExpenseTracker {

	public static void main(String[] args) {

		switch (args[0]) {
		case "add": {
			if (args.length < 2) {
				System.out.println("java -cp src expense.ExpenseTracker add <description> <amount>");
			} else {
				ExpenseStorage.addExpense(args[1], Double.parseDouble(args[2]));
			}
			break;
		}
		case "list": {
			if (args.length == 2) {
				ExpenseStorage.displayExpense(args[1]);
			} else if (args.length == 1) {
				ExpenseStorage.displayExpense("");
			} else {
				System.out.println("java -cp src expense.ExpenseTracker list <year/month/day>");
			}
			break;
		}
		case "delete": {
			if (args.length < 2) {
				System.out.println("java -cp src expense.ExpenseTracker delete <id>");
			} else {
				ExpenseStorage.deleteId(Integer.parseInt(args[1]));
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + args[0]);
		}
	}

}
