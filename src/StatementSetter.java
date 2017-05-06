import java.util.MissingFormatArgumentException;

/**
 * Created by Patryk on 06.05.2017.
 */
public class StatementSetter {

    Statement statement;
    int numberOfStates;

    private void giveDemand( String demand ) throws NumberFormatException {

        statement.setWhatNeighbourStateIsDemanded( Integer.parseInt( demand ) );

    }

    private void giveListOfExpectedNumberOfNeighbours( String neighboursSums ){

        for( int i = 0 ; i < 10 ; i++ ){
            statement.setHowManyNeighboursNeededValue( i , false );
        }

        for( int i = 0 ; i < neighboursSums.length() ; i++ ){
            for( int j = 0 ; j < 10; j++ ){
                try{
                    statement.setHowManyNeighboursNeededValue( Character.getNumericValue(neighboursSums.charAt(i)) , true );
                } catch ( IndexOutOfBoundsException e ){
                    throw new IllegalArgumentException( "Illegal symbol in statement.");
                }
            }
        }

    }

    private void giveTrueResult( String result ) throws NumberFormatException {

        if( Integer.parseInt(result) < numberOfStates ) {
            statement.setChangeToWhichStateIfStatementIsTrue( Integer.parseInt( result ) );
        } else {
            throw new IllegalArgumentException( "Argument state over number of statements." );
        }

    }

    private void giveFalseResult( String result ) throws NumberFormatException {

        if( Integer.parseInt(result) < numberOfStates ) {
            statement.setChangeToWhichStateIfStatementIsFalse( Integer.parseInt( result ) );
        } else {
            throw new IllegalArgumentException( "Argument state over number of statements." );
        }

    }

    private void giveStatementPart( String fragment , int numberOfPart )
            throws  IllegalArgumentException, NumberFormatException{

        if( numberOfPart == 1 ){
            this.giveDemand( fragment );
        }
        if( numberOfPart == 2 ) {
            this.giveListOfExpectedNumberOfNeighbours( fragment );
        }
        if( numberOfPart == 3 ) {
            this.giveTrueResult( fragment );
        }
        if( numberOfPart == 4 ) {
            this.giveFalseResult( fragment );
        }

    }

    public void startSetting( String statement ) {

        int leftIndex;
        int rightIndex = -1;

        try{

            for( int i = 1 ; i < 4 ; i++ ) {

                leftIndex = rightIndex + 1;
                rightIndex = statement.indexOf('/', leftIndex);

                if (rightIndex != -1) {
                    this.giveStatementPart( statement.substring(leftIndex, rightIndex ), i);
                } else {
                    throw new MissingFormatArgumentException("There's no first '/' in rule statement.");
                }

            }

            this.giveStatementPart( statement.substring( rightIndex + 1), 4);

        } catch ( MissingFormatArgumentException e ){
            throw new MissingFormatArgumentException( e.getMessage() );
        } catch ( NumberFormatException e ){
            throw  new MissingFormatArgumentException( e.getMessage() );
        } catch ( IllegalArgumentException e ){
            throw new IllegalArgumentException( e.getMessage() );
        }

    }

    StatementSetter( Statement statement , int numberOfStates ){

        this.statement = statement;
        this.numberOfStates = numberOfStates;

    }

}
