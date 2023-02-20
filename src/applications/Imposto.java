package applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Imposto {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.printf("Digite os dados do %do contribuinte:%n", i + 1);

			System.out.print("Renda anual com salário: ");
			double salaryTax = sc.nextDouble();

			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();

			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();

			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			System.out.println();

			list.add(new TaxPayer(salaryTax, servicesIncome, capitalIncome, healthSpending, educationSpending));
			
			
			

		}

		for (int i = 0; i < n; i++) {
			System.out.printf("Resumo do %do contribuinte: %n", i + 1);

			TaxPayer tax = list.get(i);

			System.out.printf("Imposto bruto total: %.2f%n", tax.grossTax());
			System.out.printf("Abatimento: %.2f%n", tax.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", tax.netTax());
			System.out.println();
		}

		sc.close();
	}

}
