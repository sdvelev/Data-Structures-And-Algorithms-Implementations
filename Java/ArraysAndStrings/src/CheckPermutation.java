import java.util.Arrays;

public class CheckPermutation {

    public static boolean checkPermutation(String first, String second) {

        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }


    public static void main(String[] args) {
        System.out.println(checkPermutation("cdf", "dfc"));
        System.out.println(checkPermutation("hello", "world"));
    }
}
