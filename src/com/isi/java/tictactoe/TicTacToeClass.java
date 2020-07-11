package com.isi.java.tictactoe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class TicTacToeClass  extends JFrame 
{
	//private turnXorY currentmove=turnXorY.EMPTYMOVE;
	private ImageIcon playAgainImage;
	public JPanel mainPanel;
	public JButton[][] dispalyBoard;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem startNewGame;
	private JMenuItem exit;

	private JMenu menuPlayWithFriends;
	private JMenuItem threeViewGrid;

	private JMenu menuPlayWithComputer;
	private JMenuItem easyLevel;

	private JMenuItem fourViewGrid;
	public boolean winnerPlayer;
	public String currentPlayer;

	private JPanel displayplayerLabel;
	private JPanel displayplayerwin;
	private JPanel jointPanle;
	private JPanel displayAllPanels;

	private JLabel player1;
	public JLabel displayX;
	private JLabel player2;
	public JLabel displayY;
	private JButton playAgain;
	private JPanel playAgainPanel;
	private JPanel xyPanel;
	private JPanel playerXLbel;
	private JPanel playerYLbel;
	private JButton button;
	private JLabel displayChangeXnY;

	public int xScore = 0;
	public int yScore = 0;
	int i,j;

	public TicTacToeClass() 
	{
		super();

		currentPlayer =" ";
		winnerPlayer=false;

		creatPanels();
		createComponents();
		buttonPrintthreegrid();
		//buttonPrintfourgrid();
		//computerTurn();
		addListners();
		randomPlayer();
		addComponentsToPanels(); 

		setTitle("Tic Tac Toe Game");
		setSize(1000,800);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		playAgainImage=new ImageIcon("C:\\Users\\ssatvirs\\Documents\\Java projects\\TicTacProject\\alphabet-2051685_640.png");

	}

	private void randomPlayer()      //choose the random turn
	{
		Random random = new Random();
		boolean xTurn = random.nextBoolean();
		System.out.println(xTurn);
		if(xTurn) currentPlayer="O";
		else currentPlayer="X";
	}

	private void creatPanels() 
	{
		displayAllPanels=(JPanel) getContentPane();
		displayAllPanels.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.gray));

		jointPanle=new JPanel();
		jointPanle.setLayout(new GridLayout(1,2));
		//jointPanle.setLayout( new BoxLayout(jointPanle, BoxLayout.X_AXIS));

		mainPanel=new JPanel();
		mainPanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.CYAN));
		mainPanel.setLayout(new GridLayout(4, 4,10,10));
		mainPanel.setBackground(Color.orange);
		mainPanel.setSize(250, 500);


		displayplayerwin=new JPanel();
		displayplayerwin.setLayout(new FlowLayout(FlowLayout.RIGHT));
		displayplayerwin.setBackground(Color.black);
		displayplayerwin.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.red));
		displayplayerwin.setLayout(new GridLayout(2,1));

		xyPanel=new JPanel();
		xyPanel = new JPanel();
		xyPanel.setLayout(new GridLayout(2,2));
		xyPanel.setBackground(Color.GRAY);
		xyPanel.setLayout(new BoxLayout(xyPanel,BoxLayout.Y_AXIS));
		xyPanel.setSize(233, 234);
		xyPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		//BorderFactory.createLineBorder(Color.BLUE),




		playAgainPanel = new JPanel();
		playAgainPanel.setBackground(Color.GRAY);
		playAgainPanel.setLayout(new FlowLayout(1));


		playerXLbel=new JPanel();
		playerXLbel.setBackground(Color.GRAY);
		playerXLbel.setLayout(new BoxLayout(playerXLbel,BoxLayout.X_AXIS));

		playerYLbel=new JPanel();
		playerYLbel.setBackground(Color.GRAY);
		playerYLbel.setLayout(new BoxLayout(playerYLbel,BoxLayout.X_AXIS));
	}

	private void buttonPrintthreegrid()        //display the button for three grid
	{

		dispalyBoard=new JButton[3][3];
		for (int i = 0; i < dispalyBoard.length; i++) {
			for (int j = 0; j < dispalyBoard.length; j++) {
				JButton button=new JButton();
				dispalyBoard[i][j]=button;
				dispalyBoard[i][j].setBackground(Color.white);
				dispalyBoard[i][j].setOpaque(true);
				
				dispalyBoard[i][j].setSize(100, 50);
				button.addActionListener((ActionEvent e)->
				{
					if(((JButton)e.getSource()).getText().equals("")&& winnerPlayer==false)
					{
					
							button.setText(currentPlayer);
							button.setForeground(Color.BLUE);
							button.setFont(new Font("Serif", Font.PLAIN, 74));
						
						winnerPlayer();
						changeMoves();
						gameDrawThreeGrid();
					}
				});

				mainPanel.add(button);

			}
		}  	
	}

	private void buttonPrintfourgrid()                      //display the button to play 4 grid
	{
		dispalyBoard=new JButton[4][4];
		for (int i = 0; i < dispalyBoard.length; i++) {
			for (int j = 0; j < dispalyBoard.length; j++) {
				JButton button=new JButton();
				dispalyBoard[i][j]=button;
				dispalyBoard[i][j].setBackground(Color.white);
				dispalyBoard[i][j].setOpaque(true);
				dispalyBoard[i][j].setSize(100, 50);
				button.addActionListener((ActionEvent e)->
				{
					if(((JButton)e.getSource()).getText().equals("")&& winnerPlayer==false)
					{
						button.setText(currentPlayer);
						button.setForeground(Color.RED);
						button.setFont(new Font("Serif", Font.PLAIN, 54));
						winnerPlayerFourGrid();
						changeMoves();
						gameDrawFourGrid();

					}
				});

				mainPanel.add(button);
			}
		}
	}
	private void createComponents()
	{
		//menu bar
		menuBar=new JMenuBar();
		menu =new JMenu("File");                                             //menu items
		startNewGame=new JMenuItem("New Game");
		exit=new JMenuItem("Exit Game");

		menuPlayWithFriends=new JMenu("Play With Frinds");
		threeViewGrid=new JMenuItem("3*3 PlayingBox");
		fourViewGrid=new JMenuItem("4*4 Playing Box");

		menuPlayWithComputer=new JMenu("Play With AI");
		easyLevel=new JMenuItem("Easy Level");
		//right panel with counting wins and play again button
		player1=new JLabel("  X wins------");
		player1.setFont(new Font( "",Font.BOLD, 30));
		displayX=new JLabel("0");
		displayX.setFont(new Font( "",Font.ITALIC, 30));
		displayX.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

		player2=new JLabel("O wins------");
		player2.setFont(new Font( "",Font.CENTER_BASELINE, 30));
		displayY=new JLabel("  0");
		displayY.setFont(new Font( "",Font.ITALIC, 30));
		displayY.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));	

		playAgain=new JButton(new ImageIcon("C:\\Users\\ssatvirs\\Documents\\Java projects\\TicTacProject\\playagain.png"));
		//playAgain.setSize(6031, 1000);
		playAgain.setPreferredSize(new Dimension(200, 100));
		playAgain.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));	
		//playAgain.setLocation(1008,45);
		displayChangeXnY=new JLabel();
		displayChangeXnY.setPreferredSize(new Dimension(300,120));
		displayChangeXnY.setFont(new Font( "",Font.LAYOUT_NO_LIMIT_CONTEXT, 25));
		displayChangeXnY.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		//displayChangeXnY.setBackground(Color.GREEN);
	}
	private void addListners()
	{

		threeViewGrid.addActionListener((ActionEvent e)->       //button to play three grid
		{ 
			removeButton();
			resetGame();
			buttonPrintthreegrid();
			paintComponents(getGraphics());

		});

		fourViewGrid.addActionListener((ActionEvent e)->      //button to play four grid
		{
			removeButton();
			resetGame();
			buttonPrintfourgrid();
			paintComponents(getGraphics());
		});

		startNewGame.addActionListener((ActionEvent e)->          //start the new game 
		{
			displayX.setText(Integer.toString(0));
			xScore=0;
			yScore=0;
			displayX.setText("0");
			displayY.setText("0");
			resetGame();
		});


		exit.addActionListener((ActionEvent e)->     //Exit button
		{
			int yes=JOptionPane.showConfirmDialog( this, "Do you want to exit","Exit",JOptionPane.YES_NO_OPTION);
			if(yes==0)
				System.exit(0);
		});

		easyLevel.addActionListener((ActionEvent e)->           //button for ai
		{
			removeButton();
			resetGame();
			//computerTurnGenerator();
			computerTurn();
			paintComponents(getGraphics());
		});


		playAgain.addActionListener((ActionEvent e)->              //play again button to start again 
		{
			displayChangeXnY.setText("  ");
			resetGame();
		
		});

	}
	private void addComponentsToPanels() {


		menu.add(startNewGame);                              //menu bar upper left side
		menu.add(exit);
		menuPlayWithFriends.add(threeViewGrid);
		menuPlayWithFriends.add(fourViewGrid);
		menuBar.add(menu);
		menuBar.add(menuPlayWithFriends);
		menuBar.add(menuPlayWithComputer);
		menuPlayWithComputer.add(easyLevel);
		setJMenuBar(menuBar);


		playerXLbel.add(player1);                    //label for count the win's of X player
		playerXLbel.add(displayX);
		xyPanel.add(playerXLbel);

		playerYLbel.add(player2);                    //label for to count win's of Y player
		playerYLbel.add(displayY);
		xyPanel.add(playerYLbel);


		playAgainPanel.add(playAgain);
		playAgainPanel.add(displayChangeXnY);
		displayplayerwin.add(xyPanel);
		displayplayerwin.add(playAgainPanel);


		jointPanle.add(mainPanel);
		jointPanle.add(displayplayerwin);


		displayAllPanels.add(jointPanle);        
	}

	private void resetGame()            //method to reset the the game for new game
	{

		winnerPlayer= false;
		for(int i=0;i<dispalyBoard.length;i++) {
			for(int j=0;j<dispalyBoard.length;j++) {
				dispalyBoard[i][j].setText("");
				dispalyBoard[i][j].setBackground(Color.white);
			}
		}

	}
	private void changeMoves()           //change the move form X to O
	{
		if(currentPlayer.equals("X"))
		{
			currentPlayer="O";
		}
		else if

		(currentPlayer.equals("O"))
			currentPlayer="X";


	}
	private void winnerPlayer()            //method for three grid view 
	{
		if(currentPlayer=="X") {
			displayChangeXnY.setText("Player O's turn");}
		if(currentPlayer=="O")
		{
			displayChangeXnY.setText("Player X's turn");

		}


		if(dispalyBoard[0][0].getText().equals(currentPlayer)&&dispalyBoard[0][1].getText().equals(currentPlayer)&&dispalyBoard[0][2].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][0].setBackground(Color.red);
				dispalyBoard[0][1].setBackground(Color.red);
				dispalyBoard[0][2].setBackground(Color.red);
			}

		}
		if(dispalyBoard[1][0].getText().equals(currentPlayer)&&dispalyBoard[1][1].getText().equals(currentPlayer)&&dispalyBoard[1][2].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;

			if(winnerPlayer==true) 
			{
				dispalyBoard[1][0].setBackground(Color.red);
				dispalyBoard[1][1].setBackground(Color.red);
				dispalyBoard[1][2].setBackground(Color.red);
			}
		}
		if(dispalyBoard[2][0].getText().equals(currentPlayer)&&dispalyBoard[2][1].getText().equals(currentPlayer)&&dispalyBoard[2][2].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[2][0].setBackground(Color.red);
				dispalyBoard[2][1].setBackground(Color.red);
				dispalyBoard[2][2].setBackground(Color.red);
			}
		}
		if(dispalyBoard[0][0].getText().equals(currentPlayer)&&dispalyBoard[1][0].getText().equals(currentPlayer)&&dispalyBoard[2][0].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][0].setBackground(Color.red);
				dispalyBoard[1][0].setBackground(Color.red);
				dispalyBoard[2][0].setBackground(Color.red);
			}  
			
		}
		if(dispalyBoard[0][1].getText().equals(currentPlayer)&&dispalyBoard[1][1].getText().equals(currentPlayer)&&dispalyBoard[2][1].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][1].setBackground(Color.red);
				dispalyBoard[1][1].setBackground(Color.red);
				dispalyBoard[2][1].setBackground(Color.red);
			}
		}
		if(dispalyBoard[0][2].getText().equals(currentPlayer)&&dispalyBoard[1][2].getText().equals(currentPlayer)&&dispalyBoard[2][2].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][2].setBackground(Color.red);
				dispalyBoard[1][2].setBackground(Color.red);
				dispalyBoard[2][2].setBackground(Color.red);
			}
		}
		if(dispalyBoard[0][0].getText().equals(currentPlayer)&&dispalyBoard[1][1].getText().equals(currentPlayer)&&dispalyBoard[2][2].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][0].setBackground(Color.red);
				dispalyBoard[1][1].setBackground(Color.red);
				dispalyBoard[2][2].setBackground(Color.red);
			}
		}
		if(dispalyBoard[0][2].getText().equals(currentPlayer)&&dispalyBoard[1][1].getText().equals(currentPlayer)&&dispalyBoard[2][0].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][2].setBackground(Color.red);
				dispalyBoard[1][1].setBackground(Color.red);
				dispalyBoard[2][0].setBackground(Color.red);
			}
		}

		if(winnerPlayer==true)	      // add winning turns for X and Y player
		{
			if(currentPlayer=="X")
				displayX.setText(Integer.toString(++xScore));
			else
				displayY.setText(Integer.toString(++yScore));
		}
		if(winnerPlayer==true)          //label for update the X or O player winning turn
		{

			displayChangeXnY.setText("Player "+currentPlayer+" is won");
		}
	}


	private void winnerPlayerFourGrid()          // method for winner player in 4 grid
	{ 
		if(currentPlayer=="X") {
			displayChangeXnY.setText("Player O's turn");}
		if(currentPlayer=="O")
		{
			displayChangeXnY.setText("Player X's turn");

		}

		if(dispalyBoard[0][0].getText().equals(currentPlayer)&&dispalyBoard[0][1].getText().equals(currentPlayer)&&dispalyBoard[0][2].getText().equals(currentPlayer)&&dispalyBoard[0][3].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][0].setBackground(Color.green);
				dispalyBoard[0][1].setBackground(Color.CYAN);
				dispalyBoard[0][2].setBackground(Color.blue);
				dispalyBoard[0][3].setBackground(Color.MAGENTA);
			}

		}
		if(dispalyBoard[1][0].getText().equals(currentPlayer)&&dispalyBoard[1][1].getText().equals(currentPlayer)&&dispalyBoard[1][2].getText().equals(currentPlayer)&&dispalyBoard[1][3].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;

			if(winnerPlayer==true) 
			{
				dispalyBoard[1][0].setBackground(Color.green);
				dispalyBoard[1][1].setBackground(Color.CYAN);
				dispalyBoard[1][2].setBackground(Color.blue);
				dispalyBoard[1][3].setBackground(Color.MAGENTA);
			}


		}
		if(dispalyBoard[2][0].getText().equals(currentPlayer)&&dispalyBoard[2][1].getText().equals(currentPlayer)&&dispalyBoard[2][2].getText().equals(currentPlayer)&&dispalyBoard[2][3].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[2][0].setBackground(Color.green);
				dispalyBoard[2][1].setBackground(Color.CYAN);
				dispalyBoard[2][2].setBackground(Color.blue);
				dispalyBoard[2][3].setBackground(Color.MAGENTA);
			}


		}
		if(dispalyBoard[3][0].getText().equals(currentPlayer)&&dispalyBoard[3][1].getText().equals(currentPlayer)&&dispalyBoard[3][2].getText().equals(currentPlayer)&&dispalyBoard[3][3].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[3][0].setBackground(Color.green);
				dispalyBoard[3][1].setBackground(Color.CYAN);
				dispalyBoard[3][2].setBackground(Color.blue);
				dispalyBoard[3][3].setBackground(Color.MAGENTA);
			}


		}
		if(dispalyBoard[0][0].getText().equals(currentPlayer)&&dispalyBoard[1][0].getText().equals(currentPlayer)&&dispalyBoard[2][0].getText().equals(currentPlayer)&&dispalyBoard[3][0].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][0].setBackground(Color.green);
				dispalyBoard[1][0].setBackground(Color.CYAN);
				dispalyBoard[2][0].setBackground(Color.blue);
				dispalyBoard[3][0].setBackground(Color.MAGENTA);
			}


		}
		if(dispalyBoard[0][1].getText().equals(currentPlayer)&&dispalyBoard[1][1].getText().equals(currentPlayer)&&dispalyBoard[2][1].getText().equals(currentPlayer)&&dispalyBoard[3][1].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][1].setBackground(Color.green);
				dispalyBoard[1][1].setBackground(Color.CYAN);
				dispalyBoard[2][1].setBackground(Color.blue);
				dispalyBoard[3][1].setBackground(Color.MAGENTA);
			}


		}
		if(dispalyBoard[0][2].getText().equals(currentPlayer)&&dispalyBoard[1][2].getText().equals(currentPlayer)&&dispalyBoard[2][2].getText().equals(currentPlayer)&&dispalyBoard[3][2].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][2].setBackground(Color.green);
				dispalyBoard[1][2].setBackground(Color.CYAN);
				dispalyBoard[2][2].setBackground(Color.blue);
				dispalyBoard[3][2].setBackground(Color.MAGENTA);
			}


		}
		if(dispalyBoard[0][3].getText().equals(currentPlayer)&&dispalyBoard[1][3].getText().equals(currentPlayer)&&dispalyBoard[2][3].getText().equals(currentPlayer)&&dispalyBoard[3][3].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;

			if(winnerPlayer==true) 
			{
				dispalyBoard[0][3].setBackground(Color.green);
				dispalyBoard[1][3].setBackground(Color.CYAN);
				dispalyBoard[2][3].setBackground(Color.blue);
				dispalyBoard[3][3].setBackground(Color.MAGENTA);
			}

		}
		if(dispalyBoard[0][0].getText().equals(currentPlayer)&&dispalyBoard[1][1].getText().equals(currentPlayer)&&dispalyBoard[2][2].getText().equals(currentPlayer)&&dispalyBoard[3][3].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][0].setBackground(Color.green);
				dispalyBoard[1][1].setBackground(Color.CYAN);
				dispalyBoard[2][2].setBackground(Color.blue);
				dispalyBoard[3][3].setBackground(Color.MAGENTA);
			}

		}
		if(dispalyBoard[0][3].getText().equals(currentPlayer)&&dispalyBoard[1][2].getText().equals(currentPlayer)&&dispalyBoard[2][1].getText().equals(currentPlayer)&&dispalyBoard[3][0].getText().equals(currentPlayer))
		{
			System.out.println("Player "+currentPlayer+" is Won");
			winnerPlayer=true;
			if(winnerPlayer==true) 
			{
				dispalyBoard[0][3].setBackground(Color.green);
				dispalyBoard[1][2].setBackground(Color.CYAN);
				dispalyBoard[2][1].setBackground(Color.blue);
				dispalyBoard[3][0].setBackground(Color.MAGENTA);
			}

		}
		if(winnerPlayer==true)				// add winning turns for X and Y player
		{
			if(currentPlayer=="X")
				displayX.setText(Integer.toString(++xScore));
			else
				displayY.setText(Integer.toString(++yScore));
		}
		if(winnerPlayer==true)             //update the level X or O win
		{

			displayChangeXnY.setText("Player "+currentPlayer+" is won");
		}
	}



	public void gameDrawThreeGrid()     //method to find the draw in 3*3 tic tac game

	{
		if((dispalyBoard[0][0].getText().equals("X")||dispalyBoard[0][0].getText().equals("O")) 
				&& (dispalyBoard[0][1].getText().equals("X")||dispalyBoard[0][1].getText().equals("O"))
				&& (dispalyBoard[0][2].getText().equals("X")||dispalyBoard[0][2].getText().equals("O"))
				&& (dispalyBoard[1][0].getText().equals("X")||dispalyBoard[1][0].getText().equals("O")) 
				&& (dispalyBoard[1][1].getText().equals("X")||dispalyBoard[1][1].getText().equals("O"))
				&& (dispalyBoard[1][2].getText().equals("X")||dispalyBoard[1][2].getText().equals("O")) 
				&& (dispalyBoard[2][0].getText().equals("X")||dispalyBoard[2][0].getText().equals("O")) 
				&& (dispalyBoard[2][1].getText().equals("X")||dispalyBoard[2][1].getText().equals("O"))
				&& (dispalyBoard[2][2].getText().equals("X")||dispalyBoard[2][2].getText().equals("O"))
				&&winnerPlayer==false) 
		{

			JOptionPane.showConfirmDialog( this, "Game Draw Play Again Or Exit","Draw Game!!",JOptionPane.CLOSED_OPTION);
		}
	}		
	public void gameDrawFourGrid()     //method to find the draw game in 4*4 tic tac
	{
		if((dispalyBoard[0][0].getText().equals("X")||dispalyBoard[0][0].getText().equals("O"))
				&& (dispalyBoard[0][1].getText().equals("X")||dispalyBoard[0][1].getText().equals("O"))
				&& (dispalyBoard[0][2].getText().equals("X")||dispalyBoard[0][2].getText().equals("O"))
				&& (dispalyBoard[0][3].getText().equals("X")||dispalyBoard[0][3].getText().equals("O"))
				&& (dispalyBoard[1][0].getText().equals("X")||dispalyBoard[1][0].getText().equals("O")) 
				&& (dispalyBoard[1][1].getText().equals("X")||dispalyBoard[1][1].getText().equals("O"))
				&& (dispalyBoard[1][2].getText().equals("X")||dispalyBoard[1][2].getText().equals("O")) 
				&& (dispalyBoard[1][3].getText().equals("X")||dispalyBoard[1][3].getText().equals("O"))
				&& (dispalyBoard[2][0].getText().equals("X")||dispalyBoard[2][0].getText().equals("O")) 
				&& (dispalyBoard[2][1].getText().equals("X")||dispalyBoard[2][1].getText().equals("O"))
				&& (dispalyBoard[2][2].getText().equals("X")||dispalyBoard[2][2].getText().equals("O"))
				&& (dispalyBoard[2][3].getText().equals("X")||dispalyBoard[2][3].getText().equals("O"))
				&& (dispalyBoard[3][0].getText().equals("X")||dispalyBoard[3][0].getText().equals("O"))
				&& (dispalyBoard[3][1].getText().equals("X")||dispalyBoard[3][1].getText().equals("O"))
				&& (dispalyBoard[3][2].getText().equals("X")||dispalyBoard[3][2].getText().equals("O"))
				&& (dispalyBoard[3][3].getText().equals("X")||dispalyBoard[3][3].getText().equals("O"))
				&&winnerPlayer==false) {

			JOptionPane.showConfirmDialog( this, "Game Draw Play Again Or Exit","Draw Game!!",JOptionPane.CLOSED_OPTION);
		}
	}

	private void removeButton()      //clean the board to print the new one
	{
		for (int i = 0; i < dispalyBoard.length; i++)
		{
			for (int j = 0; j <dispalyBoard.length; j++) 
				mainPanel.remove(dispalyBoard[i][j]);
		}
	}

	public void computerTurnGenerator()     //AI turn gnerate 
	{
		int i = 1;
		//currentPlayer="O";
		JButton button=new JButton();

	
		Random random=new Random();
		int automaticTurn=random.nextInt(10);
	
			if(automaticTurn==1 &&button.getText().equals(" ")&&!button.getText().equals("O")&&!button.getText().equals("X"))
			{
				System.out.println("number random 1");
				
				button = dispalyBoard[0][0];//=button; 
					button.setText("O");}
			
			if(automaticTurn==2&&button.getText().equals("")&&!button.getText().equals("O")&&!button.getText().equals("X"))
			{
				System.out.println("number random 2");
				button=dispalyBoard[0][1]; 
					button.setText("O");}
			
			if(automaticTurn==3&&button.getText().equals(""))
			{
				System.out.println("number random 3");
				button=dispalyBoard[0][2]; 
					button.setText("O");}
			
			if(automaticTurn==4&&button.getText().equals(""))
			{
				System.out.println("number random 4");
				button=dispalyBoard[1][0];
					dispalyBoard[1][0].setText("O");}
			
			if(automaticTurn==5&&button.getText().equals(""))
			{
				System.out.println("number random 5");
				// dispalyBoard[1][1].equals(" "); 
				button=dispalyBoard[1][1];
					dispalyBoard[1][1].setText("O");
				System.out.println("its no five");
			//	automaticTurn=i;
			}
			if(automaticTurn==6&&button.getText().equals(""))
			{
				System.out.println("number random 6");
				// dispalyBoard[1][2].equals(" "); 
				button=dispalyBoard[1][2];
					dispalyBoard[1][2].setText("O");
					
				System.out.println("its no six");
				//automaticTurn=i;
			}
			if(automaticTurn==7&&button.getText().equals(""))
			{
				System.out.println("number random 7");
			//	 dispalyBoard[2][0].equals(" "); 
				button=dispalyBoard[2][0];
					dispalyBoard[2][0].setText("O");
				System.out.println("its no seven");
			//	automaticTurn=i;
			}
			if(automaticTurn==8&&button.getText().equals(""))
			{
				System.out.println("number random 8");
				// dispalyBoard[2][1].equals(" "); 
				button=dispalyBoard[2][1];
					dispalyBoard[2][1].setText("O");
				System.out.println("its no eight");
			//	automaticTurn=i;
			}
			if(automaticTurn==9&&button.getText().equals(""))
			{
				System.out.println("number random 9");
				//dispalyBoard[2][2].equals(" "); 
				button=dispalyBoard[2][2];
					dispalyBoard[2][2].setText("O");
				System.out.println("its no nine");
			//	automaticTurn=i;
			}
		
	}		
														
	public void computerTurn()       //play with Ai
	{

		
		dispalyBoard=new JButton[3][3];
		for ( i = 0; i < dispalyBoard.length; i++) {
			for ( j = 0; j < dispalyBoard.length; j++) {
				JButton button=new JButton();
				dispalyBoard[i][j]=button;
				dispalyBoard[i][j].setBackground(Color.gray);
				dispalyBoard[i][j].setOpaque(true);
				dispalyBoard[i][j].setSize(100, 50);
				button.addActionListener((ActionEvent e)->
				{
					if(((JButton)e.getSource()).getText().equals("")&& winnerPlayer==false)
					{
					
						button.setForeground(Color.CYAN);
						button.setFont(new Font("Serif", Font.PLAIN, 74));
						System.out.println("x print");
						currentPlayer="O";
						button.setForeground(Color.CYAN);
						button.setFont(new Font("Serif", Font.PLAIN, 74));
						computerTurnGenerator();
						//button.setText(currentPlayer);
					
						currentPlayer="X";
						
						button.setText(currentPlayer);
					
						}
					winnerPlayer();
					changeMoves();
					gameDrawThreeGrid();
					});

				mainPanel.add(button);

			}
		}
	}

}

