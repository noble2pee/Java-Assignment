
/* Prince Ofori - Index - 1727338141
Java Assignment*/


public class Emolument {
    private double basic_salary;
    private double tax_relief;

    // Constructor
    public Emolument(double basic_salary, double tax_relief) {
        this.basic_salary = basic_salary;
        this.tax_relief = tax_relief;
    }

    // Getter for Basic Salary
    public double getBasicSalary() {
        return basic_salary;
    }

    // Getter for Tax Relief
    public double getTaxRelief() {
        return tax_relief;
    }

    // Calculate SSNIT Contribution
    public double SSNIT() {
        return basic_salary * 0.035;
    }

    // Calculate Taxable Income
    public double taxableIncome() {
        return basic_salary - (tax_relief + SSNIT());
    }
}





public class MyEmolument extends Emolument {
    // Default Constructor
    public MyEmolument() {
        super(0, 0);
    }

    // Parameterized Constructor
    public MyEmolument(double basic_salary, double tax_relief) {
        super(basic_salary, tax_relief);
    }

    // Calculate Income Tax
    public double incomeTax() {
        double taxableIncome = taxableIncome();
        if (taxableIncome <= 500) {
            return taxableIncome * 0.05;
        } else if (taxableIncome <= 1000) {
            return 500 * 0.05 + (taxableIncome - 500) * 0.125;
        } else {
            return 500 * 0.05 + 500 * 0.125 + (taxableIncome - 1000) * 0.175;
        }
    }

    // Calculate Total Deduction
    public double totalDeduction() {
        return SSNIT() + incomeTax();
    }

    // Calculate Net Salary
    public double netSalary() {
        return getBasicSalary() - totalDeduction();
    }
}




import javax.swing.JOptionPane;

public class TestMyEmolument {
    public static void main(String[] args) {
        // Input Dialogs
        String basicSalaryStr = JOptionPane.showInputDialog("Enter Basic Salary:");
        double basicSalary = Double.parseDouble(basicSalaryStr);
        String taxReliefStr = JOptionPane.showInputDialog("Enter Tax Relief:");
        double taxRelief = Double.parseDouble(taxReliefStr);

        // Create MyEmolument Object
        MyEmolument Staff_Salary = new MyEmolument(basicSalary, taxRelief);

        // Display Results
        String message = String.format(
                "Basic Salary: %.2f\nTax Relief: %.2f\nSSNIT Contribution: %.2f\nTaxable Income: %.2f\nIncome Tax: %.2f\nTotal Deduction: %.2f\nNet Salary: %.2f",
                Staff_Salary.getBasicSalary(),
                Staff_Salary.getTaxRelief(),
                Staff_Salary.SSNIT(),
                Staff_Salary.taxableIncome(),
                Staff_Salary.incomeTax(),
                Staff_Salary.totalDeduction(),
                Staff_Salary.netSalary());

        JOptionPane.showMessageDialog(null, message);
    }
}
