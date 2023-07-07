import java.util.HashSet;
import java.util.Set;

public class IsUnique {


    public static boolean isUnique(String word) {

        Set<String> characters = new HashSet<>();

        for (char character : word.toCharArray()) {
            if (characters.contains(String.valueOf(character))) {
                return false;
            }
            characters.add(String.valueOf(character));
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isUnique("abcdefg"));
        System.out.println(isUnique("little"));
    }


}
