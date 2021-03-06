package pl.edu.pw.iem;

import pl.edu.pw.iem.graphics.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;

public class CellularAutomaton extends JFrame {

	private static final long serialVersionUID = 1L;
	private Timer tm;
	private Timer paintTimer;
	private TablePanel tablePanel;
	private SettingsPanel settingsPanel;
	private JFileChooser fc = new JFileChooser();
	private SkipDialog skipDialog = new SkipDialog(this);
	private SizeDialog sizeDialog = new SizeDialog(this);
	private RulesDialog rulesDialog = new RulesDialog(this);

	private int numOfStates = 4;
	private final int DEF_SIZE = 30;

	public CellularAutomaton() {
		setTitle("pl.edu.pw.iem.CellularAutomaton");
		setSize(810, 640);
		setBackground(Color.DARK_GRAY);
		
		try {
			
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException ignored) {
			;
		}

		settingsPanel = new SettingsPanel();
		setPlayButton();
		setClearButton();
		setSkipButton();
		setSpeedSlider();
		setOpenButton();
		setSaveButton();
		setPngButton();
		setSizeButton();
		setNghbCombo();
		setBoundCombo();
		setRulesCombo();
		setRulesButton();
		setAddLogicGateCombo();
		setAddLogicGateButton();
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
				try {
					tablePanel.nextGeneration();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null,
							"Oh no!\nThe automaton has crushed :(...");
				}
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
				if (tm.isRunning()) {
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
				pause();
				tablePanel.clearBoard();
			}

		});
	}
	
	private void setSkipButton() {
		settingsPanel.skipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				paintTimer.stop();
				skipDialog.setVisible(true);
				if (skipDialog.isOK()) {
					try {
						for(int i=0; i<skipDialog.numOfGenToSkip(); i++) {
							tablePanel.nextGeneration();
						}
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(null,
								"Oh no!\nThe automaton has crushed :(...");
					}
				}
				skipDialog.setOk(false);
				paintTimer.start();
			}

		});
	}

	private void savePNG(File f) {
		BufferedImage image = new BufferedImage(600, 600,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		tablePanel.paintAll(g);
		try {
			ImageIO.write(image, "png", f);
		} catch (Exception e) {
			;
		}
	}

	private void setSpeedSlider() {
		settingsPanel.speedSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				tm.setDelay(settingsPanel.speedSlider.getValue());
				settingsPanel.speedLabel.setText("Delay: "
						+ settingsPanel.speedSlider.getValue() + "ms");
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
					TableReader tabReader = new TableReader(file.getPath(), numOfStates);
					
					try {
						tabReader.readFromFile();
						if(tabReader.getWidth() != tablePanel.getNumOfRows() && tabReader.getHeight() != tablePanel.getNumOfCols()) {
						remove(tablePanel);
						tablePanel = new TablePanel(tabReader.getWidth(),
								tabReader.getHeight(), numOfStates);
						add(tablePanel);
						}
						tablePanel.setBoard(tabReader.getBoard());
						settingsPanel.setTableSize(tabReader.getWidth(),
								tabReader.getHeight());
						String opt = settingsPanel.nghbCombo.getSelectedItem()
								.toString();
						tablePanel.setNeighbourhood(opt);
						opt = settingsPanel.boundCombo.getSelectedItem()
								.toString();
						tablePanel.setBoundary(opt);
						opt = settingsPanel.rulesCombo.getSelectedItem()
								.toString();
						if (opt.equals("Own rules")) {
							settingsPanel.ownRulesButton.setEnabled(true);
						} else {
							settingsPanel.ownRulesButton.setEnabled(false);
							tablePanel.setRules(opt);
							switch (opt) {
							case "Game Of Life":
								numOfStates = 2;
								break;
							default:
								numOfStates = 4;
							}
						}
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(null, "Can't read file!");
					}

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
					TableSaver tabSaver = new TableSaver(file.getPath(), tablePanel.getNumOfRows(), tablePanel.getNumOfCols(), tablePanel.getBoard());
					try {
						tabSaver.saveToFile();
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "Can't write file!");
					}
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
				if (sizeDialog.isOK()) {
					if (sizeDialog.getTableHeight() == tablePanel
							.getNumOfRows()
							&& sizeDialog.getTableWidth() == tablePanel
									.getNumOfCols()) {
						tablePanel.clearBoard();
					} else {
						remove(tablePanel);
						tablePanel = new TablePanel(sizeDialog.getTableWidth(),
								sizeDialog.getTableHeight(), numOfStates);
						add(tablePanel);
						settingsPanel.setTableSize(sizeDialog.getTableWidth(),
								sizeDialog.getTableHeight());
						String opt = settingsPanel.nghbCombo.getSelectedItem()
								.toString();
						tablePanel.setNeighbourhood(opt);
						opt = settingsPanel.boundCombo.getSelectedItem()
								.toString();
						tablePanel.setBoundary(opt);
						opt = settingsPanel.rulesCombo.getSelectedItem()
								.toString();
						tablePanel.clearBoard();
						if (opt.equals("Own rules")) {
							settingsPanel.ownRulesButton.setEnabled(true);
						} else {
							settingsPanel.ownRulesButton.setEnabled(false);
							tablePanel.setRules(opt);
							switch (opt) {
							case "Game Of Life":
								numOfStates = 2;
								break;
							default:
								numOfStates = 4;
							}
						}
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
				String opt = settingsPanel.nghbCombo.getSelectedItem()
						.toString();
				tablePanel.setNeighbourhood(opt);
			}

		});
	}

	private void setBoundCombo() {
		settingsPanel.boundCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				String opt = settingsPanel.boundCombo.getSelectedItem()
						.toString();
				tablePanel.setBoundary(opt);
			}

		});
	}

	private void setRulesCombo() {
		settingsPanel.rulesCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				String opt = settingsPanel.rulesCombo.getSelectedItem()
						.toString();
				tablePanel.clearBoard();
				if (opt.equals("Own rules")) {
					settingsPanel.ownRulesButton.setEnabled(true);

				} else {
					settingsPanel.ownRulesButton.setEnabled(false);
					tablePanel.setRules(opt);
					
					if(opt.equals("Wireworld")) {
						settingsPanel.addLogicGateButton.setEnabled(true);
						settingsPanel.addLogicGateButton.setVisible(true);
						settingsPanel.addLogicGateCombo.setEnabled(true);
						settingsPanel.addLogicGateCombo.setVisible(true);
						settingsPanel.addLogicGateLabel.setVisible(true);
					} else {
						settingsPanel.addLogicGateButton.setEnabled(false);
						settingsPanel.addLogicGateButton.setVisible(false);
						settingsPanel.addLogicGateCombo.setEnabled(false);
						settingsPanel.addLogicGateCombo.setVisible(false);
						settingsPanel.addLogicGateLabel.setVisible(false);
					}
					
					switch (opt) {
					case "Game Of Life":
						numOfStates = 2;
						break;
					default:
						numOfStates = 4;
					}
				}
			}

		});
	}

	private void setRulesButton() {
		settingsPanel.ownRulesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				rulesDialog.setVisible(true);
				if (rulesDialog.isOK()) {
					try {
						tablePanel.setRules(rulesDialog.getRules(), rulesDialog.getNumberOfStates());
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(null, "Your rules cannot be runned :(\nPlease refer to the specification.");
						settingsPanel.rulesCombo.setSelectedIndex(0);
					}
				}
				rulesDialog.setOK(false);
			}

		});
	}
	
	private void setAddLogicGateCombo() {
		settingsPanel.addLogicGateCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				String opt = settingsPanel.addLogicGateCombo.getSelectedItem()
						.toString();
				tablePanel.setGateName(opt);
			}
		});
	}
	
	private void setAddLogicGateButton() {
		settingsPanel.addLogicGateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				tablePanel.setAddGateMode(true);
			}
		});
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CellularAutomaton();
			}
		});
	}
}