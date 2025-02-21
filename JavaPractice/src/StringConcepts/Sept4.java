package StringConcepts;

public class Sept4 {

    public static void main(String[] args) {

String name = "nayan kumar";
        char c = name.charAt(5);
int [][] arr = {
        {1,2,3},
        {3,5,7},
        {9,1,6}
};

        System.out.println(arr); //[[I@58372a00
        System.out.println(arr.length);  //3 only
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------");
        int[][] bb= new int[4][5];
        System.out.println(bb.length);
        //length of overall array bb that it has 4 arrays in it
        System.out.println(bb[0].length);
        //length of only 1st array inside bbb that it has 5 elemets in its 1st 1st array
        System.out.println(bb[1].length);

        System.out.println("-------------");
        int[][] bbb= new int[5][2];
        System.out.println(bbb.length);
        System.out.println(bbb[0].length);

    }
}
