package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
	private JLabel nghbLabel;
	public JComboBox<String> nghbCombo;
	private JLabel boundLabel;
	public JComboBox<String> boundCombo;
	private JLabel rulesLabel;
	public JComboBox<String> rulesCombo;
	public JButton ownRulesButton;
	public JLabel addLogicGateLabel;
	public JComboBox<String> addLogicGateCombo;
	public JButton addLogicGateButton;
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
		
		
		
		speedLabel = new JLabel("Delay: 500ms", JLabel.CENTER);
		speedLabel.setFont(font);
		speedLabel.setForeground(Color.WHITE);
		speedLabel.setBounds(10, 100, this.getWidth()-20, 25);
		add(speedLabel);
		
		speedSlider = new JSlider(JSlider.HORIZONTAL,5, 800, 500);
		speedSlider.setBackground(Color.DARK_GRAY);
		speedSlider.setBounds(10, 125, this.getWidth()-20, 15);
		add(speedSlider);
		
		
		
		openButton = new JButton("Open");
		openButton.setToolTipText("Open board from file.");
		openButton.setBounds(10, 155, (this.getWidth()/2)-5, 25);
		add(openButton);
		saveButton = new JButton("Save");
		saveButton.setToolTipText("Save board to file.");
		saveButton.setBounds((this.getWidth()/2)+5, 155, (this.getWidth()/2)-10, 25);
		add(saveButton);
		pngButton = new JButton("Save as PNG");
		pngButton.setToolTipText("Save board as png file. Remember to add .png to your file name.");
		pngButton.setBounds(30, 185, this.getWidth()-60, 25);
		add(pngButton);
		
		
		
		sizeLabel = new JLabel("Board size: "+this.width+"x"+this.height+" ", JLabel.CENTER);
		sizeLabel.setFont(font);
		sizeLabel.setForeground(Color.WHITE);
		sizeLabel.setBounds(10, 225, this.getWidth()-20, 25);
		add(sizeLabel);
		
		sizeButton = new JButton("Change Size");
		sizeButton.setToolTipText("Change board size. Board'll be cleared.");
		sizeButton.setBounds(40, 255, this.getWidth()-80, 30);
		add(sizeButton);
		
		
		
		nghbLabel = new JLabel("Neighbourhood:", JLabel.CENTER);
		nghbLabel.setFont(font);
		nghbLabel.setForeground(Color.WHITE);
		nghbLabel.setBounds(10, 305, this.getWidth()-20, 25);
		add(nghbLabel);
		
		nghbCombo = new JComboBox<String>();
		nghbCombo.addItem("Moore");
		nghbCombo.addItem("von Neumann");
		nghbCombo.setBounds(30, 335, this.getWidth()-60, 25);
		add(nghbCombo);
		
		
		
		boundLabel = new JLabel("Boundary:", JLabel.RIGHT);
		boundLabel.setFont(font);
		boundLabel.setForeground(Color.WHITE);
		boundLabel.setBounds(10, 380, (this.getWidth()/2)-10, 25);
		add(boundLabel);
		
		boundCombo = new JComboBox<String>();
		boundCombo.setBounds((this.getWidth()/2)+10, 380, (this.getWidth()/2)-20, 25);
		boundCombo.addItem("Void");
		boundCombo.addItem("Planet");
		add(boundCombo);
		
		
		
		rulesLabel = new JLabel("Rules: ", JLabel.RIGHT);
		rulesLabel.setFont(font);
		rulesLabel.setForeground(Color.WHITE);
		rulesLabel.setBounds(10, 425, (this.getWidth()/2)-30, 25);
		add(rulesLabel);
		
		rulesCombo = new JComboBox<String>();
		rulesCombo.addItem("Wireworld");
		rulesCombo.addItem("Game Of Life");
		rulesCombo.addItem("Own rules");
		rulesCombo.setBounds((this.getWidth()/2)-20, 425, (this.getWidth()/2), 25);
		add(rulesCombo);
		
		ownRulesButton = new JButton("New rules");
		ownRulesButton.setEnabled(false);
		ownRulesButton.setToolTipText("Set your own rules in Rules Editor.");
		ownRulesButton.setBounds(40, 455, this.getWidth()-80, 30);
		add(ownRulesButton);
		
		
		
		addLogicGateLabel = new JLabel("Insert logic gate:", JLabel.CENTER);
		addLogicGateLabel.setFont(font);
		addLogicGateLabel.setForeground(Color.WHITE);
		addLogicGateLabel.setBounds(10, 500, this.getWidth()-20, 25);
		add(addLogicGateLabel);
		
		addLogicGateCombo = new JComboBox<String>();
		addLogicGateCombo.addItem("AND");
		addLogicGateCombo.addItem("OR");
		addLogicGateCombo.addItem("DIODE");
		addLogicGateCombo.addItem("XOR");
		addLogicGateCombo.setBounds(10, 530, (this.getWidth()/2), 25);
		add(addLogicGateCombo);
		
		addLogicGateButton = new JButton("Add");
		addLogicGateButton.setBounds((this.getWidth()/2)+10, 530, (this.getWidth()/2)-20, 25);
		addLogicGateButton.setToolTipText("Click here and choose the cell to add logic gate.");
		add(addLogicGateButton);
		
		
		
		authorsLabel = new JLabel("By: Patryk Cholewa, Michał Mitros.");
		authorsLabel.setFont(new Font("Courier New", Font.PLAIN, 11));
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