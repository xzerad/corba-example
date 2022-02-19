package com.company;
import NoteInterfaceModule.NoteInterfacePOA;

public class NoteImpl extends NoteInterfacePOA {
	@Override
	public double getNote(short cin, String codeMatiere) {
		return Math.random() * 10 + 10;
	}

	@Override
	public void shutdown() {

	}
}
