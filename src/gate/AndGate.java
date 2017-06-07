package gate;

import gate.LogicGate;

public class AndGate implements LogicGate {
	
	private boolean gatePlaced = true;
	
	@Override
	public String getName() {
		
		return "AND";
	}

	@Override
	public int[][] addToTable(int [][]t, int x, int y) {
		
		if(y < t[0].length - 7 && x < t.length - 13) {
			t[x][y] = 3;
			t[x+1][y] = 3;
			t[x+2][y] = 3;
			t[x+3][y] = 3;
			t[x+4][y] = 3;
			t[x+5][y] = 3;
			t[x+6][y] = 3;
			t[x+7][y] = 3;
			t[x+8][y] = 3;
			t[x+9][y+1] = 3;
			t[x+10][y+1] = 3;
			t[x+11][y+1] = 3;
			t[x+6][y+2] = 3;
			t[x+8][y+2] = 3;
			t[x+12][y+2] = 3;
			t[x][y+3] = 3;
			t[x+1][y+3] = 3;
			t[x+5][y+3] = 3;
			t[x+6][y+3] = 3;
			t[x+7][y+3] = 3;
			t[x+12][y+3] = 3;
			t[x+2][y+4] = 3;
			t[x+4][y+4] = 3;
			t[x+6][y+4] = 3;
			t[x+8][y+4] = 3;
			t[x+10][y+4] = 3;
			t[x+12][y+4] = 3;
			t[x+2][y+5] = 3;
			t[x+4][y+5] = 3;
			t[x+9][y+5] = 3;
			t[x+10][y+5] = 3;
			t[x+11][y+5] = 3;
			t[x+2][y+6] = 3;
			t[x+4][y+6] = 3;
			t[x+10][y+6] = 3;
			t[x+3][y+7] = 3;
			t[x+12][y+6] = 3;
			t[x+13][y+6] = 3;
			
		} else {
			gatePlaced = false;
		}
		
		return t;
	}

	@Override
	public boolean canInsertGate() {
		return gatePlaced;
	}
	
}