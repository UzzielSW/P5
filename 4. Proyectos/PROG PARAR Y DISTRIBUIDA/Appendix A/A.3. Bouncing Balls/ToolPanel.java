
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ToolPanel extends JToolBar
{
	private JRadioButton addBall, deleteBall, deleteAllBall, stopBall, stopAllBall, setColor, setSize;
	private JCheckBox  bounceModeCheckBox;

	private CanvasPanel canvasPanel;
	private InfoPanel infoPanel;

	private ButtonGroup radioGroup;
	private Color ballColor;

	public ToolPanel(CanvasPanel cPanel, InfoPanel iPanel)
	{
		canvasPanel 	 = cPanel;
		infoPanel		 = iPanel;

		bounceModeCheckBox = new JCheckBox("Bounce Mode");
		bounceModeCheckBox.addItemListener(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent event)
				{
					if(bounceModeCheckBox.isSelected())
						canvasPanel.setBounceMode(true);
					else
						canvasPanel.setBounceMode(false);

					canvasPanel.repaint();
				}
			}
		);

		radioGroup 		 = new ButtonGroup();

		addBall			 = new JRadioButton("Add Ball",true);	//default
		addBall.addItemListener(new RadioButtonHandler());

		deleteBall 		 = new JRadioButton("Delete Ball");
		deleteBall.addItemListener(new RadioButtonHandler());

		deleteAllBall	 = new JRadioButton("Delete All");
		deleteAllBall.addItemListener(new RadioButtonHandler());;

		stopBall		 = new JRadioButton("Stop/Start Ball");
		stopBall.addItemListener(new RadioButtonHandler());

		stopAllBall		 = new JRadioButton("Stop/Start All");
		stopAllBall.addItemListener(new RadioButtonHandler());

		setColor		 = new JRadioButton("Set Color");
		setColor.addItemListener(new RadioButtonHandler());

		setSize			 = new JRadioButton("Set Size");
		setSize.addItemListener(new RadioButtonHandler());

		radioGroup.add(addBall);
		radioGroup.add(deleteBall);
		radioGroup.add(deleteAllBall);
		radioGroup.add(stopBall);
		radioGroup.add(stopAllBall);
		radioGroup.add(setColor);
		radioGroup.add(setSize);

		this.setLayout(new GridLayout(2,4,2,2));
		//this.setBackground(Color.Black);

		this.add(addBall);
		this.add(deleteBall);
		this.add(deleteAllBall);
		this.add(stopBall);
		this.add(stopAllBall);
		this.add(setColor);
		this.add(setSize);
		this.add(bounceModeCheckBox);
	}

	private class RadioButtonHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			if(addBall.isSelected())
			{
				canvasPanel.setStateCondition(canvasPanel.ADD_BALL);
				infoPanel.setText("Please Click on the Canvas to ADD Ball");
			}
			if(deleteBall.isSelected())
			{
				canvasPanel.setStateCondition(canvasPanel.DELETE_BALL);
				infoPanel.setText("Please Click on a Ball to do Deletion");
			}
			if(deleteAllBall.isSelected())
			{
				canvasPanel.setStateCondition(canvasPanel.DELETE_ALL);
				infoPanel.setText("Please Click on the Canvas to DELETE ALL Balls");
			}
			if(stopBall.isSelected())
			{
				canvasPanel.setStateCondition(canvasPanel.STOP_BALL);
				infoPanel.setText("Please Click on a Ball to PAUSE/RESUME the ball's thread");
			}
			if(stopAllBall.isSelected())
			{
				canvasPanel.setStateCondition(canvasPanel.STOP_ALL);
				infoPanel.setText("Please Click on the Canvas to PAUSE/RESUME ALL Balls");
			}
			if(setColor.isSelected())
			{
				ballColor = JColorChooser.showDialog(ToolPanel.this,"Choose a color",ballColor);

				if(ballColor != null)
					canvasPanel.setBallColor(ballColor);

				canvasPanel.setStateCondition(canvasPanel.SET_COLOR);
				infoPanel.setText("Please Click on a Ball to Change its COLOR");
			}
			if(setSize.isSelected())
			{
				canvasPanel.setStateCondition(canvasPanel.SET_SIZE);
				infoPanel.setText("Please Click on a Ball to Change its SIZE");
			}
		}
	}
}