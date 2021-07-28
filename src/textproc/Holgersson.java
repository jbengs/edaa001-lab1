package textproc;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = {"blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland"};

	public static void main(String[] args) throws FileNotFoundException {

		List<TextProcessor> processorList= new ArrayList<TextProcessor>();
		processorList.add(new SingleWordCounter("nils"));
		processorList.add(new SingleWordCounter("norge"));

		TextProcessor multiProcessor = new MultiWordCounter(REGIONS);

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			multiProcessor.process(word);

			for (TextProcessor p : processorList) {
				p.process(word);
			}
		}

		s.close();

		for (TextProcessor p : processorList) {
			p.report();
		}

		multiProcessor.report();

		feature1();
		feature2();
		importantBugFix();
	}

	public static void feature1() {
		System.out.println("feature1");
	}

	public static void feature2() {
		System.out.println("feature2");
	}
	public static void importantBugFix() {
		System.out.println("bugfix");
	}
}