
public class Snail {
	
	private int position;
	private QueueADT<Integer> movePattern;
	
	public Snail (int[] pattern) {
		this.position = 0;
		movePattern = new LinkedQueue<Integer>();

		for (int i = 0; i < pattern.length; i++){
			movePattern.enqueue(pattern[i]);
		}
	}
	
	public void move () {
		int t = movePattern.dequeue();
		movePattern.enqueue(t);

		if (position <= SnailRace.raceLength){
			position += t;
		}
	}
	
	public int getPosition () {
		return this.position;
	}
	
	public void display () {
		int dashesBefore = position;
		int dashesAfter = SnailRace.raceLength - position;
		
		for (int i = 0; i < dashesBefore; i++){
			System.out.print("-");
		}
		System.out.print("@");
		for (int i = 0; i < dashesAfter; i++){
			System.out.print("-");
		}
		System.out.println();

	}

}
