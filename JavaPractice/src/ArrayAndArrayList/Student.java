package ArrayAndArrayList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Student {
private String name;
   private ArrayList<Integer> lisOfmarks = new ArrayList<>();

    public Student(String name, int... lisOfmarks) {
        this.name=name;
        for(int item:lisOfmarks){
            this.lisOfmarks.add(item);
        }

    }

    public int getNumberOfSubjects() {
        return lisOfmarks.size();
    }

    public int getSumOfMarks() {
        int sum=0;
        for(int item:lisOfmarks){
            sum = sum + item;
        }
        return sum;

    }

    public int getMaxMarks() {
        int maxMarks=Integer.MIN_VALUE;
        for(int item:lisOfmarks){
          if (item>maxMarks){
              maxMarks= item;
          }
        }
        return maxMarks;


    }

    public int getMinMarks() {
        int minMarks=Integer.MAX_VALUE;
        for(int item:lisOfmarks){
            if (item<minMarks){
                minMarks= item;
            }
        }
        return minMarks;
    }

    public BigDecimal getAverageMarks() {
        return new BigDecimal(getSumOfMarks())
                .divide(new BigDecimal(getNumberOfSubjects()),3,RoundingMode.UP);
    }

    public void addNweMark(int i) {
        lisOfmarks.add(i);
    }

    public void removeMarksAtIndex(int i) {
        lisOfmarks.remove(i);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lisOfmarks=" + lisOfmarks +
                '}';
    }
}
