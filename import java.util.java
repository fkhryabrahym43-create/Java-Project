import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {
        // Constants
        final double DRINK_PRICE = 15.50;
        // Customer Information
        System.out.print("Enter customer name: ");
        String name = input.nextLine();
        System.out.print("Enter customer age: ");
        int age = input.nextInt();
        System.out.print("Enter meal price: ");
        double mealPrice = input.nextDouble();
        System.out.print("Enter number of drinks: ");
        int drinks = input.nextInt();
        System.out.print("Is the customer a student? (true/false): ");
        boolean student = input.nextBoolean();
        System.out.print("Enter service rating (1-5): ");
        int rating = input.nextInt();
        // Validate Rating
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5.");
        } else {
            // Bill Calculations
            double drinksCost = drinks * DRINK_PRICE;
            double subtotal = mealPrice + drinksCost;
            // Discount Calculation
            double discountRate = 0.0;
            if (student) {
                discountRate = 0.10;
            } else if (age >= 60) {
                discountRate = 0.05;
            } else {
                discountRate = 0.0;
            }
            double discountAmount = subtotal * discountRate;
            double afterDiscount = subtotal - discountAmount;
            // Tip Calculation
            double tipAmount = 0;
            if (rating == 4 || rating == 5) {
                tipAmount = afterDiscount * 0.10;
            }
            // Final Bill
            double finalBill = afterDiscount + tipAmount;
            int wholeAmount = (int) finalBill;
            // Print Receipt
            System.out.println("\n===== SMART RESTAURANT =====");
            System.out.println("Customer: " + name);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final Bill: $%.2f%n", finalBill);
            System.out.println("Whole Amount: $" + wholeAmount);
            System.out.println("============================");
        }
        input.close();
    }
}
}
