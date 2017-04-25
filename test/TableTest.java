import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 25.04.2017.
 */
class TableTest{

    Table table = new Table(4, 5);

    @BeforeEach
    void setUp() {

        int [][]board = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,1,1,1,0},
        };

        table.setBoard( board );

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void setBoardTestError() {

        int [][]board = {{1},{1},{1},{1},{1},{1}};
        boolean b = false;

        try{
            table.setBoard( board );
        } catch( Error e){
            b = true;
        }

        if( b == false ){
            fail( "Error expected! ");
        }

    }

    @Test
    void getRowNumberTest() {

        assertEquals( 4 , table.getRowNumber() );

    }

    @Test
    void getColumnNumberTest() {

        assertEquals( 5 , table.getColumnNumber() );

    }

    @Test
    void getCellValueTest() {

        assertEquals( 1 , table.getCellValue( 2 , 3));

    }

    @Test
    void getBoardTest() {

        int [][]expect = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,1,1,1,0},
        };

        int [][]result = table.getBoard();

        for( int i = 0 ; i < expect.length ; i++ ){

            for( int j = 0 ; j < expect[i].length ; j++ ){

                assertEquals( expect[i][j] , result[i][j] );

            }

        }

    }

}