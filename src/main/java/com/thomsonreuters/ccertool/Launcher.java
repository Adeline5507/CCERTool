package com.thomsonreuters.ccertool;

import java.io.File;
import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class Launcher {

	public static final int PORT = 8080;
	public static final String CONTEXT = "/";
	private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";

	 /**
     * 创建用于生产环境的Jetty Server
     */
    public static Server createProdServer(int port, String contextPath) {
        Server server = new Server(port);
        server.setStopAtShutdown(true);

        ProtectionDomain protectionDomain = Launcher.class.getProtectionDomain();
        URL location = protectionDomain.getCodeSource().getLocation();

        String warFile = location.toExternalForm();
        System.out.println("war file path:"+warFile);
        WebAppContext context = new WebAppContext(warFile, contextPath);
        context.setServer(server);

        // 设置work dir,war包将解压到该目录，jsp编译后的文件也将放入其中。
        String currentDir = new File(location.getPath()).getParent();
        File workDir = new File(currentDir, "work");
        context.setTempDirectory(workDir);

        server.setHandler(context);
        return server;
    }
    
    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createDevServer(int port, String contextPath) {
        Server server = new Server();
         // 设置在JVM退出时关闭Jetty的钩子。
         server.setStopAtShutdown(true);

         //这是http的连接器
         ServerConnector connector = new ServerConnector(server);
         connector.setPort(port);
         // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
         connector.setReuseAddress(false);
         server.setConnectors(new Connector[] { connector });

         WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
         //webContext.setContextPath("/");
         webContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
         // 设置webapp的位置
         webContext.setResourceBase(DEFAULT_WEBAPP_PATH);
         webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
         server.setHandler(webContext);
         return server;
    }


	/**
	 * 启动jetty服务
	 * 
	 * @param port
	 * @param context
	 */
	public void startJetty(int port, String context, String env) {
		 Server server = null;
	        if ("dev".equals(env)) {
	            server= Launcher.createDevServer(port, context);
	        }else {
	            server= Launcher.createProdServer(port, context);
	        }
	        try {
	            server.stop();
	            server.start();
	            server.join();
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(-1);
	        }
	        
	        
	}

	public static void main(String[] args) {
		new Launcher().startJetty(8080, "/","");
	}
}