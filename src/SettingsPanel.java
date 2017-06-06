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
	public JButton skipButton;
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
	private JLabel authorsLabel;

	
	public SettingsPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBounds(600, 0, WIDTH, HEIGHT);
		this.setLayout(null);
		
		Font font = new Font("Courier New", Font.BOLD, 16);
		
		playButton = new JButton("Play");
		playButton.setToolTipText("Start/stop the automaton.");
		playButton.setBounds(10, 15, (this.getWidth()/2)-5, 35);
		add(playButton);
		
		clearButton = new JButton("Clear");
		clearButton.setToolTipText("Clear board and stop the automaton.");
		clearButton.setBounds((this.getWidth()/2)+5, 15, (this.getWidth()/2)-10, 35);
		add(clearButton);
		
		skipButton = new JButton("Skip generations");
		skipButton.setToolTipText("Enter number of generations to skip.");
		skipButton.setBounds(30, 60, this.getWidth()-60, 25);
		add(skipButton);
		
		add(Box.createVerticalStrut(50));
		
		speedLabel = new JLabel("Delay: 500ms", JLabel.CENTER);
		speedLabel.setFont(font);
		speedLabel.setForeground(Color.WHITE);
		speedLabel.setBounds(10, 110, this.getWidth()-20, 25);
		add(speedLabel);
		
		speedSlider = new JSlider(JSlider.HORIZONTAL,5, 800, 500);
		speedSlider.setBackground(Color.DARK_GRAY);
		speedSlider.setBounds(10, 135, this.getWidth()-20, 15);
		add(speedSlider);
		
		add(Box.createVerticalStrut(50));
		
		openButton = new JButton("Open");
		openButton.setToolTipText("Open board from file.");
		openButton.setBounds(10, 180, (this.getWidth()/2)-5, 25);
		add(openButton);
		saveButton = new JButton("Save");
		saveButton.setToolTipText("Save board to file.");
		saveButton.setBounds((this.getWidth()/2)+5, 180, (this.getWidth()/2)-10, 25);
		add(saveButton);
		pngButton = new JButton("Save as PNG");
		pngButton.setToolTipText("Save board as png file. Remember to add .png to your file name.");
		pngButton.setBounds(30, 210, this.getWidth()-60, 25);
		add(pngButton);
		
		add(Box.createVerticalStrut(50));
		
		sizeLabel = new JLabel("Board size: "+this.width+"x"+this.height+" ", JLabel.CENTER);
		sizeLabel.setFont(font);
		sizeLabel.setForeground(Color.WHITE);
		sizeLabel.setBounds(10, 265, this.getWidth()-20, 25);
		add(sizeLabel);
		
		sizeButton = new JButton("Change Size");
		sizeButton.setToolTipText("Change board size. Board'll be cleared.");
		sizeButton.setBounds(40, 295, this.getWidth()-80, 30);
		add(sizeButton);
		
		add(Box.createVerticalStrut(50));
		
		nghbLabel = new JLabel("Neighbourhood:", JLabel.CENTER);
		nghbLabel.setFont(font);
		nghbLabel.setForeground(Color.WHITE);
		nghbLabel.setBounds(10, 355, this.getWidth()-20, 25);
		add(nghbLabel);
		
		nghbCombo = new JComboBox<String>();
		nghbCombo.addItem("Moore");
		nghbCombo.addItem("von Neumann");
		nghbCombo.setBounds(30, 385, this.getWidth()-60, 25);
		add(nghbCombo);
		
		add(Box.createVerticalStrut(50));
		
		boundLabel = new JLabel("Boundary:", JLabel.RIGHT);
		boundLabel.setFont(font);
		boundLabel.setForeground(Color.WHITE);
		boundLabel.setBounds(10, 440, (this.getWidth()/2)-10, 25);
		add(boundLabel);
		
		boundCombo = new JComboBox<String>();
		boundCombo.setBounds((this.getWidth()/2)+10, 440, (this.getWidth()/2)-20, 25);
		boundCombo.addItem("Void");
		boundCombo.addItem("Planet");
		add(boundCombo);
		
		add(Box.createVerticalStrut(50));
		
		rulesLabel = new JLabel("Rules: ", JLabel.RIGHT);
		rulesLabel.setFont(font);
		rulesLabel.setForeground(Color.WHITE);
		rulesLabel.setBounds(10, 495, (this.getWidth()/2)-30, 25);
		add(rulesLabel);
		
		rulesCombo = new JComboBox<String>();
		rulesCombo.addItem("Wireworld");
		rulesCombo.addItem("Game Of Life");
		rulesCombo.addItem("Own rules");
		rulesCombo.setBounds((this.getWidth()/2)-20, 495, (this.getWidth()/2), 25);
		add(rulesCombo);
		
		ownRulesButton = new JButton("New rules");
		ownRulesButton.setEnabled(false);
		ownRulesButton.setToolTipText("Set your own rules in Rules Editor.");
		ownRulesButton.setBounds(40, 530, this.getWidth()-80, 30);
		add(ownRulesButton);
		
		authorsLabel = new JLabel("By: Patryk Cholewa, Michal Mitros.");
		authorsLabel.setFont(new Font("Courier New", Font.PLAIN, 10));
		authorsLabel.setBounds(5, 585, this.getWidth()-4, 12);
		authorsLabel.setForeground(Color.WHITE);
		add(authorsLabel);
		
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