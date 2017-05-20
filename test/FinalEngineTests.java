import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 20.05.2017.
 */
public class FinalEngineTests {

    Table table;

    @Test
    void starGOLTest(){

        int [][]board = {
                { 0 , 0 , 0 , 0 , 0 },
                { 0 , 0 , 1 , 0 , 0 },
                { 0 , 0 , 1 , 0 , 0 },
                { 0 , 0 , 1 , 0 , 0 },
                { 0 , 0 , 0 , 0 , 0 },
        };

        String []rules = {
                "1/3/1/0",
                "1/23/1/0",
        };

        table = new Table( 5 , 5 );
        table.setBoundary( "Void" );
        table.setNeighbourhood( "Moore" );
        table.setBoard( board );
        table.setRules( rules );

        table.makeNextGeneration();

        int [][]result1 = {
                { 0 , 0 , 0 , 0 , 0 },
                { 0 , 0 , 0 , 0 , 0 },
                { 0 , 1 , 1 , 1 , 0 },
                { 0 , 0 , 0 , 0 , 0 },
                { 0 , 0 , 0 , 0 , 0 },
        };

        assertArrayEquals( result1 , table.getBoard() , "iter1");

        table.makeNextGeneration();

        int [][]result2 = {
                { 0 , 0 , 0 , 0 , 0 },
                { 0 , 0 , 1 , 0 , 0 },
                { 0 , 0 , 1 , 0 , 0 },
                { 0 , 0 , 1 , 0 , 0 },
                { 0 , 0 , 0 , 0 , 0 },
        };

        assertArrayEquals( result2 , table.getBoard() , "iter2" );

    }

}
