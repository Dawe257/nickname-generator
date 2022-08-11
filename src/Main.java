import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = Generator.generateText("abc", 3 + random.nextInt(3));
        }

        Thread thread1 = new Thread(null, () -> WordsChecker.checkWords(texts, 3), "Поток 1");
        Thread thread2 = new Thread(null, () -> WordsChecker.checkWords(texts, 4), "Поток 2");
        Thread thread3 = new Thread(null, () -> WordsChecker.checkWords(texts, 5), "Поток 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();

        System.out.printf("""
                        Красивых слов с длиной 3: %d шт
                        Красивых слов с длиной 4: %d шт
                        Красивых слов с длиной 5: %d шт
                        """,
                WordsChecker.getLength3(), WordsChecker.getLength4(), WordsChecker.getLength5());
    }
}
