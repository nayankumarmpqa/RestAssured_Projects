package Pack1;

public class StringBufferTest {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Test");
        System.out.println(sb);
        sb.append(" Kumar");
        System.out.println(sb);
        sb.setCharAt(1,'N');
        System.out.println(sb);
    }
}
