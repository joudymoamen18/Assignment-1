import java.util.Scanner;

public class lifecoachapp {
    //shared contoller data
    static String[] nameofusers = new String[100];
    static String[] passofusers = new String[100];
    static int count = 0;
    static Scanner input = new Scanner(System.in);
    static User currentuser;
    static User[] users=new User[100];



    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose:");
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.println("3.Exit app");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) login();
        else if (choice == 2) signup();
        else if (choice == 3) return;
        else System.out.print("INVALID CHOICE");
    }
    }

    public static void signup() {
        System.out.println("Enter username");
        String name = input.nextLine();
        System.out.println("Enter password");
        String pass = input.nextLine();
        nameofusers[count] = name;
        passofusers[count] = pass;
        User newUser = new User(name, pass);
        users[count] = newUser;
        currentuser = newUser;
        count++;
        System.out.println("sign up succesfully");
        showmenu();
    }

    public static void login() {
            System.out.println("Enter username");
            String name = input.nextLine();
            System.out.println("Enter password");
            String pass = input.nextLine();
             boolean found=false;
            for (int i = 0; i < count; i++) {
                if (nameofusers[i].equals(name) &&
                        passofusers[i].equals(pass)) {
                    currentuser = users[i];
                    System.out.print("log in succesfully");
                    found = true;
                    break;
                }
            }
            if(found) showmenu();
               else System.out.print("invalid username or password");

    }


    public static void logout() {
        currentuser = null;
        System.out.println("logedout");

    }


    public static void showmenu() {
        boolean inmenu=true;
        while (inmenu) {

            System.out.println("Choose:");
            System.out.println("1. add goal");
            System.out.println("2. view goals");
            System.out.println("3. mark goal as done");
            System.out.println("4. show progress");
            System.out.println("5. logout");
            int no = input.nextInt();
            if (no == 1)
                addgoal();
            else if (no == 2)
                currentuser.viewgoals();
            else if (no == 3)
                markGoalDone();
            else if (no == 4)
                currentuser.showprogress();
            else if (no == 5) {
                logout();
               break;
            } else System.out.print("invalid choice");

        }
    }

    public static void addgoal() {
        System.out.print("Enter goal title: ");
        String title = input.next();
        currentuser.addgoal(title);
    }

    public static void markGoalDone() {
        System.out.print("Enter goal number: ");
        int index = input.nextInt();
        currentuser.markdone(index-1);
    }
}

