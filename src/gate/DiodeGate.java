package gate;

import engine.Table;
import gate.LogicGate;

public class DiodeGate implements LogicGate {
	
	private boolean gatePlaced = true;

	@Override
	public String getName() {
		
		return "DIODE";
	}

	@Override
	public Table addToTable(Table t, int x, int y) {
		
		if(y < t.getNumberOfColumns() - 2 && x < t.getNumberOfRows() - 3) {
			t.setCellValue(x+1, y, 3);
			t.setCellValue(x+2, y, 3);
			t.setCellValue(x, y+1, 3);
			t.setCellValue(x+1, y+1, 3);
			t.setCellValue(x+3, y+1, 3);
			t.setCellValue(x+1, y+2, 3);
			t.setCellValue(x+2, y+2, 3);
			
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