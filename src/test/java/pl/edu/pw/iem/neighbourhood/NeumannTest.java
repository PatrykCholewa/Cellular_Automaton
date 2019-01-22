package pl.edu.pw.iem.neighbourhood;

import org.junit.jupiter.api.Test;
import pl.edu.pw.iem.neighbourhood.Neumann;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 06.05.2017.
 */
class NeumannTest {

    @Test
    void tellWhoIsNeighbourTest() {

        int [][]expect = {
                { - 1 , 0 },
                { 0 , - 1 },
                { 0 , 1 },
                { 1 , 0 },
        };

        Neumann neumann = new Neumann();

        assertArrayEquals( expect , neumann.tellWhoIsNeighbour( 0 , 0 ));

    }

    @Test
    void returnNameTest() {

        Neumann neumann = new Neumann();

        assertEquals( "Neumann" , neumann.returnName() );

    }

}