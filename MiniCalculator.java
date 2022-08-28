package cop2805;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiniCalculator {
		
	private static void constructGUI() { 
		JTextField firstNumber = new JTextField(); 
		JTextField secondNumber = new JTextField(); 
		JButton calculateButton = new JButton("Calculate"); 
		JLabel calculateResults = new JLabel();
		
		String[] mathTypes = {"Add", "Subtract", "Multiply", "Divide"};
		JComboBox<String> mathFunction = new JComboBox<String>(mathTypes);
				
  		JFrame.setDefaultLookAndFeelDecorated(true); JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mini Calculator");
  
		frame.setLayout(new GridLayout(5, 2)); 
		frame.add(new JLabel("First Number:")); 
		frame.add(firstNumber);
		frame.add(new JLabel("Second Number:"));
		frame.add(secondNumber);
		frame.add(new JLabel(""));
		frame.add(mathFunction);
		frame.add(new JLabel(""));
		frame.add(calculateButton);
		frame.add(new JLabel("Results: "));
		frame.add(calculateResults);
  
		int frameWidth = 300; 
		int frameHeight = 150;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(
			(int)(screenSize.getWidth()/2) - frameWidth, 
			(int)(screenSize.getHeight()/2) - frameHeight, frameWidth, frameHeight);
		frame.setVisible(true);
		
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(firstNumber.getText());
				double num2 = Double.parseDouble(secondNumber.getText());
			try {
				if (mathFunction.getSelectedItem().toString().equals("Add")) {
				double results = num1 + num2;
				calculateResults.setText(Double.toString(results));
			} else if (mathFunction.getSelectedItem().toString().equals("Subtract")) {
				double results = num1 - num2;
				calculateResults.setText(Double.toString(results));
			} else if (mathFunction.getSelectedItem().toString().equals("Multiply")) {
				double results = num1 * num2;
				calculateResults.setText(Double.toString(results));
			} else if (mathFunction.getSelectedItem().toString().equals("Divide")) {
				double results = num1 / num2;
				calculateResults.setText(Double.toString(results));
			}
			} catch (Exception f) {}
			} 
		});
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
				}
			});
		}
	}
	