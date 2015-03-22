package mapMyCampusODU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;



public class DirectClass extends JFrame
{
	
	private JPanel nav, northPanel, organizationPanel, innerPanel;
	private JLabel abbrv, rmNum, img;
	ButtonListenerClass buttonListener;
	private JButton back, checkin;
	private JComboBox bBox;
	private JTextField rmText;
	private String selection, loc;
	private int points, lvl;
	private int a,b,c,d,e;
	
	public DirectClass(int pts, int p_lvl, String p_loc, int p_a, int p_b, int p_c, int p_d, int p_e)
    {
        super("Old Dominion University Campus Direct");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lvl = p_lvl;
        loc = p_loc;
        
        a= p_a;
        b= p_b;
        c= p_c;
        d= p_d;
        e= p_e;
        points = pts;
        buttonListener = new ButtonListenerClass();
        
        nav = new JPanel();
        nav.setLayout(new GridLayout(1,4));
        
        
        nav = new JPanel();
        nav.setBackground(Color.WHITE);
        nav.setLayout(new GridLayout(1,1));
        setUpNav();
        
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.WHITE);
        northPanel.add(new JLabel(new ImageIcon("ODUlogo4.png")), BorderLayout.CENTER);
        northPanel.add(nav, BorderLayout.EAST);
    	
    	add(northPanel, BorderLayout.NORTH);
    	
    	organizationPanel = new JPanel();
    	organizationPanel.setLayout(new BorderLayout());
    	
    	organizationPanel.setBorder(new TitledBorder(null, "Campus Directory", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, 
				new Font ( "Verdana", Font.BOLD, 16 ), Color.BLACK));
    	
    	innerPanel = new JPanel();
    	innerPanel.setLayout(new GridLayout(2,1));
    	
    	img = new JLabel(new ImageIcon ("pic.png"));
    	
    	ComboListenerClass comboListener = new ComboListenerClass();
    	
    	String[] abbreviations = {"No Selection","ALFRN", "BAL", "CONST", "DIEHN","DRGS","ECSB", "ED", "ESB", "MGB","OCNPS","VAB"};
    	bBox = new JComboBox(abbreviations);
    	bBox.addItemListener(comboListener);
    	
    	checkin = new JButton("Check In +10 pts");
		checkin.addActionListener(buttonListener);
		
    	abbrv = new JLabel("Select Building Abbreviation:");
      rmNum = new JLabel("Enter the Room Number (Optional):");
      rmText = new JTextField();
      
      innerPanel.add(abbrv);
      innerPanel.add(bBox);
     // innerPanel.add(rmNum);
      
      
      organizationPanel.add(innerPanel, BorderLayout.NORTH);
      organizationPanel.add(img, BorderLayout.CENTER);
      organizationPanel.add(checkin, BorderLayout.SOUTH);
      add(organizationPanel);
      
      
        //pack();
      	setSize(1000, 750);
      	setLocationRelativeTo(null);
        setVisible(true);
    }
	
	
	
	
	
	public void setUpNav()
	{
		back = new JButton("Return to Menu");
		back.addActionListener(buttonListener);
		
		
		nav.add(back);
	}
	
	private class ButtonListenerClass implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent button) 
		{
			if("Return to Menu".equals(button.getActionCommand()))
			{
				dispose();
	            new MapClass(points, lvl, loc, a, b, c,d,e);
			}
			
			if("Check In +10 pts".equals(button.getActionCommand()))
			{
				if (bBox.getSelectedItem() != "No Selection")
				{
				loc = (String) bBox.getSelectedItem();
				points+=10;
				}
			}
		

		}

	}
	
	private class ComboListenerClass implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent comboBox)
		{			
			//debug statement
			System.out.println("The garage combobox is functioning properly.");

			//get the input
			selection = (String) bBox.getSelectedItem();

			//debug statement
			System.out.println(selection);


			if (selection.equals("No Selection"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("pic.png"));
				img.revalidate();
				img.repaint();
			}
			 
			if (selection.equals("ALFRN"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("alfn.png"));
				img.revalidate();
				img.repaint();

			}
			if (selection.equals("BAL"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("bal.png"));
				img.revalidate();
				img.repaint();

			}
			if (selection.equals("CONST"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("const.png"));
				img.revalidate();
				img.repaint();

			}
			if (selection.equals("DIEHN"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("diehn.png"));
				img.revalidate();
				img.repaint();

			}
			if (selection.equals("DRGS"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("drgs.png"));
				img.revalidate();
				img.repaint();

			}
			if (selection.equals("ECSB"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("ecsb.png"));
				img.revalidate();
				img.repaint();

			}
			if (selection.equals("ED"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("educ.png"));
				img.revalidate();
				img.repaint();
				
			}
			if (selection.equals("ESB"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("esb.png"));
				img.revalidate();
				img.repaint();
				
			}
			if (selection.equals("MGB"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("mgb.png"));
				img.revalidate();
				img.repaint();
				
			}
			if (selection.equals("OCNPS"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("ocnps.png"));
				img.revalidate();
				img.repaint();
				
			}
			if (selection.equals("VAB"))
			{
				img.removeAll();
				img.revalidate();
				img.repaint();
				img.setIcon(new ImageIcon ("vab.png"));
				img.revalidate();
				img.repaint();
				
			}
		}
	}
}
