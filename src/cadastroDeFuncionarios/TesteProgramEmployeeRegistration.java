package cadastroDeFuncionarios;
import cadastroDeFuncionarios.Employee;

public class TesteProgramEmployeeRegistration {
    public static void main(String[] args) {
        Employee emp1 = new Employee(
            "Carlos Silva", "TI", 5000.00, "10/03/2020", "12345678"
        );

        Employee emp2 = new Employee(
            "Ana Souza", "RH", 4200.50, "15/06/2018", "87654321"
        );

        System.out.println("Dados dos Funcionários:");
        emp1.showInfo();
        emp2.showInfo();
    }

}
