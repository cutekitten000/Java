package entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public final Double tax() {
        if (super.getAnnualIncome() > 20000.00) {
            if (healthExpenditures > 0) {
                return (super.getAnnualIncome() * 25 / 100) - (healthExpenditures * 50 / 100);
            }

            return super.getAnnualIncome() * 25 / 100;
        }

        return super.getAnnualIncome() * 15 / 100;
    }
}
