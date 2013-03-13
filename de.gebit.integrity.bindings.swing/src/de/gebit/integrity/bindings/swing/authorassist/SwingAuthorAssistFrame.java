package de.gebit.integrity.bindings.swing.authorassist;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import de.gebit.integrity.bindings.swing.AbstractSwingComponentHandler;

public class SwingAuthorAssistFrame extends JFrame {

	protected JPanel identificationPanel;
	protected JButton identificationToggleButton;
	protected JPanel identificationPathPanel;
	protected JLabel identificationFullPathLabel;
	protected JTextField identificationFullPathField;
	protected JLabel identificationShortPathLabel;
	protected JTextField identificationShortPathField;

	protected ComponentInjectionThread identificationInjectionThread;

	protected boolean eventQueueReplaced;

	private Object closeSync = new Object();

	protected Map<Component, AuthorAssistComponentListener> mouseListenersCreated = new HashMap<Component, AuthorAssistComponentListener>();

	protected boolean identificationFrozen;

	protected JComponent identifiedComponent;
	protected Border identifiedComponentBorder;

	protected AbstractSwingComponentHandler swingComponentHandler;

	protected SwingAuthorAssistServer autoCompleteServer;

	public SwingAuthorAssistFrame() {
		this(new AbstractSwingComponentHandler() {
		});
	}

	public SwingAuthorAssistFrame(AbstractSwingComponentHandler aSwingComponentHandler) {
		super("Integrity Swing Bindings - Author Assist Tools");

		swingComponentHandler = aSwingComponentHandler;

		setBounds(100, 100, 540, 120);
		setAlwaysOnTop(true);
		setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new AuthorAssistWindowListener());

