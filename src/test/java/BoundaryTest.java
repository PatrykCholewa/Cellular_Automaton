import engine.Boundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 30.04.2017.
 */
class BoundaryTest {

    Boundary boundary;

    @BeforeEach
    void setUp() {

        boundary = new Boundary( "Void" );

    }

    @Test
    void getNameTest() {

        assertEquals( "Void" , boundary.getName() );

    }

    @Test
    void checkStateByIndexTest() {

        int [][]board = {
                {1,0,1},
                {0,0,1},
        };

        int [][]expect = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
        };

        int [][]result = new int[4][5];

        for( int i = 0 ; i < 4 ; i++ ){
            for( int j = 0 ; j < 5 ; j++ ){
                result[i][j] = boundary.checkStateByIndex( board , i-1 , j-1 );
            }
        }

        assertArrayEquals( expect , result );
    }

}