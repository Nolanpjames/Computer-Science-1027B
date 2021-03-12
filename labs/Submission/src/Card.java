
public class Card implements Comparable<Card> {
	
	private String suit; // S (spade), H (heart), D (diamond), or C (club)
	private String rank; // A (ace), 2, 3, ..., 10, J (jack), Q (queen), or K (king)

	public Card (String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit () {
		return suit;
	}
	
	public String getRank () {
		return rank;
	}
	
	public void setSuit (String suit) {
		this.suit = suit;
	}
	
	public void setRank (String rank) {
		this.rank = rank;
	}
	
	public String toString () {
		return rank + " of " + suit;
	}

	public boolean equals(Card other){
		return (this.getSuit().equals(other.getSuit())) && (this.getRank().equals(other.getRank()));
	}

	public int getSuitValue(){
		int suitValue = 0;
		if (this.getSuit().equals("D")){
			suitValue = 0;
		}
		else if (this.getSuit().equals("C")){
			suitValue = 1;
		}
		else if (this.getSuit().equals("H")){
			suitValue = 2;
		}
		else if (this.getSuit().equals("S")){
			suitValue = 3;
		}
		return suitValue;
	}

	public int getRankValue(){
		String letterRank = this.getRank();
		int rankValue = 0;
		try {
			rankValue = Integer.parseInt(letterRank);
		} catch (NumberFormatException nfe) {
			if(letterRank.equals("J") || letterRank.equals("Q") || letterRank.equals("K")){
				rankValue = 11;
			}
			else if(letterRank.equals("A")){
				rankValue = 12;
			}
		}
		return rankValue;
	}

	@Override
	public int compareTo(Card other) {
		if (this.equals(other)){
			return 0;
		}
		if (this.getRankValue() < other.getRankValue()){
			return -1;
		}
		else if (this.getRankValue() > other.getRankValue()){
			return 1;
		}
		else if (this.getRankValue() == other.getRankValue()){
			if(this.getSuitValue() < other.getSuitValue()){
				return -1;
			}
			else if(this.getSuitValue() == other.getSuitValue()){
				return 0;
			}
			else if(this.getSuitValue() > other.getSuitValue()){
				return 1;
			}
		}
		return 100000;
	}
}

