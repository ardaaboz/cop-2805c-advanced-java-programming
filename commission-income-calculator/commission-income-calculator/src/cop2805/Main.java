package cop2805;

public class Main {
    public static void main(String[] args) {

        // Values to calculate based upon
        // I declared them like this for better readability and flexibility.
        final double incrementAmount = 1000;
        final double maxSales = 20000;

        final double threshold1 = 5000;
        final double threshold2 = 10000;

        double salesAmount = 1000;
        double income;

        // Formatting and printing out
        System.out.println("Sales\t\t\tIncome");
        while (salesAmount <= maxSales) {
            income = computeIncome(salesAmount, threshold1, threshold2);
            System.out.println("$" + salesAmount + "\t\t\t" + "$" + income );
            salesAmount += incrementAmount;
        }
    }

    // Method
    public static double computeIncome(double salesAmount, double threshold1, double threshold2) {
        if (salesAmount <= threshold1) {
            return firstCommission(salesAmount);
        } else if (salesAmount > threshold1 && salesAmount <= threshold2) {
            return secondCommission(salesAmount);
        } else {
            return thirdCommission(salesAmount);
        }
    }

    // Commission calculations
    public static double firstCommission(double salesAmount) {
        return 5000 + (salesAmount * 0.08);
    }
    public static double secondCommission(double salesAmount) {
        return 5000 + (5000 * 0.08) + ((salesAmount - 5000) * 0.10);
    }
    public static double thirdCommission(double salesAmount) {
        return 5000 + (5000 * 0.08) + (5000 * 0.10) + ((salesAmount - 10000) * 0.12);
    }
}