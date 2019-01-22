package pl.edu.pw.iem.stories.star_appears;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import pl.edu.pw.iem.engine.Table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StarAppearsSteps {

    private Table table;

    private int[][] tableBoardToIntBoard(ExamplesTable board){
        int[][] intBoard = new int[board.getRowCount()][board.getRowCount()];

        for( int i = 0 ; i < board.getRowCount() ; i++ ){
            for( int j = 0 ; j < board.getRowCount() ; j ++ ){
                intBoard[i][j] = Integer.parseInt(board.getRow(i).get(String.valueOf(j)));
            }
        }
        return intBoard;
    }

    @Given("a table of $boundary boundary and $neighbourhood neighbourhood and a board of $rows x $columns")
    public void initTable(String boundary, String neighbourhood, int rows, int columns){
        table = new Table(rows, columns);
        table.setBoundary(boundary);
        table.setNeighbourhood(neighbourhood);
    }

    @Given("rules: $rules")
    public void setRules(ExamplesTable rules){
        this.table.setRules( rules.getRows().stream().map( row -> row.get("rule") ).toArray(String[]::new) ) ;
    }

    @Given("a board: $board")
    public void setBoard(ExamplesTable board){
        table.setBoard(tableBoardToIntBoard(board));
    }

    @When("a next generation is simulated")
    public void step1(){
        table.makeNextGeneration();
    }

    @Then("a board should be: $board")
    public void boardAfterStep1ShouldBe(ExamplesTable board){
        assertThat(table.getBoard(), equalTo(tableBoardToIntBoard(board)));
    }

}
