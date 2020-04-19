package autoVoter.server.listeners;

import java.util.ArrayList;

import autoVoter.server.interfaces.AddListener;

public class AddListenerToServer {

	public AddListenerToServer(ArrayList<AddListener> listeners) {
		super();
		this.listeners = listeners;
	}

	private ArrayList<AddListener> listeners;

	public void add() {
		for (AddListener listener : this.listeners) {
			listener.addListeners();
		}
	}
}
