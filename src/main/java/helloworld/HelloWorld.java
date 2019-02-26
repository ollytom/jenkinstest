package helloworld;

import java.io.OutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;

class HelloWorld {
	public static void main(String[] args) throws Exception {
		System.out.println("starting http server...");
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
			server.createContext("/", new HelloHandler());
			server.setExecutor(null);
			server.start();
		} catch (Exception e) {
			System.out.printf("error starting http server: %s", e.getMessage());
		}
	}
	static class HelloHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			String response = "Hello world!";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}
