package document;

/** 
 * A class that represents a text document
 * @author UC San Diego Intermediate Programming MOOC team
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Document {

	private String text;

	/**
	 * Create a new document from the given text. Because this class is
	 * abstract, this is used only from subclasses.
	 * 
	 * @param text
	 *            The text of the document.
	 */
	protected Document(String text) {
		this.text = text;
	}

	/**
	 * Returns the tokens that match the regex pattern from the document text
	 * string.
	 * 
	 * @param pattern
	 *            A regular expression string specifying the token pattern
	 *            desired
	 * @return A List of tokens from the document text that match the regex
	 *         pattern
	 */
	protected List<String> getTokens(String pattern) {
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);

		while (m.find()) {
			tokens.add(m.group());
		}

		return tokens;
	}

	/**
	 * This is a helper function that returns the number of syllables in a word.
	 * You should write this and use it in your BasicDocument class.
	 * 
	 * You will probably NOT need to add a countWords or a countSentences method
	 * here. The reason we put countSyllables here because we'll use it again
	 * next week when we implement the EfficientDocument class.
	 * 
	 * For reasons of efficiency you should not create Matcher or Pattern
	 * objects inside this method. Just use a loop to loop through the
	 * characters in the string and write your own logic for counting syllables.
	 * 
	 * @param word
	 *            The word to count the syllables in
	 * @return The number of syllables in the given word, according to this
	 *         rule: Each contiguous sequence of one or more vowels is a
	 *         syllable, with the following exception: a lone "e" at the end of
	 *         a word is not considered a syllable unless the word has no other
	 *         syllables. You should consider y a vowel.
	 */
	protected int countSyllables(String word) {
		// TODO: Implement this method so that you can call it from the
		// getNumSyllables method in BasicDocument (module 2) and
		// EfficientDocument (module 3).
		int answer = noOfSyllable(word);
		return answer;
	}

	private static int noOfSyllable(String word) {
		// TODO Auto-generated method stub
		int count = 0;
		String lower = word.toLowerCase();
		char[] wordchar = lower.toCharArray();
		char end = wordchar[wordchar.length - 1];
		Object[] answer = calculate(lower);
		int ans = (int) answer[0];
		String lastmatch = (String) answer[1];
		if (!isvowel(end)) {
			count = ans;
		} else {
			if (end == 'e') {
				if (lastmatch.charAt((lastmatch.length() - 1)) == 'e') {
					if (lastmatch.length() > 1) {
						int checking = 0;
						for (int i = 0; i < lastmatch.length(); i++) {
							if (isvowel(lastmatch.charAt(i))) {
								checking++;
							}
						}
						if (checking == lastmatch.length()) {
							count = ans;
						} else
							count = count + 1;
					}
					// }
					else if (ans == 0)
						ans = 1;
					else {
						count = ans - 1;
					}

				}

			} else {
				count = ans;
			}

		}

		return count;
	}

	private static Object[] calculate(String lower) {
		// TODO Auto-generated method stub
		Object[] intermediate = new Object[2];
		int count = 0;
		String pattern = "[bcdfghjklmnpqrstvwxz]*[aeiouy]+[bcdfghjklmnpqrstvwxz]*";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(lower);
		while (m.find()) {
			// System.out.println(m.group());
			intermediate[1] = m.group();
			count++;
		}

		intermediate[0] = count;

		return intermediate;
	}

	private static boolean isvowel(char c) {
		// TODO Auto-generated method stub
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
			return true;
		else
			return false;
	}

	/**
	 * A method for testing
	 * 
	 * @param doc
	 *            The Document object to test
	 * @param syllables
	 *            The expected number of syllables
	 * @param words
	 *            The expected number of words
	 * @param sentences
	 *            The expected number of sentences
	 * @return true if the test case passed. False otherwise.
	 */
	public static boolean testCase(Document doc, int syllables, int words, int sentences) {
		System.out.println("Testing text: ");
		System.out.print(doc.getText() + "\n....");
		boolean passed = true;
		int syllFound = doc.getNumSyllables();
		int wordsFound = doc.getNumWords();
		int sentFound = doc.getNumSentences();
		if (syllFound != syllables) {
			System.out.println("\nIncorrect number of syllables.  Found " + syllFound + ", expected " + syllables);
			passed = false;
		}
		if (wordsFound != words) {
			System.out.println("\nIncorrect number of words.  Found " + wordsFound + ", expected " + words);
			passed = false;
		}
		if (sentFound != sentences) {
			System.out.println("\nIncorrect number of sentences.  Found " + sentFound + ", expected " + sentences);
			passed = false;
		}

		if (passed) {
			System.out.println("passed.\n");
		} else {
			System.out.println("FAILED.\n");
		}
		return passed;
	}

	/** Return the number of words in this document */
	public abstract int getNumWords();

	/** Return the number of sentences in this document */
	public abstract int getNumSentences();

	/** Return the number of syllables in this document */
	public abstract int getNumSyllables();

	/** Return the entire text of this document */
	public String getText() {
		return this.text;
	}

	/** return the Flesch readability score of this document */
	public double getFleschScore() {
		// TODO: You will play with this method in week 1, and
		// then implement it in week 2
		double noofwords = getNumWords();
		double noofsentences = getNumSentences();
		double noofsyllables = getNumSyllables();
		double fleshscore = 0.0;

		try {
			fleshscore = 206.835 - 1.015 * (noofwords / noofsentences) - 84.6 * (noofsyllables / noofwords);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fleshscore = 0.0;
		}
		return fleshscore;
	}

}
