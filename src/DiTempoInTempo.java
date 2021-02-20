import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiTempoInTempo {
		protected static final JComboBox box = null;
		protected static final JComboBox box1 = null;
	public static void main(String[] args) {
		final ComboBoxFrame frame = new ComboBoxFrame();
		frame.getContentPane().setMaximumSize(new Dimension(2147483647, 50));
		frame.getContentPane().setLayout(
				new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent arg0) {
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ComboBoxFrame extends JFrame{
	public ComboBoxFrame() {
		setTitle("DiTempoInTempo");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		box = new JComboBox();
		box.setForeground(Color.BLACK);
		box.setEditable(true);
		box1 = new JComboBox();
		
		try {
			File fil = new File("MesiStagioni.txt");
			Scanner sc = new Scanner(fil);
			while(sc.hasNextLine()) {
				final String data = sc.nextLine();
				
				box.addItem(data);
				box1.addItem(data);
				box1.setVisible(false);
				box.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						box1.setVisible(true);
						if(box.getSelectedIndex() == 0 || box.getSelectedIndex() == 1) {
							box1.setSelectedIndex(12);
							box1.setBackground(Color.GRAY);
						}
						if(box.getSelectedIndex() == 2) {
							box1.setSelectedIndex(13);
							box1.setBackground(Color.LIGHT_GRAY);
						}
						if(box.getSelectedIndex() == 3 || box.getSelectedIndex() == 4) {
							box1.setSelectedIndex(14);
							box1.setBackground(Color.GREEN);
						}
						if(box.getSelectedIndex() == 5) {
							box1.setSelectedIndex(15);
							box1.setBackground(Color.PINK);
						}
						if(box.getSelectedIndex() == 6 || box.getSelectedIndex() == 7) {
							box1.setSelectedIndex(16);
							box1.setBackground(Color.YELLOW);
						}
						if(box.getSelectedIndex() == 8) {
							box1.setSelectedIndex(17);
							box1.setBackground(Color.ORANGE);
						}
						if(box.getSelectedIndex() == 9 || box.getSelectedIndex() == 10) {
							box1.setSelectedIndex(18);
							box1.setBackground(Color.magenta);
						}
						if(box.getSelectedIndex() == 11) {
							box1.setSelectedIndex(19);
							box1.setBackground(Color.LIGHT_GRAY);
						}
						
					}
				});
			}
		}catch(Exception e) {
			System.out.println("Errore");
			e.printStackTrace();
		}
		JPanel comboPanel = new JPanel();
		comboPanel.add(box);
		comboPanel.add(box1);
		add(comboPanel, BorderLayout.SOUTH );
	}
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 80;
	private JComboBox box;
	private JComboBox box1;
	
	private static final int DEFAULT_SIZE = 12;
}