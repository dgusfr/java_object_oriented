package application;

import java.util.Locale;
import java.util.Scanner;
import entities.EmployeeRegistration;

public class ProgramEmployeeRegistration {
  
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Bem-vindo ao Banco J!");
        System.out.println("\nDigite os dados do funcionário:");

        System.out.print("Nome Completo: ");
        String name = sc.nextLine();

        System.out.print("Departamento: ");
        String department = sc.nextLine();

        System.out.print("Salário: ");
        double salary = sc.nextDouble();
        while (salary <= 0) {
            System.out.print("O salário deve ser positivo. Digite novamente: ");
            salary = sc.nextDouble();
        }
        sc.nextLine(); 

        System.out.print("Data de entrada: ");
        String startDate = sc.nextLine();

        System.out.print("RG: ");
        String rg = sc.nextLine();

        // Criando o funcionário com o CONSTRUTOR
        EmployeeRegistration empRegis = new EmployeeRegistration(name, department, salary, startDate, rg);

        System.out.print("\nQual a bonificação? ");
        double bonus = sc.nextDouble();
        empRegis.increaseSalary(bonus);
        sc.nextLine();

        System.out.println("Deseja desligar o funcionário? (Sim/Não):");
        String desligar = sc.nextLine().trim().toLowerCase();
        if (desligar.equals("sim")) {
            empRegis.dismissEmployee();
        } else {
            System.out.println("Funcionário não desligado!");
        }

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
