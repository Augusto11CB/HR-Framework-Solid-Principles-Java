package isp.before.documents;

import isp.before.personnel.*;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

// [aug-isp] The new requirement wants to generate a payslip report
public class Payslip implements ExportableDocument {
    private String employeeName;
    private int monthlyIncome;
    private Month month;

    public Payslip(Employee employee, Month month) {
        this.employeeName = employee.getFullName();
        this.monthlyIncome = employee.getMonthlyIncome();
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public String toTxt() {
        // [aug-isp] firstly, there are only the necessity to generate report in txt format
        StringBuilder sb = new StringBuilder();
        sb.append("MONTH: ").append(this.month);
        sb.append(System.lineSeparator());
        sb.append("NAME: ").append(this.employeeName);
        sb.append(System.lineSeparator());
        sb.append("INCOME: ").append(this.monthlyIncome);
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    // [aug-isp] As there is no need at the moment of the new requirement to generate s payslip in the PDF or JSON format
    // The bellow methods just throw an exception

    // [aug-isp] This kind of code does not respect the principle o interface segregation that says:
        //"**a class should not be forced to depend on methods it does not use**."
    @Override
    public byte[] toPdf() {
        List<String> list = Arrays.asList("ana","are");
        list.re;

        throw new UnsupportedOperationException();
    }

    @Override
    public String toJson() {
        throw new UnsupportedOperationException();
    }
}
