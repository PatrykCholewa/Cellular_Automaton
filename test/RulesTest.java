import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 29.04.2017.
 */
class RulesTest {

    Rules rules;

    @BeforeEach
    void setUp() {

        String []rules = {
                "0/9/1/0",
                "1/9/1/2",
                "2/9/1/3",
                "1/12/1/3",
        };

        this.rules = new Rules( rules );

    }

    @Test
    void getRulesTest() {

        String []expect = {
                "0/9/1/0",
                "1/9/1/2",
                "2/9/1/3",
                "1/12/1/3",
        };

        assertArrayEquals( expect , rules.getRules() );

    }

    @Test
    void getnumberOfStatesTest() {

        assertEquals( 4 , rules.getnumberOfStates() );

    }

    @Test
    void getDemandedNeighbourStateTest() {

       assertEquals( 2 , rules.getDemandedNeighbourState( 2 ));

    }

    @Test
    void checkIsThatSumOfNeighboursNeededTest() {

        assertTrue( rules.checkIsThatSumOfNeighboursNeeded( 2 ,9));
        assertFalse( rules.checkIsThatSumOfNeighboursNeeded( 3 , 4));

    }

    @Test
    void getStateOfTrueStatementTest() {

        assertEquals( 1 , rules.getStateOfTrueStatement( 1));

    }

    @Test
    void getStateOfFalseStatementTest() {

        assertEquals( 3 ,rules.getStateOfFalseStatement(3));

    }

}