package solid.second;

public class SolidDemoMain {

        public static void main(String[] args) {

            CarApp ola = new Ola();
            ola.signUp("Khaleel","9700637644");
            ola.showRoute("Malakpet","Hitech City");
            ola.makeBooking("Ritz");
            ola.makeBooking("XUV");

            Uber uber = new Uber();
            uber.signUp("Rehman","6789354736");
            uber.showRoute("Secunderabad","Banjara Hills");
            uber.makeBooking("Innova");

        }
}
