import java.util.*;


public class number {
    public static void main(String[] args) {
        
      
        Scanner sc = new Scanner(System.in);

   
        int mynum = (int)(Math.random()*100);
        int userNumber = 0;
        do {
            System.out.print("Guess my number (1 to 100): ");
            userNumber = sc.nextInt();
            if (userNumber == mynum) {
                System.out.println("YEHHH!!! CORRECT NUMBER!!!");
                break;
            }

            else if (userNumber > mynum) {
                System.out.println("Your number is too large!");
            }

            else if (userNumber < mynum) {
                System.out.println("Your number is too small!");
            }

           
            else {
                System.out.println("WRONG INPUT!!!!");
            }

        }while(true);

    
        System.out.println("My Number was: " + mynum);
        System.out.println("\n");
    }
}
