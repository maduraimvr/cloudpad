/**
 * 
 */
package com.portal.cloudpad.view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.StringUtils;
import com.portal.cloudpad.controller.dashboard.ImageUploader;
import com.portal.cloudpad.dto.User;
import com.portal.cloudpad.service.DashboardService;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.qos.logback.core.util.StringCollectionUtil;

/**
 * @author Venkatraman
 *
 */
@org.springframework.stereotype.Component
@UIScope
public class RegisterView extends VerticalLayout{
    

    @Autowired
    DashboardService dashboardService;
    
    
    public RegisterView() {
	setSizeFull();
        setMargin(false);
        setSpacing(false);
        Component registerForm = buildRegisterForm();
        addComponent(registerForm);
        setStyleName("background-image");
        setComponentAlignment(registerForm, Alignment.MIDDLE_CENTER);
    }

    /**
     * @return
     */
    private Component buildRegisterForm() {
	final VerticalLayout registerPanel = new VerticalLayout();
	registerPanel.setSizeUndefined();
	registerPanel.setMargin(false);
        Responsive.makeResponsive(registerPanel);
        registerPanel.addStyleName("register-panel");

        registerPanel.addComponent(buildLabels());
        registerPanel.addComponent(buildFields());
        return registerPanel;
    }

    /**
     * @return
     */
    private Component buildFields() {
	VerticalLayout feildLayout=new VerticalLayout();
	
	HorizontalLayout nameRow=new HorizontalLayout();
	TextField firstName=new TextField("Enter your First Name :");
	firstName.setRequiredIndicatorVisible(true);
	TextField lastName=new TextField("Enter your Last Name :");
	lastName.setRequiredIndicatorVisible(true);
	nameRow.addComponents(firstName,lastName);
	
	
	TextField userName=new TextField("Enter your User Name :");
	
	HorizontalLayout passowrdRow=new HorizontalLayout();
	PasswordField  password=new PasswordField ("Enter your password :");
	password.setRequiredIndicatorVisible(true);
	PasswordField  confirmPassword=new PasswordField ("Re-Enter your password :");
	confirmPassword.setRequiredIndicatorVisible(true);
	passowrdRow.addComponents(password,confirmPassword);
	
	ImageUploader imageUploader=new ImageUploader();
	Upload profilePictureUploader = new Upload("Upload it here",imageUploader);
	profilePictureUploader.setButtonCaption("Upload Now");
	profilePictureUploader.addSucceededListener(imageUploader);
	// A single-select radio button group
	RadioButtonGroup<String> genderRadioButtongroup =
	    new RadioButtonGroup<>("Choose Gender :");
	genderRadioButtongroup.setRequiredIndicatorVisible(true);
	genderRadioButtongroup.setItems("Male", "Female");
	genderRadioButtongroup.setSelectedItem("Male");
	
	List<String> roleList = new ArrayList<>();
	roleList.add( "Employee");
	roleList.add( "Manager");
	roleList.add( "Admin");
	
	ComboBox<String> roleSelect =
		    new ComboBox<>("Select a Role :");
	roleSelect.setItems(roleList);
	roleSelect.setSelectedItem(roleList.get(0));
	
	// List of planets
	List<String> locationList = new ArrayList<>();
	locationList.add( "Tokyo");
	locationList.add( "Chennai");
	locationList.add( "New York");

	ComboBox<String> locationSelect =
	    new ComboBox<>("Select a City :");
	locationSelect.setItems(locationList);
	locationSelect.setSelectedItem(locationList.get(0));

	
	
	HorizontalLayout buttonRoom=new HorizontalLayout();
	Button register = new Button("Sign Up");
	register.setIcon(VaadinIcons.USER);
	register.addStyleName(ValoTheme.BUTTON_PRIMARY);
	register.setClickShortcut(KeyCode.ENTER);
        register.focus();
        register.setSizeFull();
        Button clearAll = new Button();
        clearAll.setIcon(VaadinIcons.ERASER);
        clearAll.addStyleName(ValoTheme.BUTTON_PRIMARY);
        clearAll.setClickShortcut(KeyCode.DELETE);
        clearAll.focus();
        buttonRoom.addComponent(register);
        feildLayout.addComponents(nameRow,userName,passowrdRow,profilePictureUploader,genderRadioButtongroup,roleSelect,locationSelect,buttonRoom);
       
        register.addClickListener(listener->{
            if(password.getValue().equals(confirmPassword.getValue())) {
        	User userDto=new User(); 
        	userDto.setUserName(userName.getValue());
        	userDto.setFirstName(firstName.getValue());
        	userDto.setLastName(lastName.getValue());
        	userDto.setPassword(password.getValue());
        	userDto.setRole(roleSelect.getValue());
        	if(genderRadioButtongroup.getValue().equals("Male")) {
        	    
        	    userDto.setMale(true);
        	}else {
        	    userDto.setMale(false);
        	}
        	userDto.setLocation(locationSelect.getValue());
        	userDto.setAttempts(0);
        	Timestamp currentTimeStamp=new Timestamp(new java.util.Date().getTime());
        	userDto.setLastLoginTime(currentTimeStamp);
        	userDto.setLastBlockedTime(currentTimeStamp);
        	dashboardService.registerUser(userDto);
        	
        	
        	Notification.show("Sucesssfully Registered !!!", Type.ASSISTIVE_NOTIFICATION);
            }
	});
	return feildLayout;
	
    }

    /**
     * @return
     */
    private Component buildLabels() {
	VerticalLayout labels = new VerticalLayout();
        Label register = new Label("Register");
        register.setSizeUndefined();
        register.addStyleName(ValoTheme.LABEL_HUGE);
        register.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(register);
        labels.setComponentAlignment(register, Alignment.MIDDLE_CENTER);
        return labels;
    }

    
}
