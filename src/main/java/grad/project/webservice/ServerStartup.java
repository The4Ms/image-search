package grad.project.webservice;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ServerStartup implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
    	String datasetFolder = sce.getServletContext().getRealPath("calteckUniversityDataSet");
    	SearchHandler.getInstance().init(datasetFolder);
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
    	
    }
	
}
