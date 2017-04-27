/**
 * Created by Patryk Cholewa on 25.04.2017.
 */

public class Table {

    private int rowNumber;
    private int columnNumber;
    private int [][]board;
    private String boundary;
    private String neighbourhood;

    public Table( int rowNumber , int columnNumber , int [][]board ){

        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.board = new int[rowNumber][columnNumber];
        this.setBoard( board );

    }

    public void setBoard( int [][]board ){

        assert board.length == rowNumber ;

        for( int i = 0; i < rowNumber ; i++ ){

            assert board[i].length == columnNumber;

            for( int j = 0; j < columnNumber; j++ ){
                this.board[i][j] = board[i][j];
            }
        }

    }

    public int getRowNumber(){

        return rowNumber;

    }

    public int getColumnNumber(){

        return columnNumber;

    }

    public int getCellValue( int rowNumber, int columnNumber ) throws IndexOutOfBoundsException {

        return board[rowNumber][columnNumber];

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

    public void setRules( /* ??? */ ){

        throw new UnsupportedOperationException( "Not supported yet! ");

    }

}
