/**
 * Created by Patryk on 27.04.2017.
 */
public class TableGenerationMaker {

    private int [][]oldTable;
    private int [][]newTable;

    private TableGenerationMaker( Table table ){

        this.oldTable = table.getBoard();
        this.newTable = new int[table.getRowNumber()][table.getColumnNumber()];

    }

    public int getCellNewState( int i , int j ){

        throw new UnsupportedOperationException( "Not supported yet." );

    }

    public static int [][]makeNextGenerationBoard( Table table ){

        TableGenerationMaker tgm = new TableGenerationMaker( table );

        for( int i = 0; i < table.getRowNumber() ; i++ ){
            for( int j = 0; j < table.getColumnNumber() ; j ++ ){

                tgm.getCellNewState( i , j );

            }
        }

        throw new UnsupportedOperationException( "Not supported yet.");

    }

}
