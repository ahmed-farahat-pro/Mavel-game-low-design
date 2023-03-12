package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.*;
import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;

import model.world.Champion;
import model.world.Cover;
import model.world.Direction;

import javax.swing.*;
import javax.swing.text.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class view extends JFrame  implements ActionListener {
	public static String ch="";
	public JComboBox abilities;
	public boolean player1usedability;

	public boolean isPlayer1usedability() {
		return player1usedability;
	}
	public void setPlayer1usedability(boolean player1usedability) {
		this.player1usedability = player1usedability;
	}
	public boolean isPlayer2usedability() {
		return player2usedability;
	}
	public void setPlayer2usedability(boolean player2usedability) {
		this.player2usedability = player2usedability;
	}
	public boolean player2usedability;
	public JComboBox getAbilities() {
		return abilities;
	}
	public void setAbilities(JComboBox abilities) {
		this.abilities = abilities;
	}
	public  JPanel grid;
	public String first_name="";
	public String second_name="";
	public JPanel down;
	public JTextArea player1;
	public JTextArea player2;
	public JButton show_champ = new JButton("Show_champions");
	public JButton show_abilities = new JButton("Show_abilities");
	public JTextArea getPlayer1() {
		return player1;
	}
	public void setPlayer1(JTextArea jTextArea) {
		this.player1 = jTextArea;
	}
	public JTextArea getPlayer2() {
		return player2;
	}
	public void setPlayer2(JTextArea player2) {
		this.player2 = player2;
	}
	public JPanel leftt;
	public JPanel getLeftt() {
		return leftt;
	}
	public void setLeftt(JPanel leftt) {
		this.leftt = leftt;
	}
	public  JComboBox combobox ;
	public JComboBox firstplayer;
	
	public  JComboBox secondlayer;
	public Game game;
	public Game game2;
	public JTextArea ab;
	public JTextArea getAb() {
		return ab;
	}
	public void setAb(JTextArea ab) {
		this.ab = ab;
	}
	public Game getGame2() {
		return game2;
	}
	public void setGame2(Game game2) {
		this.game2 = game2;
	}
	public String firstpp [] =   new String[3];
	public String secondpp [] =  new String[3] ;
	public int uu = 0;
	public int yy = 0;		
	public Boolean flag1 = false;
	public Boolean flag2 =false;
	public ArrayList<JButton>buttons = new ArrayList<JButton>();
	
	public Player firstt ;
	public Player second ;

	
	public  JButton attackup =  new JButton("attack_up");
	
	public  JButton attackdown =  new JButton("attack_down");
	public  JButton attackright =  new JButton("attack_right");
	public  JButton attackleft =  new JButton("attack_left");
	public  JButton useLeader =  new JButton("useLeader");
	
	public  JButton up =  new JButton("up");
	public  JButton downn =  new JButton("down");
	public  JButton right =  new JButton("right");
	public  JButton left =  new JButton("left");

	public  JButton endturn =  new JButton("EndTurn");
	
	
	
	
	public static String getAbilityType(Ability a)
	{
		if(a instanceof HealingAbility)
		{
			return "Healing Ability: ";
		}
		else if (a instanceof DamagingAbility)
		{
			return "Damaging Ability: ";
		}
		else if (a instanceof CrowdControlAbility)
		{
		   return "Crowd Control Ability";	
		}
		return "Ability";
	}
	public Player getFirstt() {
		return firstt;
	}
	public void setFirstt(Player firstt) {
		this.firstt = firstt;
	}
	public Player getSecond() {
		return second;
	}
	public void setSecond(Player second) {
		this.second = second;
	}
	public JComboBox getCombobox() {
		return combobox;
	}
	public void setCombobox(JComboBox combobox) {
		this.combobox = combobox;
	}
	public view()
	{
		
	this.setTitle("Marvel");
	  this.setBounds(500,500,800,800);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  //JPanel products = new JPanel(); you wont be able to acess this JPAnel if written inside the construcctor
	  grid  = new JPanel();
	  
	  this.setPlayer1(new JTextArea());
	  this.setPlayer2(new JTextArea());
	  player1.setPreferredSize(new Dimension(300,450));
	  player2.setPreferredSize(new Dimension(300,450));
	  this.add(player1 ,BorderLayout.EAST );
	  this.add(player2 ,BorderLayout.WEST );
	  
	  grid.setPreferredSize(new Dimension(800,450));

	  grid.setLayout(new GridLayout(5,5));
	
	  leftt = new JPanel();
	  ab = new JTextArea("Welcome to The Marvel");
	  leftt.add(ab);
	  
	  this.add(leftt);
	  
	 
	  
	  down = new JPanel();
	  down.setLayout(new GridLayout(4,4));
	  down.setPreferredSize(new Dimension(800,250 ));
	  down.add(show_champ);
	  down.add(show_abilities);
	  show_champ.setBackground(Color.ORANGE);
	  show_abilities.setBackground(Color.LIGHT_GRAY);
	  
	 
	  this.add(grid, BorderLayout.NORTH);
	  this.add(down,BorderLayout.SOUTH);
	  
	  
	 
	  for(int i=0;i<25;i++)
		{ 
			JButton j = new JButton();
			j.setBackground(Color.WHITE);
			
			j.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.MAGENTA));
			buttons.add(j);
			grid.add(j);
		}
	  
	
		
	useLeader.setBackground(Color.WHITE);
		up.setBackground(Color.WHITE);
		downn.setBackground(Color.WHITE);
		right.setBackground(Color.WHITE);
	    left.setBackground(Color.WHITE);
	    attackup.setBackground(Color.WHITE);
	    attackdown.setBackground(Color.WHITE);
	    attackright.setBackground(Color.WHITE);
	    attackleft.setBackground(Color.WHITE);
		endturn.setBackground(Color.WHITE);
	
		
	  down.add(attackup);
	  down.add(attackdown);
	  down.add(attackright);
	  down.add(attackleft);
	 down.add(useLeader);
	  down.add(up);
	  down.add(downn);
	  down.add(right);
	  down.add(left);
	  down.add(endturn);
	  
	 
	
	  
	   
		
	  
	 
	  this.revalidate();
	  this.repaint();
	}
	public static void main(String[]args) throws IOException
	{
		
		//Game.loadChampions("Champion.csv");
		view x =new view();
		String h = "";
		String b= "";		
		
		  do
		  {
			  h=JOptionPane.showInputDialog("Enter first player name");
		  }while(h==null||h.equals(""));
		  do
		  {
			  b=JOptionPane.showInputDialog("Enter second player name");
		  }while(b==null||b.equals(""));
		 x.setFirst_name(h);
	     x.setSecond_name(b); 
		
		  x.setFirstt(new Player(x.getFirst_name())); 
		  x.setSecond(new Player(x.getSecond_name())); 
		  x.getPlayer1().setText(x.getFirst_name());
		  x.getPlayer2().setText(x.getSecond_name());
		
		
		x.setGame(new Game(x.getFirstt(),x.getSecond()));
		
		x.getGame().loadAbilities("Abilities.csv");
		x.getGame().loadChampions("Champions.csv");
		//System.out.print(xx.getAvailableChampions().get(0).getAbilities().get(0).getName());
	System.out.print(x.getGame().getAvailableChampions().size());
		String dd[]= new String[x.getGame().getAvailableChampions().size()];
		int i = 0;
	   
		for(Champion e:x.getGame().getAvailableChampions())
		{String ab ="";
			for(int p=0;p<e.getAbilities().size();p++ )
			{
				Ability c = e.getAbilities().get(p);
				ab+=" "+c.getName()+" "+getAbilityType(c)+" mana_cost  "+c.getManaCost()+" basecolldown  "+c.getBaseCooldown()+" castRange "+c.getCastRange()+" recuired antionPT "+c.getRequiredActionPoints()+" area of effect "+c.getCastArea().name()+"\n" ;
			}
			ch+=e.getName()+" AttackDamage: "+e.getAttackDamage()+" CuurentActionPt: "+e.getCurrentActionPoints()+"\n"+" Mana: "+e.getMana()+" MaxHP: "+e.getMaxHP()+" AttackRange:"+e.getAttackRange()+" "+" Abilities "+ab+" Speed "+e.getSpeed()+" max action per turn "+e.getMaxActionPointsPerTurn()+" Condition :"+e.getCondition().name()+"\n"+"\n";
			dd[i]=e.getName();
			i++;
		}
		 x.setCombobox(new JComboBox(dd));
		x.show_champ.addActionListener(x);		
		x.getPlayer1().setEditable(false);
		x.getPlayer2().setEditable(false);
	
		x.getCombobox().setSelectedIndex(-1);
		
			
		x.getCombobox().addActionListener(x);
		
		
		x.getDown().add(x.getCombobox());
		
		
	  //x.setFocusable(true);
	  //x.requestFocusInWindow();
	  x.revalidate();
      x.repaint();
		
		//System.out.print(first.getName());
		
		
		
		
	}


	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	public JButton getShow_champ() {
		return show_champ;
	}
	public void setShow_champ(JButton show_champ) {
		this.show_champ = show_champ;
	}
	public JButton getShow_abilities() {
		return show_abilities;
	}
	public void setShow_abilities(JButton show_abilities) {
		this.show_abilities = show_abilities;
	}
	public JComboBox getFirstplayer() {
		return firstplayer;
	}
	public void setFirstplayer(JComboBox firstplayer) {
		this.firstplayer = firstplayer;
	}
	public JComboBox getSecondlayer() {
		return secondlayer;
	}
	public void setSecondlayer(JComboBox secondlayer) {
		this.secondlayer = secondlayer;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public JPanel getGrid() {
		return grid;
	}
	public void setGrid(JPanel grid) {
		this.grid = grid;
	}
	public JPanel getDown() {
		return down;
	}
	public void setDown(JPanel down) {
		this.down = down;
	}
	public void set_player(view a)
	{
		String pi ="first_player "+"\n"+ a.getGame2().getFirstPlayer().getName()+"\n"+"-----------"+"\n";
		String po ="second_player "+"\n"+ a.getGame2().getSecondPlayer().getName()+"\n"+"-----------"+"\n";
		
	
		
		for(int l = 0 ;l<a.getGame2().getFirstPlayer().getTeam().size();l++)
		{
			pi+=a.getGame2().getFirstPlayer().getTeam().get(l).getName()+"\n";
			
		}
		for(int l = 0 ;l<a.getGame2().getSecondPlayer().getTeam().size();l++)
		{
			po+=a.getGame2().getSecondPlayer().getTeam().get(l).getName()+"\n";
		}
		if(!a.player1usedability)
		{
			pi+="Leader not used his ability"+"\n";
		}
		else
		{
			pi+="Leader  used his ability"+"\n";
		}
		if(!a.player2usedability)
		{
			po+="Leader not used his ability"+"\n";
		}
		else
		{
			po+="Leader  used his ability"+"\n";
		}
		
		
		
		
		a.getPlayer1().setText(pi);
		a.getPlayer2().setText(po);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==show_champ)
		{
	
			JFrame t = new JFrame();
			t.setBackground(Color.LIGHT_GRAY);
			t.setVisible(true);
			  t.setBounds(500,500,800,800);
			
		
			JTextArea a =new JTextArea();
			
			t.add(a);
			a.setText(ch);
			JScrollPane  gg = new JScrollPane(a,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			t.add(gg);
			
	        
		
		}else
			
		if(e.getSource()==combobox)
		{
			int h = combobox.getSelectedIndex();
			if(this.getGame().getFirstPlayer().getTeam().size()<3)
			{
				firstpp[uu]=this.getGame().getAvailableChampions().get(h).getName();
				uu++;
				this.getGame().getFirstPlayer().getTeam().add(this.getGame().getAvailableChampions().get(h));
				
			}else
				if(this.getGame().getSecondPlayer().getTeam().size()<3)
				{
			
					this.getGame().getSecondPlayer().getTeam().add(this.getGame().getAvailableChampions().get(h));
					secondpp[yy]=this.getGame().getAvailableChampions().get(h).getName();
					yy++;
				}
			
			this.getCombobox().removeItemAt(h);
			this.getGame().getAvailableChampions().remove(h);
			
			if(yy==3&& flag1 == false)
			{
				this.setSecondlayer(new JComboBox(secondpp));
				this.getSecondlayer().addActionListener(this);
				
				this.getDown().add(this.getSecondlayer());
				flag1 =true;
				buttons.get(1).setText(this.getGame().getSecondPlayer().getTeam().get(0).getName()+"\n"+this.getGame().getSecondPlayer().getTeam().get(0).getCurrentHP() );
				buttons.get(2).setText(this.getGame().getSecondPlayer().getTeam().get(1).getName()+"\n"+this.getGame().getSecondPlayer().getTeam().get(1).getCurrentHP());
				buttons.get(3).setText(this.getGame().getSecondPlayer().getTeam().get(2).getName()+"\n"+this.getGame().getSecondPlayer().getTeam().get(2).getCurrentHP());
				
			}
			if(uu == 3&& flag2 == false)
			{
				
				this.setFirstplayer(new JComboBox(firstpp));
				this.getFirstplayer().addActionListener(this);
				this.getDown().add(this.getFirstplayer());
				flag2 = true;
				buttons.get(21).setText(this.getGame().getFirstPlayer().getTeam().get(0).getName()+"\n"+this.getGame().getFirstPlayer().getTeam().get(0).getCurrentHP());
				buttons.get(22).setText(this.getGame().getFirstPlayer().getTeam().get(1).getName()+"\n"+this.getGame().getFirstPlayer().getTeam().get(1).getCurrentHP());
				buttons.get(23).setText(this.getGame().getFirstPlayer().getTeam().get(2).getName()+"\n"+this.getGame().getFirstPlayer().getTeam().get(2).getCurrentHP());
				
				
				
				

			}
			
			if(flag1 == true && flag2 == true) {
				this.getShow_abilities().addActionListener(this);
				this.getCombobox().setEnabled(false);
		
				this.setGame2(new Game(this.getFirstt(),this.getSecond())) ; 
				set_player(this);
				
				this.revalidate();
				  this.repaint();
				for(int i=0;i<5;i++)
					for(int j = 0;j<5;j++)
					{
						if(this.getGame2().getBoard()[i][j] instanceof Cover)
						{
							System.out.println(i+" "+j );
							
							buttons.get((((4-i)*5+j))).setText("COVERRRR  "+((Cover)this.getGame2().getBoard()[i][j]).getCurrentHP());
						}
					}
		
				System.out.print(this.getGame2().getCurrentChampion().getName());
		
				
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 buttons.get((4-i)*5+j).setBackground(Color.GRAY);
						 
						 
					 }
				 
				 
				}
					
					
				}
				
				int ooo = this.getGame2().getCurrentChampion().getAbilities().size();
				String a[] = new String[ooo] ;
				for(int i=0;i<this.getGame2().getCurrentChampion().getAbilities().size();i++)
				{
					a[i]=this.getGame2().getCurrentChampion().getAbilities().get(i).getName();
				}
				this.setAbilities(new JComboBox(a));

				 this.getDown().add(this.getAbilities());
				 this.getAbilities().addActionListener(this);
			
					
			
				
				

				
	
				 
					Comparable [] order = this.getGame2().getTurnOrder().elements;
					
					 String x = "";
						for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
							 x += (((Champion)order[i]).getName()+"  \n  ");
							
						
						
							
						
						this.getAb().setText(x);
				
				flag1 =false;
				flag2=false;
				
				
				
			}
			 
		}
		else if(e.getSource()==this.getShow_abilities())
		{
			String ll="";
			for(int i=0;i<this.getGame2().getCurrentChampion().getAbilities().size();i++)
			{
				Ability c =this.getGame2().getCurrentChampion().getAbilities().get(i);
				String p = "Ability";
				if(c instanceof CrowdControlAbility)
				{
					p="CrowdControlAbility";
					ll+=c.getName()+"\n"+"Type"+p+"\n"+"Area of Effect: "+c.getCastArea().name()+"\n"+"CastRange: "+c.getCastRange()+"\n"+"ManaCost: "+c.getManaCost()+"\n"+"RequiredActionPoints: "+c.getRequiredActionPoints()+"\n"+"BaseCooldown: "+c.getBaseCooldown()+"\n"+"CurrentCooldown"+c.getCurrentCooldown()+"\n"+"Effect: "+((CrowdControlAbility)c).getEffect().getName()+" TYPE OF EFFECT "+((CrowdControlAbility)c).getEffect().getType().name()+" Duration"+((CrowdControlAbility)c).getEffect().getDuration()+"\n"+"-----------"+"\n";
				}
				else if (c instanceof DamagingAbility)
				{
					p="DamagingAbility";
					ll+=c.getName()+"\n"+"Type"+p+"\n"+"Area of Effect: "+c.getCastArea().name()+"\n"+"CastRange: "+c.getCastRange()+"\n"+"ManaCost: "+c.getManaCost()+"\n"+"RequiredActionPoints: "+c.getRequiredActionPoints()+"\n"+"BaseCooldown: "+c.getBaseCooldown()+"\n"+"CurrentCooldown"+c.getCurrentCooldown()+"\n"+"DamageAmount: "+((DamagingAbility)c).getDamageAmount()+"\n"+"-----------"+"\n";
				}
				else
					if(c instanceof HealingAbility)
					{
						p="HealingAbility";
						ll+=c.getName()+"\n"+"Type"+p+"\n"+"Area of Effect: "+c.getCastArea().name()+"\n"+"CastRange: "+c.getCastRange()+"\n"+"ManaCost: "+c.getManaCost()+"\n"+"RequiredActionPoints: "+c.getRequiredActionPoints()+"\n"+"BaseCooldown: "+c.getBaseCooldown()+"\n"+"CurrentCooldown"+c.getCurrentCooldown()+"\n"+"HealAmount: "+((HealingAbility)c).getHealAmount()+"\n"+"-----------"+"\n";
					}
			

				
		}
			JFrame y = new JFrame();
			  y.setBounds(500,500,800,800);
			y.setVisible(true);
			JTextArea p = new JTextArea();
			y.add(p);
			
			
		p.setText(ll);
		}
		else if(e.getSource()==firstplayer)
		{
			if(this.getGame2().getFirstPlayer().getLeader()==null)
			{
			
				for(int i=0 ;i<this.getGame2().getFirstPlayer().getTeam().size();i++ )
				{
					if(this.getGame2().getFirstPlayer().getTeam().get(i).getName().equals(firstplayer.getSelectedItem()))
					{
						
						this.getGame2().getFirstPlayer().setLeader(this.getGame2().getFirstPlayer().getTeam().get(i));
				
						//System.out.print(this.getGame().getFirstPlayer().getLeader().getName());
					}
				}
				
			}
			firstplayer.setEnabled(false);
			if(this.getGame2().getFirstPlayer().getLeader()!=null&&this.getGame2().getSecondPlayer().getLeader()!=null)
			{
			buttons.get(0).addActionListener(this);
			buttons.get(1).addActionListener(this);
			buttons.get(2).addActionListener(this);
			buttons.get(3).addActionListener(this);
			buttons.get(4).addActionListener(this);
			buttons.get(5).addActionListener(this);
			buttons.get(6).addActionListener(this);
			buttons.get(7).addActionListener(this);
			buttons.get(8).addActionListener(this);
			buttons.get(9).addActionListener(this);
			buttons.get(10).addActionListener(this);
			buttons.get(11).addActionListener(this);
			buttons.get(12).addActionListener(this);
			buttons.get(13).addActionListener(this);
			buttons.get(14).addActionListener(this);
			buttons.get(15).addActionListener(this);
			buttons.get(16).addActionListener(this);
			buttons.get(17).addActionListener(this);
			buttons.get(18).addActionListener(this);
			buttons.get(19).addActionListener(this);
			buttons.get(20).addActionListener(this);
			buttons.get(21).addActionListener(this);
			buttons.get(22).addActionListener(this);
			buttons.get(23).addActionListener(this);
			buttons.get(24).addActionListener(this);
			 up.addActionListener(this);
			  downn.addActionListener(this);
			  right.addActionListener(this);
			  left.addActionListener(this);
			  endturn.addActionListener(this);
			  attackdown.addActionListener(this);
			  attackright.addActionListener(this);
			  attackleft.addActionListener(this);
			  attackup.addActionListener(this);
			  useLeader.addActionListener(this);
			
			}
			
		}
		else if(e.getSource()==secondlayer)
		{
			if(this.getGame2().getSecondPlayer().getLeader()==null)
			{
		
				for(int i=0 ;i<this.getGame().getSecondPlayer().getTeam().size();i++ )
				{
					
					if(this.getGame2().getSecondPlayer().getTeam().get(i).getName().equals(secondlayer.getSelectedItem()))
					{
						
					
						this.getGame2().getSecondPlayer().setLeader(this.getGame2().getSecondPlayer().getTeam().get(i));
					
					
						
					}
				}
			}
			
			secondlayer.setEnabled(false);
			if(this.getGame2().getFirstPlayer().getLeader()!=null&&this.getGame2().getSecondPlayer().getLeader()!=null)
			{
			buttons.get(0).addActionListener(this);
			buttons.get(1).addActionListener(this);
			buttons.get(2).addActionListener(this);
			buttons.get(3).addActionListener(this);
			buttons.get(4).addActionListener(this);
			buttons.get(5).addActionListener(this);
			buttons.get(6).addActionListener(this);
			buttons.get(7).addActionListener(this);
			buttons.get(8).addActionListener(this);
			buttons.get(9).addActionListener(this);
			buttons.get(10).addActionListener(this);
			buttons.get(11).addActionListener(this);
			buttons.get(12).addActionListener(this);
			buttons.get(13).addActionListener(this);
			buttons.get(14).addActionListener(this);
			buttons.get(15).addActionListener(this);
			buttons.get(16).addActionListener(this);
			buttons.get(17).addActionListener(this);
			buttons.get(18).addActionListener(this);
			buttons.get(19).addActionListener(this);
			buttons.get(20).addActionListener(this);
			buttons.get(21).addActionListener(this);
			buttons.get(22).addActionListener(this);
			buttons.get(23).addActionListener(this);
			buttons.get(24).addActionListener(this);
			 up.addActionListener(this);
			  downn.addActionListener(this);
			  right.addActionListener(this);
			  left.addActionListener(this);
			  endturn.addActionListener(this);
			  attackdown.addActionListener(this);
			  attackright.addActionListener(this);
			  attackleft.addActionListener(this);
			  attackup.addActionListener(this);
			  useLeader.addActionListener(this);
			
			
			}
			
		}
		else if(e.getSource()==up)
		{
			
			try {
				this.getGame2().move(Direction.UP);
				set_player(this);
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
			} catch ( UnallowedMovementException e1) {
				
				   JOptionPane.showMessageDialog(null,"UnallowedMovement" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch (NotEnoughResourcesException e2 )
			{
				 JOptionPane.showMessageDialog(null,"there is no resourses for this movement " ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		else if(e.getSource()==downn)
		{
			
			try {
				this.getGame2().move(Direction.DOWN);
				set_player(this);
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}

				
			} catch ( UnallowedMovementException e1) {
				
				   JOptionPane.showMessageDialog(null,"UnallowedMovement" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch (NotEnoughResourcesException e2 )
			{
				 JOptionPane.showMessageDialog(null,"there is no resourses for this movement " ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource()==right)
		{
			
			try {
				this.getGame2().move(Direction.RIGHT);
				set_player(this);
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}

			}catch ( UnallowedMovementException e1) {
				
				   JOptionPane.showMessageDialog(null,"UnallowedMovement" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch (NotEnoughResourcesException e2 )
			{
				 JOptionPane.showMessageDialog(null,"there is no resourses for this movement " ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
		
		}
		else if(e.getSource()==left)
		{ 
			
			try {
				this.getGame2().move(Direction.LEFT);
				set_player(this);
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
			} catch ( UnallowedMovementException e1) {
				
				   JOptionPane.showMessageDialog(null,"UnallowedMovement" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch (NotEnoughResourcesException e2 )
			{
				 JOptionPane.showMessageDialog(null,"there is no resourses for this movement " ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
		
			
		}
		else if(e.getSource()==attackup)
		{
			try {
				
				
				
				this.getGame2().attack(Direction.UP);
				Comparable [] order = this.getGame2().getTurnOrder().elements;
				
				 String x = "";
					for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
						 x += (((Champion)order[i]).getName()+"  \n  ");
						
					
					
						
					
					this.getAb().setText(x);
				set_player(this);
				
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
				
				
				if(this.getGame2().checkGameOver()!=null)
				{
					 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
					 TimeUnit.SECONDS.sleep(2);
					 this.dispose();
					
				}
				
			} catch (InvalidTargetException e1) {
				
				  JOptionPane.showMessageDialog(null,"InvalidTarget" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(ChampionDisarmedException e2)
			{
				  JOptionPane.showMessageDialog(null,"The current champ is disarmed" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch(NotEnoughResourcesException e3)
			{
				
				  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
	
		}else if(e.getSource()==attackdown)
		{
			try {
				
				
				
				this.getGame2().attack(Direction.DOWN);
				Comparable [] order = this.getGame2().getTurnOrder().elements;
				
				 String x = "";
					for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
						 x += (((Champion)order[i]).getName()+"  \n  ");
						
					
					
						
					
					this.getAb().setText(x);
				set_player(this);
				
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
			
			
				if(this.getGame2().checkGameOver()!=null)
				{
					 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
					 TimeUnit.SECONDS.sleep(2);
					 this.dispose();
					
				}
				
				
			}  catch (InvalidTargetException e1) {
				
				  JOptionPane.showMessageDialog(null,"InvalidTarget" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(ChampionDisarmedException e2)
			{
				  JOptionPane.showMessageDialog(null,"The current champ is disarmed" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch(NotEnoughResourcesException e3)
			{
				
				  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	
		}
			
			
	else if(e.getSource()==attackright)
	{
		try {
			
			
			
			this.getGame2().attack(Direction.RIGHT);
			Comparable [] order = this.getGame2().getTurnOrder().elements;
			
			 String x = "";
				for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
					 x += (((Champion)order[i]).getName()+"  \n  ");
					
				
				
					
				
				this.getAb().setText(x);
			set_player(this);
		
			for(int i=0;i<5;i++)
			{for(int j = 0;j<5;j++)
			{
			 if(this.getGame2().getBoard()[i][j]==null)
			 {
				 buttons.get((4-i)*5+j).setText("");
				 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
			 }
			 else
				 if(this.getGame2().getBoard()[i][j] instanceof Champion)
				 {
					 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
					 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
						 
					 }
					 else
					 {
						 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
					 }
					 
				 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
				 {
					 Cover m = (Cover)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
					 
					 
				 }
			 
			 
			}
				
				
			}
			
			if(this.getGame2().checkGameOver()!=null)
			{
				 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
				 TimeUnit.SECONDS.sleep(2);
				 this.dispose();
				
			}
			
			
		}  catch (InvalidTargetException e1) {
			
			  JOptionPane.showMessageDialog(null,"InvalidTarget" ,"Error",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(ChampionDisarmedException e2)
		{
			  JOptionPane.showMessageDialog(null,"The current champ is disarmed" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(NotEnoughResourcesException e3)
		{
			
			  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}else if(e.getSource()==attackleft)
	{
		try {
			
			
			
			this.getGame2().attack(Direction.LEFT);
			Comparable [] order = this.getGame2().getTurnOrder().elements;
			
			 String x = "";
				for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
					 x += (((Champion)order[i]).getName()+"  \n  ");
					
				
				
					
				
				this.getAb().setText(x);
			set_player(this);
			
			for(int i=0;i<5;i++)
			{for(int j = 0;j<5;j++)
			{
			 if(this.getGame2().getBoard()[i][j]==null)
			 {
				 buttons.get((4-i)*5+j).setText("");
				 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
			 }
			 else
				 if(this.getGame2().getBoard()[i][j] instanceof Champion)
				 {
					 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
					 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
						 
					 }
					 else
					 {
						 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
					 }
					 
				 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
				 {
					 Cover m = (Cover)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
					 
					 
				 }
			 
			 
			}
				
				
			}
			
			if(this.getGame2().checkGameOver()!=null)
			{
				 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
				 TimeUnit.SECONDS.sleep(2);
				 this.dispose();
				
			}
			
			
		}  catch (InvalidTargetException e1) {
			
			  JOptionPane.showMessageDialog(null,"InvalidTarget" ,"Error",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(ChampionDisarmedException e2)
		{
			  JOptionPane.showMessageDialog(null,"The current champ is disarmed" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(NotEnoughResourcesException e3)
		{
			
			  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}
		else if(e.getSource()==abilities)
		{
			
			int uu  =  this.getAbilities().getSelectedIndex();
			Ability a = this.getGame2().getCurrentChampion().getAbilities().get(uu);
			String direc =  a.getCastArea().name();
			String d="";
			switch(direc)
			{
			case "DIRECTIONAL" : {
				do {
				 d = JOptionPane.showInputDialog("Enter a direction of the cast  ");
					d = d.toUpperCase();}
					while((!d.equals("UP"))&&(!d.equals("DOWN"))&&(!d.equals("RIGHT"))&&(!d.equals("LEFT")));
					if(d.equals("UP"))
					{
						try {
							this.getGame2().castAbility(a,Direction.UP);
							Comparable [] order = this.getGame2().getTurnOrder().elements;
							
							 String x = "";
								for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
									 x += (((Champion)order[i]).getName()+"  \n  ");
									
								
								
									
								
								this.getAb().setText(x);
							set_player(this);
							
							for(int i=0;i<5;i++)
							{for(int j = 0;j<5;j++)
							{
							 if(this.getGame2().getBoard()[i][j]==null)
							 {
								 buttons.get((4-i)*5+j).setText("");
								 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
							 }
							 else
								 if(this.getGame2().getBoard()[i][j] instanceof Champion)
								 {
									 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
									 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
										 
									 }
									 else
									 {
										 Champion m = (Champion)this.getGame2().getBoard()[i][j];
										 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
									 }
									 
								 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
								 {
									 Cover m = (Cover)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
									 
									 
								 }
							 
							 
							}
								
								
							}
							
							if(this.getGame2().checkGameOver()!=null)
							{
								 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
								 TimeUnit.SECONDS.sleep(2);
								 this.dispose();
								
							}
							
							
						}
						 catch ( CloneNotSupportedException e1) {
						
							  JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch(AbilityUseException e2)
						{
							
							  JOptionPane.showMessageDialog(null,"Can't use this Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (NotEnoughResourcesException e3)
						{
							  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					else if (d.equals("DOWN"))
					{
						try {
							this.getGame2().castAbility(a,Direction.DOWN);
							Comparable [] order = this.getGame2().getTurnOrder().elements;
							
							 String x = "";
								for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
									 x += (((Champion)order[i]).getName()+"  \n  ");
									
								
								
									
								
								this.getAb().setText(x);
							set_player(this);
							
							for(int i=0;i<5;i++)
							{for(int j = 0;j<5;j++)
							{
							 if(this.getGame2().getBoard()[i][j]==null)
							 {
								 buttons.get((4-i)*5+j).setText("");
								 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
							 }
							 else
								 if(this.getGame2().getBoard()[i][j] instanceof Champion)
								 {
									 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
									 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
										 
									 }
									 else
									 {
										 Champion m = (Champion)this.getGame2().getBoard()[i][j];
										 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
									 }
									 
								 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
								 {
									 Cover m = (Cover)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
									 
									 
								 }
							 
							 
							}
								
								
							}
							
							if(this.getGame2().checkGameOver()!=null)
							{
								 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
								 TimeUnit.SECONDS.sleep(2);
								 this.dispose();
								
							}
							
							
						}
						 catch ( CloneNotSupportedException e1) {
								
							  JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch(AbilityUseException e2)
						{
							
							  JOptionPane.showMessageDialog(null,"Can't use this Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (NotEnoughResourcesException e3)
						{
							  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if (d.equals("RIGHT"))
					{
						try {
							this.getGame2().castAbility(a,Direction.RIGHT);
							Comparable [] order = this.getGame2().getTurnOrder().elements;
							
							 String x = "";
								for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
									 x += (((Champion)order[i]).getName()+"  \n  ");
									
								
								
									
								
								this.getAb().setText(x);
							set_player(this);
							
							for(int i=0;i<5;i++)
							{for(int j = 0;j<5;j++)
							{
							 if(this.getGame2().getBoard()[i][j]==null)
							 {
								 buttons.get((4-i)*5+j).setText("");
								 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
							 }
							 else
								 if(this.getGame2().getBoard()[i][j] instanceof Champion)
								 {
									 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
									 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
										 
									 }
									 else
									 {
										 Champion m = (Champion)this.getGame2().getBoard()[i][j];
										 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
									 }
									 
								 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
								 {
									 Cover m = (Cover)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
									 
									 
								 }
							 
							 
							}
								
								
							}
							
							if(this.getGame2().checkGameOver()!=null)
							{
								 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
								 TimeUnit.SECONDS.sleep(2);
								 this.dispose();
								
							}
							
							
							
						}
						 catch ( CloneNotSupportedException e1) {
								
							  JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch(AbilityUseException e2)
						{
							
							  JOptionPane.showMessageDialog(null,"Can't use this Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (NotEnoughResourcesException e3)
						{
							  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else if (d.equals("LEFT"))
					{
						try {
							this.getGame2().castAbility(a,Direction.LEFT);
							Comparable [] order = this.getGame2().getTurnOrder().elements;
							
							 String x = "";
								for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
									 x += (((Champion)order[i]).getName()+"  \n  ");
									
								
								
									
								
								this.getAb().setText(x);
							set_player(this);
							
							for(int i=0;i<5;i++)
							{for(int j = 0;j<5;j++)
							{
							 if(this.getGame2().getBoard()[i][j]==null)
							 {
								 buttons.get((4-i)*5+j).setText("");
								 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
							 }
							 else
								 if(this.getGame2().getBoard()[i][j] instanceof Champion)
								 {
									 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
									 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
										 
									 }
									 else
									 {
										 Champion m = (Champion)this.getGame2().getBoard()[i][j];
										 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
									 }
								 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
								 {
									 Cover m = (Cover)this.getGame2().getBoard()[i][j];
									 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
									 
									 
								 }
							 
							 
							}
								
								
							}
							
							
							if(this.getGame2().checkGameOver()!=null)
							{
								 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
								 TimeUnit.SECONDS.sleep(2);
								 this.dispose();
								
							}
							
						}
						 catch ( CloneNotSupportedException e1) {
								
							  JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch(AbilityUseException e2)
						{
							
							  JOptionPane.showMessageDialog(null,"Can't use this Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (NotEnoughResourcesException e3)
						{
							  JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
							
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
						
						
			
			}break; 
 			case "SINGLETARGET" : {
 				String x = "";
 				String y ="";
 				int xx=0;
 				int yy=0;
 						
 			
 				do {
 					
 			 x = JOptionPane.showInputDialog("Enter the x axis between 0 and 4 ");
 				
 			
 		
 		        xx = Integer.parseInt(x);
 		       
 		   
 		    	
 		   
 			 
 				}
 			while (xx<0||xx>4);
 				
 				do {
 		 			
 		 			 y = JOptionPane.showInputDialog("Enter the y axis between 0 and 4  ");
 		 			
 		 			 yy = Integer.parseInt(y);
 		 		
 		 				}
 		 			while (yy<0||yy>4);
 				
 				
 			try {
				this.getGame2().castAbility(a,xx,yy);
				Comparable [] order = this.getGame2().getTurnOrder().elements;
				
				 String xy = "";
					for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
						 xy += (((Champion)order[i]).getName()+"  \n  ");
						
					
					
						
					
					this.getAb().setText(xy);
				set_player(this);
				
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
				
				if(this.getGame2().checkGameOver()!=null)
				{
					 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
					 TimeUnit.SECONDS.sleep(2);
					 this.dispose();
					
				}
				
				
			}
 			catch ( CloneNotSupportedException e1) {
 				 JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
 			catch ( InvalidTargetException e1) {
 				 JOptionPane.showMessageDialog(null,"InvalidTarget" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
 			catch (NotEnoughResourcesException e1) {
 				 JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
 			catch ( AbilityUseException e1) {
 				 JOptionPane.showMessageDialog(null,"Can't Use This Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			} catch (InterruptedException e1) {
				
			}
 			}break;
			case "SELFTARGET" : {try {
				this.getGame2().castAbility(a);
				Comparable [] order = this.getGame2().getTurnOrder().elements;
				
				 String x = "";
					for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
						 x += (((Champion)order[i]).getName()+"  \n  ");
						
					
					
						
					
					this.getAb().setText(x);
				set_player(this);
				
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
				if(this.getGame2().checkGameOver()!=null)
				{
					 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
					 TimeUnit.SECONDS.sleep(2);
					 this.dispose();
					
				}
				
				
				
			}
			catch ( CloneNotSupportedException e1) {
				 JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
			catch (NotEnoughResourcesException e1) {
				 JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			catch ( AbilityUseException e1) {
				 JOptionPane.showMessageDialog(null,"Can't Use This Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}break;
			case "TEAMTARGET" : {try {
				this.getGame2().castAbility(a);
				Comparable [] order = this.getGame2().getTurnOrder().elements;
				
				 String x = "";
					for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
						 x += (((Champion)order[i]).getName()+"  \n  ");
						
					
					
						
					
					this.getAb().setText(x);
				set_player(this);
			
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 { if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
					 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
						 
					 }
					 else
					 {
						 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
					 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
				
				if(this.getGame2().checkGameOver()!=null)
				{
					 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
					 TimeUnit.SECONDS.sleep(2);
					 this.dispose();
					
				}
				
				
			}
			catch ( CloneNotSupportedException e1) {
				 JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
			catch (NotEnoughResourcesException e1) {
				 JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			catch ( AbilityUseException e1) {
				 JOptionPane.showMessageDialog(null,"Can't Use This Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}break;
			case "SURROUND" : {try {
				this.getGame2().castAbility(a);
				
				Comparable [] order = this.getGame2().getTurnOrder().elements;
				
				 String x = "";
					for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
						 x += (((Champion)order[i]).getName()+"  \n  ");
						
					
					
						
					
					this.getAb().setText(x);
				set_player(this);
				
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 {
						 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
						 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
							 
						 }
						 else
						 {
							 Champion m = (Champion)this.getGame2().getBoard()[i][j];
							 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
						 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
				
				
				if(this.getGame2().checkGameOver()!=null)
				{
					 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
					 TimeUnit.SECONDS.sleep(2);
					 this.dispose();
					
				}
				
			}
			catch ( CloneNotSupportedException e1) {
				 JOptionPane.showMessageDialog(null,"CLONE_EXCEPTION_ERROR" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
			catch (NotEnoughResourcesException e1) {
				 JOptionPane.showMessageDialog(null,"NotEnoughResources" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			catch ( AbilityUseException e1) {
				 JOptionPane.showMessageDialog(null,"Can't Use This Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}break;
			
			
			
			
			
			}
			
			
		
			
			
			
			
		}else if(e.getSource()==useLeader)
		{
			try {
				System.out.print(this.getGame2().getFirstPlayer().getLeader().getName());
				this.getGame2().useLeaderAbility();
				Comparable [] order = this.getGame2().getTurnOrder().elements;
				
				 String x = "";
					for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
						 x += (((Champion)order[i]).getName()+"  \n  ");
						
					
					
						
					
					this.getAb().setText(x);
				
				if(this.getGame2().getFirstPlayer().getLeader().equals(this.getGame2().getCurrentChampion()))
				{
					this.player1usedability=true;
					
				}
				if(this.getGame2().getSecondPlayer().getLeader().equals(this.getGame2().getCurrentChampion()))
				{
					this.player2usedability=true;
					
				}
				set_player(this);
				
			
				for(int i=0;i<5;i++)
				{for(int j = 0;j<5;j++)
				{
				 if(this.getGame2().getBoard()[i][j]==null)
				 {
					 buttons.get((4-i)*5+j).setText("");
					 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
				 }
				 else
					 if(this.getGame2().getBoard()[i][j] instanceof Champion)
					 { if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
					 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+""+m.getCurrentHP());
						 
					 }
					 else
					 {
						 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText(m.getName()+""+m.getCurrentHP());
					 }
						 
					 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
					 {
						 Cover m = (Cover)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
						 
						 
					 }
				 
				 
				}
					
					
				}
				
				if(this.getGame2().checkGameOver()!=null)
				{
					 JOptionPane.showMessageDialog(null,"The Winner "+((Player)this.getGame2().checkGameOver()).getName() ,"Winner",JOptionPane.INFORMATION_MESSAGE);
					 TimeUnit.SECONDS.sleep(2);
					 this.dispose();
					
				}
				
			} catch ( LeaderAbilityAlreadyUsedException e1) {
				 JOptionPane.showMessageDialog(null,"The Leader has Already Used His Ability" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			catch (  LeaderNotCurrentException e2) {
				 JOptionPane.showMessageDialog(null,"The Current Champion is not The Leader" ,"Error",JOptionPane.INFORMATION_MESSAGE);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if (e.getSource()==endturn)
		{
			this.getGame2().endTurn();
			set_player(this);
			for(int i=0;i<5;i++)
			{for(int j = 0;j<5;j++)
			{
			 if(this.getGame2().getBoard()[i][j]==null)
			 {
				 buttons.get((4-i)*5+j).setText("");
				 buttons.get((4-i)*5+j).setBackground(Color.WHITE);
			 }
			 else
				 if(this.getGame2().getBoard()[i][j] instanceof Champion)
				 {
					 if(this.getGame2().getCurrentChampion().equals((Champion)this.getGame2().getBoard()[i][j]))
					 {	 Champion m = (Champion)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("currently playing"+m.getName()+" "+m.getCurrentHP());
						 
					 }
					 else
					 {
						 Champion m = (Champion)this.getGame2().getBoard()[i][j];
						 buttons.get((4-i)*5+j).setText(m.getName()+" "+m.getCurrentHP());
					 }
				
					 
				 }else if (this.getGame2().getBoard()[i][j] instanceof Cover)
				 {
					 Cover m = (Cover)this.getGame2().getBoard()[i][j];
					 buttons.get((4-i)*5+j).setText("Cover "+" "+m.getCurrentHP());
					 
					 
				 }
				
			 
			}
			
			}
			
			
		
			this.getAbilities().setRequestFocusEnabled(false);
			this.getAbilities().removeActionListener(this);;
			this.getAbilities().removeAllItems();
			int ooo = this.getGame2().getCurrentChampion().getAbilities().size();
			String a[] = new String[ooo] ;
			for(int i=0;i<this.getGame2().getCurrentChampion().getAbilities().size();i++)
			{
				a[i]=this.getGame2().getCurrentChampion().getAbilities().get(i).getName();
				this.getAbilities().addItem(a[i]);
				
			}
		this.getAbilities().addActionListener(this);
		
		Comparable [] order = this.getGame2().getTurnOrder().elements;
		
		 String x = "";
			for(int i=this.getGame2().getTurnOrder().size()-1;i>=0;i--)
				 x += (((Champion)order[i]).getName()+"  \n  ");
				
			
			
				
			
			this.getAb().setText(x);
		
			
			
			
		
			
		 
			
			
			 
		 
			
			
		}
		else if(e.getSource()==buttons.get(0))
		{
			if(this.getGame2().getBoard()[4][0] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[4][0];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		else if(e.getSource()==buttons.get(1))
		{
			if(this.getGame2().getBoard()[4][1] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[4][1];
				
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(2))
		{
			if(this.getGame2().getBoard()[4][2] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[4][2];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(3))
		{
			if(this.getGame2().getBoard()[4][3] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[4][3];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(4))
		{
			if(this.getGame2().getBoard()[4][4] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[4][4];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(5))
		{
			if(this.getGame2().getBoard()[3][0] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[3][0];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(6))
		{
			if(this.getGame2().getBoard()[3][1] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[3][1];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(7))
		{
			if(this.getGame2().getBoard()[3][2] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[3][2];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(8))
		{
			if(this.getGame2().getBoard()[3][3] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[3][3];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(9))
		{
			if(this.getGame2().getBoard()[3][4] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[3][4];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(10))
		{
			if(this.getGame2().getBoard()[2][0] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[2][0];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(11))
		{
			if(this.getGame2().getBoard()[2][1] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[2][1];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(12))
		{
			if(this.getGame2().getBoard()[2][2] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[2][2];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(13))
		{
			if(this.getGame2().getBoard()[2][3] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[2][3];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		}
		else if(e.getSource()==buttons.get(14))
		{
			if(this.getGame2().getBoard()[2][4] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[2][4];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		else if(e.getSource()==buttons.get(15))
		{
			if(this.getGame2().getBoard()[1][0] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[1][0];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		}
		else if(e.getSource()==buttons.get(16))
		{
			if(this.getGame2().getBoard()[1][1] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[1][1];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		}
		else if(e.getSource()==buttons.get(17))
		{
			if(this.getGame2().getBoard()[1][2] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[1][2];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		}
		else if(e.getSource()==buttons.get(18))
		{
			if(this.getGame2().getBoard()[1][3] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[1][3];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		}
		else if(e.getSource()==buttons.get(19))
		{
			if(this.getGame2().getBoard()[1][4] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[1][4];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		}
		else if(e.getSource()==buttons.get(20))
		{
			if(this.getGame2().getBoard()[0][0] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[0][0];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
			
		}
		
		else if(e.getSource()==buttons.get(21))
		{
			if(this.getGame2().getBoard()[0][1] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[0][1];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else if(e.getSource()==buttons.get(22))
		{
			if(this.getGame2().getBoard()[0][2] instanceof Champion)
			{Champion  m = (Champion)this.getGame2().getBoard()[0][2];
			String leader = "Not";
			if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
			{
				leader = "Yes";
			}
			else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
			{
				leader = "Yes";
			}
			String j = "";
			if(m instanceof Hero)
			{
				j="Hero";
			}
			else
				if(m instanceof AntiHero)
				{
					j="AntiHero";
				}
				else
				{
					j="Villan";
				}
			String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
			for(int i=0;i<m.getAppliedEffects().size();i++)
			{
				Effect f =  m.getAppliedEffects().get(i);
				s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
						
			}
			JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
			
			}
		}
		else if(e.getSource()==buttons.get(23))
		{
			if(this.getGame2().getBoard()[0][3] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[0][3];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		else if(e.getSource()==buttons.get(24))
		{
			if(this.getGame2().getBoard()[0][4] instanceof Champion)
			{
				Champion  m = (Champion)this.getGame2().getBoard()[0][4];
				String leader = "Not";
				if(m.equals(this.getGame2().getFirstPlayer().getLeader()))
				{
					leader = "Yes";
				}
				else if (m.equals(this.getGame2().getSecondPlayer().getLeader()))
				{
					leader = "Yes";
				}
				String j = "";
				if(m instanceof Hero)
				{
					j="Hero";
				}
				else
					if(m instanceof AntiHero)
					{
						j="AntiHero";
					}
					else
					{
						j="Villan";
					}
				String s = m.getName()+"\n"+m.getCondition().name()+"\n"+"Current Action Points "+m.getCurrentActionPoints()+"\n"+"Mana: "+ m.getMana()+"\n"+"AttackDamage:"+m.getAttackDamage()+"\n"+"AttackRange: "+m.getAttackRange()+"\n"+"CurrentHP"+m.getCurrentHP()+"\n"+"Speed: "+m.getSpeed()+"\n"+"MaxActionsPerTurn: "+m.getMaxActionPointsPerTurn()+"\n"+"Type:"+j+"\n"+"Leader"+leader+ "\n";
				for(int i=0;i<m.getAppliedEffects().size();i++)
				{
					Effect f =  m.getAppliedEffects().get(i);
					s+="Effect : "+  f.getName()+" Duration: "+f.getDuration()+" TYPE: "+f.getType().name() +"\n";
							
				}
				JOptionPane.showMessageDialog(null,s ,"Champ_Info",JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		
		
		
		
		
			
		
		
		
	}
	
		
			
		
		
		
	}
	