		add(createIdentificationPanel());
	}

	protected JPanel createIdentificationPanel() {
		identificationPanel = new JPanel();
		identificationPanel.setBorder(new TitledBorder("Component Identification"));

		identificationPanel.setLayout(new BorderLayout(10, 0));

		identificationToggleButton = new JButton("Enable");
		identificationToggleButton.setPreferredSize(new Dimension(80, 40));
		identificationPanel.add(identificationToggleButton, BorderLayout.WEST);
		attachIdentificationToggleButtonAction();

		identificationPathPanel = new JPanel();
		identificationPathPanel.setLayout(new GridBagLayout());

		identificationFullPathLabel = new JLabel("Full Path:");
		identificationFullPathLabel.setHorizontalAlignment(JLabel.RIGHT);
		identificationFullPathField = new JTextField();
		GridBagConstraints tempConstraint = new GridBagConstraints();
		tempConstraint.gridx = 0;
		tempConstraint.gridy = 0;
		tempConstraint.fill = GridBagConstraints.HORIZONTAL;
		tempConstraint.insets = new Insets(2, 2, 2, 2);
		identificationPathPanel.add(identificationFullPathLabel, tempConstraint);
		tempConstraint = new GridBagConstraints();
		tempConstraint.gridx = 1;
		tempConstraint.gridy = 0;
		tempConstraint.insets = new Insets(2, 2, 2, 2);
		tempConstraint.fill = GridBagConstraints.HORIZONTAL;
		tempConstraint.weightx = 1.0;
		identificationPathPanel.add(identificationFullPathField, tempConstraint);

		identificationShortPathLabel = new JLabel("Short Path:");
		identificationShortPathLabel.setHorizontalAlignment(JLabel.RIGHT);
		identificationShortPathField = new JTextField();
		tempConstraint = new GridBagConstraints();
		tempConstraint.gridx = 0;
		tempConstraint.gridy = 1;
		tempConstraint.fill = GridBagConstraints.HORIZONTAL;
		tempConstraint.insets = new Insets(2, 2, 2, 2);
		identificationPathPanel.add(identificationShortPathLabel, tempConstraint);
		tempConstraint = new GridBagConstraints();
		tempConstraint.gridx = 1;
		tempConstraint.gridy = 1;
		tempConstraint.insets = new Insets(2, 2, 2, 2);
		tempConstraint.fill = GridBagConstraints.HORIZONTAL;
		tempConstraint.weightx = 1.0;
		identificationPathPanel.add(identificationShortPathField, tempConstraint);

		identificationPanel.add(identificationPathPanel, BorderLayout.CENTER);

		return identificationPanel;
	}

	protected void attachIdentificationToggleButtonAction() {
		identificationToggleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent anEvent) {
				if (identificationInjectionThread != null) {
					((SwallowingEventQueue) Toolkit.getDefaultToolkit().getSystemEventQueue())
							.setAuthorAssistFrame(null);
					identificationInjectionThread.kill();
					identificationInjectionThread = null;
					identificationToggleButton.setText("Enable");
				} else {
					identificationInjectionThread = new ComponentInjectionThread();
					identificationInjectionThread.start();
					identificationToggleButton.setText("Disable");
					((SwallowingEventQueue) Toolkit.getDefaultToolkit().getSystemEventQueue())
							.setAuthorAssistFrame(SwingAuthorAssistFrame.this);
				}
			}
		});
	}

	@Override
	public void setVisible(boolean aBoolean) {
		if (aBoolean && !isVisible()) {
			startUp();
		}

		super.setVisible(aBoolean);
	}

	protected void startUp() {
		EventQueue tempEventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		if (!(tempEventQueue instanceof SwallowingEventQueue)) {
			tempEventQueue = new SwallowingEventQueue();
			Toolkit.getDefaultToolkit().getSystemEventQueue().push(tempEventQueue);
		}

		autoCompleteServer = new SwingAuthorAssistServer(swingComponentHandler, this);
		autoCompleteServer.startUp();
	}

	protected void shutDown() {
		if (autoCompleteServer != null) {
			autoCompleteServer.shutDown();
		}

		if (identificationInjectionThread != null) {
			identificationInjectionThread.kill();
		}

		synchronized (closeSync) {
			closeSync.notifyAll();
		}
	}

	protected void injectComponentListeners() {
		for (Window tempWindow : Window.getWindows()) {
			if (tempWindow != this) {
				injectListeners(tempWindow);
			}
		}
	}

	protected void cleanupComponentListeners() {
		unfreezeIdentification();
		if (identifiedComponent != null) {
			clearIdentification(identifiedComponent);
		}

		for (Entry<Component, AuthorAssistComponentListener> tempEntry : mouseListenersCreated.entrySet()) {
			tempEntry.getValue().remove();
		}
		mouseListenersCreated.clear();
	}

	protected void injectListeners(Container aContainer) {
		for (final Component tempComponent : aContainer.getComponents()) {
			if (!mouseListenersCreated.containsKey(tempComponent)) {
				AuthorAssistComponentListener tempNewListener = new AuthorAssistComponentListener(tempComponent);
				tempNewListener.attach();
				mouseListenersCreated.put(tempComponent, tempNewListener);
			}

			if (tempComponent instanceof Container) {
				injectListeners((Container) tempComponent);
			}
		}
	}

	public void waitForClose() {
		synchronized (closeSync) {
			while (isVisible()) {
				try {
					closeSync.wait();
				} catch (InterruptedException e) {
					// ignored
				}
			}
		}
	}

	protected void identifyComponent(JComponent aComponent) {
		if (!identificationFrozen && identifiedComponent == null) {
			identifiedComponent = aComponent;
			identifiedComponentBorder = aComponent.getBorder();
			aComponent.setBorder(new LineBorder(Color.RED, 1));

			String tempFullPath = swingComponentHandler.createUniquifiedComponentPath(aComponent);
			if (tempFullPath != null) {
				String tempShortestPath = swingComponentHandler.createShortestComponentPath(aComponent);
				identificationFullPathField.setText(tempFullPath);
				identificationShortPathField.setText(tempShortestPath);
			} else {
				identificationFullPathField.setText("--- component path not unique ---");
				identificationShortPathField.setText("");
			}
		}
	}

	protected void clearIdentification(JComponent aComponent) {
		if (!identificationFrozen && identifiedComponent != null) {
			identifiedComponent = null;
			aComponent.setBorder(identifiedComponentBorder);
			identifiedComponentBorder = null;
		}
	}

	protected void freezeIdentification() {
		if (!identificationFrozen && identifiedComponent != null) {
			identificationFrozen = true;
			identifiedComponent.setBorder(new LineBorder(Color.GREEN.darker(), 1));
		}
	}

	protected void unfreezeIdentification() {
		if (identificationFrozen && identifiedComponent != null) {
			identificationFrozen = false;
			identifiedComponent.setBorder(new LineBorder(Color.RED, 1));
		}
	}

	protected void toggleFreezeIdentification() {
		if (identificationFrozen) {
			unfreezeIdentification();
		} else {
			freezeIdentification();
		}
	}

	protected class AuthorAssistWindowListener implements WindowListener {

		@Override
		public void windowOpened(WindowEvent anEvent) {

		}

		@Override
		public void windowIconified(WindowEvent anEvent) {

		}

		@Override
		public void windowDeiconified(WindowEvent anEvent) {

		}

		@Override
		public void windowDeactivated(WindowEvent anEvent) {

		}

		@Override
		public void windowClosing(WindowEvent anEvent) {

		}

		@Override
		public void windowClosed(WindowEvent anEvent) {
			shutDown();
		}

		@Override
		public void windowActivated(WindowEvent anEvent) {

		}
	}

	protected class AuthorAssistComponentListener implements MouseListener {

		private Component component;

		public AuthorAssistComponentListener(Component aComponent) {
			component = aComponent;
		}

		public void remove() {
			component.removeMouseListener(this);
		}

		public void attach() {
			component.addMouseListener(this);
		}

		@Override
		public void mouseReleased(MouseEvent anEvent) {
			anEvent.consume();
		}

		@Override
		public void mousePressed(MouseEvent anEvent) {
			anEvent.consume();
		}

		@Override
		public void mouseExited(MouseEvent anEvent) {
			restoreBorder();
		}

		@Override
		public void mouseEntered(MouseEvent anEvent) {
			replaceBorder();
		}

		@Override
		public void mouseClicked(MouseEvent anEvent) {
			anEvent.consume();
		}

		protected void replaceBorder() {
			if (component instanceof JComponent) {
				identifyComponent((JComponent) component);
			}
		}

		protected void restoreBorder() {
			if (component instanceof JComponent) {
				clearIdentification((JComponent) component);
			}
		}
	}

	protected class ComponentInjectionThread extends Thread {

		protected static final int INJECTION_INTERVAL = 500;

		private volatile boolean killSwitch;

		public ComponentInjectionThread() {
			super("Author Assist Component Injection");
		}

		public void kill() {
			killSwitch = true;
			this.interrupt();
		}

		@Override
		public void run() {
			while (!killSwitch) {
				injectComponentListeners();
				try {
					Thread.sleep(INJECTION_INTERVAL);
				} catch (InterruptedException e) {
					// ignored
				}
			}

			cleanupComponentListeners();
		}
	}

	protected static class SwallowingEventQueue extends EventQueue {

		private SwingAuthorAssistFrame authorAssistFrame;

		public void setAuthorAssistFrame(SwingAuthorAssistFrame aFrame) {
			authorAssistFrame = aFrame;
		}

		@Override
		protected void dispatchEvent(AWTEvent anEvent) {
			if (authorAssistFrame != null) {
				if (anEvent instanceof MouseEvent) {
					MouseEvent tempMouseEvent = (MouseEvent) anEvent;
					if (tempMouseEvent.getID() == MouseEvent.MOUSE_CLICKED
							|| tempMouseEvent.getID() == MouseEvent.MOUSE_PRESSED
							|| tempMouseEvent.getID() == MouseEvent.MOUSE_RELEASED) {
						Component tempComponentInFocus = tempMouseEvent.getComponent();
						boolean tempFound = false;
						while (!tempFound && tempComponentInFocus != null) {
							if (tempComponentInFocus == authorAssistFrame) {
								tempFound = true;
							} else {
								tempComponentInFocus = tempComponentInFocus.getParent();
							}
						}

						// swallow if the target component was not in our authors'
						// tools frame, and freeze the current selection
						if (!tempFound) {
							if (tempMouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
								authorAssistFrame.toggleFreezeIdentification();
							}
							return;
						}
					}
				}
			}

			super.dispatchEvent(anEvent);
		}

	}

}
