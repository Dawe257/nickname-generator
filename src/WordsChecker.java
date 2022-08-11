import java.util.concurrent.atomic.AtomicInteger;

public class WordsChecker {

    private static final AtomicInteger length3 = new AtomicInteger();
    private static final AtomicInteger length4 = new AtomicInteger();
    private static final AtomicInteger length5 = new AtomicInteger();

    public static int getLength3() {
        return length3.get();
    }

    public static int getLength4() {
        return length4.get();
    }

    public static int getLength5() {
        return length5.get();
    }

    private static boolean isPalindrom(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    private static boolean isSameLetters(String s) {
        for (char c : s.toCharArray()) {
            if (c != s.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncrease(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void checkWords(String[] words, int length) {
        for (String word : words) {
            if ((isPalindrom(word) || isSameLetters(word) || isIncrease(word)) && word.length() == length) {
                switch (length) {
                    case 3 -> length3.incrementAndGet();
                    case 4 -> length4.incrementAndGet();
                    case 5 -> length5.incrementAndGet();
                }
            }
        }
    }
}
