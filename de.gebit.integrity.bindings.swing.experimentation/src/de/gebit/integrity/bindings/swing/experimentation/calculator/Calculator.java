/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

// Experimental examples are not obliged to obey Checkstyle rules.
// CHECKSTYLE:OFF
package de.gebit.integrity.bindings.swing.experimentation.calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * A demo program which implements a simple calculator application.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */

public class Calculator {

	private static final char OP_ADDITION = '+';

	private static final char OP_SUBTRACTION = '-';

	private static final char OP_MULTIPLICATION = 'x';

	private static final char OP_DIVISION = '/';

	private static final MathContext MATH_CONTEXT = new MathContext(14, RoundingMode.HALF_UP);

	private JFrame frame;

	private JPanel resultPanel = new JPanel();

	private JLabel resultLabel = new JLabel("0");
	private JLabel inputLabel = new JLabel("0");

	private JPanel buttonPanel = new JPanel();

	private JPanel numberPanel = new JPanel();
	private JButton numberButton1 = new JButton("1");
	private JButton numberButton2 = new JButton("2");
	private JButton numberButton3 = new JButton("3");
	private JButton numberButton4 = new JButton("4");
	private JButton numberButton5 = new JButton("5");
	private JButton numberButton6 = new JButton("6");
	private JButton numberButton7 = new JButton("7");
	private JButton numberButton8 = new JButton("8");
	private JButton numberButton9 = new JButton("9");
	private JButton numberButton0 = new JButton("0");
	private JButton numberButtonDot = new JButton(".");
	private JButton numberButton00 = new JButton("00");

	private JPanel operatorPanel = new JPanel();
	private JButton additionButton = new JButton(Character.toString(OP_ADDITION));
	private JButton subtractionButton = new JButton(Character.toString(OP_SUBTRACTION));
	private JButton multiplicationButton = new JButton(Character.toString(OP_MULTIPLICATION));
	private JButton divisionButton = new JButton(Character.toString(OP_DIVISION));

	private JPanel actionPanel = new JPanel();
	private JButton evaluateButton = new JButton("=");
	private JButton clearButton = new JButton("C");

	private StringBuilder inputBuffer = new StringBuilder();
	private BigDecimal result = BigDecimal.ZERO;

	public Calculator() {
		buttonPanel.setName("buttonPanel");
		numberPanel.setName("numberPanel");
		numberButton0.setName("numberButton0");
		numberButton00.setName("numberButton00");
		numberButton1.setName("numberButton1");
		numberButton2.setName("numberButton2");
		numberButton3.setName("numberButton3");
		numberButton4.setName("numberButton4");
		numberButton5.setName("numberButton5");
		numberButton6.setName("numberButton6");
		numberButton7.setName("numberButton7");
		numberButton8.setName("numberButton8");
		numberButton9.setName("numberButton9");

		actionPanel.setName("actionPanel");
		evaluateButton.setName("evaluateButton");
		clearButton.setName("clearButton");

		operatorPanel.setName("operatorPanel");
		additionButton.setName("additionButton");
		subtractionButton.setName("subtractionButton");
		multiplicationButton.setName("multiplicationButton");
		divisionButton.setName("divisionButton");

		resultPanel.setName("resultPanel");
		resultLabel.setName("resultLabel");
		inputLabel.setName("inputLabel");

		frame = new JFrame("Experimental Calculator");
		frame.setName("calculator");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 300, 400);

		resultPanel.setLayout(new BorderLayout());
		resultLabel.setFont(new Font("Monospaced", Font.BOLD, 26));
		resultLabel.setHorizontalAlignment(JLabel.RIGHT);
		resultLabel.setBorder(new EmptyBorder(0, 6, 0, 6));
		resultPanel.add(resultLabel, BorderLayout.NORTH);
		inputLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		inputLabel.setHorizontalAlignment(JLabel.RIGHT);
		inputLabel.setBorder(new EmptyBorder(0, 6, 0, 6));
		inputLabel.setMinimumSize(new Dimension(1, 20));
		inputLabel.setPreferredSize(new Dimension(1, 20));
		resultPanel.add(inputLabel, BorderLayout.CENTER);

		buttonPanel.setLayout(new GridBagLayout());

		buttonPanel.setMinimumSize(new Dimension(360, 300));
		numberPanel.setLayout(new GridLayout(4, 3, 10, 10));
		nullButtonSize(numberButton7);
		numberPanel.add(numberButton7);
		nullButtonSize(numberButton8);
		numberPanel.add(numberButton8);
		nullButtonSize(numberButton9);
		numberPanel.add(numberButton9);
		nullButtonSize(numberButton4);
		numberPanel.add(numberButton4);
		nullButtonSize(numberButton5);
		numberPanel.add(numberButton5);
		nullButtonSize(numberButton6);
		numberPanel.add(numberButton6);
		nullButtonSize(numberButton1);
		numberPanel.add(numberButton1);
		nullButtonSize(numberButton2);
		numberPanel.add(numberButton2);
		nullButtonSize(numberButton3);
		numberPanel.add(numberButton3);
		nullButtonSize(numberButton0);
		numberPanel.add(numberButton0);
		nullButtonSize(numberButtonDot);
		numberPanel.add(numberButtonDot);
		nullButtonSize(numberButton00);
		numberPanel.add(numberButton00);

		GridBagConstraints tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 0;
		tempConstraints.gridy = 0;
		tempConstraints.gridheight = 1;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 0.75;
		tempConstraints.weighty = 0.8;
		tempConstraints.insets = new Insets(5, 5, 5, 5);
		buttonPanel.add(numberPanel, tempConstraints);

