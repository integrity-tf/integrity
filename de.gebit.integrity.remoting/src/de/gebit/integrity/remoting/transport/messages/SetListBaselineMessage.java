package de.gebit.integrity.remoting.transport.messages;

import de.gebit.integrity.remoting.entities.setlist.SetList;

public class SetListBaselineMessage extends AbstractMessage {

	private static final long serialVersionUID = 9085447162313871124L;

	private SetList setList;

	public SetListBaselineMessage(SetList aSetList) {
		setList = aSetList;
	}

	public SetList getSetList() {
		return setList;
	}

}
