package pl.edu.pw.iem.engine;

/**
 * Created by Patryk on 30.04.2017.
 */
public class Statement {

    private int whatNeighbourStateIsDemanded;
    private boolean []howManyNeighboursNeeded;
    //bool is true if index is number of needed neighbours for true of statement
    private int changeToWhichStateIfStatementIsTrue;
    private int changeToWhichStateIfStatementIsFalse;



    public Statement( String statement , int numberOfStates ){

        this.howManyNeighboursNeeded = new boolean[10];

        StatementSetter ss = new StatementSetter( this , numberOfStates );
        ss.startSetting( statement );

    }


    public int getWhatNeighbourStateIsDemanded() {
        return whatNeighbourStateIsDemanded;
    }

    public int getChangeToWhichStateIfStatementIsTrue() {
        return changeToWhichStateIfStatementIsTrue;
    }

    public int getChangeToWhichStateIfStatementIsFalse() {
        return changeToWhichStateIfStatementIsFalse;
    }

    public String getNeighbourSums(){

        String sums = "";

        for( int j = 0 ; j < 10 ; j++ ){
            if( howManyNeighboursNeeded[j] == true ){
                sums = sums + Integer.toString(j);
            }
        }

        return sums;
    }

    public String getStatement(){

        String rule = "";

        rule = rule + Integer.toString(whatNeighbourStateIsDemanded);
        rule = rule + "/";
        rule = rule + getNeighbourSums();
        rule = rule + "/";
        rule = rule + Integer.toString(changeToWhichStateIfStatementIsTrue);
        rule = rule + "/";
        rule = rule + Integer.toString(changeToWhichStateIfStatementIsFalse);

        return rule;

    }

    public boolean checkIsThatSumOfNeighboursNeeded( int neighbourSum ) {
        return howManyNeighboursNeeded[neighbourSum];
    }

    public void setWhatNeighbourStateIsDemanded(int whatNeighbourStateIsDemanded) {
        this.whatNeighbourStateIsDemanded = whatNeighbourStateIsDemanded;
    }

    public void setChangeToWhichStateIfStatementIsTrue(int changeToWhichStateIfStatementIsTrue) {
        this.changeToWhichStateIfStatementIsTrue = changeToWhichStateIfStatementIsTrue;
    }

    public void setChangeToWhichStateIfStatementIsFalse(int changeToWhichStateIfStatementIsFalse) {
        this.changeToWhichStateIfStatementIsFalse = changeToWhichStateIfStatementIsFalse;
    }

    public void setHowManyNeighboursNeededValue( int index , boolean value ) throws IndexOutOfBoundsException{
        this.howManyNeighboursNeeded[index] = value;
    }
}
