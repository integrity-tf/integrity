package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.entities.setlist.SetList;

/**
 * Updates the setlist with a new baseline, that is, a complete copy.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class SetListBaselineMessage extends AbstractMessage {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 9085447162313871124L;

	/**
	 * The new setlist.
	 */
	private SetList setList;

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetList
	 *            the new setlist
	 */
	public SetListBaselineMessage(SetList aSetList) {
		setList = aSetList;
	}

	public SetList getSetList() {
		return setList;
	}

}
