import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login form
        String username;
        String password;
        boolean isLoggedIn = false;

        System.out.println("Welcome to the Online Reservation System!");
        System.out.println("Please log in to continue:");

        do {
            System.out.print("Username: ");
            username = scanner.nextLine();

            System.out.print("Password: ");
            password = scanner.nextLine();

            if (username.equals("onkar") && password.equals("onkar123")) {
                isLoggedIn = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } while (!isLoggedIn);

        // Reservation system
        int numSeats = 10;
        boolean[] seats = new boolean[numSeats];

        System.out.println("Welcome to the Online Reservation System!");
        System.out.println("Please select an option:");
        System.out.println("1. Reserve a seat");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Quit");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter seat number to reserve (1-10): ");
                    int seatNumber = scanner.nextInt();

                    if (seatNumber < 1 || seatNumber > numSeats) {
                        System.out.println("Invalid seat number. Please try again.");
                    } else if (seats[seatNumber - 1]) {
                        System.out.println("Seat is already reserved. Please select another seat.");
                    } else {
                        seats[seatNumber - 1] = true;
                        System.out.println("Seat " + seatNumber + " reserved successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter seat number to cancel reservation (1-10): ");
                    seatNumber = scanner.nextInt();

                    if (seatNumber < 1 || seatNumber > numSeats) {
                        System.out.println("Invalid seat number. Please try again.");
                    } else if (!seats[seatNumber - 1]) {
                        System.out.println("Seat is not reserved. Please select another seat.");
                    } else {
                        seats[seatNumber - 1] = false;
                        System.out.println("Reservation for seat " + seatNumber + " cancelled successfully!");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Online Reservation System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}

