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





public class ParkingClass  extends JFrame
{

	private JPanel nav, northPanel;
	private JButton profileB, parkingB, campusDirectB, scheduleB, submitB, back;
	ButtonListenerClass buttonListener;

	private JPanel currentP, reportP, aP, bP, cP, dP, eP;
	private JLabel aLabel, bLabel, cLabel, dLabel, eLabel, aAvail, bAvail, cAvail, dAvail, eAvail, selGL, selCL, red, green, amber, tyLabel;
	private int aCond, bCond, cCond, dCond, eCond, rCond;
	private JComboBox gBox, cBox;
	private String gSel, cSel, loc;
	private char g;
	private int points, lvl;
	

	public ParkingClass(int pts, int p_lvl, String p_loc, int p_a, int p_b, int p_c, int p_d, int p_e)
	{
		super("Old Dominion University Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		buttonListener = new ButtonListenerClass();

		loc = p_loc;
		lvl = p_lvl;
		points = pts;
		aCond = p_a;
		bCond = p_b;
		cCond = p_c;
		dCond = p_d;
		eCond = p_e;
		
		determineCondition();

		currentP = new JPanel();
		currentP.setLayout(new GridLayout(5,1));
		currentP.setBorder(new TitledBorder(null, "Current Parking Conditions", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, 
				new Font ( "Verdana", Font.BOLD, 16 ), Color.BLACK));

		nav = new JPanel();
        nav.setLayout(new GridLayout(1,1));
        nav.setBackground(Color.WHITE);
        setUpNav();
        
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.WHITE);
        northPanel.add(new JLabel(new ImageIcon("ODUlogo4.png")), BorderLayout.CENTER);
        northPanel.add(nav, BorderLayout.EAST);
		
		
		
		
		
		
		
		
		
		aLabel = new JLabel("Garage A (Elkhorn)");
		bLabel = new JLabel("Garage B (43rd Street)");
		cLabel = new JLabel("Garage C (Constant Center South)");
		dLabel = new JLabel("Garage D (Constant Center North)");
		eLabel = new JLabel("Garage E (49th Street)");
		
		tyLabel = new JLabel("Thank you! You've earned 20 points!");
		tyLabel.setVisible(false);

		red = new JLabel(new ImageIcon("r.png"));
		green = new JLabel(new ImageIcon("g.png"));
		amber = new JLabel(new ImageIcon("y.png"));

		aP = new JPanel();
		bP = new JPanel();
		cP = new JPanel();
		dP = new JPanel();
		eP = new JPanel();

		aP.add(aLabel);
		aP.add(aAvail);
		bP.add(bLabel);
		bP.add(bAvail);
		cP.add(cLabel);
		cP.add(cAvail);
		dP.add(dLabel);
		dP.add(dAvail);
		eP.add(eLabel);
		eP.add(eAvail);

		currentP.add(aP);
		currentP.add(bP);
		currentP.add(cP);
		currentP.add(dP);
		currentP.add(eP);

		////////////////////////////////////////////////////////////////////////////////////////
		reportP = new JPanel();
		reportP.setLayout(new GridLayout(6,1));
		reportP.setBorder(new TitledBorder(null, "Make a Report", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, 
				new Font ( "Verdana", Font.BOLD, 16 ), Color.BLACK));


		selGL = new JLabel("Select a Garage:");
		selCL = new JLabel("Select Condition:");


		String[] garages = {"No Selection","Garage A", "Garage B", "Garage C", "Garage D","Garage E"};
		String[] conditions = {"No Selection","Open Parking", "Limited Parking", "Full/Closed"};

		ComboListenerClass comboListener = new ComboListenerClass();
		ComboListenerClass2 comboListener2 = new ComboListenerClass2();
		buttonListener = new ButtonListenerClass();

		//create the combobox
		gBox = new JComboBox(garages);
		gBox.addItemListener(comboListener);

		cBox = new JComboBox(conditions);
		cBox.addItemListener(comboListener2);

		submitB = new JButton("Submit");
		submitB.addActionListener(buttonListener);


		reportP.add(selGL);
		reportP.add(gBox);
		reportP.add(selCL);
		reportP.add(cBox);
		reportP.add(submitB);
		reportP.add(tyLabel);



		northPanel.add(currentP, BorderLayout.SOUTH);


		add(northPanel, BorderLayout.NORTH);
		add(reportP, BorderLayout.CENTER);
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

	public void determineCondition()
	{
		if (aCond == 0)
		{
			aAvail = new JLabel(new ImageIcon("g.png"));
		}
		else if (aCond == 1)
		{
			aAvail = new JLabel(new ImageIcon("y.png"));
		}
		else if (aCond == 2)
		{
			aAvail = new JLabel(new ImageIcon("r.png"));
		}


		if (bCond == 0)
		{
			bAvail = new JLabel(new ImageIcon("g.png"));
		}
		else if (bCond == 1)
		{
			bAvail = new JLabel(new ImageIcon("y.png"));
		}
		else if (bCond == 2)
		{
			bAvail = new JLabel(new ImageIcon("r.png"));
		}


		if (cCond == 0)
		{
			cAvail = new JLabel(new ImageIcon("g.png"));
		}
		else if (cCond == 1)
		{
			cAvail = new JLabel(new ImageIcon("y.png"));
		}
		else if (cCond == 2)
		{
			cAvail = new JLabel(new ImageIcon("r.png"));
		}

		if (dCond == 0)
		{
			dAvail = new JLabel(new ImageIcon("g.png"));
		}
		else if (dCond == 1)
		{
			dAvail = new JLabel(new ImageIcon("y.png"));
		}
		else if (dCond == 2)
		{
			dAvail = new JLabel(new ImageIcon("r.png"));
		}

		if (eCond == 0)
		{
			eAvail = new JLabel(new ImageIcon("g.png"));
		}
		else if (eCond == 1)
		{
			eAvail = new JLabel(new ImageIcon("y.png"));
		}
		else if (eCond == 2)
		{
			eAvail = new JLabel(new ImageIcon("r.png"));
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
			gSel = (String) gBox.getSelectedItem();

			//debug statement
			System.out.println(gSel);


			if (gSel.equals("No Selection"))
			{
				//clear the panel and add the new image
				//	imagePanel.removeAll();
				//	imagePanel.revalidate();
				//	imagePanel.repaint();
				//	imagePanel.add(none);
				g = 'n';
				tyLabel.setVisible(false);

			}
			else if (gSel.equals("Garage A"))
			{
				g ='a';
				tyLabel.setVisible(false);
			}
			else if (gSel.equals("Garage B"))
			{
				g ='b';
				tyLabel.setVisible(false);
			}
			else if (gSel.equals("Garage C"))
			{
				g ='c';
				tyLabel.setVisible(false);
			}
			else if (gSel.equals("Garage D"))
			{
				g ='d';
				tyLabel.setVisible(false);
			}
			else if (gSel.equals("Garage E"))
			{
				g ='e';
				tyLabel.setVisible(false);
			}

		}

	}
	private class ComboListenerClass2 implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent comboBox)
		{			
			//debug statement
			System.out.println("The garage combobox is functioning properly.");

