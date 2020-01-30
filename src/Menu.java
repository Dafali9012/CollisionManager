import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    private static Scanner scan = new Scanner(System.in);

    public static int numInput(String prompt) {
        boolean thisIsFine = true;
        int amount = 0;
        System.out.println(prompt);
        do {
            System.out.print("> ");
            try {
                amount = scan.nextInt();
                scan.nextLine();
                thisIsFine = true;
            } catch (InputMismatchException e) {
                scan.nextLine();
                thisIsFine = false;
            }
        } while (!thisIsFine);
        return amount;
    }

    public static int restart() {
        boolean thisIsFine = true;
        int selection = 0;
        System.out.println("Restart?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        do {
            System.out.print("> ");
            try {
                selection = scan.nextInt();
                scan.nextLine();
                if(selection < 3 && selection > 0) {
                    thisIsFine = true;
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                thisIsFine = false;
            }
        } while (!thisIsFine);
        return selection;
    }
}
