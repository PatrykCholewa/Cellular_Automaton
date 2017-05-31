import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RulesDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton cancelButton;
	private JButton okButton;
	private JButton nextButton;
	private JTextArea previewArea;
	private JLabel stateLabel;
	private JTextField AField;
	private JLabel label1;
	private JTextField BField;
	private JLabel label2;
	private JTextField CField;
	private JLabel label3;
	private JTextField DField;
	private int numOfStates = 0;
	private String rules[];
	private boolean ok = false;
	
	public RulesDialog(JFrame owner) {
		super(owner, "Rules Editor", true);
		setSize(400, 375);
		setResizable(false);
		setLayout(null);
		
		previewArea = new JTextArea();
		previewArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(previewArea);
		scrollPane.setBounds(10, 10, 380, 150);
		add(scrollPane);
		
		stateLabel = new JLabel(numOfStates+" :", JLabel.RIGHT);
		stateLabel.setBounds(10, 180, 40, 20);
		add(stateLabel);
		
		AField = new JTextField();
		AField.setBounds(60, 180, 50, 20);
		add(AField);
		
		label1 = new JLabel("/", JLabel.CENTER);
		label1.setBounds(125, 180, 5, 20);
		add(label1);
		
		BField = new JTextField();
		BField.setBounds(145, 180, 50, 20);
		add(BField);
		
		label2 = new JLabel("/", JLabel.CENTER);
		label2.setBounds(210, 180, 5, 20);
		add(label2);
		
		CField = new JTextField();
		CField.setBounds(230, 180, 50, 20);
		add(CField);
		
		label3 = new JLabel("/", JLabel.CENTER);
		label3.setBounds(295, 180, 5, 20);
		add(label3);
		
		DField = new JTextField();
		DField.setBounds(315, 180, 50, 20);
		add(DField);
		
		nextButton = new JButton(">>");
		nextButton.setBounds(170, 230, 60, 30);
		nextButton.addActionListener(this);
		add(nextButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 290, 185, 35);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		okButton = new JButton("OK");
		okButton.setBounds(205, 290, 185, 35);
		okButton.addActionListener(this);
		add(okButton);
		
		previewArea.append("W trakcie budowy...\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == nextButton) {
			int a, b, c, d;
			try {
				a = Integer.parseInt(AField.getText());
			} catch (Exception exc) {
				a = 0;
			}
			try {
				b = Integer.parseInt(BField.getText());
			} catch (Exception exc) {
				b = 0;
			}
			try {
				c = Integer.parseInt(CField.getText());
			} catch (Exception exc) {
				c = 0;
			}
			try {
				d = Integer.parseInt(DField.getText());
			} catch (Exception exc) {
				d = 0;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(numOfStates+":  ");
			sb.append(a);
			sb.append("/");
			sb.append(b);
			sb.append("/");
			sb.append(c);
			sb.append("/");
			sb.append(d);
			sb.append("\n");
			
			previewArea.append(sb.toString());
			
			AField.setText("");
			BField.setText("");
			CField.setText("");
			DField.setText("");
			numOfStates++;
			stateLabel.setText(numOfStates+" :");
			
		}
		
		if(o == cancelButton) {
			this.ok = false;
			this.setVisible(false);
		}
		
		if(o == okButton) {
			JOptionPane.showMessageDialog(null, "Rules Editor jeszcze nie dziala :/\n");
			this.ok = true;
			this.setVisible(false);
		}
	}
	
	public void setOK(boolean k) {
		this.ok = k;
	}
	
	public boolean isOK() {
		return this.ok;
	}
	
	public String[] getRules() {
		return rules;
	}
	
	public int getNumberOfStates() {
		return numOfStates;
	}
	
}