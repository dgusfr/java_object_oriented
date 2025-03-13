package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class ProgramEmployeeRegistration {
  
  public static void main(String[] args) {
            Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();

        System.out.print("Name: ");
        emp.name = sc.nextLine();

        System.out.print("Gross salary: ");
        emp.grossSalary = sc.nextDouble();

        System.out.print("Tax: ");
        emp.tax = sc.nextDouble();

        System.out.println("\nEmployee: " + emp);

        System.out.print("\nWhich percentage to increase salary? ");
        double percentage = sc.nextDouble();

        emp.increaseSalary(percentage);

        System.out.println("\nUpdated data: " + emp);

        sc.close();

  }

}
