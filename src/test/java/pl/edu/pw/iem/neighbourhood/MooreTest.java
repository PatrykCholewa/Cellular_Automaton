package pl.edu.pw.iem.neighbourhood;

import org.junit.jupiter.api.Test;
import pl.edu.pw.iem.neighbourhood.Moore;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 30.04.2017.
 */
class MooreTest {

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

        Moore moore = new Moore();

        assertArrayEquals( expect , moore.tellWhoIsNeighbour( 0 , 0 ));

    }

    @Test
    void returnNameTest() {

        Moore moore = new Moore();

        assertEquals( "Moore" , moore.returnName() );

    }

}