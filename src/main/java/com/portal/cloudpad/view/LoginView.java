package com.portal.cloudpad.view;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.cloudpad.service.DashboardService;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FileResource;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@org.springframework.stereotype.Component
@UIScope
public class LoginView extends VerticalLayout {

    @Autowired
    DashboardService dashboardService;
    
    public LoginView() {
        setSizeFull();
        setMargin(false);
        setSpacing(false);
        
        
        Label headerLabel =new Label();
        headerLabel.setCaption("CloudPad");
        headerLabel.setStyleName("header-label");
        addComponent(headerLabel);
        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setStyleName("background-image");
        setComponentAlignment(headerLabel, Alignment.MIDDLE_CENTER);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    }

    private Component buildLoginForm() {
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setMargin(false);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildUserPofilePicture());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(new CheckBox("Remember me", true));
        
        return loginPanel;
    }

    /**
     * @return
     */
    private Component buildUserPofilePicture() {
	
	// Find the application directory
	String basepath = VaadinService.getCurrent()
	                  .getBaseDirectory().getAbsolutePath();
		
	FileResource resource = new FileResource(new File(basepath +
                "/VAADIN/themes/dashboard/img/img_avatar3.png"));
	
	// Show the image in the application
	Image userImage = new Image(null, resource);
	userImage.setStyleName("avatar");
	userImage.setWidth("80px");
	userImage.setHeight("80px");
	userImage.setResponsive(true);
	VerticalLayout avatar = new VerticalLayout(userImage);
	avatar.setComponentAlignment(userImage, Alignment.MIDDLE_CENTER);
	return avatar;
    }

    private Component buildFields() {
        VerticalLayout fields = new VerticalLayout();
        fields.addStyleName("fields");

        final TextField username = new TextField("Username");
        username.setIcon(VaadinIcons.USER);
        username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final PasswordField password = new PasswordField("Password");
        password.setIcon(VaadinIcons.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button signin = new Button("Sign In");
        signin.setIcon(VaadinIcons.SIGN_IN);
        signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signin.setClickShortcut(KeyCode.ENTER);
        signin.focus();

        fields.addComponent(username);
        fields.setComponentAlignment(username,Alignment.MIDDLE_CENTER);
        fields.addComponent(password);
        fields.setComponentAlignment(password,Alignment.MIDDLE_CENTER);
        fields.addComponent(signin);
        fields.setComponentAlignment(signin, Alignment.MIDDLE_CENTER);

        signin.addClickListener(listener->{
            String userName=username.getValue();
            String pass=password.getValue();
            dashboardService.authenticateUser(userName, pass);
        });
        return fields;
    }

    private Component buildLabels() {
	VerticalLayout labels = new VerticalLayout();
        Label welcome = new Label("Login");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_HUGE);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);
        labels.setComponentAlignment(welcome, Alignment.MIDDLE_CENTER);
        return labels;
    }

}
