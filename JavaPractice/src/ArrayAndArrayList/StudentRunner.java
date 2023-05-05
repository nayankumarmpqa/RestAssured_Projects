package ArrayAndArrayList;

import java.math.BigDecimal;
import java.util.Arrays;

public class StudentRunner {
    public static void main(String[] args) {

        String name = "Nayan";
        int[] lisOfmarks = {35, 45, 55, 65, 75, 99};
        Student student = new Student(name, lisOfmarks);

        int numOfsubjects = student.getNumberOfSubjects();
        System.out.println("numOfsubjects = " + numOfsubjects);
        int sumOfMarks = student.getSumOfMarks();
        System.out.println("sumOfMarks = " + sumOfMarks);
        int maxMarks = student.getMaxMarks();
        System.out.println("maxMarks = " + maxMarks);
        int minMarks = student.getMinMarks();
        System.out.println("minMarks = " + minMarks);
        BigDecimal averageMarks = student.getAverageMarks();
        System.out.println("averageMarks = " + averageMarks);

        System.out.println(" Printing Student to string before add or remove operation = " + student);

        student.addNweMark(66);
        System.out.println(" Printing Student to string after add operation = " + student);

        student.removeMarksAtIndex(2);

        System.out.println(" Printing Student to string after remove operation = " +student);


    }
}
