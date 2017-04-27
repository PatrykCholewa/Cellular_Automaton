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

    public static int [][]makeNextGenerationBoard( Table table ){

        TableGenerationMaker tgm = new TableGenerationMaker( table );

        throw new UnsupportedOperationException( "Not Finished yet!");

    }

}
