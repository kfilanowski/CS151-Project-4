import java.util.Scanner;
import java.util.Stack;
import java.util.Collection;
import java.util.HashSet;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 * This class is the driver for the word ladder.
 * It will compute and return a word ladder from two provided words by the user.
 * Required parameters: a dictionary file, a begin word, and an end word.
 * usage: java Driver <dictionary> start end
 * @author Kevin Filanowski
 * @author Tyler Baylson
 * @version 12/07/2017
 */
public class Driver {

	/**
	 * The main method running the driver.
	 * @param args String arguments, in the following order: dictionary start end
	 */
	public static void main(String[] args) {
		//Check the argument length.
		if (args.length != 3) {
			System.err.println("usage: java Driver <dictionary> start end");
			//Check the start and end word length
		} else if (args[1].length() != args[2].length()) {
			System.err.println("Words are not the same length.");
			//Check equality between start and end words.
		} else if (args[1].equalsIgnoreCase(args[2])) {
			System.err.println("Start and end words are the same!");
		} else {
			//Handles invalid dictionary file path.
			try {
				DictionaryBuilder dictionary = new DictionaryBuilder(args[0]);
				Collection<String> words = dictionary.getWordsOfLength(args[1].length());

				//Check if words are in the dictionary.
				if (words.contains(args[1]) && words.contains(args[2])) {
					LadderBuilder ladder = new LadderBuilder(words);
					Stack<String> solution = ladder.buildLadder(args[1], args[2]);
					//Prints out the solution.
					for (String s : solution) {
						System.out.println(s);
					}
					System.out.println("There are " + solution.size() + " words total.");
				} else {
					System.err.println("The words are not contained in the dictionary!");
				}
			} catch (FileNotFoundException e) {
				System.out.println("Dictionary File not found.");
				e.printStackTrace();
			}
		}
	}
}
