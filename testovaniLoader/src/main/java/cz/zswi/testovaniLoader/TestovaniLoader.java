package cz.zswi.testovaniLoader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Hlavni trida, preda parametry a spusti aplikaci
 */
public class TestovaniLoader {
	/**
	 * Vstupni bod programu, parsuje argumenty z pøíkazové øádky
	 * @param args typ souboru a cesty k nim
	 */
	public static void main(String[] args) {
		TestovaniLoadManager manager = new TestovaniLoadManager();
		Options options = new Options();
		setOptions(options);
		HelpFormatter formatter = new HelpFormatter();

		CommandLine cmd = getParser(options, args);
		if(cmd == null) {
			formatter.printHelp("TestovaniLoader", options);
			return;
		}

		if (cmd.hasOption("h")) {
			formatter.printHelp("TestovaniLoader", options);
			return;
		} else if (cmd.hasOption("csv")) {
			if(args.length != 4) {
				formatter.printHelp("TestovaniLoader", options);
				return;
			}
			manager.load("CSV", args[1], args[2], args[3]);
			return;
		} else {
			System.out.println("Neplatny prikaz");
			formatter.printHelp("TestovaniLoader", options);
			return;
		}


	}
	
	/**
	 * Zajisti vytvoreni CommandLine pro parsovani argumentu
	 * @param options 
	 * @param args argumenty z prikazove radky
	 * @return vytvoreny CommandLine
	 */
	private static CommandLine getParser(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			return cmd;
		} catch (ParseException e) {
			System.err.println("Error: Parsovani prikazove radky se nezdarilo");
			return null;
		}
	}

	/**
	 * Pridani moznosti do options
	 * @param options
	 */
	private static void setOptions(Options options) {
		Option csvOption = Option.builder("csv").argName("milnik.csv> <naplanovaneTesty.csv> <vysledekTestu.csv").hasArgs().numberOfArgs(2)
				.desc("Zapise csv soubory do MongoDB").build();
		options.addOption("h", "help", false, "Vypise napovedu")
		.addOption(csvOption);

	}

}
