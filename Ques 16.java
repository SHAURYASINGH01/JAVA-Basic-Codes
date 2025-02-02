import java.util.ArrayList;
import java.util.Scanner;

class Appliance {
    //..... YOUR CODE STARTS HERE .....
    
    int applianceID;
    String name;
    double powerRating;
    boolean status;  // true for 'on', false for 'off'
    // Parameterized constructor
    public Appliance(int applianceID, String name, double powerRating, boolean status) {
        this.applianceID = applianceID;
        this.name = name;
        this.powerRating = powerRating;
        this.status = status;
    }
    // Method to toggle the status
    public void toggleStatus() {
        this.status = !this.status;
    }
    // Method to get the power rating
    public double getPowerRating() {
        return this.powerRating;
    }
    // Method to check if the appliance is on
    public boolean isOn() {
        return this.status;
    }
    
    //..... YOUR CODE ENDS HERE .....
}
class SmartHome {
    //..... YOUR CODE STARTS HERE .....
    
   Appliance[] appliances;
    int count;
    // Constructor to initialize SmartHome with a max capacity of appliances
    public SmartHome() {
        appliances = new Appliance[100];  // Default maximum capacity is 100 appliances
        count = 0;
    }
    // Method to add a new appliance
    public void addAppliance(Appliance appliance) {
        if (count < appliances.length) {
            appliances[count++] = appliance;
        }
    }
    // Method to remove an appliance by ID
    public boolean removeAppliance(int applianceID) {
        for (int i = 0; i < count; i++) {
            if (appliances[i].applianceID == applianceID) {
                // Shift the remaining appliances
                for (int j = i; j < count - 1; j++) {
                    appliances[j] = appliances[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;  // Appliance not found
    }
    // Method to toggle appliance status by ID
    public boolean toggleApplianceStatus(int applianceID) {
        for (int i = 0; i < count; i++) {
            if (appliances[i].applianceID == applianceID) {
                appliances[i].toggleStatus();
                return true;
            }
        }
        return false;  // Appliance not found
    }
    // Method to calculate total power consumption of appliances that are 'on'
    public double calculateTotalPower() {
        double totalPower = 0;
        for (int i = 0; i < count; i++) {
            if (appliances[i].isOn()) {
                totalPower += appliances[i].getPowerRating();
            }
        }
        return totalPower;
    }
   
    //..... YOUR CODE ENDS HERE .....
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHome smartHome = new SmartHome();
        // Input the number of appliances
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        // Add appliances to the system
        for (int i = 0; i < n; i++) {
            int applianceID = scanner.nextInt();
            String name = scanner.next();
            double powerRating = scanner.nextDouble();
            String status = scanner.next();
            scanner.nextLine();  // Consume newline
            boolean isOn = status.equalsIgnoreCase("on");
            Appliance appliance = new Appliance(applianceID, name, powerRating, isOn);
            smartHome.addAppliance(appliance);
        }
        // Input the number of operations
        int m = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        // Perform operations
        for (int i = 0; i < m; i++) {
            String operation = scanner.next();
            switch (operation.toLowerCase()) {
                case "remove":
                    int applianceID = scanner.nextInt();
                    if (smartHome.removeAppliance(applianceID)) {
                        System.out.println("Appliance removed successfully");
                    } else {
                        System.out.println("Appliance not found");
                    }
                    break;
                case "toggle":
                    applianceID = scanner.nextInt();
                    if (smartHome.toggleApplianceStatus(applianceID)) {
                        System.out.println("Appliance status toggled");
                    } else {
                        System.out.println("Appliance not found");
                    }
                    break;
                case "calculate":
                    double totalPower = smartHome.calculateTotalPower();
                    System.out.println("Total Power Consumption: " + totalPower + " kW");
                    break;
            }
        }
        scanner.close();
    }
}
