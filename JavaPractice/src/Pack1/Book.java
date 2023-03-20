package Pack1;

public class Book {

    //state or instance variable
    private int numOfBookCopies;

    int setNumOfBookCopies(int numOfBookCopies){

        if(numOfBookCopies>0){
            this.numOfBookCopies=numOfBookCopies;
        }
        else
            System.out.println("number is less than 0");

        return this.numOfBookCopies;
    }

    int getNumOfBookCopies(){
        return numOfBookCopies;
    }
    void increaseNumberOfBookCopies(int thisMuch){
        setNumOfBookCopies(this.numOfBookCopies+thisMuch);

    }

    void decreaseNumberOfBookCopies(int thisMuch){
      setNumOfBookCopies(this.numOfBookCopies-thisMuch);
    }


}
