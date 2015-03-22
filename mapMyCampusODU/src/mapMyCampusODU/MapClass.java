package mapMyCampusODU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MapClass extends JFrame
{
	
	private JPanel nav, northPanel;
	private JButton profileB, parkingB, campusDirectB, scheduleB;
	private int points, lvl;
	ButtonListenerClass buttonListener;
	private String loc;
	private int a,b,c,d,e;
	
	public MapClass(int pts, int p_lvl, String p_loc, int p_a, int p_b, int p_c, int p_d, int p_e)
    { 
		
        super("Old Dominion University");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        lvl = p_lvl;
        points = pts;
        
        a= p_a;
        b= p_b;
        c= p_c;
        d= p_d;
        e= p_e;
        
        
        buttonListener = new ButtonListenerClass();
        loc = p_loc;
        nav = new JPanel();
        nav.setLayout(new GridLayout(1,4));
        setUpNav();
        
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(new JLabel(new ImageIcon("ODUlogo4.png")), BorderLayout.CENTER);
        northPanel.add(nav, BorderLayout.EAST);
        
       
        add(northPanel, BorderLayout.NORTH);
        add(new JLabel(new ImageIcon("Mapx1000px.png")), BorderLayout.CENTER);
        
        
      
      	
        //pack();
      	setSize(1000, 750);
      	setLocationRelativeTo(null);
        setVisible(true);
    }
	
	public void setUpNav()
	{
		profileB = new JButton("Profile");
		profileB.addActionListener(buttonListener);
		
		campusDirectB = new JButton("Campus Directory");
		campusDirectB.addActionListener(buttonListener);
		
		parkingB = new JButton("Parking");
		parkingB.addActionListener(buttonListener);
		
		scheduleB = new JButton("Rewards");
		scheduleB.addActionListener(buttonListener);
		
		nav.add(profileB);
		nav.add(campusDirectB);
		nav.add(parkingB);
		nav.add(scheduleB);
	}
	
	
	
	
	
	
	
	private class ButtonListenerClass implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent button) 
		{


			if("Profile".equals(button.getActionCommand()))
			{
				
				dispose();
	            new ProfileClass("Witherow", points, lvl, loc, a, b, c,d,e);
			}
			if("Campus Directory".equals(button.getActionCommand()))
			{

				dispose();
	            new DirectClass(points, lvl, loc, a, b, c,d,e);


			}
			if("Parking".equals(button.getActionCommand()))
			{

				dispose();
	            new ParkingClass(points, lvl, loc, a, b, c,d,e);


			}
			if("Rewards".equals(button.getActionCommand()))
			{

				dispose();
	            new Rewards(points, lvl,loc, a, b, c,d,e);


			}

		}

	}
}
