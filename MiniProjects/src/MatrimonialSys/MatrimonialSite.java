package MatrimonialSys;

import java.util.Scanner;

public class MatrimonialSite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //Input for gender
            System.out.print("Enter your gender (male/female): ");
            String gender = scanner.nextLine();
            ValidationReq.gender(gender);

            //Input for age
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            ValidationReq.age(gender, age);

            System.out.println("Validation successful. Welcome to the matrimonial system!");
        } catch (InvalidInputException e) {

            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {

            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Thank you.");
            scanner.close();
        }
    }
}