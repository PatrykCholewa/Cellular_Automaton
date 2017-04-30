import java.util.IllegalFormatException;

/**
 * Created by Patryk on 27.04.2017.
 */

public class TableGenerationMaker {

    private int [][]newBoard;
    private Rules rules;
    private Neighbourhood neighbourhood;
    private Boundary boundary;

    public TableGenerationMaker(){

        this.newBoard = null;
        this.rules = null;
        this.neighbourhood = null;
        this.boundary = null;

    }

    public int getCellNewState( int i , int j ){

        throw new UnsupportedOperationException( "Not supported yet." );

    }

    public static int [][]makeNextGenerationBoard( Table table ){

        TableGenerationMaker tgm = new TableGenerationMaker();

        for(int i = 0; i < table.getNumberOfRows() ; i++ ){
            for(int j = 0; j < table.getNumberOfColumns() ; j ++ ){

                tgm.getCellNewState( i , j );

            }
        }

        throw new UnsupportedOperationException( "Not supported yet.");

    }

    public String []getRules() {
        return rules.getRules();
    }

    public void setRules( String []rules ) {
        this.rules = new Rules( rules );
    }

    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(Neighbourhood neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Boundary getBoundary() {
        return boundary;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
