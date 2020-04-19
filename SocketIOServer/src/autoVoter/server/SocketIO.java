package autoVoter.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.google.gson.Gson;

import autoVoter.server.interfaces.AddListener;
import autoVoter.server.interfaces.ServerType;
import autoVoter.server.listeners.AddListenerToServer;
import autoVoter.server.listeners.ConnectListeners;
import autoVoter.server.listeners.DisconnectListeners;
import autoVoter.server.listeners.OnDataListener;

public class SocketIO implements ServerType {

	private SocketIOServer server;
	
	private int port;
	
	private String ip;

	public SocketIO(String ip, int port, List<TableModel> tableModels) {
		this.tableModels = tableModels;
		this.port = port;
		this.ip = ip;
	}

	public static void main(String[] args) throws InterruptedException {
		
		int port = Integer.parseInt(args[0]);
		String ip = args[1];
		
		//int i, String rowWebsite, int votedThisSession, int maxThreads, int stopAtVotes, int votingDelay,
//		int proxyTimeout
		ArrayList<TableModel> tableModels = new ArrayList<TableModel>(
				Arrays.asList(new TableModel(0, "abc", 0, 0, 0, 0, 5), new TableModel(1, "abc", 0, 0, 0, 0, 5)));

		ServerType server = new SocketIO(ip, port, tableModels);
		server.start();
	}

	private List<TableModel> tableModels = new ArrayList<TableModel>();

	@Override
	public void start() {
		Thread t = new Thread(() -> {
			Configuration config = new Configuration();
			config.setOrigin("*");
			config.setHostname(this.ip);
			config.setPort(this.port);
			System.out.println("starting on port: "+port+" and hostname: "+ip);

			this.server = new SocketIOServer(config);

			AddListenerToServer listeners = new AddListenerToServer(new ArrayList<AddListener>(Arrays.asList(
					new OnDataListener(server), new ConnectListeners(server), new DisconnectListeners(server))));
			listeners.add();

			server.start();

			while (true) {
				String json = new Gson().toJson(this.tableModels);

				System.out.println(String.format("emitted %s", json));
				server.getBroadcastOperations().sendEvent("tableModel", json);
				try {
					Thread.sleep(5_000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		t.setName("wsserver");
		t.start();
	}

}
