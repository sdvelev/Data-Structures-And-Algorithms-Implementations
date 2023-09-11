public class Recursion {

    public static void fromOneToTen(int i) {
        if (i > 10 || i < 1) {
            return;
        }

        System.out.print(i + " ");
        fromOneToTen(++i);
    }

    public static void main(String[] args) {

        fromOneToTen(1);
        System.out.println();
        fromOneToTen(2);
        System.out.println();
        fromOneToTen(3);
        System.out.println();
        fromOneToTen(4);
        System.out.println();
        fromOneToTen(5);
        System.out.println();
        fromOneToTen(6);
        System.out.println();
        fromOneToTen(7);
        System.out.println();
        fromOneToTen(8);
        System.out.println();
        fromOneToTen(9);
        System.out.println();
        fromOneToTen(10);
    }

}
