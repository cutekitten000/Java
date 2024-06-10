import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Tax payer #" + (i + 1) + " data:");
            System.out.print("Individual or Company (i/c)? ");
            char ch =  sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual Income: ");
            Double annualIncome = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();

                TaxPayer taxPayer = new Individual(name, annualIncome, healthExpenditures);
                list.add(taxPayer);
            } else if (ch == 'c') {
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = sc.nextInt();

                TaxPayer taxPayer = new Company(name, annualIncome, numberOfEmployees);
                list.add(taxPayer);
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer taxPayer : list) {
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
        }

        sc.close();
    }
}
