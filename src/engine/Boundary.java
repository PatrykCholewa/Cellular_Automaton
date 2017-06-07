package engine;

import boundary.BoundaryTemplate;

/**
 * Created by Patryk on 30.04.2017.
 */
public class Boundary {

    private boundary.BoundaryTemplate boundaryObject;

    public Boundary( String name ){

        try{
            if( name.contains("Void")) {
                Class cls = Class.forName( "boundary.Void" );
                boundaryObject = ( boundary.BoundaryTemplate ) cls.newInstance();
            } else if ( name.contains("Planet")){
                Class cls = Class.forName( "boundary.Planet" );
                boundaryObject = ( boundary.BoundaryTemplate ) cls.newInstance();
            } else {
                throw new IllegalArgumentException ( "Unsupported boundary." );
            }


        } catch( ClassNotFoundException e ){
            throw new AssertionError( "There's no Void class in package!");
        } catch ( InstantiationException | IllegalAccessException e ) {
            throw new InternalError("Problem with boundary class!");
        }
    }

    public String getName(){

        return boundaryObject.returnName();

    }

    public int checkStateByIndex( int [][]board , int rowIndex , int columnIndex ){

       return boundaryObject.checkStateByIndex( board , rowIndex , columnIndex );

    }

}
