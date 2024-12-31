import java.util.ArrayList;
import java.util.List;

public class Admin {
    private final List<Vehicle> rentaVehicles;
    private final String password;

    public Admin() {
        this.rentaVehicles = new ArrayList<>();
        this.password = "admin419";
        prepopulateFleet();
    }

    private void prepopulateFleet() {
        // Cars
        rentaVehicles.add(new Car("CAR001", "Hyundai Elantra", 45.0));
        rentaVehicles.add(new Car("CAR002", "Mazda3", 48.0));
        rentaVehicles.add(new Car("CAR003", "Volkswagen Jetta", 50.0));
        rentaVehicles.add(new Car("CAR004", "Subaru Impreza", 53.0));
        rentaVehicles.add(new Car("CAR005", "Kia Forte", 47.0));
        rentaVehicles.add(new Car("CAR006", "Honda Civic", 52.0));
        rentaVehicles.add(new Car("CAR007", "Chevrolet Cruze", 46.0));
        rentaVehicles.add(new Car("CAR008", "Nissan Sentra", 49.0));
        rentaVehicles.add(new Car("CAR009", "Toyota Corolla", 55.0));
        rentaVehicles.add(new Car("CAR010", "Ford Focus", 51.0));

        // Motorcycles
        rentaVehicles.add(new Motorcycle("MTR001", "Harley-Davidson Street 750", 38.0));
        rentaVehicles.add(new Motorcycle("MTR002", "Royal Enfield Classic 350", 34.0));
        rentaVehicles.add(new Motorcycle("MTR003", "BMW G310R", 37.0));
        rentaVehicles.add(new Motorcycle("MTR004", "KTM Duke 390", 36.0));
        rentaVehicles.add(new Motorcycle("MTR005", "Triumph Bonneville T100", 42.0));
        rentaVehicles.add(new Motorcycle("MTR006", "Suzuki Hayabusa", 50.0));
        rentaVehicles.add(new Motorcycle("MTR007", "Yamaha MT-15", 33.0));
        rentaVehicles.add(new Motorcycle("MTR008", "Ducati Panigale V2", 48.0));
        rentaVehicles.add(new Motorcycle("MTR009", "Honda Rebel 500", 35.0));
        rentaVehicles.add(new Motorcycle("MTR010", "Kawasaki Z650", 40.0));

        // Trucks
        rentaVehicles.add(new Truck("TRK001", "GMC Sierra", 78.0));
        rentaVehicles.add(new Truck("TRK002", "Jeep Gladiator", 84.0));
        rentaVehicles.add(new Truck("TRK003", "Tesla Cybertruck", 95.0));
        rentaVehicles.add(new Truck("TRK004", "Rivian R1T", 92.0));
        rentaVehicles.add(new Truck("TRK005", "Hummer EV Pickup", 100.0));
        rentaVehicles.add(new Truck("TRK006", "Ford Ranger", 75.0));
        rentaVehicles.add(new Truck("TRK007", "Chevrolet Colorado", 80.0));
        rentaVehicles.add(new Truck("TRK008", "Toyota Hilux", 78.0));
        rentaVehicles.add(new Truck("TRK009", "Ram 2500", 98.0));
        rentaVehicles.add(new Truck("TRK010", "Nissan Navara", 83.0));
        rentaVehicles.add(new Truck("TRUCK005", "Nissan Titan", 82.0));
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void addVehicle(Vehicle vehicle) {
        rentaVehicles.add(vehicle);
        System.out.println(vehicle.getClass().getSimpleName() + " added to the fleet.");
    }

    public void displayFleet() {
        if (rentaVehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            System.out.println("Vehicle Fleet:");
            for (Vehicle vehicle : rentaVehicles) {
                System.out.println(vehicle.getClass().getSimpleName() + " - ID: " + vehicle.getVehicleId() + ", Model: " + vehicle.getModel());
            }
        }
    }

    public void displayAvailableVehicles() {
        boolean hasAvailableVehicles = false;
        for (Vehicle vehicle : rentaVehicles) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle.getClass().getSimpleName() + " - ID: " + vehicle.getVehicleId() + ", Model: " + vehicle.getModel() + ", Rate: $" + vehicle.getBaseRentalRate() + " per day");
                hasAvailableVehicles = true;
            }
        }
        if (!hasAvailableVehicles) {
            System.out.println("No available vehicles.");
        }
    }

    public Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : rentaVehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }
}
