package gate;

import gate.LogicGate;

public class OrGate implements LogicGate {
	
	private boolean gatePlaced = true;
	
	@Override
	public String getName() {
		
		return "OR";
	}

	@Override
	public int[][] addToTable(int [][]t, int x, int y) {
		
		if(y < t[0].length - 4 && x < t.length - 5) {
			t[x+2][y] = 3;
			t[x+3][y] = 3;
			t[x][y+1] = 3;
			t[x+1][y+1] = 3;
			t[x+4][y+1] = 3;
			t[x+3][y+2] = 3;
			t[x+4][y+2] = 3;
			t[x+5][y+2] = 3;
			t[x+1][y+3] = 3;
			t[x+4][y+3] = 3;
			t[x][y+3] = 3;
			t[x+2][y+4] = 3;
			t[x+3][y+4] = 3;
			
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