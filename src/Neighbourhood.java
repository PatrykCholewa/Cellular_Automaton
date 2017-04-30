/**
 * Created by Patryk on 30.04.2017.
 */
public class Neighbourhood {

    private neighbourhood.NeighbourhoodTemplate neighbourhoodObject;

    public Neighbourhood( String name ){

        try{
            if( name.contains("Moore")) {
                Class cls = Class.forName( "neighbourhood.Moore" );
                neighbourhoodObject = ( neighbourhood.NeighbourhoodTemplate ) cls.newInstance();
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
