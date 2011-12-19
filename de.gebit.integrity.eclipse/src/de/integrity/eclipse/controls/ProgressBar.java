package de.integrity.eclipse.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import de.integrity.remoting.entities.setlist.SetList;
import de.integrity.remoting.entities.setlist.SetListEntryResultStates;

public class ProgressBar extends Composite {

	private SetList setList;

	private Color resultSuccessColor;
	private Color resultFailureColor;
	private Color resultNeutralColor;
	private Color resultExceptionColor;
	private Color borderColor;

	public ProgressBar(Composite aParent, int aStyle) {
		this(aParent, aStyle, null);
	}

	public ProgressBar(Composite aParent, int aStyle, SetList aSetList) {
		super(aParent, aStyle | SWT.NO_BACKGROUND | SWT.DOUBLE_BUFFERED);
		setList = aSetList;

		resultSuccessColor = new Color(Display.getCurrent(), 0, 94, 13);
		resultFailureColor = new Color(Display.getCurrent(), 190, 0, 0);
		resultNeutralColor = new Color(Display.getCurrent(), 220, 220, 220);
		resultExceptionColor = new Color(Display.getCurrent(), 204, 163, 0);
		borderColor = new Color(Display.getCurrent(), 181, 189, 210);

		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				updateDisplay(e.gc, e.x, e.y, e.width, e.height, ProgressBar.this.getBounds().width);
			}
		});
	}

	public void setSetList(SetList aSetList) {
		setList = aSetList;
	}

	private void updateDisplay(GC aGC, int anX, int anY, int aWidth, int aHeight, int aFullWidth) {
		aGC.setLineStyle(SWT.LINE_SOLID);
		aGC.setLineWidth(1);

		if (setList == null) {
			aGC.setBackground(resultNeutralColor);
			aGC.fillRectangle(anX, anY, aWidth, aHeight);
		} else {
			int tempTotalCount = setList.getNumberOfExecutableEntries();

			for (int tempX = anX; tempX < anX + aWidth; tempX++) {
				SetListEntryResultStates tempState = getResultStateForPosition(tempX, aWidth, tempTotalCount);
				if (tempState == null) {
					tempState = SetListEntryResultStates.UNKNOWN;
				}

				switch (tempState) {
				case SUCCESSFUL:
					aGC.setForeground(resultSuccessColor);
					break;
				case FAILED:
					aGC.setForeground(resultFailureColor);
					break;
				case EXCEPTION:
					aGC.setForeground(resultExceptionColor);
					break;
				case UNKNOWN:
				default:
					aGC.setForeground(resultNeutralColor);
				}

				aGC.drawLine(tempX, anY, tempX, anY + aHeight);
			}
		}

		if (anY + aHeight == getBounds().height) {
			aGC.setForeground(borderColor);
			aGC.drawLine(anX, anY + aHeight - 1, anX + aWidth, anY + aHeight - 1);
		}
	}

	protected SetListEntryResultStates getResultStateForPosition(int aPos, int aWidth, int aMax) {
		int tempMinEntryPosition = (int) Math.floor(((double) aPos / (double) aWidth) * (double) aMax);
		int tempMaxEntryPosition = (int) Math.ceil(((double) (aPos + 1) / (double) aWidth) * (double) aMax) - 1;

		if (tempMinEntryPosition >= tempMaxEntryPosition) {
			return setList.getResultStateForExecutableEntry(tempMinEntryPosition);
		} else {
			boolean tempHasUnknown = false;
			for (int i = tempMinEntryPosition; i < tempMaxEntryPosition; i++) {
				SetListEntryResultStates tempResultState = setList.getResultStateForExecutableEntry(i);
				if (tempResultState != null) {
					switch (tempResultState) {
					case EXCEPTION:
						return SetListEntryResultStates.EXCEPTION;
					case FAILED:
						return SetListEntryResultStates.FAILED;
					case UNKNOWN:
						tempHasUnknown = true;
						break;
					case SUCCESSFUL:
						continue;
					}
				}
			}

			if (tempHasUnknown) {
				return SetListEntryResultStates.UNKNOWN;
			} else {
				return SetListEntryResultStates.SUCCESSFUL;
			}
		}
	}

	@Override
	public void dispose() {
		resultExceptionColor.dispose();
		resultFailureColor.dispose();
		resultNeutralColor.dispose();
		resultSuccessColor.dispose();
		borderColor.dispose();
		super.dispose();
	}
}
