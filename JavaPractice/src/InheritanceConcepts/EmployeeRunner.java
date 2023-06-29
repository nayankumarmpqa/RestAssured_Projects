package InheritanceConcepts;

import java.math.BigDecimal;

public class EmployeeRunner {

    public static void main(String[] args) {



    Employee employee = new Employee();

        System.out.println(employee);

    employee.setName("Nayan Kumar");
    employee.setEmail("nk@gmail.com");
    employee.setPhone("8699726011");
    employee.setTitle("QA");
    employee.setEmployerName("MS");
    employee.setEmployeeGrade('A');
    employee.setSalary(BigDecimal.valueOf(6000000));
        System.out.println("--------------------------");
        System.out.println(employee);


    }


}
