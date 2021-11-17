package ee.bcs.java.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        System.out.println(min(2, 5));
        System.out.println(min(9, 5));
        System.out.println(min(11, 6));
        System.out.println(min(9, 1));
        Scanner in = new Scanner(System.in);
        while (true) {
        System.out.println("sisesta, millist funktsiooni käivitada");
        System.out.println("1 - min");
        System.out.println("2 -max");
        System.out.println("3 -abs");
        System.out.println("4 -even");
        System.out.println("5 -min3");
        System.out.println("6 -max3");
        System.out.println("7 -someString");
        System.out.println("8 -exit");
            //TO DO siia edaspidi kõik funktsioonid
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Min: ");
                System.out.println("sisesta a");
                int a = in.nextInt();
                System.out.println("sisesta b");
                int b = in.nextInt();
                int vastus = min(a, b);
                System.out.println("Miinimum a-st ja b-st on:" + vastus);
            } else if (choice == 2) {
                System.out.println("Max: ");
                System.out.println("sisesta a");
                int a = in.nextInt();
                System.out.println("sisesta b");
                int b = in.nextInt();
                int vastus = max(a, b);
                System.out.println("Maximum a-st ja b-st on:" + vastus);
            } else if (choice == 3) {
                System.out.println("Absoluutarv: ");
                System.out.println("sisesta a");
                int a = in.nextInt();
                int vastus = abs(a);
                System.out.println("Absoluutarv a-st on:" + vastus);
            } else if (choice == 4) {
                System.out.println("Paarisarv: ");
                System.out.println("sisesta a");
                int a = in.nextInt();
                boolean vastus = isEven(a);
                System.out.println("A on 2 või võrdne kahega:" + vastus);
            } else if (choice == 5) {
                System.out.println("Kolmest väikseim: ");
                System.out.println("sisesta a");
                int a = in.nextInt();
                System.out.println("sisesta b");
                int b = in.nextInt();
                System.out.println("sisesta c");
                int c = in.nextInt();
                int vastus = min3(a, b, c);
                System.out.println("a-st, b-st ja c-st väikseim on:" + vastus);
            } else if (choice == 6) {
                System.out.println("Kolmest suurim: ");
                System.out.println("sisesta a");
                int a = in.nextInt();
                System.out.println("sisesta b");
                int b = in.nextInt();
                System.out.println("sisesta c");
                int c = in.nextInt();
                int vastus = max3(a, b, c);
                System.out.println("a-st, b-st ja c-st suurim on:" + vastus);
            } else if (choice == 7) {
                System.out.println("Otsi \"\\\"\\\\\"\": ");
                String vastus = someString();
                System.out.println("\"\\\"\\\\\"\" on:" + vastus);
            } else if (choice == 8) {
                System.out.println("exit");
                break;
            }
        }
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        // funktsiooni ees on andmetüüp, mis
        //kui (if) a on väiksem, kui b, siis tagasta a (return a) ja kui ei, siis vastus on b (else b)
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b; //kui pole -a siis tagastagi see sama a ergo absoluut arv
        }
    }


    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a <= 0) { // tegelikult siin see nulli ees võrdumärk polegi oluline, ikka on õige
            return -a;
        } else {
            return a; //kui pole -a siis tagastagi see sama a ergo absoluut arv ehk siis absoluut arv -99st on 99
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true; // tagasta kui a on 2 või on võrdne kahega
        } else {
            return (false);
        }

    }


    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\\\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        return "\"\\\"\\\\\"\"";
    }
}