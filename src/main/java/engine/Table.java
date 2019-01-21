package engine;

/**
 * Created by Patryk Cholewa on 25.04.2017.
 */

public class Table {

    private int numberOfRows;
    private int numberOfColumns;
    private int [][]board;
    private TableGenerationMaker tgm = new TableGenerationMaker();

    public Table( int numberOfRows , int numberOfColumns ){

        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.board = new int[numberOfRows][numberOfColumns];

    }

    public void setCellValue( int rowNumber , int columnNumber , int value )
            throws IndexOutOfBoundsException, NullPointerException{

        try {
            board[rowNumber][columnNumber] = value;
        } catch ( IndexOutOfBoundsException e ){
            throw new IndexOutOfBoundsException( e.getMessage() );
        } catch ( NullPointerException e ){
            throw  new IndexOutOfBoundsException( e.getMessage() );
        }

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

        board = tgm.makeNextGenerationBoard( board );

    }

    public void setBoundary( String boundaryName ){

        tgm.setBoundary( boundaryName );

    }

    public String getBoundary(){

        return tgm.getBoundary();

    }

    public void setNeighbourhood( String neighbourhoodName ){

        tgm.setNeighbourhood( neighbourhoodName );

    }

    public String getNeighbourhood(){

        return tgm.getNeighbourhood();

    }

    public void setRules( String []rules ){

        tgm.setRules( rules );

    }

    public String []getRules(){

        return tgm.getRules();

    }

}
