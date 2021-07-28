package textproc;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Holgersson {

	public static final String[] REGIONS = {"blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland"};

	public static void main(String[] args) throws FileNotFoundException {
		//Creates simple word processors
		List<TextProcessor> processorList= new ArrayList<TextProcessor>();
		processorList.add(new SingleWordCounter("nils"));
		processorList.add(new SingleWordCounter("norge"));

		//Creat multi word processor
		TextProcessor multiProcessor = new MultiWordCounter(REGIONS);

		//Creates general word counter
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopWords = new HashSet<String>();
		while(scan.hasNext()) {
			stopWords.add(scan.next());
		}

		TextProcessor generalProcessor = new GeneralWordCounter(stopWords);

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning


		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			generalProcessor.process(word);
			multiProcessor.process(word);
			for (TextProcessor p : processorList) {
				p.process(word);
			}
		}

		s.close();
		generalProcessor.report();
		/*
		multiProcessor.report();
		for (TextProcessor p : processorList) {
			p.report();
		}
		feature1();
		feature2();
		importantBugFix();
		 */
	}

	public static void feature1() {
		System.out.println("feature1 to learn Git");
	}
	public static void feature2() {
		System.out.println("feature2 to learn Git");
	}
	public static void importantBugFix() {
		System.out.println("bugfix to learn Git");
	}
}