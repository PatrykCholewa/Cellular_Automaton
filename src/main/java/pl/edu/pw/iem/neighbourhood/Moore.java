package pl.edu.pw.iem.neighbourhood;

/**
 * Created by Patryk on 30.04.2017.
 */

public class Moore implements NeighbourhoodTemplate {

    @Override
    public int[][] tellWhoIsNeighbour(int rowIndex, int columnIndex) {

        int [][]result = {
                { rowIndex - 1 , columnIndex - 1 },
                { rowIndex - 1 , columnIndex },
                { rowIndex - 1 , columnIndex + 1},
                { rowIndex , columnIndex - 1 },
                { rowIndex , columnIndex + 1 },
                { rowIndex + 1 , columnIndex - 1},
                { rowIndex + 1 , columnIndex },
                { rowIndex + 1 , columnIndex + 1},
        };

        return result;

    }

    @Override
    public String returnName() {
        return "Moore";
    }

    public Moore(){

    }

}
