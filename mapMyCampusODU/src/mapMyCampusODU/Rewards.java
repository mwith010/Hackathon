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



public class Rewards extends JFrame
{

	private JPanel nav, northPanel, rewardPanel, chargePanel;
	private JLabel starLabel, starImage, costLabel, pointValue;
	ButtonListenerClass buttonListener;
	private JButton back, purchase;
	private String loc;
	private int a,b,c,d,e;

	private int points, lvl, starCost;

	public Rewards(int pts, int p_lvl, String p_loc, int p_a, int p_b, int p_c, int p_d, int p_e)
	{
		super("Old Dominion University Campus Direct");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		lvl = p_lvl;
		points = pts;
		a= p_a;
        b= p_b;
        c= p_c;
        d= p_d;
        e= p_e;
		loc = p_loc;
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

		rewardPanel = new JPanel();
		rewardPanel.setLayout(new GridLayout(1,2));
		
		chargePanel = new JPanel();
		chargePanel.setLayout(new GridLayout(3,1));
		
		
		purchase = new JButton("Purchase With Points");
		purchase.addActionListener(buttonListener);
		
		starLabel = new JLabel("$5 Starbucks Card");
		starImage = new JLabel(new ImageIcon("starlogo.png"));
		costLabel = new JLabel("50 points");
		
		chargePanel.add(starLabel);
		chargePanel.add(costLabel);
		chargePanel.add(purchase);
		
		rewardPanel.add(starImage);
		rewardPanel.add(chargePanel);
		
		JPanel placeholder = new JPanel();
		placeholder.setLayout(new GridLayout(3,1));
		
		pointValue = new JLabel("Points Balance: "+ points, SwingConstants.CENTER);
		
		
		//placeholder.add(new JPanel());
		placeholder.add(rewardPanel);
		placeholder.add(new JLabel("More Rewards to Come!",SwingConstants.CENTER));
		
		
		
		
		JPanel placeholder2 = new JPanel();
		placeholder2.setLayout(new GridLayout(2,1));
	placeholder.add(pointValue);
		
		
		add(placeholder, BorderLayout.CENTER);
		//add(placeholder2, BorderLayout.SOUTH);



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
			if("Purchase With Points".equals(button.getActionCommand()))
			{
				if (points >= 50)
				{
				points-=50;
				purchase.setVisible(false);
				costLabel.setText("Purchased");
				pointValue.setText("Points Balance: "+ points);
				}
				else
				{
					purchase.setVisible(false);
					costLabel.setText("Not Enough Points");
				}
			}


		}
	}
}