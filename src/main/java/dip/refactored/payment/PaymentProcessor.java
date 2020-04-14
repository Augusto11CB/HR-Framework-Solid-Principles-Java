package dip.refactored.payment;


import dip.refactored.notifications.EmailSender;
import dip.refactored.notifications.EmployeeNotifier;
import dip.refactored.persistence.EmployeeFileRepository;
import dip.refactored.persistence.EmployeeFileSerializer;
import dip.refactored.persistence.EmployeeRepository;
import dip.refactored.personnel.Employee;

import java.util.List;


public class PaymentProcessor {

    //[aug-dip] using dependency inversion principle
//    PaymentProcessor can now be modified at run time by passing other instances of EmployeeRepository
    private EmployeeRepository employeeRepository;
    private EmployeeNotifier employeeNotifier;

    public PaymentProcessor(EmployeeRepository employeeRepository,
                            EmployeeNotifier employeeNotifier){
        //[aug-dip] Using dependency injection technique
        this.employeeRepository = employeeRepository;
        this.employeeNotifier = employeeNotifier;
    }

    public int sendPayments(){
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for(Employee employee : employees){
            totalPayments += employee.getMonthlyIncome();
            this.employeeNotifier.notify(employee);
        }

        return totalPayments;
    }
}


// old implementation

/*public class PaymentProcessor {

    private EmployeeFileRepository employeeRepository;

    public PaymentProcessor() {
        // [aug-dip] after breaking the dependencies in order to depends upon abstractions EmployeeRepository Interface and EmployeeNotifier were created
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
}*/
