import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class SettingsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 210;
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
	public JLabel nghbLabel;
	public JComboBox<String> nghbCombo;
	public JLabel boundLabel;
	public JComboBox<String> boundCombo;
	public JLabel rulesLabel;
	public JComboBox<String> rulesCombo;
	public JButton ownRulesButton;

	
	public SettingsPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBounds(600, 0, WIDTH, HEIGHT);
		
		Font font = new Font("", Font.PLAIN, 18);
		
		playButton = new JButton("Play");
		playButton.setLocation(600+((100-playButton.getWidth())), 50);
		playButton.setToolTipText("Start/stop the automaton.");
		add(playButton);
		
		clearButton = new JButton("Clear");
		clearButton.setToolTipText("Clear board and stop the automaton.");
		clearButton.setLocation(700+clearButton.getWidth(), 50);
		add(clearButton);
		
		add(Box.createVerticalStrut(50));
		
		speedLabel = new JLabel("Delay: 500ms");
		speedLabel.setFont(font);
		speedLabel.setForeground(Color.WHITE);
		add(speedLabel);
		
		speedSlider = new JSlider(JSlider.HORIZONTAL,5, 800, 500);
		speedSlider.setBackground(Color.DARK_GRAY);
		speedSlider.setMaximumSize(new Dimension(180, 30));
		add(speedSlider);
		
		add(Box.createVerticalStrut(50));
		
		openButton = new JButton("Open");
		openButton.setToolTipText("Open board from file.");
		add(openButton);
		saveButton = new JButton("Save");
		saveButton.setToolTipText("Save board to file.");
		add(saveButton);
		pngButton = new JButton("Save as PNG");
		pngButton.setToolTipText("Save board as png file. Remember to add .png to your file name.");
		add(pngButton);
		
		add(Box.createVerticalStrut(50));
		
		sizeLabel = new JLabel("Board size: "+this.width+"x"+this.height+" ");
		sizeLabel.setFont(font);
		sizeLabel.setForeground(Color.WHITE);
		add(sizeLabel);
		
		sizeButton = new JButton("Change Size");
		sizeButton.setToolTipText("Change board size. Board'll be cleared.");
		add(sizeButton);
		
		add(Box.createVerticalStrut(50));
		
		nghbLabel = new JLabel("Neighbourhood:");
		nghbLabel.setFont(font);
		nghbLabel.setForeground(Color.WHITE);
		add(nghbLabel);
		
		nghbCombo = new JComboBox<String>();
		nghbCombo.addItem("Moore");
		nghbCombo.addItem("von Neumann");
		add(nghbCombo);
		
		add(Box.createVerticalStrut(50));
		
		boundLabel = new JLabel("Boundary:");
		boundLabel.setFont(font);
		boundLabel.setForeground(Color.WHITE);
		add(boundLabel);
		
		boundCombo = new JComboBox<String>();
		boundCombo.setMinimumSize(new Dimension(100, 20));
		boundCombo.addItem("Void");
		boundCombo.addItem("Planet");
		add(boundCombo);
		
		add(Box.createVerticalStrut(50));
		
		rulesLabel = new JLabel("Rules: ");
		rulesLabel.setFont(font);
		rulesLabel.setForeground(Color.WHITE);
		add(rulesLabel);
		
		rulesCombo = new JComboBox<String>();
		rulesCombo.addItem("Wireworld");
		rulesCombo.addItem("Game Of Life");
		rulesCombo.addItem("Own rules");
		add(rulesCombo);
		
		ownRulesButton = new JButton("New rules");
		ownRulesButton.setEnabled(false);
		ownRulesButton.setToolTipText("Set your own rules in Rules Editor.");
		add(ownRulesButton);
		
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
		;
	}
	
}