package gate;


import engine.Table;

public interface LogicGate {
	String getName();
	Table addToTable(Table t, int x, int y);
	boolean canInsertGate();
}