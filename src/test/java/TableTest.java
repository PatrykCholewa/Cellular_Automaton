import engine.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Patryk on 25.04.2017.
 */
class TableTest{

    private Table table;

    @BeforeEach
    void setUp() {

        int [][]board = {
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
        };

        String []rules = {
                "1/3/1/0",
                "1/23/1/0",
        };

        table = new Table( 4 ,5 );
        table.setBoundary( "Void" );
        table.setNeighbourhood( "Moore" );
        table.setRules( rules );
        table.setBoard( board );

    }

    @Test
    void setBoardTestError() {

        int [][]board = {{1},{1},{1},{1},{1},{1}};

        assertThrows( AssertionError.class, () -> {
            table.setBoard( board );
        });

    }

    @Test
    void getNumberOfRowsTest() {

        assertEquals( 4 , table.getNumberOfRows() );

    }

    @Test
    void getNumberOfColumnsTest() {

        assertEquals( 5 , table.getNumberOfColumns() );

    }

    @Test
    void getCellValueTest() {

        table.setCellValue( 2 , 3 , 2);
        assertEquals( 2 , table.getCellValue( 2 , 3));

    }

    @Test
    void getCellValueTestIndexOutBounds() {

        assertThrows( IndexOutOfBoundsException.class, () -> {
            table.getCellValue( 4 , 4 );
        });

    }

    @Test
    void getBoardTest() {

        int[][] expect = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
        };

        int[][] result = table.getBoard();

        assertArrayEquals( expect , result );

    }

    @Test
    public void getBoundaryTest(){

        assertEquals( "Void" , table.getBoundary() );

    }

    @Test
    public void getNeighbourhoodTest(){

        assertEquals( "Moore" , table.getNeighbourhood() );

    }

    @Test
    public void makeNextGenerationTest() {

        int[][] expect = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 0, 0},
        };

        table.makeNextGeneration();

        assertArrayEquals( expect , table.getBoard() );

    }

    @Test
    void getRulesTest() {

        String []rules = {
                "1/3/1/0",
                "1/23/1/0",
        };

        assertArrayEquals( rules , table.getRules() );

    }

}