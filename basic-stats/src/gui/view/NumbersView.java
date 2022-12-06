package gui.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.BasicStatsModel;

import java.util.*;


public class NumbersView implements View
{
    /** TextArea that shows all the numbers */
    private JTextArea jtaNumbers;

    
    public NumbersView(JFrame jfMain) {
	super();

	jtaNumbers = new JTextArea(10, 5);
	jtaNumbers.setEditable(false);

	jfMain.getContentPane().add(jtaNumbers, BorderLayout.SOUTH);
    }

    public void update(BasicStatsModel model, boolean isundo) {
	
	// Reset
	if (model.getArrayDouble().length == 0) {
	    jtaNumbers.setText("");
		return;
	}

	if (isundo)
	{
		double[] numbers = model.getArrayDouble();
		jtaNumbers.setText("");
		for (int i = 0 ; i < numbers.length; i++)
			jtaNumbers.append(numbers[i] + ",");

	}
	// Add number
	else {
	    // Update the displayed list of numbers
	    double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
	    jtaNumbers.append(num + ",");
	}
	}

	// public void update(BasicStatsModel model, boolean isundo) {
	// // Remove last number from displayed list of numbers
	// if (model.getArrayDouble().length == 0) 
	//     jtaNumbers.setText("");

	// String numbers = jtaNumbers.getText();
	// int index = numbers.lastIndexOf(",",numbers.length()-2);
	// if(index == -1)
	// 	jtaNumbers.setText("");
	// else
	// 	jtaNumbers.setText(numbers.substring(0, index+1));	
    
	// }

    public String getStringValue() {
	// This is a snapshot of the current value to support
	// testability and debuggability without breaking the encapsulation.
	return jtaNumbers.getText();
    }
}
