package autoVoter.server.listeners;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DisconnectListener;

import autoVoter.server.ServerBase;
import autoVoter.server.interfaces.AddListener;

public class AddDisconnectListener extends ServerBase implements AddListener {

	public AddDisconnectListener(SocketIOServer server) {
		super(server);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addListeners() {
		getServer().addDisconnectListener(new DisconnectListener() {

			@Override
			public void onDisconnect(SocketIOClient client) {
				// TODO Auto-generated method stub
				System.out.println(String.format("client disconnected %s", client));
			}
		});
	}

}
