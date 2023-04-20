public class Player extends Ludu{
	private String color;
	private int superPos, relPos;
	private int[][] pieces;
	
	public Player(String color){
		this.color = color;
		setPos(color);
		pieces = new int[2][4];
	}
	public Player(String color, int numPieces){
		this.color = color;
		setSuperPos(color);
		setRelPos(color);
		pieces = new int[2][numPieces];
	}
	
	setPos(String color){
		if(color.toLowerCase().equals("red")) { superPos = ; relPos = ; }
		if(color.toLowerCase().equals("blue")) { superPos = ; relPos = ; } 
		if(color.toLowerCase().equals("green")) { superPos = ; relPos = ; }
		if(color.toLowerCase().equals("yellow")) { superPos = ; relPos = ; }
	}

	public void roll(){
		int[] rolls = new int[numDice];
		int strikes = 0;
		for(int i=0;i<numDice;i++){
			int roll = (int) (Math.random() * (diceMax-diceMin)) + diceMin;
			rolls[i] = roll;
			if(roll==specialNum) strikes++;
			if(strikes==numStrikes) System.out.println("You rolled " + numStrikes + " " + specialNum + "\'s! How unlucky");
		}
	}

	
}
