import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CellularAutomaton extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private Timer tm;
	private Timer paintTimer;
	private TablePanel tablePanel;
	private SettingsPanel settingsPanel;
	private JFileChooser fc = new JFileChooser();
	private SizeDialog sizeDialog = new SizeDialog(this);
	
	private int numOfStates = 2;
	private final int DEF_SIZE = 30;

	public CellularAutomaton() {
		setTitle("CellularAutomaton");
		setSize(800, 601);
		setBackground(Color.DARK_GRAY);
		
		settingsPanel = new SettingsPanel();
		setPlayButton();
		setClearButton();
		setSpeedSlider();
		setOpenButton();
		setSaveButton();
		setPngButton();
		setSizeButton();
		setNghbCombo();
		setBoundCombo();
		setRulesCombo();
		add(settingsPanel);
		
		tablePanel = new TablePanel(DEF_SIZE, DEF_SIZE, numOfStates);
		add(tablePanel);
		
		settingsPanel.setTableSize(DEF_SIZE, DEF_SIZE);
		
		paintTimer = new Timer(5, null);
		paintTimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				
			}
			
		});
		
		tm = new Timer(500, null);
		tm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tablePanel.nextGeneration();
				//tablePanel.setRandomBoard();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		paintTimer.start();
		tm.stop();
	}
	
	private void pause() {
		tm.stop();
		settingsPanel.playButton.setText("Play");
	}
	
	private void setPlayButton() {
		settingsPanel.playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tm.isRunning()) {
					pause();
				} else {
					tm.start();
					settingsPanel.playButton.setText("Pause");
				}
				
			}
			
		});
	}
	
	private void setClearButton() {
		settingsPanel.clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//tablePanel.clearBoard();
				pause();
				/*remove(tablePanel);
				tablePanel = new TablePanel(sizeDialog.getTableWidth(), sizeDialog.getTableHeight(), numOfStates);
				add(tablePanel);*/
				tablePanel.clearBoard();
			}
			
		});
	}
	
	private void savePNG(File f) {
		BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		tablePanel.paintAll(g);
		try {
			ImageIO.write(image, "png", f);
		} catch(Exception e) {
			;
		}
	}
	
	private void setSpeedSlider() {
		settingsPanel.speedSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				tm.setDelay(settingsPanel.speedSlider.getValue());
				settingsPanel.speedLabel.setText("Delay: "+settingsPanel.speedSlider.getValue()+"ms");
			}
		});
	}
	
	private void setOpenButton() {
		settingsPanel.openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				int returnVal = fc.showOpenDialog(CellularAutomaton.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            
		        }
			}
			
		});
	}
	
	private void setSaveButton() {
		settingsPanel.saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				int returnVal = fc.showSaveDialog(CellularAutomaton.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            
		        }
			}
			
		});
	}
	
	private void setPngButton() {
		settingsPanel.pngButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				int returnVal = fc.showSaveDialog(CellularAutomaton.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            savePNG(file);
		        }
			}
			
		});
	}
	
	private void setSizeButton() {
		settingsPanel.sizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				sizeDialog.setVisible(true);
				if(sizeDialog.isOK()) {
					if(sizeDialog.getTableHeight() == tablePanel.getNumOfRows() && sizeDialog.getTableWidth() == tablePanel.getNumOfCols()) {
						tablePanel.clearBoard();
					} else {
						remove(tablePanel);
						tablePanel = new TablePanel(sizeDialog.getTableWidth(), sizeDialog.getTableHeight(), numOfStates);
						add(tablePanel);
						settingsPanel.setTableSize(sizeDialog.getTableWidth(), sizeDialog.getTableHeight());
					}
				}
				sizeDialog.setOk(false);
			}
			
		});
	}
	
	private void setNghbCombo() {
		settingsPanel.nghbCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				String opt = settingsPanel.nghbCombo.getSelectedItem().toString();
				tablePanel.clearBoard();
				tablePanel.setNeighbourhood(opt);
			}
			
		});
	}
	
	private void setBoundCombo() {
		settingsPanel.boundCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				String opt = settingsPanel.boundCombo.getSelectedItem().toString();
				tablePanel.clearBoard();
				tablePanel.setBoundary(opt);
			}
			
		});
	}
	
	private void setRulesCombo() {
		settingsPanel.rulesCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				String opt = settingsPanel.rulesCombo.getSelectedItem().toString();
				tablePanel.clearBoard();
				if(opt.equals("Own rules")) {
					settingsPanel.ownRulesButton.setEnabled(true);
				} else {
					settingsPanel.ownRulesButton.setEnabled(false);
					tablePanel.setRules(opt);
					switch(opt) {
						case "Wireworld":
							numOfStates = 4;
							break;
						default:
							numOfStates = 2;
					}
				}
			}
			
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//tablePanel.setRandomBoard();
		//tablePanel.nextGeneration();
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CellularAutomaton();
            }
        });
	}
}