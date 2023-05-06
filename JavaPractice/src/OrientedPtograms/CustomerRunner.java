package OrientedPtograms;

public class CustomerRunner {

    public static void main(String[] args) {
        Address homeAddress = new Address("madhu nagar", "AMB", "135");
        Customer customer = new Customer("Nayen", homeAddress);

        System.out.println(customer);

        Address workAddress = new Address("My workplace nagar", "MHL", "139");
        customer.setWorkAddress(workAddress);
        System.out.println(customer);

    }
}
