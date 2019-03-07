import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This class enables clients (users of the class) to read a file containing a list of whitespace 
 * delimited words and return a subset of those word of a given length. Each word will be 
 * converted to lower case, and each word will appear only once in the dictionary.
 * @author Kevin Filanowski
 * @author Tyler Baylson
 * @version 12/07/2017
 */
public class DictionaryBuilder {
	/** The scanner from which the words will be read. **/
	private Scanner fileInput;
	
	/**
	 * Constructs a new DictionaryBuilder that will read words from the specified file.
	 * @param filename the name of the dictionary.
	 * @throws FileNotFoundException 
	 */
	public DictionaryBuilder(String filename) throws FileNotFoundException  {
		FileInputStream file = new FileInputStream(filename);
		fileInput = new Scanner(file);
	}
	
	/**
	 * Gets a Collection of words from the file with the specified length. This method 
	 * creates a HashSet to hold the dictionary. It then uses the fileInput field to 
	 * read each word from the file. If the word's length is correct, the method 
	 * converts the word to lower case. If the converted word is not found in the 
	 * dictionary, it adds the word to the dictionary. Once the method examines each 
	 * word in the file, the method returns the dictionary of words.
	 * @param length
	 * @return
	 */
	public Collection<String> getWordsOfLength(int length) {
		HashSet<String> dictionary = new HashSet<>();
		String word;
		
		while (fileInput.hasNext()) {
			word = fileInput.next();
			if (word.length() == length) {
				dictionary.add(word.toLowerCase());
			}
		}
		return dictionary;
	}
}