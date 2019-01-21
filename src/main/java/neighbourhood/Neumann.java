package neighbourhood;

/**
 * Created by Patryk on 06.05.2017.
 */
public class Neumann implements neighbourhood.NeighbourhoodTemplate {

    @Override
    public int[][] tellWhoIsNeighbour(int rowIndex, int columnIndex) {

        int[][] result = {
                {rowIndex - 1, columnIndex},
                {rowIndex, columnIndex - 1},
                {rowIndex, columnIndex + 1},
                {rowIndex + 1, columnIndex},
        };

        return result;

    }

    @Override
    public String returnName() {
        return "Neumann";
    }

    public Neumann() {

    }

}