import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Class that created a word-ladder between two words (if possible)
 *
 * @author Kevin Filanowski 
 * @author Tyler Baylson
 *
 * @version 12/07/2017
 */
public class LadderBuilder {

	/** The dictionary of words from which to build the word ladder. **/
	private Collection<String> dictionary;

	/** The words that have already been used in the word ladder. **/
	private Collection<String> usedWords;

	/** 
	 * Initializes a new LadderBuilder based on the specified dictionary. 
	 * @param dictionary The dictionary to use.
	 **/
	public LadderBuilder(Collection<String> dictionary) {
		this.dictionary = dictionary;
		this.usedWords = new HashSet<String>();
	}

	/**
	 * Builds many ladders until a solution is found to the word ladder.
	 * @param start The starting word.
	 * @param end The ending word.
	 * @return A stack containing the words that lead from start to end.
	 */
	public Stack<String> buildLadder(String start, String end) {
		//Get all the words that are one word away from the end.
		List<String> wordsOneAway = getWordsOneAway(end);
		
		//Creates a double ended queue to hold stacks.
		Deque<Stack<String>> deq = new ArrayDeque<>();
		
		//Create a new stack to hold possible solutions.
		Stack<String> stack = new Stack<>();
		stack.add(end);
		
		boolean solution = false;
		while (!solution) {
			for (String s : wordsOneAway) {
				//Clone the first stack to push more words onto.
				Stack<String> clone = (Stack<String>) stack.clone();
				clone.push(s);
				//Add this clone to the queue.
				deq.add(clone);
				//If the word is the end word, we found the first (and shortest) solution!
				if (s.equals(start)) {
					solution = true;
					return clone;
				}
			}
			//Pull a stack from the front of the queue.
			stack = deq.pollFirst();
			//This check will test to see if a solution exists.
			if (stack == null) {
				System.out.println("There is no solution.");
				return new Stack<>();
			}
			//Gets words that are one character away from the word at the top of the stack.
			wordsOneAway = getWordsOneAway(stack.peek());
		}
		return null;
	}

	/**
	 * Initializes a new LadderBuilder based on the specified dictionary.
	 * @param word The target word.
	 * @return a list of words that are different from word by only one character.
	 */
	private List<String> getWordsOneAway(String word) {
		//Ensures that word is a lowercase word.
		word = word.toLowerCase();
		usedWords.add(word);

		List<String> list = new Stack<>();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] charWord = word.toCharArray();
		char tempChar;
		String stringWord;

		//Loop through the char array of the word.
		for (int i = 0; i < charWord.length; i++) {
			//Create a temp char to save changed chars.
			tempChar = charWord[i];

			//Second loop to iterate through the alphabet.
			for (int j = 0; j < alphabet.length-1; j++) {
				//Prevents the same word from being added to the list by skipping an iteration.
				if (tempChar == alphabet[j]) {
					continue;
				}

				charWord[i] = alphabet[j];
				//checks the new word with the dictionary and passes it in the list if it exists.
				stringWord = new String(charWord);
				if (dictionary.contains(stringWord) && !usedWords.contains(stringWord)) {
					list.add(stringWord);
					usedWords.add(stringWord);
				}
			}
			//Reset the word back to what the original word was.
			charWord[i] = tempChar;
		}
		return list;
	}
}