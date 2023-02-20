package entities;

public class TaxPayer {

	private double salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending;

	public TaxPayer() {

	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {

		double monthlyIncome;
		monthlyIncome = getSalaryIncome() / 12;

		if (monthlyIncome < 3000.0) {
			return getSalaryIncome();
		} else if (monthlyIncome < 5000.0) {
			return getSalaryIncome() * 0.1;
		} else {
			return getSalaryIncome() * 0.2;
		}
	}

	public double servicesTax() {
		return getServicesIncome() * 0.15;
	}

	public double capitalTax() {
		return getCapitalIncome() * 0.2;
	}

	public double grossTax() {

		double gross;
		gross = salaryTax() + servicesTax() + capitalTax();
		return gross;
	}

	public double taxRebate() {

		double deductibleExpenses, maxDeductible;
		deductibleExpenses = getHealthSpending() + getEducationSpending();
		maxDeductible = grossTax() * 0.3;

		if (deductibleExpenses > maxDeductible) {
			return maxDeductible;
		} else {
			return deductibleExpenses;
		}

	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

}
