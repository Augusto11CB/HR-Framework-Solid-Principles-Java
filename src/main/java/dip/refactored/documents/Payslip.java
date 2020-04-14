package dip.refactored.documents;

import dip.refactored.personnel.Employee;

import java.time.Month;

// [aug-isp] The new requirement wants to generate a payslip report
public class Payslip implements ExportableText {
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


//
//    // [aug-isp] now that ExportableDocument interface was divided into 3 new smaller interfaces, this methods are no longer needed to implement
//
//    @Override
//    public byte[] toPdf() {
//        List<String> list = Arrays.asList("ana","are");
//        list.re;
//
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public String toJson() {
//        throw new UnsupportedOperationException();
//    }

}
