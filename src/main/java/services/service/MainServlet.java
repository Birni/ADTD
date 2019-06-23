package services.service;


import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




public class MainServlet implements ServletContextListener
{
    @Inject
    private InitService initService;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        //do stuff
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        initService.init();
    }

}
