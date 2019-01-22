package pl.edu.pw.iem.boundary;

import org.junit.jupiter.api.Test;
import pl.edu.pw.iem.boundary.Void;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patryk on 30.04.2017.
 */
class VoidTest {

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

        Void vclass = new Void();

        int [][]result = new int[4][5];

        for( int i = 0 ; i < 4 ; i++ ){
            for( int j = 0 ; j < 5 ; j++ ){
                result[i][j] = vclass.checkStateByIndex( board , i-1 , j-1 );
            }
        }

        assertArrayEquals( expect , result );
    }



}