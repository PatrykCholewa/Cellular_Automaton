package graphics;

import java.io.File;
import java.io.PrintWriter;


public class TableSaver {
	
	private File file;
	private int width, height;
	private int board[][];
	
	public TableSaver(String f, int width, int height, int [][]board) {
		this.file = new File(f);
		this.width = width;
		this.height = height;
		this.board = board;
	}
	
	public void saveToFile() throws Exception {
		PrintWriter out = new PrintWriter(file);
		
		out.println(width + " " + height);
		
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				if(board[x][y] != 0) {
					out.println(x + " " + y + " " + board[x][y]);
				}
			}
		}
		
		out.close();
	}
}