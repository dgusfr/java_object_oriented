package cadastroDeFuncionarios;

public class Employee {
    public String name;
    public String department;
    public double salary;
    public String startDate;
    public String rg;
    public boolean ativo;

    public Employee(String name, String department, double salary, String startDate, String rg) {
        this.name = name;
        this.department = department;
        this.salary = salary > 0 ? salary : 0; 
        this.startDate = startDate;
        this.rg = rg;
        this.ativo = true;
    }

    public void increaseSalary(double bonus) {
        if (bonus > 0) {
            salary += bonus;
        }
    }

    public void dismissEmployee() {
        ativo = false;
        System.out.println("Funcionário desligado com sucesso!");
    }

    public void showInfo() {
        System.out.println("Nome: " + name);
        System.out.println("Departamento: " + department);
        System.out.println("Salário: " + salary);
        System.out.println("Data de entrada: " + startDate);
        System.out.println("RG: " + rg);
        System.out.println("Ativo: " + (ativo ? "Sim" : "Não"));
        System.out.println("--------------------------");
    }
}
