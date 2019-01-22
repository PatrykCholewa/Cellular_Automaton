package pl.edu.pw.iem.engine;

import pl.edu.pw.iem.engine.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Patryk on 30.04.2017.
 */
class StatementTest {

    private Statement statement;

    @BeforeEach
    void setUp() {

        this.statement = new Statement( "1/12/1/3" , 4 );

    }

    @Test
    void getWhatNeighbourStateIsDemanded() {

        assertEquals( 1 , statement.getWhatNeighbourStateIsDemanded() );

    }

    @Test
    void getChangeToWhichStateIfStatementIsTrue() {

        assertEquals( 1 , statement.getChangeToWhichStateIfStatementIsTrue() );

    }

    @Test
    void getChangeToWhichStateIfStatementIsFalse() {

        assertEquals( 3 , statement.getChangeToWhichStateIfStatementIsFalse() );

    }

    @Test
    void getNeighbourSums() {

        assertEquals( "12" , statement.getNeighbourSums() );

    }

    @Test
    void getStatement() {

        assertEquals( "1/12/1/3" , statement.getStatement() );

    }

    @Test
    void checkIsThatSumOfNeighboursNeeded() {

        assertEquals( true , statement.checkIsThatSumOfNeighboursNeeded( 2 ));
        assertEquals( false , statement.checkIsThatSumOfNeighboursNeeded( 3 ));

    }

}