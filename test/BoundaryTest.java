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

    }

}