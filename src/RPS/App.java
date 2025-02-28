package RPS;

import javax.swing.*;

public class App 
{
	public static void main(String[] Args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				RockPaperScissorGUI RockPaperScissorGUI = new RockPaperScissorGUI();
				
				RockPaperScissorGUI.setVisible(true);
			}
		});
	}

}
