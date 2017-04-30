package boundary;

/**
 * Created by Patryk on 30.04.2017.
 */
public class Void implements BoundaryTemplate{

    public int checkStateByIndex( int [][]board , int rowIndex , int columnIndex ){

        if( rowIndex < board.length && rowIndex >= 0 ){
            if( columnIndex < board[rowIndex].length && columnIndex >= 0 ){
                return board[rowIndex][columnIndex];
            }
        }

        return 0;

    }

    public String returnName(){

        return "Void";

    }

    public Void(){

    }

}
