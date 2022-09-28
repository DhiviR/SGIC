package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSelectorFrame extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
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
	    fileChooser.setCurrentDirectory(new File("C:\\Users\\hp\\Desktop"));
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
	    fileChooser.setFileFilter(filter);
	    int response = fileChooser.showOpenDialog(null);

	    if (response == JFileChooser.APPROVE_OPTION) {
		this.file = fileChooser.getSelectedFile();
		System.out.println(file);
	    }

	}
    }

    public File getFile() {
	return file;
    }

}
