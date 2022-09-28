package functions;

import java.io.File;
import java.io.FileNotFoundException;

import GUI.FileSelectorFrame;

public class Main {

    public static void main(String[] args) {
	FileSelectorFrame frame = new FileSelectorFrame();

	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	File file = frame.getFile();
	InsertDataUsingCSV insertDataUsingCSV = new InsertDataUsingCSV();

	try {
	    insertDataUsingCSV.insertData(file);
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	frame.setVisible(false);
    }

}
