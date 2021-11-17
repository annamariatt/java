package ee.bcs.java.tasks;

public class LessonC {
    public static void main(String[] args) {

    }

    // TODO korruta omavahel x ja z ning liida sellele y ja z korrutis
    public static int testMath(int x, int y, int z) {
        return 0;
    }

    // TODO kui mitu paaris arvu on sisendites
    public static int testStuff(int a, int b, int c, int d, int e, int f, int g) {
        int count = 0;
        count = getCount(a, count);
        count = getCount(b, count);
        count = getCount(c, count);
        count = getCount(d, count);
        count = getCount(e, count);
        count = getCount(f, count);
        count = getCount(g, count);
        return count;
    }

    private static int getCount(int a, int count) {
        if (a % 2 == 0) {
            count++;
        }
        return count;
    }

    public static boolean userValidation(boolean emailValid, boolean telephoneValid, boolean addressValid) {
        // tagasta true, kui muutuja addressValid on tõene ja vähemalt üks (emailValid või telephoneValid) on tõene
        return addressValid && (emailValid || telephoneValid);
    }
}
