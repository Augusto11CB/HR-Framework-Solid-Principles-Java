package dip.before.payment;


import dip.before.notifications.EmailSender;
import dip.before.persistence.EmployeeFileRepository;
import dip.before.persistence.EmployeeFileSerializer;
import dip.before.personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private EmployeeFileRepository employeeRepository;

    public PaymentProcessor() {
        // [aug-dip] this component is highly coupled with the EmployeeFileRepository and the EmailService
        // PaymentProcessor is creating its own dependencies
        // By doing it, there is no possibility to change the repository in runtime if the format of the file that must be stored changes.
        // this code are tied with these dependencies
        // violate dip principle
        EmployeeFileSerializer serializer =
                new EmployeeFileSerializer();
        this.employeeRepository =
                new EmployeeFileRepository(serializer);
    }

    public int sendPayments() {
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for (Employee employee : employees) {
            totalPayments += employee.getMonthlyIncome();
            //[aug-dip] Static method call can be a signal of coupling
            // Example, if a requirement of sending messages appear. then, this code needs to be modified. here there is a high level of coupling with EmailSender
            // violate ocp
            EmailSender.notify(employee);
        }

        return totalPayments;
    }
}
