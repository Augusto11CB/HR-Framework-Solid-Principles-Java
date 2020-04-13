package lsp.before.personnel;


//public class Subcontractor extends Employee {
// [aug-lsp] breaking this relationshiop since Subcontractor is not a kind of entity that properly implements Employee

public class Subcontractor {

    private final int monthlyIncome;
    private int nbHoursPerWeek;
    private String email;
    private String name;

    public Subcontractor(String name,
                         String email,
                         int monthlyIncome,
                         int nbHoursPerWeek) {

        this.name = name;
        this.email = email;
        this.monthlyIncome = monthlyIncome;
        this.nbHoursPerWeek = nbHoursPerWeek;
    }

    public boolean approveSLA(ServiceLicenseAgreement sla) {
        boolean result = false;
        if (sla.getMinUptimePercent() >= 98 &&
                sla.getProblemResolutionTimeDays() <= 2) {
            result = true;
        }

        System.out.println("SLA approval for " + this.name + ": " + result);
        return result;
    }
}