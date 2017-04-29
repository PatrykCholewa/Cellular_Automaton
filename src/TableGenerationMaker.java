import java.util.IllegalFormatException;

/**
 * Created by Patryk on 27.04.2017.
 */

public class TableGenerationMaker {

    private int [][]oldTable;
    private int [][]newTable;
    private Rules rules;

    private TableGenerationMaker( Table table ){

        oldTable = table.getBoard();
        newTable = new int[table.getNumberOfRows()][table.getNumberOfColumns()];
        rules = new Rules( table.getRules() , table.getNeighbourhood() , table.getBoundary() );

    }

    public int getCellNewState( int i , int j ){

        throw new UnsupportedOperationException( "Not supported yet." );

    }

    public static int [][]makeNextGenerationBoard( Table table ){

        TableGenerationMaker tgm = new TableGenerationMaker( table );

        for(int i = 0; i < table.getNumberOfRows() ; i++ ){
            for(int j = 0; j < table.getNumberOfColumns() ; j ++ ){

                tgm.getCellNewState( i , j );

            }
        }

        throw new UnsupportedOperationException( "Not supported yet.");

    }

}
