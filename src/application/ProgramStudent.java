package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Student;

public class ProgramStudent {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.print("Name: ");
        student.name = sc.nextLine();

        System.out.print("First grade: ");
        student.grade1 = sc.nextDouble();

        System.out.print("Second grade: ");
        student.grade2 = sc.nextDouble();

        System.out.print("Third grade: ");
        student.grade3 = sc.nextDouble();

        System.out.printf("\nFINAL GRADE: %.2f%n", student.finalGrade());

        if (student.finalGrade() < 60.0) {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS%n", student.missingPoints());
        } else {
            System.out.println("PASS");
        }

        sc.close();
    }
}
