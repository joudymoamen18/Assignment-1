import java.util.Scanner;
class Transaction {
    protected double amount;
    protected String description;

    public Transaction(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {

        return amount;
    }

    public String toString() {

        return description + " : " + amount;
    }
}
class Income extends Transaction {

    public Income(double amount, String description) {
        super(amount, description);
    }

    public String toString() {
        return "Income -> " + super.toString();
    }
}
class Expense extends Transaction {

    public Expense(double amount, String description) {
        super(amount, description);
    }

    public String toString() {
        return "Expense -> " + super.toString();
    }
}
class BudgetManager {

    private Transaction[] transactions = new Transaction[100];
    private int count = 0;
    private double balance = 0;
    private double savingGoal = 0;

    public void addIncome(Income income) {
        transactions[count++] = income;
        balance += income.getAmount();
    }

    public void addExpense(Expense expense) {
        transactions[count++] = expense;
        balance -= expense.getAmount();
    }

    public void showTransactions() {
        for (int i = 0; i < count; i++) {
            System.out.println(transactions[i]);
        }
    }

    public void showBalance() {
        System.out.println("Balance = " + balance);
    }

    public void setSavingGoal(double g) {
        savingGoal = g;
    }

    public void showGoalStatus() {
        if (balance >= savingGoal)
            System.out.println("Goal reached ");
        else
            System.out.println("You need " + (savingGoal - balance));
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BudgetManager manager = new BudgetManager();

        while (true) {
            System.out.println("\n1.Add Income");
            System.out.println("2.Add Expense");
            System.out.println("3.Show Balance");
            System.out.println("4.Show Transactions");
            System.out.println("5.Set Goal");
            System.out.println("6.Show Goal Status");
            System.out.println("7.Exit");

            int c = input.nextInt();

            if (c == 1) {
                System.out.print("Amount: ");
                double a = input.nextDouble();
                input.nextLine();
                System.out.print("Description: ");
                String d = input.nextLine();
                manager.addIncome(new Income(a, d));
            }

            else if (c == 2) {
                System.out.print("Amount: ");
                double a = input.nextDouble();
                input.nextLine();
                System.out.print("Description: ");
                String d = input.nextLine();
                manager.addExpense(new Expense(a, d));
            }

            else if (c == 3)
                manager.showBalance();

            else if (c == 4)
                manager.showTransactions();

            else if (c == 5) {
                System.out.print("Goal: ");
                manager.setSavingGoal(input.nextDouble());
            }
            else if (c == 6)
                manager.showGoalStatus();

            else if (c == 7)
                break;
        }
    }
}