package Exceptioandaling;
class CustomException extends Exception{

    public CustomException(String msg){
        super(msg);
    }

}
public class ThrowCustomException {
    public static void main(String[] args) throws CustomException {

        add();
        //If not throws by main
        // It will be a unreported exception Exceptioandaling.CustomException;
        // must be caught or declared to be thrown

    }

    public static void add() throws CustomException {
            throw new CustomException("It is my exception message");

    }
}
