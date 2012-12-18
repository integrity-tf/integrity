/**
 * 
 */
package de.gebit.integrity.ui;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.browser.BrowserViewer;
import org.eclipse.ui.internal.browser.WebBrowserEditor;
import org.eclipse.ui.internal.browser.WebBrowserView;

import com.google.inject.Inject;

import de.gebit.integrity.ui.search.IntegritySearch;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
@SuppressWarnings("restriction")
public class IntegrityUIStartup implements IStartup {

	/**
	 * The {@link IntegritySearch} engine.
	 */
	@Inject
	protected IntegritySearch integritySearch;

	@Override
	public void earlyStartup() {
		registerBrowserLocationListener();
	}

	private void registerBrowserLocationListener() {
		final IPartListener partListener = new IPartListener() {
			@Override
			public void partOpened(IWorkbenchPart aPart) {
				if (aPart instanceof WebBrowserEditor) {
					WebBrowserEditor tempEditor = (WebBrowserEditor) aPart;

					try {
						Field tempWebBrowserField = tempEditor.getClass().getDeclaredField("webBrowser");
						tempWebBrowserField.setAccessible(true);
						BrowserViewer tempViewer = (BrowserViewer) tempWebBrowserField.get(tempEditor);

						Field tempBrowserField = tempViewer.getClass().getDeclaredField("browser");
						tempBrowserField.setAccessible(true);
						Browser tempBrowser = (Browser) tempBrowserField.get(tempViewer);

						tempBrowser.addLocationListener(new IntegrityURLLocationListener());
					} catch (SecurityException exc) {
						exc.printStackTrace();
					} catch (NoSuchFieldException exc) {
						exc.printStackTrace();
					} catch (IllegalArgumentException exc) {
						exc.printStackTrace();
					} catch (IllegalAccessException exc) {
						exc.printStackTrace();
					}
				} else if (aPart instanceof WebBrowserView) {
					WebBrowserView tempView = (WebBrowserView) aPart;

					try {
						Field tempViewerField = tempView.getClass().getDeclaredField("viewer");
						tempViewerField.setAccessible(true);
						BrowserViewer tempViewer = (BrowserViewer) tempViewerField.get(tempView);

						Field tempBrowserField = tempViewer.getClass().getDeclaredField("browser");
						tempBrowserField.setAccessible(true);
						Browser tempBrowser = (Browser) tempBrowserField.get(tempViewer);

						tempBrowser.addLocationListener(new IntegrityURLLocationListener());
					} catch (SecurityException exc) {
						exc.printStackTrace();
					} catch (NoSuchFieldException exc) {
						exc.printStackTrace();
					} catch (IllegalArgumentException exc) {
						exc.printStackTrace();
					} catch (IllegalAccessException exc) {
						exc.printStackTrace();
					}
				}
			}

			@Override
			public void partActivated(IWorkbenchPart aPart) {
				// nothing to do here
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart aPart) {
				// nothing to do here
			}

			@Override
			public void partClosed(IWorkbenchPart aPart) {
				// nothing to do here
			}

			@Override
			public void partDeactivated(IWorkbenchPart aPart) {
				// nothing to do here
			}
		};

		final IPageListener pageListener = new IPageListener() {
			@Override
			public void pageOpened(IWorkbenchPage aPart) {
				aPart.addPartListener(partListener);
			}

			@Override
			public void pageActivated(IWorkbenchPage aPart) {
				// nothing to do here
			}

			@Override
			public void pageClosed(IWorkbenchPage aPart) {
				// nothing to do here
			}
		};

		final IWindowListener windowListener = new IWindowListener() {
			@Override
			public void windowOpened(IWorkbenchWindow aWindow) {
				aWindow.addPageListener(pageListener);
			}

			@Override
			public void windowActivated(IWorkbenchWindow aWindow) {
				// nothing to do here
			}

			@Override
			public void windowDeactivated(IWorkbenchWindow aWindow) {
				// nothing to do here
			}

			@Override
			public void windowClosed(IWorkbenchWindow aWindow) {
				// nothing to do here
			}
		};

		IWorkbenchWindow tempActiveWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		if (tempActiveWindow != null) {
			IWorkbenchPage tempActivePage = tempActiveWindow.getActivePage();

			if (tempActivePage != null) {
				tempActivePage.addPartListener(partListener);
			} else {
				tempActiveWindow.addPageListener(pageListener);
			}
		} else {
			for (IWorkbenchWindow tempWindow : PlatformUI.getWorkbench().getWorkbenchWindows()) {
				for (IWorkbenchPage tempPage : tempWindow.getPages()) {
					tempPage.addPartListener(partListener);
				}
				tempWindow.addPageListener(pageListener);
			}

			PlatformUI.getWorkbench().addWindowListener(windowListener);
		}
	}

	private static final Pattern INTEGRITY_URL_PATTERN = Pattern.compile("integrity:\\/\\/([^#]+?)\\/?(?:\\#(\\d+))?");

	/**
	 * 
	 * 
	 * 
	 * @author Slartibartfast
	 * 
	 */
	class IntegrityURLLocationListener implements LocationListener {
		@Override
		public void changed(LocationEvent anEvent) {
			return;
		}

		@Override
		public void changing(LocationEvent anEvent) {
			Matcher tempMatcher = INTEGRITY_URL_PATTERN.matcher(anEvent.location);
			if (tempMatcher.matches()) {
				anEvent.doit = false;
				integritySearch.openSuiteDefinitionByName(tempMatcher.group(1));
			}
		}
	}

}
