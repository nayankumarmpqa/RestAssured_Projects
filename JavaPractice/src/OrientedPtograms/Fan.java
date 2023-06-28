package OrientedPtograms;

public class Fan {
    //state or variables

    private String brand;
    private double radios;
    private String color;


    // state that changes too much
    private boolean isOn;
    private byte speed;  //0 to 5


    public void switchOn() {
        this.isOn = true;
    }

    public void switchOff() {
        this.isOn = false;
        setSpeed((byte) 0);
    }

    void setSpeed(byte speed) {
        this.speed = speed;
    }

    // object creation using constructor
    public Fan(String brand, double radios, String color) {
        this.brand = brand;
        this.radios = radios;
        this.color = color;
    }

    //print a state using toString method
    @Override
    public String toString() {
        return "Fan{" +
                "comp='" + brand + '\'' +
                ", radios=" + radios +
                ", color='" + color + '\'' +
                ", isOn=" + isOn +
                ", speed=" + speed +
                '}';
    }
}
