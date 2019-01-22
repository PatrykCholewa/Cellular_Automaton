package pl.edu.pw.iem.gate;

public class DiodeGate implements LogicGate {
	
	private boolean gatePlaced = true;

	@Override
	public String getName() {
		
		return "DIODE";
	}

	@Override
	public int[][] addToTable(int [][]t, int x, int y) {
		
		if(y < t[0].length - 2 && x < t.length - 3) {
			t[x+1][y] = 3;
			t[x+2][y] = 3;
			t[x][y+1] = 3;
			t[x+1][y+1] = 3;
			t[x+3][y+1] = 3;
			t[x+1][y+2] = 3;
			t[x+2][y+2] = 3;
			
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