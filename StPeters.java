import java.util.Random;

public class StPeters
{
    private Random r = new Random();
    private double entryFee;
    private int pot = 1;
   
    public StPeters(double fee){
        this.entryFee = fee;    
    }
    
    public void optimizeEntryFee(){
        for(double i=1; i<5; i=i+0.1){
            this.entryFee = i;
            tester(1000);
        }
    }
    
    public void tester(int howMany){
        int counter = 0;
        int countBreakEvenOrWin=0;
        while(counter < howMany)
        {
           pot = 1;
           if(runGame() >= this.entryFee)
                countBreakEvenOrWin++;
           counter++;
        }
        System.out.println("Entry Fee: " + this.entryFee + " : " + countBreakEvenOrWin + " broke even or won out of " + howMany + " tries. Chance of winning: " + countBreakEvenOrWin * 1.0 / howMany); 
    }
    
    //returns the amount of money you win in the game
    private int runGame(){
        pot = 1;
        boolean b = true;
           while(b){
            if(this.flip() == 1){
                pot=pot*2;
            }
            else b=false;
           }
           return pot;
    }
    
    //code to return a 0 or 1 simulating a flip
    private int flip(){
        int c =0;
        c=r.nextInt(2);
        return c;
    }    
    public static void main(String[] args) {
        StPeters gam = new StPeters(2.1);
        gam.optimizeEntryFee();

    }
}
