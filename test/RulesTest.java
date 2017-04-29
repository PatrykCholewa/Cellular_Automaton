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
    void getNeighbourSumsTest() {

        assertEquals( "12" , rules.getNeighbourSums( 3 ) );

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

}