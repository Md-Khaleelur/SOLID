package solid.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// solid.second.CarApp class - open for extension, closed for modification (OCP)
// Substitute what can be fully extended (Liskov's Substitution principle) - solid.second.CarApp class fully extended by solid.second.Ola/solid.second.Uber class
// DIP - classes should depend on abstractions and not concretions, invert the dependency we get the same output

abstract class CarApp implements IDrivable,IBookable {
    abstract void signUp(String name, String phone);
    abstract void editProfile(String name, String rename);
}


//Interface Segregation principle (Each interface with only one responsibility)
interface IDrivable {
    void showRoute(String start, String end);
    boolean checkAvailable(String car);
}

interface IBookable {
    void makeBooking(String car);
    String driverDetails(String car);
}

//SRP - Instead of single solid.second.CarApp class, solid.second.Ola/solid.second.Uber can do it (SRP)
class Ola extends CarApp {

    List<String> carList;
    HashMap<String,String> carDriver;
    HashMap<String,String> driverDetails;
    String name;
    String email;
    String phone;

    Ola() {
        carList = new ArrayList<String>();
        carList.add("XUV");
        carList.add("Swift");

        carDriver = new HashMap<String, String>();
        carDriver.put("XUV","Karthik");
        carDriver.put("Swift","Ahmed");

        driverDetails = new HashMap<String, String>();
        driverDetails.put("Karthik","9700234567");
        driverDetails.put("Ahmed","8686357876");
    }

    @Override
    void signUp(String name, String phone) {
        this.name=name;
        this.phone=phone;
    }

    @Override
    void editProfile(String name, String email) {
        this.name=name;
        this.email=email;
    }

    @Override
    public String driverDetails(String car) {
        return driverDetails.get(carDriver.get(car));
    }

    @Override
    public void makeBooking(String car) {
        String driverName = carDriver.get(car);
        if (checkAvailable(car)) {
            System.out.println("Booking made by: "+name);
            System.out.println(car + " Booking Confirmed\nThe driver is "+driverName+"\nContact:"+driverDetails.get(driverName));
        }
        else
            System.out.println(car+" is not Available");
    }

    @Override
    public void showRoute(String start, String end) {
        System.out.println("The route starts from "+start+" to X to Y to Z "+end);
    }

    @Override
    public boolean checkAvailable(String car) {
        return carList.contains(car);
    }

}

class Uber extends CarApp {

    List<String> carList;
    HashMap<String,String> carDriver;
    HashMap<String,String> driverDetails;
    String name;
    String email;
    String phone;

    Uber() {
        carList = new ArrayList<String>();
        carList.add("Ritz");
        carList.add("Innova");

        carDriver = new HashMap<String, String>();
        carDriver.put("Ritz","Sagar");
        carDriver.put("Innova","Asghar");

        driverDetails = new HashMap<String, String>();
        driverDetails.put("Sagar","970874567");
        driverDetails.put("Asghar","8682657876");
    }

    @Override
    void signUp(String name, String phone) {
        this.name=name;
        this.phone=phone;
    }

    @Override
    void editProfile(String name, String email) {
        this.name=name;
        this.email=email;
    }

    @Override
    public String driverDetails(String car) {
        return driverDetails.get(carDriver.get(car));
    }

    @Override
    public void makeBooking(String car) {
        String driverName = carDriver.get(car);
        if (checkAvailable(car)) {
            System.out.println("\nBooking made by: "+name);
            System.out.println(car + " Booking Confirmed\nThe driver is "+driverName+"\nContact:"+driverDetails.get(driverName)+"\n");
        }
        else
            System.out.println(car+" is not Available");
    }


    @Override
    public void showRoute(String start, String end) {
        System.out.println("The route starts from "+start+" to X to Y to Z "+end);
    }

    @Override
    public boolean checkAvailable(String car) {
        return carList.contains(car);
    }

}

