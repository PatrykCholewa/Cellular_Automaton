package pl.edu.pw.iem.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SizeDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel widthLabel, heightLabel, infoLabel;
	private JTextField widthField, heightField;
	private JButton okButton, cancelButton;
	private boolean dataOk = false;
	
	public SizeDialog(JFrame owner) {
		super(owner, "Change size", true);
		setSize(300, 250);
		setResizable(false);
		setLayout(null);
		
		infoLabel = new JLabel("Enter new size (max 600x600):", JLabel.CENTER);
		infoLabel.setBounds(45, 15, 220, 30);
		add(infoLabel);
		
		widthLabel = new JLabel("Width:", JLabel.RIGHT);
		widthLabel.setBounds(45, 60, 65, 25);
		add(widthLabel);
		
		widthField = new JTextField();
		widthField.setBounds(125, 60, 100, 25);
		add(widthField);
		
		heightLabel = new JLabel("Height:", JLabel.RIGHT);
		heightLabel.setBounds(45, 100, 65, 25);
		add(heightLabel);
		
		heightField = new JTextField();
		heightField.setBounds(125, 100, 100, 25);
		add(heightField);
		
		okButton = new JButton("OK");
		okButton.setBounds(165, 150, 100, 30);
		okButton.addActionListener(this);
		add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(35, 150, 100, 30);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		
	}
	
	public int getTableWidth() {
		int w;
		try {
			w = Integer.parseInt(widthField.getText());
		} catch (Exception e) {
			w = 30;
		}
		
		if(w > 600) {
			w = 600;
		}
		
		if(w <= 0) {
			w = 1;
		}
		
		return w;
	}
	
	public int getTableHeight() {
		int h;
		try {
			h = Integer.parseInt(heightField.getText());
		} catch (Exception e) {
			h = 30;
		}
		
		if(h > 600) {
			h = 600;
		}
		
		if(h <= 0) {
			h = 1;
		}
		
		return h;
	}
	
	public boolean isOK() {
		return this.dataOk;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==okButton) {
			dataOk = true;
		}
		if(o==cancelButton) {
			dataOk = false;
		}
		
		setVisible(false);
	}

	public void setOk(boolean b) {
		dataOk = b;
		
	}

}
