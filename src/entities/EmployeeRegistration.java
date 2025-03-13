package entities;

public class EmployeeRegistration {
  public String name;
  public String department;
  public double salary;
  public String startDate;
  public String rg;
  public boolean ativo;
  public String desligar;

  public void increaseSalary(double bonus) {
    salary = salary + bonus;
  }

  public void dismissEmployee() {
    ativo = false;
  }
}
