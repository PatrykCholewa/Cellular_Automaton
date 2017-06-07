import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AddGateDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton okButton, cancelButton;
	private DrawPanel drawPanel;
	private String option;
	private boolean dataOk = false;
	
	public AddGateDialog(JFrame owner) {
		super(owner, "Insert logic gate", true);
		setSize(470, 600);
		setResizable(false);
		setLayout(null);
		
		okButton = new JButton("Add");
		okButton.setBounds(this.getWidth()/2+50, 480, this.getWidth()/2-100, 30);
		okButton.addActionListener(this);
		add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(50, 480, this.getWidth()/2-100, 30);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		
	}
	
	public boolean isOK() {
		return this.dataOk;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==okButton) {
			if(drawPanel.getToClick() == 0) {
				dataOk = true;
				setVisible(false);
			} else {
				if(option.equals("DIODE")) {
					JOptionPane.showMessageDialog(null, "Choose 1 input (green) and 1 output (red)!");
				} else {
					JOptionPane.showMessageDialog(null, "Choose 2 inputs (green) and 1 output (red)!");
				}
			}
		}
		if(o==cancelButton) {
			dataOk = false;
			setVisible(false);
		}
	}
	
	public int[][] getGateInfo() {
		
		int gateInfo[][];
		
		if(option.equals("DIODE")) {
			gateInfo = new int[2][2];
			gateInfo[0][0] = drawPanel.inp2X;
			gateInfo[0][1] = drawPanel.inp2Y;
			gateInfo[1][0] = drawPanel.outX;
			gateInfo[1][1] = drawPanel.outY;
		} else {
			gateInfo = new int[3][2];
			gateInfo[0][0] = drawPanel.inp1X;
			gateInfo[0][1] = drawPanel.inp1Y;
			gateInfo[1][0] = drawPanel.inp2X;
			gateInfo[1][1] = drawPanel.inp2Y;
			gateInfo[2][0] = drawPanel.outX;
			gateInfo[2][1] = drawPanel.outY;
		}
		
		return gateInfo;
	}
	
	public boolean canBeAdded(String opt) {
		
		if(opt.equals("AND") || opt.equals("OR") || opt.equals("DIODE")) {
			return true;
		}
		
		return false;
	}
	
	public void setOption(String opt) {
		this.option = opt;
		this.setTitle("Insert " + this.option + " gate");
	}
	
	public void setBoard(int [][]board) {
		try {
			remove(drawPanel);
		} catch(Exception e) {
			;
		}
		if(this.option.equals("DIODE")) {
			drawPanel = new DrawPanel(board, 10, 10, 451, 451, 2);
		} else {
			drawPanel = new DrawPanel(board, 10, 10, 451, 451, 3);
		}
		
		add(drawPanel);
		repaint();
	}

	public void setOk(boolean b) {
		dataOk = b;
		
	}
	
	private class DrawPanel extends JPanel implements MouseListener {
		
		private static final long serialVersionUID = 1L;
		private int [][]board;
		private int cellSize;
		private int toClick;
		public int inp1X = -1;
		public int inp1Y = -1;
		public int inp2X = -1;
		public int inp2Y = -1;
		public int outX = -1;
		public int outY = -1;
		
		public DrawPanel(int [][]board, int x, int y, int width, int height, int toClick) {
			this.setBounds(x, y, width, height);
			this.board = new int[board.length][board[0].length];
			for(int i=0; i<board.length; i++) {
				for (int j=0; j<board[i].length; j++) {
					this.board[i][j] = board[i][j];
				}
			}
			calcCellSize();
			this.toClick = toClick;
			
			this.addMouseListener(this);
		}
		
		private void calcCellSize() {
			if(board.length > board[0].length) {
				this.cellSize = this.getHeight()/board.length;
			} else {
				this.cellSize = this.getWidth()/board[0].length;
			}
		}
		
		private Color getColorFromState(int state) {
			if(state == 1) {
				return Color.BLUE;
			}
			if(state == 2) {
				return Color.RED;
			}
			
			return Color.ORANGE;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
		    g.fillRect(0, 0, cellSize*board.length, cellSize*board[0].length);
		    
	        for(int x=0; x<board.length; x++) {
	            for(int y=0; y<board[0].length; y++) {
	            	if(board[x][y] != 0) {
	            		g.setColor(getColorFromState(board[x][y]));
	            		g.fillRect(x*cellSize, y*cellSize, cellSize, cellSize);
	            	}
	            }
	        }
	        
	        g.setColor(Color.GREEN);
	        
	        if(inp1X != -1) {
	        	g.fillOval(inp1X*cellSize, inp1Y*cellSize, cellSize, cellSize);
	        }
	        if(inp2X != -1) {
	        	g.fillOval(inp2X*cellSize, inp2Y*cellSize, cellSize, cellSize);
	        }
	        
	        g.setColor(Color.RED);
	        
	        if(outX != -1) {
	        	g.fillOval(outX*cellSize, outY*cellSize, cellSize, cellSize);
	        }
	        
	        
	        g.setColor(Color.BLACK);

	        for(int i=0; i<=cellSize*board.length; i+=cellSize) {
	        	g.drawLine(i, 0, i, cellSize*board[0].length);
	        }
	        for(int i=0; i<=cellSize*board[0].length; i+=cellSize) {
	            g.drawLine(0, i, cellSize*board.length, i);
	        }
	        
		}
		
		public int getToClick() {
			return toClick;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (toClick != 0) {
				if (e.getY() <= cellSize * board[0].length
						&& e.getX() <= cellSize * board.length
						&& e.getButton() == MouseEvent.BUTTON1) {
					int x = (int) Math.floor(e.getX() / this.cellSize);
					int y = (int) Math.floor(e.getY() / this.cellSize);
					
					if(!((inp1X == x && inp1Y == y) || (inp2X == x && inp2Y == y) || (outX == x && outY == y))) {
						if (toClick == 1) {
							outX = x;
							outY = y;
						} else if(toClick == 2){
							inp2X = x;
							inp2Y = y;
						} else {
							inp1X = x;
							inp1Y = y;
						}
						toClick--;
					}
				}
				
			}
			
			repaint();
			
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

}
