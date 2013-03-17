/**
 * 
 */
package de.gebit.integrity.bindings.swing.experimentation.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author Rene Schneider
 * 
 */
public class Chat {

	private JFrame frame;

	private JPanel connectPanel;
	private JPanel targetPanel;
	private JTextField hostField;
	private JTextField portField;
	private JPanel rolePanel;
	private JRadioButton clientChoice;
	private JRadioButton serverChoice;
	private JPanel actionPanel;
	private JButton connectButton;
	private JButton disconnectButton;

	private JList messageList;

	private JPanel inputPanel;
	private JTextField messageField;
	private JButton sendButton;

	private DatagramSocket sendSocket;
	private DatagramSocket recvSocket;

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
		clientChoice = new JRadioButton("Client");
		clientChoice.setName("clientChoice");
		serverChoice = new JRadioButton("Server");
		serverChoice.setName("serverChoice");
		ButtonGroup tempButtonGroup = new ButtonGroup();
		tempButtonGroup.add(clientChoice);
		tempButtonGroup.add(serverChoice);
		rolePanel.add(clientChoice);
		rolePanel.add(serverChoice);
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

		frame.validate();
		addActions();
		updateButtons();
	}

	protected void updateButtons() {
		if (sendSocket == null) {
			connectButton.setEnabled(true);
			disconnectButton.setEnabled(false);
			sendButton.setEnabled(false);
			clientChoice.setEnabled(true);
			serverChoice.setEnabled(true);
			hostField.setEditable(true);
			portField.setEditable(true);
		} else {
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			sendButton.setEnabled(true);
			clientChoice.setEnabled(false);
			serverChoice.setEnabled(false);
			hostField.setEditable(false);
			portField.setEditable(false);
		}
	}

	protected void addActions() {
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int tempSendPort = Integer.parseInt(portField.getText()) + (serverChoice.isSelected() ? 0 : 1);
				int tempRecvPort = Integer.parseInt(portField.getText()) + (clientChoice.isSelected() ? 0 : 1);

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
									((DefaultListModel) messageList.getModel()).addElement(new String(tempPacket
											.getData(), tempPacket.getOffset(), tempPacket.getLength()));
								} catch (IOException exc) {
									if (!"socket closed".equals(exc.getMessage())) {
										exc.printStackTrace();
									}
								}
							}
						};
					};
					tempListenerThread.start();
					updateButtons();
				}
			}

		});

		disconnectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendSocket.close();
				sendSocket = null;
				recvSocket.close();
				recvSocket = null;
				updateButtons();
			}
		});

		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tempMessage = messageField.getText();

				if (tempMessage.length() > 0) {
					try {
						byte[] tempBytes = tempMessage.getBytes();
						sendSocket.send(new DatagramPacket(tempBytes, tempBytes.length));
						messageField.setText("");
					} catch (IOException exc) {
						exc.printStackTrace();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new Chat();
	}

}
