package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: Terminate.java
 *
 * purpose: simulates terminate event for greenhouse control
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import test.GHCGui;

import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.TextArea;

public class GCGui {

    private JFrame frmGreenhouseControls;
    private JTextField fileTxtFld;
    String eventFile;
    GreenhouseControls ghc;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GCGui window = new GCGui();
		    window.frmGreenhouseControls.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public GCGui() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	
	//application frame
	frmGreenhouseControls = new JFrame();
	frmGreenhouseControls.setTitle("Greenhouse Controls");
	frmGreenhouseControls.setBounds(100, 100, 584, 300);
	frmGreenhouseControls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmGreenhouseControls.getContentPane().setLayout(null);
	
	fileTxtFld = new JTextField();
	fileTxtFld.setText("Select File to Open");
	fileTxtFld.setEditable(false);
	fileTxtFld.setEnabled(false);
	fileTxtFld.setBounds(83, 11, 472, 20);
	frmGreenhouseControls.getContentPane().add(fileTxtFld);
	fileTxtFld.setColumns(10);
	
	JLabel lblEventsFile = new JLabel("Events File:");
	lblEventsFile.setBounds(10, 14, 89, 15);
	frmGreenhouseControls.getContentPane().add(lblEventsFile);
	
	TextArea textAreaOut = new TextArea();
	textAreaOut.setEnabled(false);
	textAreaOut.setText("enter file");
	textAreaOut.setBounds(10, 40, 545, 160);
	frmGreenhouseControls.getContentPane().add(textAreaOut);
	
	//buttons
	JButton btnStart = new JButton("Start");
	btnStart.setEnabled(false);
	btnStart.setBounds(10, 206, 100, 23);
	frmGreenhouseControls.getContentPane().add(btnStart);
	
	JButton btnRestart = new JButton("Restart");
	btnRestart.setEnabled(false);
	btnRestart.setBounds(125, 206, 100, 23);
	frmGreenhouseControls.getContentPane().add(btnRestart);
	
	JButton btnTerminate = new JButton("Terminate");
	btnTerminate.setEnabled(false);
	btnTerminate.setBounds(235, 206, 100, 23);
	frmGreenhouseControls.getContentPane().add(btnTerminate);
	
	JButton btnSuspend = new JButton("Suspend");
	btnSuspend.setEnabled(false);
	btnSuspend.setBounds(345, 206, 100, 23);
	frmGreenhouseControls.getContentPane().add(btnSuspend);
	
	JButton BtnResume = new JButton("Resume");
	BtnResume.setEnabled(false);
	BtnResume.setBounds(455, 206, 100, 23);
	frmGreenhouseControls.getContentPane().add(BtnResume);
	
	
	
	
	//pop up menu
	JPopupMenu popupMenu = new JPopupMenu();
	addPopup(frmGreenhouseControls, popupMenu);
	
	JMenuItem mntmStart = new JMenuItem("Start");
	popupMenu.add(mntmStart);
	
	JMenuItem mntmRestart = new JMenuItem("Restart");
	popupMenu.add(mntmRestart);
	
	JSeparator separator = new JSeparator();
	popupMenu.add(separator);
	
	JMenuItem mntmTerminate = new JMenuItem("Terminate");
	popupMenu.add(mntmTerminate);
	
	JSeparator separator_1 = new JSeparator();
	popupMenu.add(separator_1);
	
	JMenuItem mntmSuspend = new JMenuItem("Suspend");
	popupMenu.add(mntmSuspend);
	
	JMenuItem mntmResume = new JMenuItem("Resume");
	popupMenu.add(mntmResume);
	
	
	//menu bar items
	JMenuBar menuBar = new JMenuBar();
	frmGreenhouseControls.setJMenuBar(menuBar);
	
	JMenu mnFile = new JMenu("File");
	menuBar.add(mnFile);
	
	JMenuItem mntmNewWindow = new JMenuItem("New Window", KeyEvent.VK_N);
	mnFile.add(mntmNewWindow);
	
