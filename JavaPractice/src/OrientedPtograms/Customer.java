package OrientedPtograms;

public class Customer {

    //state
    private String name;
    private Address homeAddress;
    private Address workAddress;


    Customer(String name , Address homeAddress){
        this.name= name;
        this.homeAddress=homeAddress;
    }

    void setWorkAddress(Address workAddress){
        this.workAddress=workAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                '}';
    }
}
