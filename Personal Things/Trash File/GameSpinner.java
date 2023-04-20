public class GameSpinner{
    private int sectors;
    private int prevValue;
    private int streak;
    public GameSpinner(int numSects){
         sectors = numSects;
         prevValue = 0;
         streak = 0;
    }     
    
    public int currentRun(){
         return streak;
    }     
    /* First it initializes the value of the "spin" between 1 and sectors.
         It then determines whether that current number is the same as the previous spin, 
              If it the current spin value is the same as the previous spin, increment streak; else reset streak to 1.
         Regardless of output, reset "prevValue" to the current spin value. Finally, return the curValue of this spin

         @param none
         @return int curValue
    */
    public int spin(){
         int curValue = (int)(Math.random()*(sectors-1)+1);
         streak = curValue == prevValue ? streak+1 : 1;
         prevValue = curValue;
         return curValue;
    }

    public int getValue(){
        return prevValue;
    }
}