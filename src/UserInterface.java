import java.util.Scanner;

public class UserInterface {

    private static String recentMessage = "";
    private static Scanner sc;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean getYesNoOption(String userInput) {
        String SelectedOption = "";
        sc = new Scanner(System.in);
        System.out.print(userInput +  " Y/N: ");
        while (sc.hasNext()) {
            SelectedOption = sc.nextLine();
            if (SelectedOption.equals("Y") || SelectedOption.equals("y"))
                return true;
            else if (SelectedOption.equals("N") || SelectedOption.equals("n"))
                break;

        }
        return false;
    }

    public static int getSelection() {
        int SelectedOption = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            SelectedOption = sc.nextInt();
            if (SelectedOption == 1 || SelectedOption == 2 || SelectedOption == 3 || SelectedOption == 4)
                break;
        }

        return SelectedOption;
    }

    public static void displayMenu(Players newPlayer) {

        clearScreen();
        System.out.println(
                "\nWelcome to a game of 21. You have been provided with a fresh Deck.\nNavigate with numbers.\n");
        UserInterface.getRecentMessag();
        if (newPlayer.checkIfnameSet())
            System.out.println("1. " + newPlayer.getPlayerName());
        else
            System.out.println("1. Set Name");
        System.out.println("2. Shuffle Deck");
        System.out.println("3. Start Game.");
        System.out.println("4. Exit.");
        System.out.print("\nOption: ");
        System.out.flush();
    }

    public static void displayStartMessage(Players newPlayer) {
        clearScreen();

        if (newPlayer.checkIfnameSet())
            System.out.println("\nGame has started between " + newPlayer.getPlayerName() + " and the Computer!");
        else
            System.out.println("\nGame has started between the Human and the Computer!");
            
        System.out.flush();
    }

    public static void setRecentMessag(String a) {
        recentMessage = a;

    }

    public static void getRecentMessag() {
        System.out.println(recentMessage);
    }

    public static void extiGame() {
        String SelectedOption = "";
        sc = new Scanner(System.in);
        System.out.print("Are you sure? Yes or No: ");
        while (sc.hasNext()) {
            SelectedOption = sc.nextLine();
            if (SelectedOption.equals("Y") || SelectedOption.equals("y")) {
                clearScreen();
                System.out.println("\n\n\n\t\t It was nice playing with you!\n\n");
                System.exit(1);
            } else if (SelectedOption.equals("N") || SelectedOption.equals("n")) {
                break;
            } else
                break;
        }

    }

}
