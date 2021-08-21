import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookTicket {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Reservation service.");
        List<Reservation> list = new ArrayList<>();
        int people = 0;
        while(true){
            System.out.println("For reserving seats Enter 1 and To Quit Enter 2:");
            int select = Integer.parseInt(scanner.nextLine());
            boolean flag = true;
            switch (select){
                case 1 : {
                    System.out.print("Enter your Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the seat number you want to reserve from 1-10: ");
                    int seatNumber = Integer.parseInt(scanner.nextLine());

                    list.add(new Reservation(name,seatNumber));
                    people++;
                    break;
                }
                case 2  : {
                    flag = false;
                    break;
                }
                default : System.out.println("Wrong choice is chosen.");
            }
            if(!flag)
                break;
        }
        for(int i=0;i<people;i++) {
            Thread th = new Thread(list.get(i));
            th.start();
        }

    }
}