		Insets tempOperatorInsets = new Insets(5, 5, 5, 5);
		operatorPanel.setLayout(new GridBagLayout());
		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 0;
		tempConstraints.gridy = 0;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 1.0;
		tempConstraints.weighty = 0.2;
		tempConstraints.insets = tempOperatorInsets;
		nullButtonSize(divisionButton);
		operatorPanel.add(divisionButton, tempConstraints);
		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 0;
		tempConstraints.gridy = 1;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 1.0;
		tempConstraints.weighty = 0.2;
		tempConstraints.insets = tempOperatorInsets;
		nullButtonSize(multiplicationButton);
		operatorPanel.add(multiplicationButton, tempConstraints);
		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 0;
		tempConstraints.gridy = 2;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 1.0;
		tempConstraints.weighty = 0.2;
		tempConstraints.insets = tempOperatorInsets;
		nullButtonSize(subtractionButton);
		operatorPanel.add(subtractionButton, tempConstraints);
		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 0;
		tempConstraints.gridy = 3;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 1.0;
		tempConstraints.weighty = 0.4;
		tempConstraints.insets = tempOperatorInsets;
		nullButtonSize(additionButton);
		operatorPanel.add(additionButton, tempConstraints);

		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 1;
		tempConstraints.gridy = 0;
		tempConstraints.gridheight = 2;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 0.25;
		tempConstraints.weighty = 1.0;
		buttonPanel.add(operatorPanel, tempConstraints);

		actionPanel.setLayout(new GridBagLayout());
		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 0;
		tempConstraints.gridy = 0;
		tempConstraints.gridwidth = 1;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 0.25;
		tempConstraints.weighty = 1.0;
		tempConstraints.insets = new Insets(5, 5, 5, 5);
		nullButtonSize(clearButton);
		actionPanel.add(clearButton, tempConstraints);
		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 1;
		tempConstraints.gridy = 0;
		tempConstraints.gridwidth = 2;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 0.5;
		tempConstraints.weighty = 1.0;
		tempConstraints.insets = new Insets(5, 5, 5, 5);
		nullButtonSize(evaluateButton);
		actionPanel.add(evaluateButton, tempConstraints);

		tempConstraints = new GridBagConstraints();
		tempConstraints.gridx = 0;
		tempConstraints.gridy = 1;
		tempConstraints.gridwidth = 1;
		tempConstraints.fill = GridBagConstraints.BOTH;
		tempConstraints.weightx = 0.75;
		tempConstraints.weighty = 0.2;
		buttonPanel.add(actionPanel, tempConstraints);

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(resultPanel, BorderLayout.NORTH);
		frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

		addActions();
		clear();
	}

	private static void nullButtonSize(JButton aButton) {
		aButton.setMinimumSize(new Dimension(0, 0));
		aButton.setPreferredSize(new Dimension(0, 0));
	}

	private void addActions() {
		ActionListener tempNumberButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				inputBuffer.append(((JButton) anEvent.getSource()).getText());
				updateDisplay();
			}
		};

		numberButton1.addActionListener(tempNumberButtonListener);
		numberButton2.addActionListener(tempNumberButtonListener);
		numberButton3.addActionListener(tempNumberButtonListener);
		numberButton4.addActionListener(tempNumberButtonListener);
		numberButton5.addActionListener(tempNumberButtonListener);
		numberButton6.addActionListener(tempNumberButtonListener);
		numberButton7.addActionListener(tempNumberButtonListener);
		numberButton8.addActionListener(tempNumberButtonListener);
		numberButton9.addActionListener(tempNumberButtonListener);
		numberButton0.addActionListener(tempNumberButtonListener);
		numberButton00.addActionListener(tempNumberButtonListener);
		numberButtonDot.addActionListener(tempNumberButtonListener);

		additionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				evaluate();
				inputBuffer.append(OP_ADDITION);
				updateDisplay();
			}
		});
		subtractionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				evaluate();
				inputBuffer.append(OP_SUBTRACTION);
				updateDisplay();
			}
		});
		multiplicationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				evaluate();
				inputBuffer.append(OP_MULTIPLICATION);
				updateDisplay();
			}
		});
		divisionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				evaluate();
				inputBuffer.append(OP_DIVISION);
				updateDisplay();
			}
		});

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				if (JOptionPane.showConfirmDialog(null, "Really clear the current result?", "Calculator",
						JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					clear();
				}
			}
		});
		evaluateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				evaluate();
			}
		});
	}

	/**
	 * Updates the labels with the current buffer contents.
	 */
	protected void updateDisplay() {
		inputLabel.setText(inputBuffer.toString());
		resultLabel.setText(result.toString());
	}

	/**
	 * Clears the memory and display.
	 */
	protected void clear() {
		inputBuffer = new StringBuilder();
		result = BigDecimal.ZERO;
		updateDisplay();
	}

	/**
	 * Evaluates.
	 */
	protected void evaluate() {
		String tempInput = inputBuffer.toString();
		inputBuffer = new StringBuilder();
		if (tempInput.length() >= 1) {
			switch (tempInput.charAt(0)) {
			case OP_ADDITION:
				result = result.add(new BigDecimal(tempInput.substring(1)), MATH_CONTEXT);
				break;
			case OP_SUBTRACTION:
				result = result.subtract(new BigDecimal(tempInput.substring(1)), MATH_CONTEXT);
				break;
			case OP_MULTIPLICATION:
				result = result.multiply(new BigDecimal(tempInput.substring(1)), MATH_CONTEXT);
				break;
			case OP_DIVISION:
				result = result.divide(new BigDecimal(tempInput.substring(1)), MATH_CONTEXT);
				break;
			default:
				result = new BigDecimal(tempInput);
			}

			result = result.stripTrailingZeros();
		}

		updateDisplay();
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] someArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		new Calculator();
	}

}
