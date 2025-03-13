package application;

import java.util.Locale;
import java.util.Scanner;

import entities.EmployeeRegistration;

public class ProgramEmployeeRegistration {
  
  public static void main(String[] args) {
            Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        EmployeeRegistration empRegis = new EmployeeRegistration();

        System.out.print("Bem vindo ao Banco J!");
        System.out.println("\nDigite os dados do funcionário:");

        System.out.print("Nome Completo: ");
        empRegis.name = sc.nextLine();

        System.out.print("Departamento: ");
        empRegis.department = sc.nextLine();

        System.out.print("Salário: ");
        empRegis.salary = sc.nextDouble();

        System.out.print("Data de entrada: ");
        empRegis.startDate = sc.nextLine();

        System.out.print("RG: ");
        empRegis.rg = sc.nextLine();

        System.out.print("O Funcionario está ativo? ");
        empRegis.ativo = sc.nextLine();

        System.out.print("\nQual a bonificação? ");
        double bonus = sc.nextDouble();
        empRegis.increaseSalary(bonus);

        System.out.println("Deseja desligar o funcionário? ");
        empRegis.desligar = sc.nextLine();

        System.out.println("\nDados do funcionário:");
        System.out.println("Nome: " + empRegis.name);
        System.out.println("Departamento: " + empRegis.department);
        System.out.println("Salário: " + empRegis.salary);
        System.out.println("Data de entrada: " + empRegis.startDate);
        System.out.println("RG: " + empRegis.rg);
        System.out.println("Ativo: " + empRegis.ativo);

        sc.close();
  }
}
