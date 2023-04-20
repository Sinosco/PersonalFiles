public class Ludu{
	private int numDice, diceMin, diceMax, maxSuperPos, numPlayers, numPieces, specialNumber, numStrikes;
	
	public Ludu(){
		numDice = 2;
        diceMin = 1;
		diceMax = 6;
        numPlayers = 4;
        numPieces = 4;
		specialNumber = 6;
		maxSuperPos = 72;
		numStrikes = 3;
	}
	public Ludu(int numDice, int diceMin, int diceMax, int maxSuperPos, int numPlayers, int numPieces, int specialNumber, int numStrikes){
		this.numDice = numDice;
		this.diceMax = diceMax;
		this.maxSuperPos = maxSuperPos;
		this.numPlayers = numPlayers;
        this.numPieces = numPieces;
		this.specialNumber = specialNumber;
		this.numStrikes = numStrikes;
	}
    public Ludu(int[] settings){
        numDice = settings[0];
        diceMin = settings[1];
        diceMax = settings[2];
        maxSuperPos = settings[3];
        numPlayers = settings[4];
        numPieces = settings[5];
        specialNumber = settings[6];
        numStrikes = settings[7];
    }

	
}
