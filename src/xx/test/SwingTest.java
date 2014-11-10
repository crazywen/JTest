package xx.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingTest {

	private static void createAndShowGUI() {

		JFrame jf = new JFrame("hello world!");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = jf.getContentPane();
		container.setLayout(new FlowLayout());

		// JButton jb = new JButton("click me!");
		// JButton jb1 = new JButton("shit");
		//
		// container.add(jb);
		// container.add(jb1);

		container.add(new ButtonPanel());
		// jb.addActionListener(l);

		jf.pack();
		jf.setVisible(true);

	}

	/**
	 * JPanel with Event Handling
	 */
	static class ButtonPanel extends JPanel {
		public ButtonPanel() {
			JButton yellowButton = new JButton("Yellow");
			JButton redButton = new JButton("Red");

			this.add(yellowButton);
			this.add(redButton);

			/**
			 * register ActionListeners
			 */
			ColorAction yellowAction = new ColorAction(Color.yellow);
			ColorAction redAction = new ColorAction(Color.red);

			yellowButton.addActionListener(yellowAction);
			redButton.addActionListener(redAction);
		}

		/**
		 * ActionListener as an inner class
		 */
		private class ColorAction implements ActionListener {
			public ColorAction(Color c) {
				backgroundColor = c;
			}

			/**
			 * Actions
			 */
			public void actionPerformed(ActionEvent event) {
				setBackground(backgroundColor); // outer object, JPanel method
				repaint();
			}

			private Color backgroundColor;
		}
	}

	public static void main(String[] args) {

		Runnable run = new Runnable() {

			@Override
			public void run() {
				createAndShowGUI();
			}
		};

		SwingUtilities.invokeLater(run);

	}
}
