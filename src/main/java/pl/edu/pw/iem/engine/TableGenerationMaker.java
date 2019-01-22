package pl.edu.pw.iem.engine;

/**
 * Created by Patryk on 27.04.2017.
 */

public class TableGenerationMaker {

    private Rules rules;
    private Neighbourhood neighbourhood;
    private Boundary boundary;

    public TableGenerationMaker(){

        this.rules = null;
        this.neighbourhood = null;
        this.boundary = null;

    }

    private int countCellNewState( int [][]board , int rowIndex , int columnIndex ){

       int [][]neighbours = neighbourhood.tellWhoIsNeighbour( rowIndex, columnIndex );
       int sum = 0;
       int thisCellState = board[rowIndex][columnIndex];
       int demand = rules.getDemandedNeighbourState( thisCellState );

       for( int i = 0 ; i < neighbours.length ; i ++ ){
           if( boundary.checkStateByIndex( board , neighbours[i][0] , neighbours[i][1] ) == demand ){
               sum++;
           }
       }

       if( rules.checkIsThatSumOfNeighboursNeeded( thisCellState , sum ) ){
           return rules.getStateOfTrueStatement( thisCellState );
       } else {
           return rules.getStateOfFalseStatement( thisCellState );
       }

    }

    public int [][]makeNextGenerationBoard( int [][]oldBoard ){

        if( rules == null ){
            throw new NullPointerException( "Rules not set." );
        } else
        if( neighbourhood == null ){
            throw new NullPointerException( "Neighbourhood not set." );
        } else
        if( boundary == null ){
            throw new NullPointerException( "Boundary not set." );
        } else {

            int [][]newBoard = new int[oldBoard.length][ oldBoard[0].length ];

            for (int i = 0; i < oldBoard.length; i++) {
                for (int j = 0; j < oldBoard[i].length; j++) {

                    newBoard[i][j] = countCellNewState(oldBoard, i, j);

                }
            }

            return newBoard;

        }
    }

    public String []getRules() {
        return rules.getRules();
    }

    public void setRules( String []rules ) {
        this.rules = new Rules( rules );
    }

    public String getNeighbourhood() {
        return neighbourhood.getName();
    }

    public void setNeighbourhood( String Name ) {
        neighbourhood = new Neighbourhood( Name );
    }

    public String getBoundary() {
        return boundary.getName();
    }

    public void setBoundary( String Name ) {
        boundary = new Boundary( Name );
    }

}
