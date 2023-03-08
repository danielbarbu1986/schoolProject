package variableExercises;

import java.awt.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class variableExercises extends JFrame implements ActionListener {
private JTextArea textArea;
private JButton openButton;
private JButton saveButton;
private JFileChooser fileChooser;

public variableExercises() {
super("File Reader GUI");
setLayout(new BorderLayout());


//Create the menu bar
JMenuBar menuBar = new JMenuBar();

//Create the File menu
JMenu fileMenu = new JMenu("File");
//Add Save menu item to the File menu
JMenuItem saveMenuItem = new JMenuItem("Save");
saveMenuItem.addActionListener(e -> saveFile());

fileMenu.add(saveMenuItem);
fileMenu.addSeparator();

//Add the File menu to the menu bar
menuBar.add(fileMenu);

//Set the menu bar of the frame
setJMenuBar(menuBar);


// creeate  text area
textArea = new JTextArea(30, 80);
JScrollPane scrollPane = new JScrollPane(textArea);
add(scrollPane, BorderLayout.CENTER);

// create open button
openButton = new JButton("Open");
openButton.addActionListener(this);

// Create save button
saveButton = new JButton("Save");
saveButton.addActionListener(this);

// Create file chooser
fileChooser = new JFileChooser();

// Add buttons to panel
JPanel buttonPanel = new JPanel(new FlowLayout());
buttonPanel.add(openButton);
buttonPanel.add(saveButton);
add(buttonPanel, BorderLayout.NORTH);

// Set frame properties
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pack();
setVisible(true);
}

public void actionPerformed(ActionEvent e) {
if (e.getSource() == openButton) {
int returnVal = fileChooser.showOpenDialog(this);

if (returnVal == JFileChooser.APPROVE_OPTION) {
File file = fileChooser.getSelectedFile();
try {
FileReader reader = new FileReader(file);
BufferedReader br = new BufferedReader(reader);
String line = null;
while ((line = br.readLine()) != null) {
textArea.append(line + "\n");
}
br.close();
reader.close();
} catch (IOException ex) {
ex.printStackTrace();
}
}
} else if (e.getSource() == saveButton) {
int returnVal = fileChooser.showSaveDialog(this);

if (returnVal == JFileChooser.APPROVE_OPTION) {
File file = fileChooser.getSelectedFile();
try {
FileWriter writer = new FileWriter(file);
writer.write(textArea.getText());
writer.close();
} catch (IOException ex) {
ex.printStackTrace();
}
}
}
}



public static void main(String[] args) {
new variableExercises();
}


private void saveFile() {
	// Prompt the user to choose a file to save
	JFileChooser chooser = new JFileChooser();
	int result = chooser.showSaveDialog(this);
	if (result != JFileChooser.APPROVE_OPTION) {
	return;
	}
	// Save the text in the text area to the selected file
	try (ObjectOutputStream out = new ObjectOutputStream(
	new FileOutputStream(chooser.getSelectedFile()))) {
	out.writeObject(textArea.getText());

	// Add a menu item for the saved file
	JMenuItem savedMenuItem = new JMenuItem(chooser.getSelectedFile().getName());
	
	/*
	// Get the name of the file from the selected menu item
	String fileName = savedMenuItem.toString();
	
	try {
		// Create a new File object with the specified file name
		File file = new File(fileName);

		// Create a new FileReader object to read the contents of the file
		FileReader reader = new FileReader(file);

		// Create a new BufferedReader object to improve the performance of reading large files
		BufferedReader bufferedReader = new BufferedReader(reader);

		// Use a StringBuilder to store the contents of the file
		StringBuilder stringBuilder = new StringBuilder();

		// Read each line of the file and append it to the StringBuilder
		String line;
		while ((line = bufferedReader.readLine()) != null) {
		stringBuilder.append(line);
		stringBuilder.append(System.lineSeparator());
		}

		// Close the BufferedReader and FileReader objects
		bufferedReader.close();
		reader.close();

		// Print the contents of the file
		System.out.println(stringBuilder.toString());

		} catch (IOException e) {
		// Handle the exception if the file cannot be read
		e.printStackTrace();
		}
	*/
	
	JMenu fileMenu = getJMenuBar().getMenu(0);
	fileMenu.add(savedMenuItem);
	} catch (Exception ex) {
	JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(),
	"Error", JOptionPane.ERROR_MESSAGE);
	}
}
	
}