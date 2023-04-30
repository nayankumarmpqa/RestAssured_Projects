package Resources;

import java.io.IOException;
import java.util.ArrayList;

public class POITestRunner {

    public static void main(String[] args) throws IOException {

        DataDrivenPOI dataDrivenPOI = new DataDrivenPOI();
        ArrayList<String> a = dataDrivenPOI.getExcelData();
        System.out.println(a);
        System.out.println(a.get(1));

    }
}
