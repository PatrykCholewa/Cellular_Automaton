import java.util.MissingFormatArgumentException;

/**
 * Created by Patryk Cholewa on 29.04.2017.
 */

public class Rules {

    private Statement []statements;

    public Rules(String []rules){

        this.statements = new Statement[rules.length];

        for( int i = 0 ; i < rules.length ; i++ ){

            try {
                this.statements[i] = new Statement( rules[i] , rules.length );
            }catch( IllegalArgumentException e ) {
                throw new IllegalArgumentException( e.getMessage() + " Problem occurred in statement with index " + Integer.toString(i));
            }

        }

    }

    public String []getRules(){

        String []rules = new String[statements.length];

        for( int i = 0 ; i < statements.length ; i ++ ){

           rules[i] = statements[i].getStatement();

        }

        return rules;

    }

}
