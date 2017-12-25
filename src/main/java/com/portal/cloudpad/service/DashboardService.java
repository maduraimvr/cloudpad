/**
 * 
 */
package com.portal.cloudpad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.cloudpad.dao.UserCredentialRepository;
import com.portal.cloudpad.dto.User;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;


/**
 * @author Venkatraman
 *
 */
@Service
public class DashboardService {
    
    private static final Logger log = LoggerFactory.getLogger(DashboardService.class);
    
    @Autowired
    UserCredentialRepository userCredentialRepository;
    /**
     * 
     * @param nameFeild
     * @return
     */
    public void registerUser(User user) {
	log.info("registerUser method starts");
	userCredentialRepository.save(user);
	log.info("registerUser method ends");
	}
    
    public void authenticateUser(String userName,String passWord) {
   	log.info("authenticateUser method starts");
   	User userEntity=userCredentialRepository.findOne(userName);
   	if(userEntity.getUserName().equals(userName) && userEntity.getPassword().equals(passWord)) {
   	   	log.info("authenticateUser Sucess");

   	    Notification.show("Sucess",Type.TRAY_NOTIFICATION);
   	}else {
   	 Notification.show("Sorry Try Again",Type.ERROR_MESSAGE);
   	}
   	
   	log.info("authenticateUser method ends");
   	}

}
