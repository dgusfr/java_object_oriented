package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class ProgramEmployeeRegistration {
  
  public static void main(String[] args) {
            Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();

        System.out.print("Bem vindo ao Banco J!");
        System.out.println("\nDigite os dados do funcionário:");

        System.out.print("Nome Completo: ");
        emp.name = sc.nextLine();

        System.out.print("Departamento: ");
        emp.grossSalary = sc.nextDouble();

        System.out.print("Salário: ");
        emp.tax = sc.nextDouble();

        System.out.print("Data de entrada: ");
        emp.date = sc.nextLine();

        System.out.print("RG: ");
        emp.rg = sc.nextLine();

        System.out.print("O Funcionario está ativo? ");
        emp.ativo = sc.nextLine();

        System.out.print("\nQual a porcentagem de bonificação? ");
        double percentage = sc.nextDouble();

        emp.increaseSalary(percentage);

        System.out.println("Deseja desligar o funcionário? ");
        emp.desligar = sc.nextLine();

        sc.close();
  }
}
