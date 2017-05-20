import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 30.04.2017.
 */
class TableGenerationMakerTest {

    TableGenerationMaker tgm;

    @BeforeEach
    void setUp() {

        String []rules = {
                "0/9/1/0",
                "1/9/1/2",
                "2/9/1/3",
                "1/12/1/3",
        };

        tgm = new TableGenerationMaker();
        tgm.setRules( rules );
        tgm.setNeighbourhood( "Moore" );
        tgm.setBoundary( "Void" );


    }

    @Test
    void getRulesTest() {

        String []rules = {
                "0/9/1/0",
                "1/9/1/2",
                "2/9/1/3",
                "1/12/1/3",
        };

        assertArrayEquals( rules , tgm.getRules() );

    }

    @Test
    void getNeighbourhoodTest() {

        assertEquals( "Moore" , tgm.getNeighbourhood() );

    }

    @Test
    void getBoundaryTest() {

        assertEquals( "Void" , tgm.getBoundary() );

    }

    @Test
    void makeNextGenerationBoard() {

        int [][]oldBoard = {
                {0,0,0,0},
                {0,0,0,0},
                {3,2,1,3},
                {0,0,0,0}
        };

        int [][]newBoard = {
                {0,0,0,0},
                {0,0,0,0},
                {3,3,2,1},
                {0,0,0,0}
        };

        assertArrayEquals( newBoard , tgm.makeNextGenerationBoard( oldBoard ));

    }

}