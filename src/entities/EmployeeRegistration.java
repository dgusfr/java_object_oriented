package entities;

public class EmployeeRegistration {
    public String name;
    public String department;
    public double salary;
    public String startDate;
    public String rg;
    public boolean ativo;

    public EmployeeRegistration() {
        this.ativo = true;
    }

    public void increaseSalary(double bonus) {
        if (bonus > 0) {
            salary += bonus;
        } else {
            System.out.println("O valor da bonificação deve ser positivo.");
        }
    }

    public void dismissEmployee() {
        if (ativo) {
            ativo = false;
            System.out.println("Funcionário desligado com sucesso!");
        } else {
            System.out.println("Funcionário já está desligado.");
        }
    }
}
