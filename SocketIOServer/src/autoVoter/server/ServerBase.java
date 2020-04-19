package autoVoter.server;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;

public class ServerBase {

	public ServerBase(SocketIOServer server) {
		this.setServer(server);
	}

	public SocketIOServer getServer() {
		return server;
	}

	public void setServer(SocketIOServer server) {
		this.server = server;
	}

	private SocketIOServer server;

}
