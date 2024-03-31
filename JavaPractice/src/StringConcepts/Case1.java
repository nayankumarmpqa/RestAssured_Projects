package StringConcepts;

public class Case1 {
    public static void main(String[] args) {

        String s = new String("Nayan");
        System.out.println(s.concat(" Kumar"));

        System.out.println(s);

        StringBuffer sb = new StringBuffer("Rupali");
        sb.append(" mahi");
        System.out.println(sb);
        System.out.println();
    }
}
