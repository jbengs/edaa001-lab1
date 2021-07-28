package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor{
    private Map<String, Integer> wordMap;

    public MultiWordCounter(String[] wordVector){
        wordMap = new HashMap<String, Integer>();
        for (String word : wordVector) {
            wordMap.put(word, 0);
        }
    }

    /**
     * Anropas när ett ord lästs in. Metoden ska uppdatera statistiken därefter.
     *
     * @param w
     */
    @Override
    public void process(String w) {
        if (wordMap.containsKey(w)) {
           int n = wordMap.get(w);
           n++;
           wordMap.put(w,n);
        }
    }

    /**
     * Anropas när samtliga ord i sekvensen lästs in. Metoden ska skriva ut
     * en sammanställning av statistiken.
     */
    @Override
    public void report() {
        for (String key : wordMap.keySet()) {
            System.out.println(key + ": " + wordMap.get(key));
        }
    }
}
