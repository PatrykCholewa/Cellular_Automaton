package gate;

public interface LogicGate {
	String getName();
	int[][] addToTable(int [][]t, int x, int y);
	boolean canInsertGate();
}