/**
 * 
 */
package com.portal.cloudpad.controller.dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.portal.cloudpad.service.DashboardService;
import com.portal.cloudpad.view.LoginView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * @author Venkatraman
 *
 */
@Theme("dashboard")
@SpringUI(path="/cloudpad/dashboard/login")
public class LoginUI extends UI{
    
    @Autowired
    DashboardService dashboardService;
    
    @Autowired
    LoginView loginView;
    
    private static final Logger log = LoggerFactory.getLogger(LoginUI.class);

    /* (non-Javadoc)
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init(VaadinRequest request) {
	log.info("init method starts");
	setSizeFull();
        setContent(loginView);
	log.info("init method ends");
    }
}
