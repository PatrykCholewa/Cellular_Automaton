/**
 * Created by Patryk on 29.04.2017.
 */
public class Rules {

    //index is number of observer state
    private int []whatNeighbourStateIsDemanded;
    private boolean [][]howManyNeighboursNeeded;
        //second index are needed neighbours
        //bool is true if index is number of needed neighbours for true of statement
    private int []changeToWhichStateIfStatementIsTrue;
    private int []changeToWhichStateIfStatementIsFalse;

    private void giveStatement( String statement ){

        

    }

    public Rules( String []rules , String neighbourhood , String boundary ){

        whatNeighbourStateIsDemanded = new int[rules.length];
        howManyNeighboursNeeded = new boolean[rules.length][10];
        changeToWhichStateIfStatementIsTrue = new int[rules.length];
        changeToWhichStateIfStatementIsFalse = new int[rules.length];

        for( int i = 0 ; i < rules.length ; i++ ){

            this.giveStatement( rules[i] );

        }

    }

}
