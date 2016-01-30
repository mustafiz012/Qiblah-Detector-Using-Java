package ultimate;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame_Class extends JFrame  {
	private static final long serialVersionUID = 1L;

	Frame_Class()
	{
		super("Qiblah Compass");
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(create_menu_file());
		bar.add(create_menu_edit());
	}
	
	private JMenu create_menu_edit() {
		// 
		JMenu edit = new JMenu("Edit");
	    edit.setFont(new Font("Cambria",Font.ROMAN_BASELINE,20));
	    edit.setMnemonic('E');
	    edit.add(create_edit_menuitem_manual());
		return edit;
	}

	private JMenuItem create_edit_menuitem_manual() {
		// 
		JMenuItem manual = new JMenuItem("Manual Set");
		class MenuItemListener implements ActionListener
		{

			@Override
			public void actionPerformed(final ActionEvent e) {
				//JOptionPane.showInputDialog("Enter Latitude", "-90 to +90");
				//JOptionPane.showInputDialog(Main_Class.this,"c", 5);
				Panel_Class.manual();
		}
	}		
		final ActionListener l = new MenuItemListener();
		manual.addActionListener(l);
		return manual;
	}

	private JMenu create_menu_file() {
		// 
		JMenu file = new JMenu("File");
		file.setToolTipText("Its File Contents");
		//file.addSeparator();
		file.setMnemonic('F');
	    file.setFont(new Font("Cambria",Font.ROMAN_BASELINE,20));
		file.add(create_menuitem_for_file_nammed_exit());
		return file;
	}

	private JMenuItem create_menuitem_for_file_nammed_exit() {
		// 
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener
		{

			@Override
			public void actionPerformed(final ActionEvent arg0) {
				// 
				System.exit(0);
			}
			
		}
		final ActionListener l = new MenuItemListener();
		item.addActionListener(l);
		return item;
		
	}

	public static void main(String[] args) {
       
		 try {
				javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
				// 
				e.printStackTrace();
			} catch (InstantiationException e) {
				// 
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// 
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		Frame_Class frame = new Frame_Class();
		Panel_Class panel = new Panel_Class();
		
		//panel.setBackground(Color.WHITE);
		frame.add(panel);
		//panel.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		frame.setSize(1000, 720);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
