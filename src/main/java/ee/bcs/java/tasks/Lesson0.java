package ee.bcs.java.tasks;

import java.util.Scanner;

public class Lesson0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("sisesta, millist funktsiooni käivitada");
        System.out.println("1 - korrutamine");
        System.out.println("2 - jagamine");
        System.out.println("3 - liitmine");
        System.out.println("4 - lahutamine");
        System.out.println("5 - protsent");
        //TO DO siia edaspidi kõik funktsioonid
        int choice = in.nextInt();
        if (choice == 1) {
            System.out.println("Korrutamine: ");
            System.out.println("sisesta a");
            int a = in.nextInt();
            System.out.println("sisesta b");
            int b = in.nextInt();
            int vastus = multiply(a, b);
            System.out.println("a korrutada b on:" + vastus);
        }
        if (choice == 2) {
            System.out.println("Jagamine: ");
            System.out.println("sisesta a");
            int a = in.nextInt();
            System.out.println("sisesta b");
            int b = in.nextInt();
            int vastus = divide(a, b);
            System.out.println("a jagada b on:" + vastus);
        }
        if (choice == 3) {
            System.out.println("Liitmine: ");
            System.out.println("sisesta a");
            int a = in.nextInt();
            System.out.println("sisesta b");
            int b = in.nextInt();
            int vastus = add(a, b);
            System.out.println("a liita b on:" + vastus);
        }
        if (choice == 4) {
            System.out.println("Lahutamine: ");
            System.out.println("sisesta a");
            int a = in.nextInt();
            System.out.println("sisesta b");
            int b = in.nextInt();
            int vastus = subtract(a, b);
            System.out.println("a miinus b on:" + vastus);
        }
        if (choice == 5) {
            System.out.println("Protsent ühest arvust: ");
            System.out.println("sisesta a");
            int a = in.nextInt();
            System.out.println("sisesta b");
            int b = in.nextInt();
            int vastus = percentage(a, b);
            System.out.println("a % b-st on:" + vastus);
        }
    }

    private static int percentage(int a, int b) {
        return a % b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }


    // TODO
    //  defineeri 3 muutujat a = 1, b = 1, c = 3
    //  Prindi välja a==b
    //  Prindi välja a==c
    //  Lisa rida a = c
    //  Prindi välja a==b
    //  Prindi välja a==c, mis muutus???
    public static void excersie1() {
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
        a = c;
        System.out.println(a == b);
        System.out.println(a == c);
    }

    // TODO
    //  Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
    //  Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
    //  Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
    //  Analüüsi tulemusi
    public static void excersie2() {
        int x1 = 10;
        int x2 = 20;
        int y1 = ++x1; // ++x1 => x = x + 1
        // 1) x1 = x1 +1
        // 2) y1 = x1
        int y2 = x2++;
        // 1) y2 = x2
        // 2) x2 = x2 + 1
        System.out.println("x1: " + x1);
        System.out.println("y1: " + y1);
        System.out.println("x2: " + x2);
        System.out.println("y2: " + y2);


    }

    // TODO
    //  Loo arvulised muutujad
    //  a = 18 % 3
    //  b = 19 % 3
    //  c = 20 % 3
    //  d = 21 % 3
    //  Prindi välja kõigi muutujate väärtused
    public static void excersie3() {
        int a = 18 % 3;
        int b = 19 % 3;
        int c = 20 % 3;
        int d = 21 % 3;
        System.out.println("a: " + a);
        System.out.println("b: " + 19 % 3);
        System.out.println("c: " + c);
        System.out.println("d: " + 21 % 3);
        // 18 jagub kolmega, siis tagastame 0.
        // 19 puhul tuleb tagastada 1, et jaguks kolmega
        // 20 puhul tuleb tagastada 2, et jaguks kolmega

    }
}
