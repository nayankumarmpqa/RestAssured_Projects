package OrientedPtograms;

public class Fan {
    //state or variables

    private String comp;
    private double radios;
    private String color;


// state that changes too much
    private boolean isOn;
    private byte speed;  //0 to 5


    public void switchOn() {
this.isOn=true;

    }

    public void switchOff() {
        this.isOn=false;
        setSpeed((byte)0);

    }


    void setSpeed(byte speed){
this.speed=speed;
    }
    // creation
   public Fan (String comp, double radios, String color){
        this.comp= comp;
                this.radios=radios;
                        this.color=color;

    }


    //print a state

    @Override
    public String toString() {
        return "Fan{" +
                "comp='" + comp + '\'' +
                ", radios=" + radios +
                ", color='" + color + '\'' +
                ", isOn=" + isOn +
                ", speed=" + speed +
                '}';
    }
}
