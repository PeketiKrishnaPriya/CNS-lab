5import java.util.Scanner;

public class WaterJug1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user inputs for jug capacities and target amount
        System.out.print("Enter the capacity of Jug 1: ");
        int jug1Capacity = scanner.nextInt();

        System.out.print("Enter the capacity of Jug 2: ");
        int jug2Capacity = scanner.nextInt();

        System.out.print("Enter the target amount of water: ");
        int targetAmount = scanner.nextInt();

        // Validate input values
        if (jug1Capacity <= 0 || jug2Capacity <= 0 || targetAmount <= 0) {
            System.out.println("Capacities and target amount must be positive.");
            scanner.close();
            return;
        }

        if (targetAmount > jug1Capacity && targetAmount > jug2Capacity) {
            System.out.println("Target amount cannot be greater than both jug capacities.");
            scanner.close();
            return;
        }

        // Initialize both jugs
        int jug1 = 0;
        int jug2 = 0;

        // Print the initial state of the jugs
        System.out.println("Initial State: Jug1 (" + jug1 + "), Jug2 (" + jug2 + ")");

        // Keep track of steps taken
        int steps = 0;

        // Use a while loop to simulate the jug operations
        while (jug1 != targetAmount && jug2 != targetAmount) {
            if (jug1 == 0) {
                // Fill jug1 from the tap
                jug1 = jug1Capacity;
                steps++;
                System.out.println("Step " + steps + ": Fill Jug1 (" + jug1 + ", " + jug2 + ")");
            } else if (jug2 == jug2Capacity) {
                // Empty jug2
                jug2 = 0;
                steps++;
                System.out.println("Step " + steps + ": Empty Jug2 (" + jug1 + ", " + jug2 + ")");
            } else {
                // Pour water from jug1 to jug2
                int transfer = Math.min(jug1, jug2Capacity - jug2);
                jug1 -= transfer;
                jug2 += transfer;
                steps++;
                System.out.println("Step " + steps + ": Pour Jug1 into Jug2 (" + jug1 + ", " + jug2 + ")");
            }
        }

        // Print the final state of the jugs
        System.out.println("Final State: Jug1 (" + jug1 + "), Jug2 (" + jug2 + ")");

        // Check if the target amount is reached
        if (jug1 == targetAmount) {
            System.out.println("Target reached in Jug1: (" + jug1 + ", " + jug2 + ")");
        } else if (jug2 == targetAmount) {
            System.out.println("Target reached in Jug2: (" + jug1 + ", " + jug2 + ")");
        }

        // Close the scanner
        scanner.close();
    }
}
