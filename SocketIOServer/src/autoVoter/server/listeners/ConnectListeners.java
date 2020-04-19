package autoVoter.server.listeners;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

import autoVoter.server.ServerBase;
import autoVoter.server.interfaces.AddListener;

public class ConnectListeners extends ServerBase implements AddListener {

	public ConnectListeners(SocketIOServer server) {
		super(server);
	}

	@Override
	public void addListeners() {
		getServer().addConnectListener(new ConnectListener() {

			@Override
			public void onConnect(SocketIOClient client) {
				System.out.println(String.format("client connected %s", client));
			}
		});
	}

}
