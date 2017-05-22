import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TablePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	private Table tab;
	private int cellSize;
	private int numOfStates;
	private BufferedImage paintImage;
	
	public TablePanel(int numberOfRows, int numberOfCols, int numOfStates) {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setDoubleBuffered(true);
		
		this.numOfStates = numOfStates;
		
		this.tab = new Table(numberOfRows, numberOfCols);
		
		if(numberOfRows > numberOfCols) {
			this.cellSize = HEIGHT/numberOfRows;
		} else {
			this.cellSize = WIDTH/numberOfCols;
		}
		
		int newBoard[][] = new int[numberOfRows][numberOfCols];
		for(int x=0; x<newBoard.length; x++) {
			for(int y=0; y<newBoard[x].length; y++) {
				newBoard[x][y] = 0;
			}
		}
		this.tab.setBoard(newBoard);
		
		this.tab.setBoundary("Void");
		this.tab.setNeighbourhood("Moore");
		String rules[] = new String[2];
		rules[0] = "1/3/1/0";
		rules[1] = "1/23/1/0";
		this.tab.setRules(rules);
		
		paintImage = new BufferedImage(cellSize*numberOfRows, cellSize*numberOfCols, BufferedImage.TYPE_INT_RGB);
		
		this.addMouseListener(this);
		repaint();
	}
	
	public void setNeighbourhood(String opt) {
		
		switch(opt) {
			case "Moore":
				this.tab.setNeighbourhood("Moore");
				break;
			case "von Neumann":
				//this.tab.setNeighbourhood("Neumann");
				JOptionPane.showMessageDialog(null, "Not supported yet  :(");
				break;
			default:
				this.tab.setNeighbourhood("Moore");
		}
		
	}
	
	public void setBoundary(String opt) {
		
		switch(opt) {
		case "Void":
			this.tab.setNeighbourhood("Void");
			break;
		case "Planet":
			JOptionPane.showMessageDialog(null, "Comming soon  :)");
			break;
		default:
			this.tab.setNeighbourhood("Void");
		}
		
	}
	
	public void setRules(String opt) {
		
		String rules[];
		
		switch(opt) {
			case "Game Of Life":
				rules = new String[2];
				rules[0] = "1/3/1/0";
				rules[1] = "1/23/1/0";
				numOfStates = 2;
				this.tab.setRules(rules);
				break;
			case "Wireworld":
				rules = new String[4];
				rules[0] = "0/9/1/0";
				rules[1] = "1/9/1/2";
				rules[2] = "2/9/1/3";
				rules[3] = "1/12/1/3";
				numOfStates = 4;
				this.tab.setRules(rules);
				break;
			default:
				rules = new String[2];
				rules[0] = "1/3/1/0";
				rules[1] = "1/23/1/0";
				numOfStates = 2;
				this.tab.setRules(rules);
		}
		
	}
	
	public void setRandomBoard() {
		Random r = new Random();
		int newBoard[][] = new int[tab.getNumberOfRows()][tab.getNumberOfColumns()];
		for(int x=0; x<newBoard.length; x++) {
			for(int y=0; y<newBoard[x].length; y++) {
				newBoard[x][y] = r.nextInt(numOfStates);
			}
		}
		this.tab.setBoard(newBoard);
	}
	
	public void nextGeneration() {
		this.tab.makeNextGeneration();
	}
	
	public void clearBoard() {
		int newBoard[][] = new int[tab.getNumberOfRows()][tab.getNumberOfColumns()];
		for(int x=0; x<newBoard.length; x++) {
			for(int y=0; y<newBoard[x].length; y++) {
				newBoard[x][y] = 0;
			}
		}
		this.tab.setBoard(newBoard);
	}
	
	public void setNewTable(Table tab) {
		this.tab = tab;
	}
	
	public void updatePaint() {
		Graphics g = paintImage.createGraphics();
		g.dispose();
		repaint();
	}
	
	public void savePNG(File f) throws IOException {
		ImageIO.write(paintImage, "png", f);
	}
	
	private Color getColorFromState(int state) {
		if(state == 0) {
			return Color.DARK_GRAY;
		}
		if(state == 1) {
			return Color.WHITE;
		}
		float dc = (float)this.numOfStates/state;
		return Color.getHSBColor(dc, 0.8f, 1.0f);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
	    g.setColor(Color.DARK_GRAY);
	    g.fillRect(0, 0, WIDTH, HEIGHT);
	    
	    g.setColor(Color.WHITE);
        for(int x=0; x<tab.getNumberOfRows(); x++) {
            for(int y=0; y<tab.getNumberOfColumns(); y++) {
            	g.setColor(getColorFromState(tab.getCellValue(x, y)));
            	g.fillRect(x*cellSize, y*cellSize, cellSize, cellSize);
            }
        }
        
        if(tab.getNumberOfColumns() <= 150 && tab.getNumberOfRows() <= 150) {
        
        	g.setColor(Color.LIGHT_GRAY);

        	for(int i=0; i<=cellSize*tab.getNumberOfRows(); i+=cellSize) {
        		g.drawLine(i, 0, i, cellSize*tab.getNumberOfColumns());
        	}
        	for(int i=0; i<=cellSize*tab.getNumberOfColumns(); i+=cellSize) {
            	g.drawLine(0, i, cellSize*tab.getNumberOfRows(), i);
        	}
        }
	}
	
	private void increaseCellState(int x, int y) {
		int state = tab.getCellValue(x, y);
		if(state == this.numOfStates-1) {
			tab.setCellValue(x, y, 0);
		} else {
			tab.setCellValue(x, y, state+1);
		}
		
	}
	
	public int getNumOfRows() {
		return tab.getNumberOfRows();
	}
	
	public int getNumOfCols() {
		return tab.getNumberOfColumns();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getY() <= cellSize*tab.getNumberOfColumns() && e.getX() <= cellSize*tab.getNumberOfRows()) {
			int x = (int)Math.floor(e.getX()/this.cellSize);
			int y = (int)Math.floor(e.getY()/this.cellSize);
			increaseCellState(x, y);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		;
		
	}
	
}