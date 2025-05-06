package expense;

import java.time.LocalDate;

public class Expense {
	private int id;
	private LocalDate date;
	private String description;
	private double amount;

	public Expense(int id, LocalDate date, String description, double amount) {
		this.id = id;
		this.date = LocalDate.now();
		this.description = description;
		this.amount = amount;
	}
	
	public String toCSV() {
		return id + "," + date + "," + description + "," + amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
