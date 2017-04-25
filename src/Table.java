/**
 * Created by Patryk Cholewa on 25.04.2017.
 */

public class Table {

    private int rowNumber; //row
    private int columnNumber; //column
    private int [][]board;

    public Table( int rowNumber , int columnNumber ){

        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.board = new int[rowNumber][columnNumber];

    }

    private void setCellValue( int m , int n, int value ) {

        this.board[m][n] = value;

    }

    public void setBoard( int [][]board ){

        if( board.length != rowNumber ){
            throw new Error( "Board sizes do not match!" );
        }

        for( int i = 0; i < rowNumber ; i++ ){
            if( board[i].length != columnNumber ){
                throw new Error( "Board sizes do not match!" );
            }
            for( int j = 0; j < columnNumber; j++ ){
                this.setCellValue( i , j , board[i][j] );
            }
        }

    }

    public int getRowNumber(){

        return rowNumber;

    }

    public int getColumnNumber(){

        return columnNumber;

    }

    public int getCellValue( int m, int n ) throws IndexOutOfBoundsException {

        return board[m][n];

    }

    public int[][] getBoard(){

        return board;

    }
    public void makeNextGeneration(){

        throw new UnsupportedOperationException( "Not supported yet!");

    }
    public void setBoundary( String boundaryTypeName ){

        throw new UnsupportedOperationException( "Not supported yet!");

    }

    public void setNeighbourhood( String neighbourhoodTypeName ){

        throw new UnsupportedOperationException( "Not supported yet!");

    }


}
