
public class GateAdder {
	
	private Table tab;
	LogicGate logicGate;
	
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
		
		tab = logicGate.addToTable(tab, x, y);
	}
	
}