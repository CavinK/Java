/*
 * ����: ������
 * ����: Java swing�� �̿��� ���� ����
 * ����: ���⿡ ��Ģ���� ��� �߰��ϱ�
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCalculator extends JFrame {
	private boolean isStart = true;
	JTextField display;
	JPanel keyPanel;
	private double result = 0; // result, operator ���� �߰� 
	private String operator = "="; 
	
	public JCalculator() {
		super("Java Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display = new JTextField("0", 16);
		display.setHorizontalAlignment(JTextField.RIGHT);
		keyPanel = new JPanel();
		JButton button;
		String buttons = "789+456-123*C0=/";
		keyPanel.setLayout(new GridLayout(5, 3));
		for (int i = 0; i < buttons.length(); i++) {
			String key = buttons.substring(i, i+1);
			if (key.equals("C") || key.equals("=") || key.equals("+") || 
					key.equals("-") || key.equals("*") || key.equals("/")) { // ��Ģ ���� ��ȣ �߰� 
				button = new JButton(key);
				button.addActionListener(new OpListener());
				keyPanel.add(button);
			} else {
				button = new JButton(key);
				button.addActionListener(new NumListener());
				keyPanel.add(button);
			}
		}
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add("North", display);
		pane.add("South", keyPanel);
	}
	
	class NumListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String digit = e.getActionCommand(); 
			if (isStart) {
				display.setText(digit);
				isStart = false;
			} else {
				display.setText(display.getText() + digit);
			}
		}
	}
	
	class OpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    String op = e.getActionCommand();
		    if (op.equals("C")) {
		    	display.setText("0");
		    	isStart = true;
		    } else if (op.charAt(0) <= '9' && '0' <= op.charAt(0) || op.equals(".")) {
		    	if (isStart)
		    		display.setText(op);
		    	else
		    		display.setText(display.getText() + op);
		      isStart = false;
		    } else {
		      if (isStart) {
		    	  if (op.equals("-")) {
		    		  display.setText(op);
		    		  isStart = false;
		        } else
		        	operator = op;
		    } else {
		    	double x = Double.parseDouble(display.getText());
		    	calculate(x);
		    	operator = op;
		    	isStart = true;
		      }
		    }
		  }
		public void calculate(double n) { // ��� ��� �߰� 
			if (operator.equals("+")) {
				result += n;
			} else if (operator.equals("-")) {
				result -= n;
			} else if (operator.equals("*")) {
				result *= n;
			} else if (operator.equals("/")) {
				result /= n;
			} else if (operator.equals("=")) {
			    result = n; 
			}
			display.setText(""+result);
		}
	}
	
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JCalculator calculator = new JCalculator();
		calculator.pack();
		calculator.setVisible(true);
	}
}
