import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class SettingsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 600;
	private int width = 30;
	private int height = 30;
	public JButton playButton;
	public JButton clearButton;
	public JLabel speedLabel;
	public JSlider speedSlider;
	public JButton openButton;
	public JButton saveButton;
	public JButton pngButton;
	public JLabel sizeLabel;
	public JButton sizeButton;

	
	public SettingsPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBounds(600, 0, WIDTH, HEIGHT);
		
		playButton = new JButton("Play");
		playButton.setLocation(600+((100-playButton.getWidth())), 50);
		add(playButton);
		
		clearButton = new JButton("Clear");
		clearButton.setLocation(700+clearButton.getWidth(), 50);
		add(clearButton);
		
		add(Box.createVerticalStrut(50));
		
		speedLabel = new JLabel("Delay: 500ms");
		speedLabel.setForeground(Color.WHITE);
		speedLabel.setLocation(600+(200-speedLabel.getWidth())/2, clearButton.getY()+clearButton.getHeight()+100);
		add(speedLabel);
		
		speedSlider = new JSlider(JSlider.HORIZONTAL,5, 1000, 500);
		speedSlider.setBackground(Color.DARK_GRAY);
		speedSlider.setMaximumSize(new Dimension(180, 30));
		add(speedSlider);
		
		add(Box.createVerticalStrut(50));
		
		openButton = new JButton("Open");
		add(openButton);
		saveButton = new JButton("Save");
		add(saveButton);
		pngButton = new JButton("Save PNG");
		add(pngButton);
		
		sizeLabel = new JLabel("Board size: "+this.width+"x"+this.height+" ");
		sizeLabel.setForeground(Color.WHITE);
		add(sizeLabel);
		
		sizeButton = new JButton("Change Size");
		add(sizeButton);
		
		repaint();
	}
	
	public void setTableSize(int w, int h) {
		this.width = w;
		this.height = h;
		sizeLabel.setText("Board size: "+this.width+"x"+this.height+" ");
	}
	
	public Dimension getSize() {
		return new Dimension(this.width, this.height);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(600, 0, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.fillRect(605, 5, WIDTH-10, HEIGHT-10);
	}
	
}