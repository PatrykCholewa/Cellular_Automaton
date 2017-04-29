import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.MissingFormatArgumentException;

/**
 * Created by Patryk Cholewa on 29.04.2017.
 */

public class Rules {

    private int numberOfStates;

    //index is number of observer state
    private int []whatNeighbourStateIsDemanded;
    private boolean [][]howManyNeighboursNeeded;
        //second index are needed neighbours
        //bool is true if index is number of needed neighbours for true of statement
    private int []changeToWhichStateIfStatementIsTrue;
    private int []changeToWhichStateIfStatementIsFalse;

    private void giveDemand( int index , String demand ) throws NumberFormatException {

        if( Integer.parseInt(demand) < numberOfStates ) {
            whatNeighbourStateIsDemanded[index] = Integer.parseInt(demand);
        } else {
            throw new IllegalArgumentException( "Argument state over number of statements." );
        }
    }

    private void giveListOfExpectedNumberOfNeighbours( int index , String neighboursSums ){

        for( int i = 0 ; i < 10 ; i++ ){
            howManyNeighboursNeeded[index][i] = false;
        }

        for( int i = 0 ; i < neighboursSums.length() ; i++ ){
            for( int j = 0 ; j < 10; j++ ){
                try{
                    howManyNeighboursNeeded[index][Character.getNumericValue(neighboursSums.charAt(i))] = true;
                } catch ( IndexOutOfBoundsException e ){
                    throw new IllegalArgumentException( "Illegal symbol in statement.");
                }
            }
        }

    }

    private void giveTrueResult( int index , String result ) throws NumberFormatException {

        if( Integer.parseInt(result) < numberOfStates ) {
            changeToWhichStateIfStatementIsTrue[index] = Integer.parseInt( result );
        } else {
            throw new IllegalArgumentException( "Argument state over number of statements." );
        }

    }

    private void giveFalseResult( int index , String result ) throws NumberFormatException {

        if( Integer.parseInt(result) < numberOfStates ) {
            changeToWhichStateIfStatementIsFalse[index] = Integer.parseInt( result );
        } else {
            throw new IllegalArgumentException( "Argument state over number of statements." );
        }

    }

    private void giveStatementPart( int indexOfStatement ,String fragment , int numberOfPart )
            throws  IllegalArgumentException,
                    NumberFormatException{

        if( numberOfPart == 1 ){
            this.giveDemand( indexOfStatement , fragment );
        }
        if( numberOfPart == 2 ) {
            this.giveListOfExpectedNumberOfNeighbours(indexOfStatement, fragment );
        }
        if( numberOfPart == 3 ) {
            this.giveTrueResult(indexOfStatement, fragment );
        }
        if( numberOfPart == 4 ) {
            this.giveFalseResult(indexOfStatement, fragment );
        }

    }

    private void giveStatement( String statement , int indexOfStatement ){

        int leftIndex;
        int rightIndex = -1;

        try{

            for( int i = 1 ; i < 4 ; i++ ) {

                leftIndex = rightIndex + 1;
                rightIndex = statement.indexOf('/', leftIndex);

                if (rightIndex != -1) {
                    this.giveStatementPart(indexOfStatement, statement.substring(leftIndex, rightIndex ), i);
                } else {
                    throw new MissingFormatArgumentException("There's no first '/' in rule statement.");
                }

            }

            this.giveStatementPart(indexOfStatement, statement.substring( rightIndex + 1), 4);

        } catch ( MissingFormatArgumentException e ){
            throw new MissingFormatArgumentException( e.getMessage() );
        } catch ( NumberFormatException e ){
            throw  new MissingFormatArgumentException( e.getMessage() );
        } catch ( IllegalArgumentException e ){
            throw new IllegalArgumentException( e.getMessage() );
        }

    }

    public Rules(String []rules){

        numberOfStates = rules.length;
        whatNeighbourStateIsDemanded = new int[rules.length];
        howManyNeighboursNeeded = new boolean[rules.length][10];
        changeToWhichStateIfStatementIsTrue = new int[rules.length];
        changeToWhichStateIfStatementIsFalse = new int[rules.length];

        for( int i = 0 ; i < rules.length ; i++ ){

            try {
                this.giveStatement(rules[i] , i );
            }catch( IllegalArgumentException e ) {
                throw new IllegalArgumentException( e.getMessage() + " Problem occurred in statement with index " + Integer.toString(i));
            }

        }

    }

    public String getNeighbourSums( int index ){

        String sums = "";

        for( int j = 0 ; j < 10 ; j++ ){
            if( howManyNeighboursNeeded[index][j] == true ){
                sums = sums + Integer.toString(j);
            }
        }

        return sums;
    }

    public String []getRules(){

        String []rules = new String[numberOfStates];

        for( int i = 0 ; i < numberOfStates ; i ++ ){

            String rule = "";

            rule = rule + Integer.toString(whatNeighbourStateIsDemanded[i]);
            rule = rule + "/";
            rule = rule + getNeighbourSums( i );
            rule = rule + "/";
            rule = rule + Integer.toString(changeToWhichStateIfStatementIsTrue[i]);
            rule = rule + "/";
            rule = rule + Integer.toString(changeToWhichStateIfStatementIsFalse[i]);

            rules[i] = rule;

        }

        return rules;

    }

}
