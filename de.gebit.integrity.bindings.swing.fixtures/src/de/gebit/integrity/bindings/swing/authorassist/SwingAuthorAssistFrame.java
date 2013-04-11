/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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

/**
 * The Frame used to display the author assist tools. These tools provide useful functionality during test editing, such
 * as identification of components in the running application. There's a fixture ({@link SwingAuthorAssistFixture}) to
 * be called which displays this frame into the running application and pauses test execution. Test execution will
 * continue when the frame is closed.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SwingAuthorAssistFrame extends JFrame {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = -7962874425773425945L;

	/**
	 * The panel containing the identification tool components.
	 */
	protected JPanel identificationPanel;

	/**
	 * Turns identification mode on and off.
	 */
	protected JButton identificationToggleButton;

	/**
	 * Contains the text fields with the component paths.
	 */
	protected JPanel identificationPathPanel;

	/**
	 * Label for the full component path text field.
	 */
	protected JLabel identificationFullPathLabel;

	/**
	 * Text field containing the full component path.
	 */
	protected JTextField identificationFullPathField;

	/**
	 * Label for the short component path text field.
	 */
	protected JLabel identificationShortPathLabel;

	/**
	 * Text field containing the short component path.
	 */
	protected JTextField identificationShortPathField;

	/**
	 * Thread used to inject component mouse listeners into all components which are required for identification
	 * purposes.
	 */
	protected ComponentInjectionThread identificationInjectionThread;

	/**
	 * Flag to store whether the event queue has been replaced with the {@link SwallowingEventQueue}.
	 */
	protected boolean eventQueueReplaced;

	/**
	 * Synchronization object used to provide the "wait for this window to close" functionality (see
	 * {@link #waitForClose()}).
	 */
	private Object closeSync = new Object();

	/**
	 * Map holding all created identification mouse listeners.
	 */
	protected Map<Component, AuthorAssistComponentListener> mouseListenersCreated = new HashMap<Component, AuthorAssistComponentListener>();

	/**
	 * Flag whether the identification feature is currently in "frozen" selection mode.
	 */
	protected boolean identificationFrozen;

	/**
	 * The currently identified component.
	 */
	protected JComponent identifiedComponent;

	/**
	 * Whether the currently identified component was marked by manipulating its background.
	 */
	protected boolean identifiedComponentViaBackground;

	/**
	 * The old border of the currently identified component.
	 */
	protected Border identifiedComponentBorder;

	/**
	 * The old background of the currently identified component.
	 */
	protected Color identifiedComponentBackground;

	/**
	 * The component handler.
	 */
	protected AbstractSwingComponentHandler swingComponentHandler;

	/**
	 * The author assist server instance (the server provides an entrance for the Eclipse autocompletion into the
	 * running software).
	 */
	protected SwingAuthorAssistServer autoCompleteServer;

	/**
	 * Creates a new instance. This auto-creates a new component handler instance to use as well.
	 */
	public SwingAuthorAssistFrame() {
		this(new AbstractSwingComponentHandler() {
		});
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aSwingComponentHandler
	 *            the component handler to use
	 */
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

	/**
	 * Creates the identification panel.
	 * 
	 * @return the finished panel
	 */
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

	/**
	 * Atteaches the action to toggle the identification feature on and off to the appropriate button.
	 */
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

	/**
	 * Starts the whole inner workings of the author assist frame, such as the autocomplete server and the override over
	 * the standard event queue.
	 */
	protected void startUp() {
		EventQueue tempEventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		if (!(tempEventQueue instanceof SwallowingEventQueue)) {
			tempEventQueue = new SwallowingEventQueue();
			Toolkit.getDefaultToolkit().getSystemEventQueue().push(tempEventQueue);
		}

		autoCompleteServer = createAuthorAssistServer(swingComponentHandler, this);
		autoCompleteServer.startUp();
	}

	/**
	 * Creates the author assist server.
	 * 
	 * @param aSwingComponentHandler
	 *            the swing component handler to use
	 * @param anOwnerFrame
	 *            the owner of this server
	 * @return the author assist server (not started)
	 */
	protected SwingAuthorAssistServer createAuthorAssistServer(AbstractSwingComponentHandler aSwingComponentHandler,
			JFrame anOwnerFrame) {
		return new SwingAuthorAssistServer(aSwingComponentHandler, anOwnerFrame);
	}

	/**
	 * Shuts down the frame. This must be called when the frame is being closed.
	 */
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

	/**
	 * Inject component mouse listeners (for identification) into all components in all windows, except the components
	 * of the author assist window itself.
	 */
	protected void injectComponentListeners() {
		for (Window tempWindow : Window.getWindows()) {
			if (tempWindow != this) {
				injectListeners(tempWindow);
			}
		}
	}

	/**
	 * Removes the component mouse listeners from all components where listeners have been added.
	 */
	protected void cleanupComponentListeners() {
		unfreezeIdentification();
		clearIdentification();

		for (Entry<Component, AuthorAssistComponentListener> tempEntry : mouseListenersCreated.entrySet()) {
			tempEntry.getValue().remove();
		}
		mouseListenersCreated.clear();
	}

	/**
	 * Inject listeners in all components within the given container. This will recurse through the whole component
	 * hierarchy.
	 * 
	 * @param aContainer
	 *            the container
	 */
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

	/**
	 * Blocks and waits for this frame to close.
	 */
	public void waitForClose() {
		synchronized (closeSync) {
			while (isVisible()) {
				try {
					closeSync.wait();
				} catch (InterruptedException exc) {
					// ignored
				}
			}
		}
	}

	/**
	 * Identify the provided component. This actually adds the red background or border to the component, and the paths
	 * are calculated and displayed.
	 * 
	 * @param aComponent
	 *            the component to identify
	 */
	protected void identifyComponent(JComponent aComponent) {
		if (!identificationFrozen && identifiedComponent == null) {
			identifiedComponent = aComponent;
			if (aComponent.getBorder() != null) {
				identifiedComponentViaBackground = true;
				identifiedComponentBackground = aComponent.getBackground();
				aComponent.setBackground(Color.RED);
			} else {
				identifiedComponentViaBackground = false;
				identifiedComponentBorder = aComponent.getBorder();
				aComponent.setBorder(new LineBorder(Color.RED, 1));
			}

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

	/**
	 * Clears the identification from the currently identified component.
	 */
	protected void clearIdentification() {
		if (!identificationFrozen && identifiedComponent != null) {
			if (identifiedComponentViaBackground) {
				identifiedComponent.setBackground(identifiedComponentBackground);
				identifiedComponentBackground = null;
			} else {
				identifiedComponent.setBorder(identifiedComponentBorder);
				identifiedComponentBorder = null;
			}
			identifiedComponent = null;
		}
	}

	/**
	 * Freezes the currently identified component in the "identification state". Even if the user moves the mouse
	 * outside the bounds of the component, it will still be identified.
	 */
	protected void freezeIdentification() {
		if (!identificationFrozen && identifiedComponent != null) {
			identificationFrozen = true;
		}
	}

	/**
	 * Unfreezes the currently identified component.
	 */
	protected void unfreezeIdentification() {
		if (identificationFrozen && identifiedComponent != null) {
			identificationFrozen = false;
		}
	}

	/**
	 * Toggles the freeze mode on the currently identified component.
	 */
	protected void toggleFreezeIdentification() {
		if (identificationFrozen) {
			unfreezeIdentification();
		} else {
			freezeIdentification();
		}
	}

	/**
	 * The window listener.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class AuthorAssistWindowListener implements WindowListener {

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
			shutDown();
		}

		@Override
		public void windowActivated(WindowEvent anEvent) {
			// ignored
		}
	}

	/**
	 * The component listener.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class AuthorAssistComponentListener implements MouseListener {

		/**
		 * The component to which this listener was added.
		 */
		private Component component;

		/**
		 * Creates a new instance.
		 * 
		 * @param aComponent
		 *            the component to which this listener will be added
		 */
		public AuthorAssistComponentListener(Component aComponent) {
			component = aComponent;
		}

		/**
		 * Remove the listener from its component.
		 */
		public void remove() {
			component.removeMouseListener(this);
		}

		/**
		 * Adds the listener to its component.
		 */
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
			clearIdentification();
		}

		@Override
		public void mouseEntered(MouseEvent anEvent) {
			if (component instanceof JComponent) {
				identifyComponent((JComponent) component);
			}
		}

		@Override
		public void mouseClicked(MouseEvent anEvent) {
			anEvent.consume();
		}
	}

	/**
	 * This thread is running all the time while identification mode is enabled. It makes sure that all visible
	 * components get the listeners injected which perform background/border coloring and path resolving when hovering
	 * over the component with the mouse.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class ComponentInjectionThread extends Thread {

		/**
		 * The interval in milliseconds in which the thread tries to inject listeners into new components.
		 */
		protected static final int INJECTION_INTERVAL = 500;

		/**
		 * The kill switch to terminate the thread.
		 */
		private volatile boolean killSwitch;

		/**
		 * Creates a new instance.
		 */
		public ComponentInjectionThread() {
			super("Author Assist Component Injection");
		}

		/**
		 * Kills the thread gracefully.
		 */
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
				} catch (InterruptedException exc) {
					// ignored
				}
			}

			cleanupComponentListeners();
		}
	}

	/**
	 * A subclass of {@link EventQueue} which is able to swallow certain mouse click events. This mode is used when
	 * identification mode is active, in order to "freeze" the current identification on click and prevent the
	 * application from processing that click normally.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected static class SwallowingEventQueue extends EventQueue {

		/**
		 * The author assist frame.
		 */
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
