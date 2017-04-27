/**
 * Created by Patryk Cholewa on 25.04.2017.
 */

public class Table {

    private int rowNumber; //row
    private int columnNumber; //column
    private int [][]board;

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
    public void setBoundary( String boundaryTypeName ){

        throw new UnsupportedOperationException( "Not supported yet!");

    }

    public void setNeighbourhood( String neighbourhoodTypeName ){

        throw new UnsupportedOperationException( "Not supported yet!");

    }


}
