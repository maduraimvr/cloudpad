/**
 * 
 */
package com.portal.cloudpad.controller.dashboard;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * @author Venkatraman
 *
 */
@Theme("valo")
@SpringUI(path="/cloudpad/dashboard")
public class DashboardUI extends UI{

    Navigator navigator;
    
    protected static final String MAINVIEW = "index";
    
    /* (non-Javadoc)
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init(VaadinRequest request) {
	// TODO Auto-generated method stub
	
    }

}
