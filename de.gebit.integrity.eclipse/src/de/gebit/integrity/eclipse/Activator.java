package de.gebit.integrity.eclipse;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Rene Schneider
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "de.gebit.integrity.eclipse"; //$NON-NLS-1$

	/**
	 * The shared instance.
	 */
	private static Activator plugin;

	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/**
	 * Will be called by OSGi when the bundle is started.
	 */
	public void start(BundleContext aContext) throws Exception {
		super.start(aContext);
		plugin = this;
	}

	/**
	 * Will be called by OSGi when the bundle is stopped.
	 */
	public void stop(BundleContext aContext) throws Exception {
		plugin = null;
		super.stop(aContext);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param aPath
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String aPath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, aPath);
	}
}
