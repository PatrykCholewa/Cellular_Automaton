package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SkipDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel infoLabel;
	private JTextField skipField;
	private JButton okButton, cancelButton;
	private boolean dataOk = false;
	
	public SkipDialog(JFrame owner) {
		super(owner, "Skip generations", true);
		setSize(300, 210);
		setResizable(false);
		setLayout(null);
		
		infoLabel = new JLabel("Enter number of generations to skip:", JLabel.CENTER);
		infoLabel.setBounds(10, 20, 280, 30);
		add(infoLabel);
		
		skipField = new JTextField(JTextField.CENTER);
		skipField.setBounds(75, 60, 150, 25);
		add(skipField);
		
		okButton = new JButton("Skip");
		okButton.setBounds(165, 120, 100, 30);
		okButton.addActionListener(this);
		add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(35, 120, 100, 30);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		
	}
	
	public boolean isOK() {
		return this.dataOk;
	}
	
	public int numOfGenToSkip() {
		int a;
		
		try {
			a = Integer.parseInt(skipField.getText());
		} catch(Exception e) {
			a = 0;
		}
		
		if(a < 0) {
			a = 0;
		}
		
		return a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==okButton) {
			dataOk = true;
			try {
				if(Integer.parseInt(skipField.getText()) > 2000) {
					JOptionPane.showMessageDialog(null, "It may take a while.\nPlease be patient...");
				}
			} catch(Exception exc) {
				;
			}
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