			//get the input
			cSel = (String) cBox.getSelectedItem();

			//debug statement
			System.out.println(cSel);

			if (cSel.equals("No Selection"))
			{
				rCond = -1;
			}
			if (cSel.equals("Open Parking"))
			{
				rCond = 0;
			}
			if (cSel.equals("Limited Parking"))
			{
				rCond = 1;
			}
			if (cSel.equals("Full/Closed"))
			{
				rCond = 2;
			}


		}

	}




	private class ButtonListenerClass implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent button) 
		{


			if("Submit".equals(button.getActionCommand()))
			{
				if (g == 'a')
				{
					if (rCond ==0)
					{
						aCond =0;
						
						aAvail.removeAll();
						aAvail.revalidate();
						aAvail.repaint();
						aAvail.setIcon(new ImageIcon ("g.png"));
						aAvail.revalidate();
						aAvail.repaint();
						
						System.out.println("A Green");
					}
					if (rCond ==1)
					{
						aCond =1;
						aAvail.removeAll();
						aAvail.revalidate();
						aAvail.repaint();
						aAvail.setIcon(new ImageIcon ("y.png"));
						aAvail.revalidate();
						aAvail.repaint();
						System.out.println("A Amber");
					}
					if (rCond ==2)
					{
						aCond =2;
						aAvail.removeAll();
						aAvail.revalidate();
						aAvail.repaint();
						aAvail.setIcon(new ImageIcon ("r.png"));
						aAvail.revalidate();
						aAvail.repaint();
						System.out.println("A Red");
					}
					points+= 20;
				}
				if (g == 'b')
				{
					if (rCond ==0)
					{
						bCond =0;
						
						bAvail.removeAll();
						bAvail.revalidate();
						bAvail.repaint();
						bAvail.setIcon(new ImageIcon ("g.png"));
						bAvail.revalidate();
						bAvail.repaint();
						
						
					}
					if (rCond ==1)
					{
						bCond =1;
						bAvail.removeAll();
						bAvail.revalidate();
						bAvail.repaint();
						bAvail.setIcon(new ImageIcon ("y.png"));
						bAvail.revalidate();
						bAvail.repaint();
						
					}
					if (rCond ==2)
					{
						bCond =2;
						bAvail.removeAll();
						bAvail.revalidate();
						bAvail.repaint();
						bAvail.setIcon(new ImageIcon ("r.png"));
						bAvail.revalidate();
						bAvail.repaint();
						
					}
					points+= 20;
				}
				if (g == 'c')
				{
					if (rCond ==0)
					{
						cCond =0;
						
						cAvail.removeAll();
						cAvail.revalidate();
						cAvail.repaint();
						cAvail.setIcon(new ImageIcon ("g.png"));
						cAvail.revalidate();
						cAvail.repaint();
						
						
					}
					if (rCond ==1)
					{
						cCond =1;
						cAvail.removeAll();
						cAvail.revalidate();
						cAvail.repaint();
						cAvail.setIcon(new ImageIcon ("y.png"));
						cAvail.revalidate();
						cAvail.repaint();
						
					}
					if (rCond ==2)
					{
						cCond =2;
						cAvail.removeAll();
						cAvail.revalidate();
						cAvail.repaint();
						cAvail.setIcon(new ImageIcon ("r.png"));
						cAvail.revalidate();
						cAvail.repaint();
						
					}
					points+= 20;
				}
				
				
				
				if (g == 'd')
				{
					if (rCond ==0)
					{
						dCond =0;
						
						dAvail.removeAll();
						dAvail.revalidate();
						dAvail.repaint();
						dAvail.setIcon(new ImageIcon ("g.png"));
						dAvail.revalidate();
						dAvail.repaint();
					
					
					}
					if (rCond ==1)
					{
						dCond =1;
						dAvail.removeAll();
						dAvail.revalidate();
						dAvail.repaint();
						dAvail.setIcon(new ImageIcon ("y.png"));
						dAvail.revalidate();
						dAvail.repaint();
						
					}
					if (rCond ==2)
					{
						dCond =2;
						dAvail.removeAll();
						dAvail.revalidate();
						dAvail.repaint();
						dAvail.setIcon(new ImageIcon ("r.png"));
						dAvail.revalidate();
						dAvail.repaint();
						
					}
					points+= 20;

				}
				if (g == 'e')
				{
					if (rCond ==0)
					{
						eCond =0;
						
						eAvail.removeAll();
						eAvail.revalidate();
						eAvail.repaint();
						eAvail.setIcon(new ImageIcon ("g.png"));
						eAvail.revalidate();
						eAvail.repaint();
					
					
					}
					if (rCond ==1)
					{
						eCond =1;
						eAvail.removeAll();
						eAvail.revalidate();
						eAvail.repaint();
						eAvail.setIcon(new ImageIcon ("y.png"));
						eAvail.revalidate();
						eAvail.repaint();
						
					}
					if (rCond ==2)
					{
						eCond =2;
						eAvail.removeAll();
						eAvail.revalidate();
						eAvail.repaint();
						eAvail.setIcon(new ImageIcon ("r.png"));
						eAvail.revalidate();
						eAvail.repaint();
						
					}
					points+= 20;

				}
				
				
				tyLabel.setVisible(true);
				
				
				
				
				
				
				
			}

			if("Return to Menu".equals(button.getActionCommand()))
			{
				dispose();
	            new MapClass(points, lvl, loc, aCond, bCond, cCond, dCond, eCond);
			}
		}


	}

}

