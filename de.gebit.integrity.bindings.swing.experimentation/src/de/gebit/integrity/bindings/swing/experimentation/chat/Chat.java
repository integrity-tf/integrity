/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

// Experimental examples are not obliged to obey Checkstyle rules.
// CHECKSTYLE:OFF
package de.gebit.integrity.bindings.swing.experimentation.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class Chat {

	private JFrame frame;

	private JPanel connectPanel;
	private JPanel targetPanel;
	private JTextField hostField;
	private JTextField portField;
	private JPanel rolePanel;
	private JRadioButton roleAChoice;
	private JRadioButton roleBChoice;
	private JPanel actionPanel;
	private JButton connectButton;
	private JButton disconnectButton;

	private JList messageList;

	private JPanel inputPanel;
	private JTextField messageField;
	private JButton sendButton;

	private DatagramSocket sendSocket;
	private DatagramSocket recvSocket;

	private static final int ACK_TIMEOUT = 5000;

	private long ackReceived;

	private static final String ACK = "!!!ACK!!!";

	public Chat() {
		frame = new JFrame("Simple Chat");
		frame.setName("chat");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 300);
		frame.getContentPane().setLayout(new BorderLayout());

		connectPanel = new JPanel();
		connectPanel.setName("connectPanel");
		targetPanel = new JPanel();
		targetPanel.setName("targetPanel");
		targetPanel.setBorder(new TitledBorder("Host/Port"));
		targetPanel.setLayout(new GridLayout(1, 2));
		hostField = new JTextField();
		hostField.setText("localhost");
		portField = new JTextField();
		portField.setText("31337");
		targetPanel.add(hostField);
		targetPanel.add(portField);
		rolePanel = new JPanel();
		rolePanel.setName("rolePanel");
		rolePanel.setBorder(new TitledBorder("Role"));
		roleAChoice = new JRadioButton("Client A");
		roleAChoice.setName("roleAChoice");
		roleBChoice = new JRadioButton("Client B");
		roleBChoice.setName("roleBChoice");
		ButtonGroup tempButtonGroup = new ButtonGroup();
		tempButtonGroup.add(roleAChoice);
		tempButtonGroup.add(roleBChoice);
		rolePanel.add(roleAChoice);
		rolePanel.add(roleBChoice);
		actionPanel = new JPanel();
		actionPanel.setName("actionPanel");
		actionPanel.setBorder(new TitledBorder("Connection"));
		actionPanel.setLayout(new GridLayout(1, 2));
		connectButton = new JButton("Connect");
		connectButton.setName("connectButton");
		actionPanel.add(connectButton);
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setName("disconnectButton");
		actionPanel.add(disconnectButton);
		connectPanel.setLayout(new GridLayout(1, 5));
		connectPanel.add(targetPanel);
		connectPanel.add(rolePanel);
		connectPanel.add(actionPanel);
		connectPanel.setPreferredSize(new Dimension(500, 52));
		frame.getContentPane().add(connectPanel, BorderLayout.NORTH);

		messageList = new JList(new DefaultListModel());
		messageList.setName("messageList");
		messageList.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		frame.getContentPane().add(messageList, BorderLayout.CENTER);

		inputPanel = new JPanel();
		inputPanel.setName("inputPanel");
		inputPanel.setLayout(new BorderLayout());
		messageField = new JTextField();
		messageField.setName("messageField");
		inputPanel.add(messageField, BorderLayout.CENTER);
		sendButton = new JButton("Send");
		sendButton.setName("sendButton");
		inputPanel.add(sendButton, BorderLayout.EAST);
		frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent anEvent) {
				// ignored
			}

			@Override
			public void windowIconified(WindowEvent anEvent) {
				// ignored
			}

			@Override
			public void windowDeiconified(WindowEvent anEvent) {
				// ignored
			}

			@Override
			public void windowDeactivated(WindowEvent anEvent) {
				// ignored
			}

			@Override
			public void windowClosing(WindowEvent anEvent) {
				// ignored
			}

			@Override
			public void windowClosed(WindowEvent anEvent) {
				disconnect();
			}

			@Override
			public void windowActivated(WindowEvent anEvent) {
				// ignored
			}
		});

		frame.validate();
		addActions();
		updateButtons();

		System.out.println("Simple Chat was started!");
	}

	protected void updateButtons() {
		if (sendSocket == null) {
			connectButton.setEnabled(true);
			disconnectButton.setEnabled(false);
			sendButton.setEnabled(false);
			roleAChoice.setEnabled(true);
			roleBChoice.setEnabled(true);
			hostField.setEditable(true);
			portField.setEditable(true);
		} else {
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			sendButton.setEnabled(true);
			roleAChoice.setEnabled(false);
			roleBChoice.setEnabled(false);
			hostField.setEditable(false);
			portField.setEditable(false);
		}
	}

	protected void connect() {
		int tempSendPort = Integer.parseInt(portField.getText()) + (roleBChoice.isSelected() ? 0 : 1);
		int tempRecvPort = Integer.parseInt(portField.getText()) + (roleAChoice.isSelected() ? 0 : 1);

		System.out.println("Setting up UDP sockets in '" + (roleBChoice.isSelected() ? "Client B" : "Client A")
				+ "' mode for sending on port " + tempSendPort + " and receiving on port " + tempRecvPort + ".");

		try {
			sendSocket = new DatagramSocket();
			sendSocket.connect(InetAddress.getByName(hostField.getText()), tempSendPort);
			recvSocket = new DatagramSocket(tempRecvPort);
		} catch (SocketException exc) {
			exc.printStackTrace();
			sendSocket = null;
			recvSocket = null;
		} catch (NumberFormatException exc) {
			exc.printStackTrace();
			sendSocket = null;
			recvSocket = null;
		} catch (UnknownHostException exc) {
			exc.printStackTrace();
			sendSocket = null;
			recvSocket = null;
		}

		if (recvSocket != null) {
			Thread tempListenerThread = new Thread() {
				public void run() {
					while (recvSocket != null && !recvSocket.isClosed()) {
						try {
							DatagramPacket tempPacket = new DatagramPacket(new byte[1024], 1024);
							recvSocket.receive(tempPacket);
							String tempString = new String(tempPacket.getData(), tempPacket.getOffset(),
									tempPacket.getLength());
							if (ACK.equals(tempString)) {
								synchronized (ACK) {
									ackReceived = System.nanoTime();
									ACK.notifyAll();
								}
							} else {
								((DefaultListModel) messageList.getModel()).addElement(tempString);
								byte[] tempAckBytes = ACK.getBytes();
								sendSocket.send(new DatagramPacket(tempAckBytes, tempAckBytes.length));
							}
						} catch (IOException exc) {
							if (!"socket closed".equals(exc.getMessage())) {
								exc.printStackTrace();
							}
						}
					}
				};
			};
			tempListenerThread.start();

			System.out.println("Ports were successfully set up. Begin chatting!");
		}
	}

	protected void disconnect() {
		if (sendSocket != null) {
			sendSocket.close();
			sendSocket = null;
		}
		if (recvSocket != null) {
			recvSocket.close();
			recvSocket = null;
		}
	}

	protected void addActions() {
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				connect();
				updateButtons();
			}

		});

		disconnectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				disconnect();
				updateButtons();
			}
		});

		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				String tempMessage = messageField.getText();

				if (tempMessage.length() > 0) {
					try {
						byte[] tempBytes = tempMessage.getBytes();
						System.out.println("Now sending message '" + tempMessage + "'");
						long tempSendTime = System.nanoTime();
						sendSocket.send(new DatagramPacket(tempBytes, tempBytes.length));
						synchronized (ACK) {
							try {
								ACK.wait(ACK_TIMEOUT);
							} catch (InterruptedException exc) {
								// ignored
							}
						}
						if (ackReceived >= tempSendTime) {
							System.out.println("Successfully sent the message '" + tempMessage + "'; ACK received in "
									+ (((double) (ackReceived - tempSendTime)) / 1000000.0) + " msecs.");
							messageField.setText("");
						} else {
							System.err.println("Failed to send: did not receive an ACK in time!");
						}
					} catch (IOException exc) {
						exc.printStackTrace();
					}
				} else {
					System.out.println("No message was entered - will not send anything!");
				}
			}
		});
	}

	public static void main(String[] someArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		new Chat();
	}

}
