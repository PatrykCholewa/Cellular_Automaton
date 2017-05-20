package boundary;

/**
 * Created by Patryk Cholewa on 21.05.2017.
 */

public class Planet implements BoundaryTemplate {

    @Override
    public int checkStateByIndex( int [][]board , int rowIndex , int columnIndex ){

        if( rowIndex < board.length ){
            rowIndex = rowIndex + board.length;
        }
        if( rowIndex >= board.length ){
            rowIndex = rowIndex - board.length;
        }
        if( columnIndex < board[0].length ){
            columnIndex = columnIndex + board[0].length;
        }
        if( columnIndex >= board[0].length ){
            columnIndex = columnIndex - board[0].length;
        }

        return board[rowIndex][columnIndex];

    }

    @Override
    public String returnName(){

        return "Planet";

    }

    public Planet(){

    }

}
