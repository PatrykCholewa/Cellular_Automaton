import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class TableReader {
	
	private File file;
	private int board[][];
	private int numOfStates;
	private int width, height;
	
	public TableReader(String f, int numOfStates) {
		this.file = new File(f);
		this.numOfStates = numOfStates;
	}
	
	@SuppressWarnings("resource")
	public void readFromFile() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(file.getPath()));
		
		String line = in.readLine();
		String words[] = line.split(" ");
		if(words.length < 2) {
			throw new Exception();
		}
		
		width = Integer.parseInt(words[0]);
		height = Integer.parseInt(words[1]);
		
		board = new int[width][height];
		for(int x = 0; x<width; x++) {
			for(int y=0; y<height; y++) {
				board[x][y] = 0;
			}
		}
		
		while((line = in.readLine()) != null) {
			words = line.split(" ");
			if(words.length < 3) {
				throw new Exception();
			}
			int x = Integer.parseInt(words[0]);
			int y = Integer.parseInt(words[1]);
			int s = Integer.parseInt(words[2]);
			if(x < 0 || y < 0 || s < 0) {
				throw new Exception();
			}
			if(x >= width || y >= height) {
				continue;
			}
			if(s >= numOfStates) {
				s = 0;
			}
			board[x][y] = s;
		}
		in.close();
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}