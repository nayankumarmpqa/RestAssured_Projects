package InheritanceConcepts;

import java.math.BigDecimal;

public class Employee extends Person{
    private String employerName;
    private char employeeGrade;
    private BigDecimal Salary;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public char getEmployeeGrade() {
        return employeeGrade;
    }

    public void setEmployeeGrade(char employeeGrade) {
        this.employeeGrade = employeeGrade;
    }

    public BigDecimal getSalary() {
        return Salary;
    }

    public void setSalary(BigDecimal salary) {
        this.Salary = salary;
    }
    @Override
    public String toString() {
        //super.toString() will call the super class toString method
        return super.toString()+"\n" + "Employee{" +
                "title='" + title + '\'' +
                ", employerName='" + employerName + '\'' +
                ", employeeGrade='" + employeeGrade + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
