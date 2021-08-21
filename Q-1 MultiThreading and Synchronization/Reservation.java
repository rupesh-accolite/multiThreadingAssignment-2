public class Reservation implements Runnable{
    private String name;
    private int seatNumber;

    public Reservation(String name, int seatNumber) {
        this.name = name;
        this.seatNumber =seatNumber;
    }
    static int totalSeats = 10;
    static boolean[] availability = new boolean[totalSeats];

    synchronized public static void booking(String name, int seatNumber){
        if(totalSeats<1){
            System.out.println("Sorry for the Inconvenience. No slots available.");
        }
        else if(seatNumber<1 || seatNumber>10){
            System.out.println("Sorry "+name+".Invalid seat number.");
            return;
        }
        else if(availability[seatNumber-1]){
            System.out.println("Sorry "+name+". The requested seat number is unavailable.");
            return;
        }
        else{
            totalSeats--;
            availability[seatNumber-1] = true;
            System.out.println("Congratulations " + name + " . Your booking is successful.");
            System.out.println("Seat allotted to you is :"+seatNumber);
            System.out.println("Available no. of tickets are: " + totalSeats);
        }
        System.out.println();
    }

    @Override
    public void run() {
        booking(name,seatNumber);
    }
}
