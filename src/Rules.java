import java.util.IllegalFormatException;
import java.util.MissingFormatArgumentException;

/**
 * Created by Patryk Cholewa on 29.04.2017.
 */

public class Rules {

    //index is number of observer state
    private int []whatNeighbourStateIsDemanded;
    private boolean [][]howManyNeighboursNeeded;
        //second index are needed neighbours
        //bool is true if index is number of needed neighbours for true of statement
    private int []changeToWhichStateIfStatementIsTrue;
    private int []changeToWhichStateIfStatementIsFalse;

    private void giveDemand(){

    }

    private void giveListOfExpectedNumberOfNeighbours(){



    }

    private void giveTrueResult(){


    }

    private void giveFalseResult(){



    }

    private void giveStatement(String statement ){

        int index = 0;

        try{

            index = statement.indexOf( '/' , index );

            if( index != -1 ) {
                this.giveDemand();
            }else{
                throw new MissingFormatArgumentException( "There's no first '/' in rule statement." );
            }

            index = statement.indexOf( '/' , index );

            if( index != -1 ) {
                this.giveListOfExpectedNumberOfNeighbours();
            }else{
                throw new MissingFormatArgumentException( "There's no second '/' in rule statement." );
            }

            index = statement.indexOf( '/' , index );

            if( index != -1 ) {
                this.giveTrueResult();
            }else{
                throw new MissingFormatArgumentException( "There's no third '/' in rule statement." );
            }

            index = statement.indexOf( '\0' , index );

            if( index != -1 ) {
                this.giveFalseResult();
            }else{
                throw new MissingFormatArgumentException( "There's no '\0' in rule statement. Strange!" );
            }

        } catch ( MissingFormatArgumentException e ){

        }

    }

    public Rules(String []rules , String neighbourhood , String boundary ){

        whatNeighbourStateIsDemanded = new int[rules.length];
        howManyNeighboursNeeded = new boolean[rules.length][10];
        changeToWhichStateIfStatementIsTrue = new int[rules.length];
        changeToWhichStateIfStatementIsFalse = new int[rules.length];

        for( int i = 0 ; i < rules.length ; i++ ){

            try {
                this.giveStatement(rules[i]);
            } catch( MissingFormatArgumentException e ){
                throw new MissingFormatArgumentException( e.getMessage() + " Problem occurred in statement with index " + Integer.toString(i) );
            }

        }

    }

}
