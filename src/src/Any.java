import java.util.HashSet;
import java.util.Set;

public class Any {

    private long any;

    public Any(long any) {
        this.any = any;
    }

    public int digitsDiferents() {
        Set<Character> digits = new HashSet<>();
        String s = String.valueOf(any);

        for (char c : s.toCharArray()) {
            digits.add(c);
        }
        return digits.size();
    }
}