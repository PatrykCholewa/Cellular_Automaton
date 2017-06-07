
public class XorGate implements LogicGate {

	@Override
	public String getName() {
		
		return "XOR";
	}

	@Override
	public Table addToTable(Table t, int x, int y) {
		
		if(y < t.getNumberOfColumns() - 6 && x < t.getNumberOfRows() - 9) {
			t.setCellValue(x+3, y, 3);
			t.setCellValue(x+4, y, 3);
			t.setCellValue(x+2, y+1, 3);
			t.setCellValue(x+5, y+1, 3);
			t.setCellValue(x, y+2, 3);
			t.setCellValue(x+1, y+2, 3);
			t.setCellValue(x+4, y+2, 3);
			t.setCellValue(x+5, y+2, 3);
			t.setCellValue(x+6, y+2, 3);
			t.setCellValue(x+7, y+2, 3);
			t.setCellValue(x+4, y+3, 3);
			t.setCellValue(x+6, y+3, 3);
			t.setCellValue(x+7, y+3, 3);
			t.setCellValue(x+8, y+3, 3);
			t.setCellValue(x+9, y+3, 3);
			t.setCellValue(x, y+4, 3);
			t.setCellValue(x+1, y+4, 3);
			t.setCellValue(x+4, y+4, 3);
			t.setCellValue(x+5, y+4, 3);
			t.setCellValue(x+6, y+4, 3);
			t.setCellValue(x+7, y+4, 3);
			t.setCellValue(x+2, y+5, 3);
			t.setCellValue(x+5, y+5, 3);
			t.setCellValue(x+3, y+6, 3);
			t.setCellValue(x+4, y+6, 3);
		}
		
		return t;
	}
	
}