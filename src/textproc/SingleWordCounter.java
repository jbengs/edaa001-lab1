package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	//Och en kommentar i denna klass

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {
		if (w == word) {
			n++;
		}
	}

	public void report() {
		System.out.println(word + ": " + n);
	}

}
