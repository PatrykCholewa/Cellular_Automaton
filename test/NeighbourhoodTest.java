import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 30.04.2017.
 */
class NeighbourhoodTest {

    @Test
    void tellWhoIsNeighbourTest() {

        int [][]expect = {
                { - 1 , - 1 },
                { - 1 , 0 },
                { - 1 , 1},
                { 0 , - 1 },
                { 0 , 1 },
                { 1 , - 1},
                { 1 , 0 },
                { 1 , 1},
        };

        Neighbourhood neighbourhood = new Neighbourhood( "Moore" );

        assertArrayEquals( expect , neighbourhood.tellWhoIsNeighbour( 0 , 0 ));

    }

    @Test
    void returnNameTest() {

        Neighbourhood neighbourhood = new Neighbourhood( "Moore" );

        assertEquals( "Moore" , neighbourhood.getName() );

    }

}