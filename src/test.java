import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

public class test {

	public static void main(String[] args) {
		try {
			DictionaryBuilder dictionary = new DictionaryBuilder("american-english");
			Collection<String> words = dictionary.getWordsOfLength(5);	
			LadderBuilder ladder = new LadderBuilder(words);
			
			ladder.buildLadder("camel", "camel");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
