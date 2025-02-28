package RPS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RockPaperScissorGUI extends JFrame implements ActionListener
{
	JButton RButton, PButton, SButton;
	
	JLabel computerChoice;
	
	JLabel computerScoreLabel, playerScoreLabel;
	
	RockPaperScissor rockPaperScissor;
	
	public RockPaperScissorGUI()
	{
		//invoke jframe constructor and add title to the GUI
		super("RockPaperScissor");
		
		//set size of GUI
		setSize(450,574);
		
		//set Layout to null to disable layout management
		setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		rockPaperScissor = new RockPaperScissor();
		
		
		addGuiComponents();
	}
	private void addGuiComponents()
	{
		computerScoreLabel = new JLabel("Computer: 0");
		computerScoreLabel.setBounds(0, 43, 450, 30);
		computerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(computerScoreLabel);
		
		//create computer choices
		computerChoice = new JLabel("?");
		computerChoice.setBounds(175, 118, 98, 81);
		computerChoice.setFont(new Font("Dialog", Font.PLAIN,26));
		computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Create black border around
		computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(computerChoice);
		
		playerScoreLabel = new JLabel("Player: 0");
		playerScoreLabel.setBounds(0, 310, 450, 30);
		playerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(playerScoreLabel);
		
		//Buttons
		
		RButton = new JButton("Rock");
		RButton.setBounds(40, 387, 105, 81);
		RButton.setFont(new Font("Dialog", Font.BOLD,18));
		RButton.addActionListener(this);
		add(RButton);
		
		PButton = new JButton("Paper");
		PButton.setBounds(165, 387, 105, 81);
		PButton.setFont(new Font("Dialog", Font.BOLD,18));
		PButton.addActionListener(this);
		add(PButton);
		
		SButton = new JButton("Scissor");
		SButton.setBounds(290, 387, 105, 81);
		SButton.setFont(new Font("Dialog", Font.BOLD,18));
		SButton.addActionListener(this);
		add(SButton);
	
		
	}
		
		// Display message with the winner and try again button
		
	private void showDialog(String message)
	{
		JDialog resultDialog = new JDialog(this, "Result", true);
		resultDialog.setSize(227, 124);
		resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultDialog.setResizable(false);
		
		JLabel resultLabel = new JLabel(message);
		resultLabel.setFont(new Font("Dialog", Font.BOLD,18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultDialog.add(resultLabel, BorderLayout.CENTER);
		
		JButton tryAgainButton= new JButton("Try Again?");
		tryAgainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				computerChoice.setText("?");
				resultDialog.dispose();
			}
			
		});
		resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
		resultDialog.setLocationRelativeTo(this);
		resultDialog.setVisible(true);
		
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String playerChoice = e.getActionCommand().toString();
			String result = rockPaperScissor.playRockPaperScissor(playerChoice);
			computerChoice.setText(rockPaperScissor.getComputerChoice());
			computerScoreLabel.setText("Computer: "+ rockPaperScissor.getComputerScore());
			playerScoreLabel.setText("Player: "+ rockPaperScissor.getPlayerScore());
			
			showDialog(result);
}
}
