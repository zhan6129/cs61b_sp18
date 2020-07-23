public class Palindrome {

	public Deque<Character> wordToDeque(String word) {
		Deque<Character> wordInDeque = new ArrayDeque<>();
		for (int i = 0; i < word.length(); i++) {
		    wordInDeque.addLast(word.charAt(i));
		}
		return wordInDeque;
	}
	
	public boolean isPalindrome(String word) {
	    int center1, center2;
	    if (word.length() % 2 == 1) {
	        center1 = (word.length() - 1) / 2;
	        center2 = (word.length() - 1) / 2;
	    } else {
	        center1 = word.length() / 2 - 1;
	        center2 = word.length() / 2;
	    }
	    
	    while (center1 >= 0) {
	        if (word.charAt(center1) != word.charAt(center2)) {
	            return false;
	        }
	        center1--;
	        center2++;       
	    }
	    return true;	    
	}
	
	public boolean isPalindrome(String word, CharacterComparator cc) {
	    return isPalindrome(wordToDeque(word), cc);
	}
	
	private boolean isPalindrome(Deque<Character> wordInDeque, CharacterComparator cc) {
        while (wordInDeque.size() > 1) {
            return cc.equalChars(wordInDeque.removeFirst(), wordInDeque.removeLast()) 
            && isPalindrome(wordInDeque, cc);
        }
        return true;
    }
}
