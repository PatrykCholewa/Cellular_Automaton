package pl.edu.pw.iem.gate;

import pl.edu.pw.iem.engine.Table;

public class GateAdder {
	
	private Table tab;
	LogicGate logicGate;
	private boolean gatePlaced = true;
	
	public GateAdder(Table tab, String gateName) {
		this.tab = tab;
		
		switch(gateName) {
		case "AND":
			logicGate = new AndGate();
			break;
		case "OR":
			logicGate = new OrGate();
			break;
		case "DIODE":
			logicGate = new DiodeGate();
			break;
		case "XOR":
			logicGate = new XorGate();
			break;
		default:
			logicGate = new AndGate();
		}
	}
	public Table getTable() {
		return tab;
	}
	
	public void addGateToTable(int x, int y) {
		
		tab.setBoard(logicGate.addToTable(tab.getBoard(), x, y));
		gatePlaced = logicGate.canInsertGate();
	}
	
	public boolean isGatePlaced() {
		return gatePlaced;
	}
	
}