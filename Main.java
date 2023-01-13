import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static List<String> CartesianProduct1(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();

        }
        String[] digitsmap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        // { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }
        List<String> possibleCombinations = new ArrayList<>();
        possibleCombinations.add("");

        for (char digit : digits.toCharArray()) {
            List<String> tempCombinations = new ArrayList<>();
            for (String x : possibleCombinations) {
                for (char c : digitsmap[digit - '0'].toCharArray()) {
                    tempCombinations.add(x + c);
                }
            }
            possibleCombinations = tempCombinations;
        }
        return possibleCombinations;
    }

    public static List<String> CartesianProduct2(String digits) {
        char[][] digitsmap = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

        if (digits.equals(""))
            return Collections.emptyList();

        List<String> possibleCombinations = new ArrayList<>();
        backTrack(digits, digitsmap, 0, possibleCombinations, new StringBuilder());
        return possibleCombinations;
    }

    private static void backTrack(String digits, char[][] digitsmap, int start, List<String> possibleCombinations,
            StringBuilder temp) {
        if (temp.length() == digits.length()) {
            possibleCombinations.add(temp.toString());
        }

        if (start == digits.length())
            return;

        for (char c : digitsmap[digits.charAt(start) - '0']) {
            temp.append(c);
            backTrack(digits, digitsmap, start + 1, possibleCombinations, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(CartesianProduct1("32"));
        System.out.println(CartesianProduct2("32"));

    }
}