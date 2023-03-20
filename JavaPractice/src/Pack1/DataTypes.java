package Pack1;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class DataTypes {

    public static void main(String[] args) {

        System.out.print(Byte.MIN_VALUE + " "); System.out.println(Byte.MAX_VALUE);
        System.out.print(Short.MIN_VALUE+ " "); System.out.println(Short.MAX_VALUE);
        System.out.print(Integer.MIN_VALUE+ " "); System.out.println(Integer.MAX_VALUE);
        System.out.print(Long.MIN_VALUE+ " "); System.out.println(Long.MAX_VALUE);

        System.out.println("-----------------------------");
        int eight = 010; // Octal 0 to 7
        int sixteen = 0x10; // Decimal 0 to 9 like ox10, 0x11, 0x12
        int fifteen = 0xf;  // Hexadecimal 0 to 9 then 10=A, 11=B, 12=C, 13=D, 14=E, 15=F;

        System.out.println(eight);
        System.out.println(sixteen);
        System.out.println(fifteen);
    }
}
