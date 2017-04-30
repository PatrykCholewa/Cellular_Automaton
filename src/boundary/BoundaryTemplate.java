package boundary;

/**
 * Created by Patryk on 30.04.2017.
 */
public interface BoundaryTemplate {

    int checkStateByIndex( int [][]board , int rowIndex , int columnIndex );
    String returnName();

}
