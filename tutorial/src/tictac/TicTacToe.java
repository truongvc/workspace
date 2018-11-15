package tictac;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {

	private JFrame frmTicTacToe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setBounds(100, 100, 500, 500);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicTacToe.getContentPane().setLayout(new GridLayout(3,3));
		
		JButton btn00 = new JButton("");
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn00.setText("hello");
			}
		});
		frmTicTacToe.getContentPane().add(btn00);
		
		JButton btn01 = new JButton("");
		frmTicTacToe.getContentPane().add(btn01);
		
		JButton btn02 = new JButton("");
		frmTicTacToe.getContentPane().add(btn02);
		
		JButton btn10 = new JButton("");
		frmTicTacToe.getContentPane().add(btn10);
		
		JButton btn11 = new JButton("");
		frmTicTacToe.getContentPane().add(btn11);
		
		JButton btn12 = new JButton("");
		frmTicTacToe.getContentPane().add(btn12);
		
		JButton btn20 = new JButton("");
		frmTicTacToe.getContentPane().add(btn20);
		
		JButton btn21 = new JButton("");
		frmTicTacToe.getContentPane().add(btn21);
		
		JButton btn22 = new JButton("");
		frmTicTacToe.getContentPane().add(btn22);
	}

}
