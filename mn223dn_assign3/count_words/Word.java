package mn223dn_assign3.count_words;

public class Word implements Comparable<Word> {
	private String word;

	public Word(String str) {
		word = str;
	}

	public String toString() {
		return word;
	}

	@Override
	public int hashCode() {
		return this.toString().toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Word)
			return word.toLowerCase().equals(((Word) other).word.toLowerCase());
		else
			return false;
	}

	public int compareTo(Word w) {
		return word.toLowerCase().compareTo(w.word.toLowerCase());
	}
	
}