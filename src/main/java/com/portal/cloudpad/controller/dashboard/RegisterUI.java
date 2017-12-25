/**
 * 
 */
package com.portal.cloudpad.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.cloudpad.service.DashboardService;
import com.portal.cloudpad.view.RegisterView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * @author Venkatraman
 *
 */
@Theme("dashboard")
@SpringUI(path="/cloudpad/dashboard/signup")
public class RegisterUI extends UI{

    @Autowired
    DashboardService dashboardService;
    
    @Autowired
    RegisterView registerView; 
    
    /* (non-Javadoc)
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init(VaadinRequest request) {
	setSizeFull();
        setContent(registerView);
    }

}
