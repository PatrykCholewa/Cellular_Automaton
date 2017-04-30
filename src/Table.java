import java.util.IllegalFormatException;

/**
 * Created by Patryk Cholewa on 25.04.2017.
 */

public class Table {

    private int numberOfRows;
    private int numberOfColumns;
    private int [][]board;
    private TableGenerationMaker tgm = new TableGenerationMaker();
    //
    private String boundary;
    private String neighbourhood;
    //

    public Table( int numberOfRows , int numberOfColumns , int [][]board ){

        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.board = new int[numberOfRows][numberOfColumns];
        this.setBoard( board );

    }

    public void setBoard( int [][]board ) throws AssertionError {

        assert board.length == numberOfRows;

        for(int i = 0; i < numberOfRows; i++ ){

            assert board[i].length == numberOfColumns;

            for(int j = 0; j < numberOfColumns; j++ ){
                this.board[i][j] = board[i][j];
            }
        }

    }

    public int getNumberOfRows(){

        return numberOfRows;

    }

    public int getNumberOfColumns(){

        return numberOfColumns;

    }

    public int getCellValue( int numberOfRows , int numberOfColumns ) throws IndexOutOfBoundsException {

        return board[numberOfRows][numberOfColumns];

    }

    public int[][] getBoard(){

        return board;

    }
    public void makeNextGeneration(){

        board = TableGenerationMaker.makeNextGenerationBoard( this );

    }
    public void setBoundary( String boundaryName ){

        this.boundary = boundaryName;

    }

    public String getBoundary(){

        return boundary;

    }

    public void setNeighbourhood( String neighbourhoodName ){

        this.neighbourhood = neighbourhoodName;

    }

    public String getNeighbourhood(){

        return neighbourhood;

    }

    public void setRules( String []rules ){

        tgm.setRules( rules );

    }

    public String []getRules(){

        return tgm.getRules();

    }

}
