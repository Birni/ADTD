package services.service;


import services.entity.Transporter;

import javax.ejb.Schedule;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

import static services.service.VirtualTransporterManager.*;

@Singleton
public class MainServlet implements ServletContextListener
{


    @Inject
    private InitService initService;
    private VirtualTransporterManager VTM;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        //do stuff
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        initService.init();


    }




}
