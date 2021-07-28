package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Holgersson {
	//Kommentar 3

	public static final String[] REGIONS = {"blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland"};

	public static void main(String[] args) throws FileNotFoundException {

		TextProcessor p = new SingleWordCounter("nils");

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			p.process(word);
		}

		s.close();

		p.report();
	}

	public void feature1() {
		System.out.println("feature1");
	}

	public void feature2() {
		System.out.println("feature2");
	}
	public void importantBugFix() {
		System.out.println("bugfix");
	}
}