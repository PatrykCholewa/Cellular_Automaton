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

    public int checkStateByIndex( int [][]board , int i , int j ){

        throw new UnsupportedOperationException( "Not supported yet!" );

    }

}
