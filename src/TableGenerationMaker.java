/**
 * Created by Patryk on 27.04.2017.
 */
public class TableGenerationMaker {

    Table oldTable;
    Table newTable;

    private TableGenerationMaker( Table table ){

        this.oldTable = table;
        this.newTable = new Table( table.getRowNumber() , table.getColumnNumber() );

    }

    public static int [][]makeNextGeneration( Table table ){

        TableGenerationMaker tgm = new TableGenerationMaker( table );

        throw new UnsupportedOperationException( "Not Finished yet!");

    }

}
