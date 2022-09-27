package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileSelectorFrame extends JFrame implements ActionListener {
    JButton button;
    File file;

    public FileSelectorFrame() {
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(new FlowLayout());

	button = new JButton("Select file");
	button.addActionListener(this);

	this.add(button);
	this.pack();
	this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == button) {
	    JFileChooser fileChooser = new JFileChooser();
	    int response = fileChooser.showOpenDialog(null);

	    if (response == JFileChooser.APPROVE_OPTION) {
		this.file = new File(fileChooser.getSelectedFile().getAbsolutePath());
		System.out.println(file);
	    }

	}
    }

    public File getFile() {
	return file;
    }

}
