package textproc;
import textproc.TextProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        Set<String> output = wordMap.keySet();
        for (String s : output) {
            if (wordMap.get(s) >= 200){
                System.out.println(s + ": " + wordMap.get(s));
            }
        }
    }
}
