public class Craps
{
    DiceRoll r;
    
    public Craps()
    {
        r = new DiceRoll ( );
    }

    // Returns 0 if lose, otherwise the amount won.
    public int play ( ) {
        r.roll();
        int r1 = r.total();
        if(r1==2||r1==3||r1==12)
            return -1;
        if(r1==7||r1==11)
            return r1;
        int ro = 0;
        while(true){
            r.roll();
            ro = r.total();
            if(ro==7)
                return -1;
            if(ro==r1)
                return ro;
        }
    }
    
    //simulate play to see your odds of winning
    public void tester(int howMany){
        int chud =0;
    	for(int i=0; i<howMany;i++){
            if (play()==-1)
                chud++;
        }
        System.out.println("Win chance: " + ((howMany-chud)*1.0)/howMany);
    }

    public static void main(String[] args) {
        Craps c = new Craps();
        c.tester(100000);
    }
}
