import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        while (true) {
            // Display main menu
            System.out.println("Greetings from the Vehicle Rental Service");
            System.out.println("1. Lease a vehicle");
            System.out.println("2. Hand back a vehicle");
            System.out.println("3. Insert a new vehicle (Admin only)");
            System.out.println("4. Show current vehicle list (Admin only)");
            System.out.println("5. Quit the program");
            System.out.print("Kindly choose an option from the list: ");
            int action = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (action == 5) {
                System.out.println("Exiting the application.");
                break;
            }

            if (action == 3 || action == 4) {
                // Verify admin password
                System.out.print("Enter admin password: ");
                String inputPassword = scanner.nextLine();
                if (!admin.verifyPassword(inputPassword)) {
                    System.out.println("Incorrect password. Access denied.");
                    continue;
                }
            }

            if (action == 3) {
                // Admin adds a vehicle
                System.out.println("Select vehicle type to add:");
                System.out.println("1. Car");
                System.out.println("2. Motorcycle");
                System.out.println("3. Truck");
                System.out.print("Please enter your choice: ");
                int vehicleChoice = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter vehicle ID: ");
                String vehicleId = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                System.out.print("Enter base rental rate: ");
                double baseRentalRate = scanner.nextDouble();
                scanner.nextLine();

                Vehicle vehicle = null;
                switch (vehicleChoice) {
                    case 1:
                        vehicle = new Car(vehicleId, model, baseRentalRate);
                        break;
                    case 2:
                        vehicle = new Motorcycle(vehicleId, model, baseRentalRate);
                        break;
                    case 3:
                        vehicle = new Truck(vehicleId, model, baseRentalRate);
                        break;
                    default:
                        System.out.println("Invalid vehicle type.");
                        continue;
                }

                admin.addVehicle(vehicle);
            } else if (action == 4) {
                // Admin displays the vehicle fleet
                admin.displayFleet();
            } else if (action == 1) {
                // Display available vehicles for rent
                System.out.println("Available vehicles for rent:");
                admin.displayAvailableVehicles();

                // Input vehicle ID to rent
                System.out.print("Enter vehicle I" +
                        "D to rent: ");
                String vehicleId = scanner.nextLine();

                Vehicle vehicle = admin.getVehicleById(vehicleId);
                if (vehicle == null || !vehicle.isAvailable()) {
                    System.out.println("Vehicle not found or not available.");
                    continue;
                }

                // Input customer name
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                Customer customer = new Customer(name);

                // Input rental days
                System.out.print("Enter number of rental days: ");
                int days = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                ((Rentable) vehicle).rent(customer, days);
                System.out.println("Rental cost: $" + vehicle.calculateRentalCost(days));
            } else if (action == 2) {
                // Return a vehicle
                System.out.print("Enter vehicle ID to return: ");
                String vehicleId = scanner.nextLine();

                Vehicle vehicle = admin.getVehicleById(vehicleId);
                if (vehicle == null) {
                    System.out.println("Vehicle not found.");
                    continue;
                }

                ((Rentable) vehicle).returnVehicle();
            } else {
                System.out.println("Invalid action.");
            }

            // Ask if the user wants to continue or exit
            System.out.print("Do you want to continue or exit? (continue/exit): ");
            String continueOrExit = scanner.nextLine().toLowerCase();
            if (continueOrExit.equals("exit")) {
                System.out.println("Exiting the application.");
                break;
            }
        }

        scanner.close();
    }
}