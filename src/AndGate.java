
public class AndGate implements LogicGate {

	@Override
	public String getName() {
		
		return "AND";
	}

	@Override
	public Table addToTable(Table t, int x, int y) {
		
		if(y < t.getNumberOfColumns() - 7 && x < t.getNumberOfRows() - 12) {
			t.setCellValue(x, y, 3);
			t.setCellValue(x+1, y, 3);
			t.setCellValue(x+2, y, 3);
			t.setCellValue(x+3, y, 3);
			t.setCellValue(x+4, y, 3);
			t.setCellValue(x+5, y, 3);
			t.setCellValue(x+6, y, 3);
			t.setCellValue(x+7, y, 3);
			t.setCellValue(x+8, y, 3);
			t.setCellValue(x+9, y+1, 3);
			t.setCellValue(x+10, y+1, 3);
			t.setCellValue(x+11, y+1, 3);
			t.setCellValue(x+6, y+2, 3);
			t.setCellValue(x+8, y+2, 3);
			t.setCellValue(x+12, y+2, 3);
			t.setCellValue(x, y+3, 3);
			t.setCellValue(x+1, y+3, 3);
			t.setCellValue(x+5, y+3, 3);
			t.setCellValue(x+6, y+3, 3);
			t.setCellValue(x+7, y+3, 3);
			t.setCellValue(x+12, y+3, 3);
			t.setCellValue(x+2, y+4, 3);
			t.setCellValue(x+4, y+4, 3);
			t.setCellValue(x+6, y+4, 3);
			t.setCellValue(x+8, y+4, 3);
			t.setCellValue(x+10, y+4, 3);
			t.setCellValue(x+12, y+4, 3);
			t.setCellValue(x+2, y+5, 3);
			t.setCellValue(x+4, y+5, 3);
			t.setCellValue(x+9, y+5, 3);
			t.setCellValue(x+10, y+5, 3);
			t.setCellValue(x+11, y+5, 3);
			t.setCellValue(x+2, y+6, 3);
			t.setCellValue(x+4, y+6, 3);
			t.setCellValue(x+10, y+6, 3);
			t.setCellValue(x+3, y+7, 3);
			t.setCellValue(x+13, y+6, 3);
			t.setCellValue(x+12, y+6, 3);
		}
		
		return t;
	}
	
}