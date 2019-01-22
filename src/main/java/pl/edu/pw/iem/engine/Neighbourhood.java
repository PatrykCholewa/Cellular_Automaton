package pl.edu.pw.iem.engine;

import pl.edu.pw.iem.neighbourhood.NeighbourhoodTemplate;

/**
 * Created by Patryk on 30.04.2017.
 */
public class Neighbourhood {

    private NeighbourhoodTemplate neighbourhoodObject;

    public Neighbourhood( String name ){

        try{
            if( name.contains("Moore")) {
                Class cls = Class.forName("pl.edu.pw.iem.neighbourhood.Moore");
                neighbourhoodObject = (NeighbourhoodTemplate) cls.newInstance();
            } else if( name.contains("Neumann")) {
                Class cls = Class.forName("pl.edu.pw.iem.neighbourhood.Neumann");
                neighbourhoodObject = (NeighbourhoodTemplate) cls.newInstance();
            } else {
                throw new IllegalArgumentException( "Not supported neighbourhood!" );
            }
        } catch( ClassNotFoundException e ){
            throw new AssertionError( "There's no Moore class in package!");
        } catch ( InstantiationException | IllegalAccessException e ) {
            throw new InternalError( "Problem with neighbourhood class!" );
        }
    }

    public String getName(){

        return neighbourhoodObject.returnName();

    }

    public int [][]tellWhoIsNeighbour( int rowIndex , int columnIndex ){

        return neighbourhoodObject.tellWhoIsNeighbour( rowIndex , columnIndex );

    }

}
