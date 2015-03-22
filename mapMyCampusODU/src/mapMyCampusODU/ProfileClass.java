package mapMyCampusODU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


	

public class ProfileClass extends JFrame
{
	private JPanel stats, friends, userInfo, nav, northPanel;
	private JLabel level, rank, points, nextLvl, name, university, email, locLabel;
	private String[] friendNames = {"Mary Aman", "Mary MacKinnon", "Maryam Amer", "Rachel Martin", "Cristina Genoese-Zerbi", "Kylee Kohl"};
	private int[] friendLevels = {1,1,1,1,1,1};
	private int pts = 0, goal, lvl;
	private JButton back;
	ButtonListenerClass buttonListener;
	private String loc;
	private int a,b,c,d,e;
	
	
	
	public ProfileClass(String user, int p_pts, int p_lvl, String p_loc, int p_a, int p_b, int p_c, int p_d, int p_e)
	{
		super("Old Dominion University Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));

		lvl = p_lvl;
		pts = p_pts;
		loc = p_loc;
		a= p_a;
        b= p_b;
        c= p_c;
        d= p_d;
        e= p_e;
		if (lvl ==1)
		{
			goal = 500;
		}
		else if (lvl ==2)
		{
			goal = 2500;
		}
		else if (lvl ==3)
		{
			goal = 10000;
		}
		else
		{
			goal = pts;
		}
		
		updateLevel();
		
		
	if (user.equals("Witherow"))
	{
		name = new JLabel("Megan Witherow");
		university = new JLabel("Old Dominion University");
		email = new JLabel("mwith010@odu.edu");
		level = new JLabel("Level: "+lvl);
		rank = new JLabel("Rank Among Friends: 1");
		points = new JLabel("Points: "+pts);
		nextLvl = new JLabel("Points to Next Level: "+(goal-pts));
		
	}

	locLabel = new JLabel("Last Location: "+loc);
	userInfo = new JPanel();
	userInfo.setLayout(new GridLayout(3,1));
	userInfo.setBorder(new TitledBorder(null, "User Information", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, 
			new Font ( "Verdana", Font.BOLD, 16 ), Color.BLACK));
	stats = new JPanel();
	stats.setLayout(new GridLayout(5,1));
	stats.setBorder(new TitledBorder(null, "User Stats", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, 
			new Font ( "Verdana", Font.BOLD, 16 ), Color.BLACK));
	friends = new JPanel();
	friends.setLayout(new GridLayout(6,1));
	friends.setBorder(new TitledBorder(null, "Friends", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, 
			new Font ( "Verdana", Font.BOLD, 16 ), Color.BLACK));

	buildUserInfo();
	buildStats();
	buildFriends();
	
	buttonListener = new ButtonListenerClass();
	
	nav = new JPanel();
    nav.setLayout(new GridLayout(1,1));
    nav.setBackground(Color.WHITE);
    setUpNav();
    
    northPanel = new JPanel();
    northPanel.setLayout(new BorderLayout());
    northPanel.add(new JLabel(new ImageIcon("ODUlogo4.png")), BorderLayout.CENTER);
    northPanel.setBackground(Color.WHITE);
    northPanel.add(nav, BorderLayout.EAST);
	
	northPanel.add(userInfo, BorderLayout.SOUTH);
	
	add(northPanel);
	add(stats);
	add(friends);

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
	
	public void updateLevel()
	{
		if (pts >= 500 && lvl ==1)
		{
			lvl++;
		}
		if (pts >= 2500 && lvl ==2)
		{
			lvl++;
		}
		if (pts >= 10000 && lvl ==3)
		{
			lvl++;
		}
	}
	public void buildUserInfo()
	{
		userInfo.add(name);
		userInfo.add(university);
		userInfo.add(email);
	}
	public void buildStats()
	{
		stats.add(locLabel);
		stats.add(level);
		stats.add(rank);
		stats.add(points);
		stats.add(nextLvl);
		
	}
	public void buildFriends()
	{
		for (int i = 0; i < 6; i++)
		{
			friends.add(new JLabel(friendNames[i] + ", Level "+ friendLevels[i]));
		}
	}

	private class ButtonListenerClass implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent button) 
		{
			if("Return to Menu".equals(button.getActionCommand()))
			{
				dispose();
	            new MapClass(pts, lvl, loc, a, b, c,d,e);
			}
		}


	}

}



