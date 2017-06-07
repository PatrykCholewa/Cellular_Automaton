package gate;

import engine.Table;
import gate.LogicGate;

public class OrGate implements LogicGate {
	
	private boolean gatePlaced = true;
	
	@Override
	public String getName() {
		
		return "OR";
	}

	@Override
	public Table addToTable(Table t, int x, int y) {
		
		if(y < t.getNumberOfColumns() - 4 && x < t.getNumberOfRows() - 5) {
			t.setCellValue(x+2, y, 3);
			t.setCellValue(x+3, y, 3);
			t.setCellValue(x, y+1, 3);
			t.setCellValue(x+1, y+1, 3);
			t.setCellValue(x+4, y+1, 3);
			t.setCellValue(x+3, y+2, 3);
			t.setCellValue(x+4, y+2, 3);
			t.setCellValue(x+5, y+2, 3);
			t.setCellValue(x+1, y+3, 3);
			t.setCellValue(x+4, y+3, 3);
			t.setCellValue(x, y+3, 3);
			t.setCellValue(x+2, y+4, 3);
			t.setCellValue(x+3, y+4, 3);
			
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