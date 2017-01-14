package hw2.frequency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class Freq {
    private String text;



    public String setTextFromConsole() {
        text = ConsoleHelper.readString("Please type your text below:");
        return text;
    }

    String setTextFromFile(String fileName) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\files\\" + fileName));
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found.");
            return null;
        }

        String line;
        StringBuilder sb = new StringBuilder();

        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException ioe) {
            System.out.println("I/O Exception");
            return null;
        }

        text = sb.toString();
        return text;
    }

    public String generateRandomText() {
        Random random = new Random();
        int bound = 100;
        int length = random.nextInt(bound);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
//            sb.append(getAlphabet().charAt(random.nextInt(getAlphabet().length())));
            sb.append(generateRandomWord());
            sb.append(" ");
        }
        text = sb.toString();
        return text;
    }

    public String generateRandomTextWithVocabulary() {
        Random random = new Random();
        int bound = 100;
        int length = random.nextInt(bound);
        String[] vocabulary = generateRandomVocabulary();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(vocabulary[random.nextInt(vocabulary.length)]);
            sb.append(" ");
        }
        text = sb.toString();
        return text;
    }

    private String[] generateRandomVocabulary() {
        int length = 20;
        String[] vocab = new String[length];
        for (int i = 0; i < length; i++) {
            vocab[i] = generateRandomWord();
        }
        return vocab;
    }

    private String generateRandomWord() {
        Random random = new Random();
        int bound = 10;
        int length = random.nextInt(bound - 1) + 1; // length != 0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(getAlphabet().charAt(random.nextInt(getAlphabet().length() - 23) + 23)); // only letters
        }
        return sb.toString();
    }

    private String getAlphabet() {
        return "!\"\'(),-.0123456789:;?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    }

    public Set<String> getWordsByFrequency(int frequency) {
        Map<Integer, Set<String>> wordsByFrequencies = getMapOfFrequencies();
        return wordsByFrequencies.get(frequency);
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        Map<Integer, Set<String>> wordsByFrequencies = getMapOfFrequencies();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < frequency; i++) {
            set.addAll(wordsByFrequencies.get(i));
        }
        return set;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Map<Integer, Set<String>> wordsByFrequencies = getMapOfFrequencies();
        Set<String> set = new HashSet<>();
        Set<Integer> keySet = wordsByFrequencies.keySet();
        for (Map.Entry<Integer, Set<String>> entry : wordsByFrequencies.entrySet()) {
            if (entry.getKey() >= frequency) {
                set.addAll(entry.getValue());
            }
        }
        return set;
    }

    public void printAcs() {

    }

    public void printDesc() {

    }

    public Map<Integer, Set<String>> getMapOfFrequencies() {
        Scanner scanner = new Scanner(text);
        Map<String, Integer> words = new HashMap<>();
        String word;
        while (scanner.hasNext()) {
            word = scanner.next();
            if (words.containsKey(word)) {
                int value = words.get(word);
                words.put(word, value + 1);
            } else {
                words.put(word, 1);
            }
        }
        Map<Integer, Set<String>> wordsByFrequencies = new TreeMap<>();

        for (Map.Entry<String, Integer> entry: words.entrySet()) {
            if (wordsByFrequencies.containsKey(entry.getValue())) {
                wordsByFrequencies.get(entry.getValue()).add(entry.getKey());
            } else {
                Set<String> set = new HashSet<>();
                set.add(entry.getKey());
                wordsByFrequencies.put(entry.getValue(), set);
            }
        }
        return wordsByFrequencies;
    }
}
