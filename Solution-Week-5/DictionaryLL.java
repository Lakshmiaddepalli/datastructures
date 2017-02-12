package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
	 public DictionaryLL() {
			dict = new LinkedList<String>();
		}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	boolean val = false;
		// TODO: Implement this method
    	for(String i :dict)
    	{
    		if(i.equals(word.toLowerCase()))
    			val  = true;
    	}
    	if(val==false)
    	dict.add(word.toLowerCase());
		return !val;
    }


   


    
	/** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
    	return dict.size();
       
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	boolean val = false;
    	for(String i :dict)
    	{
			if(i.equals(s.toLowerCase()))
    			val  = true;
    	}
        return val;
    }

    
}
