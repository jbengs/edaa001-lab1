package textproc;
import textproc.TextProcessor;

import java.util.*;

public class GeneralWordCounter implements TextProcessor {
    private Map<String, Integer> wordMap;
    private Set<String> stopWords;

    public GeneralWordCounter(Set wordSet) {
        wordMap = new HashMap<String, Integer>();
        stopWords = wordSet;
    }

    /**
     * Anropas när ett ord lästs in. Metoden ska uppdatera statistiken därefter.
     *
     * @param w
     */
    @Override
    public void process(String w) {
        if (!stopWords.contains(w)) {
            if (wordMap.containsKey(w)) {
                int n = wordMap.get(w);
                wordMap.put(w, n+1);
            } else {
                wordMap.put(w, 1);
            }
        }
    }

    /**
     * Anropas när samtliga ord i sekvensen lästs in. Metoden ska skriva ut
     * en sammanställning av statistiken.
     */
    @Override
    public void report() {
        Set<Map.Entry<String, Integer>> wordSet = wordMap.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
        wordList.sort(new WordCountComparator());
        for (int i = 0; i < 25; i++) {
           System.out.println(i+1 + ": " + wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
        }

        /* Från D8
        Set<String> output = wordMap.keySet();
        for (String s : output) {
            if (wordMap.get(s) >= 200){
                System.out.println(s + ": " + wordMap.get(s));
            }
        }

         */
    }
}