	JMenuItem mntmCloseWindow = new JMenuItem("Close Window", KeyEvent.VK_C);
	mntmCloseWindow.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    int result = JOptionPane.showConfirmDialog(frmGreenhouseControls, "are you sure", "Close app", JOptionPane.YES_NO_OPTION);
//			int result = JOptionPane.showConfirmDialog(
//				GCGui.this, "The Controller is currently running, Do you want to exit?", "EXIT?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(result == 0){
			    frmGreenhouseControls.dispose();	
			}	
		}
	});
	mnFile.add(mntmCloseWindow);
	//mnFile.addActionListener(new CloseWindow());
	
	JSeparator separator_2 = new JSeparator();
	mnFile.add(separator_2);
	
	JMenuItem mntmOpenEventsFile = new JMenuItem("Open Events File", KeyEvent.VK_O);
	mnFile.add(mntmOpenEventsFile);
	mntmOpenEventsFile.addActionListener(new OpenEventsFile());
	
	JMenuItem mntmLoadDumpFile = new JMenuItem("Load Dump File", KeyEvent.VK_L);
	mnFile.add(mntmLoadDumpFile);
	mntmLoadDumpFile.addActionListener(new OpenDumpFile());
	
	JSeparator separator_3 = new JSeparator();
	mnFile.add(separator_3);
	
	JMenuItem mntmExit = new JMenuItem("Exit", KeyEvent.VK_X);
	mnFile.add(mntmExit);
	
	
    }
    
    //pop up menu listener
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}//end popUpMenu
	
	//open events file
	class OpenEventsFile implements ActionListener{
	    JFileChooser openFileChooser;
	    
	    String event;
	    
	    public void actionPerformed(ActionEvent e) {
		openFileChooser = new JFileChooser();
		int chooserState = openFileChooser.showOpenDialog(frmGreenhouseControls);
		
		if(chooserState == JFileChooser.APPROVE_OPTION) {
		    eventFile = openFileChooser.getCurrentDirectory().toString() + "/" + 
		openFileChooser.getSelectedFile().getName();
		fileTxtFld.setText(eventFile);
		
	//	textAreaOut.setText();
		try {
		
		    //check if file is valid
		    
		    BufferedReader in = new BufferedReader(new FileReader(eventFile));
		    
		    while((event = in.readLine()) != null) {
			Scanner scan = new Scanner(event);
			//event = scan.nextLine() + "\n" + outputTxtFld.getText();
			event = scan.nextLine()+ "\n";
			System.out.println(event);
	//		outputTxtFld.setText(event + "\n");
		    }
		}catch(Exception exc) {
		    eventFile = "";
		//    outputTxtFld.setText("Invalid File\n" + exc.toString());
		    
		}
		
		
	    }//end if
	}//end actionListener
	
}//end openEventsFile

	//open dump file
	class OpenDumpFile implements ActionListener{
	    JFileChooser openFileChooser;
	    
	    String event;
	    
	    public void actionPerformed(ActionEvent e) {
		openFileChooser = new JFileChooser();
		int chooserState = openFileChooser.showOpenDialog(frmGreenhouseControls);
		
		if(chooserState == JFileChooser.APPROVE_OPTION) {
		    eventFile = openFileChooser.getCurrentDirectory().toString() + "/" + 
		openFileChooser.getSelectedFile().getName();
		fileTxtFld.setText(eventFile);
		
		try {
	//	    outputTxtFld.setText("");
		    //check if file is valid
		    
		    BufferedReader in = new BufferedReader(new FileReader(eventFile));
		    
		    while((event = in.readLine()) != null) {
			Scanner scan = new Scanner(event);
			//event = scan.nextLine() + "\n" + outputTxtFld.getText();
			event = scan.nextLine()+ "\n";
			System.out.println(event);
		//	outputTxtFld.setText(event);;
		    }
		}catch(Exception exc) {
		    eventFile = "";
		//    outputTxtFld.setText(exc.toString());
		}
		
		
	    }//end if
	}//end actionListener
	
	}//end OpenDumpFile
	
	//Class that handles Closing a GUI Window
	class CloseWindow implements ActionListener {
	
		public void actionPerformed(ActionEvent e){
		    
			int result = JOptionPane.showConfirmDialog(frmGreenhouseControls, "are you sure", "Close app", JOptionPane.YES_NO_OPTION);
//				int result = JOptionPane.showConfirmDialog(
//					GCGui.this, "The Controller is currently running, Do you want to exit?", "EXIT?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(result == 0){
				    frmGreenhouseControls.dispose();	
				}	
			}
//			else{
//			    frmGreenhouseControls.dispose();
//			}			
		
	}//end close window
}
