package com.portfolio.frontend;

import com.portfolio.frontend.domain.*;
import com.portfolio.frontend.service.BackendService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import java.net.URISyntaxException;

@Route("registerLogin")
public class RegisterLoginGUI extends VerticalLayout {

    @Autowired
    private BackendService backendService;

    public RegisterLoginGUI() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidth("700px");
        VerticalLayout verticalLayoutRegister = new VerticalLayout();
        verticalLayoutRegister.setWidth("50%");
        VerticalLayout verticalLayoutLogin = new VerticalLayout();
        verticalLayoutLogin.setWidth("50%");
        horizontalLayout.add(verticalLayoutRegister, verticalLayoutLogin);


        Binder<Users> binder = new Binder<>(Users.class);
        TextField textFieldLogin = new TextField("Login");
        TextField textFieldPassword = new TextField("Password");
        TextField textFieldMail = new TextField("Mail");
        TextField textFieldName = new TextField("Name");
        TextField textFieldSurname = new TextField("Surname");
        TextField textFieldPhoneNumber = new TextField("Phone Number");
        Button registerButton = new Button("Register");

        registerButton.addClickListener(clickEvent -> {
            Users user = new Users();
            binder.forField(textFieldLogin).bind("login");
            binder.forField(textFieldPassword).bind("password");
            binder.forField(textFieldName).bind("name");
            binder.forField(textFieldSurname).bind("surname");
            binder.forField(textFieldPhoneNumber).bind("phoneNumber");
            try {
                binder.writeBean(user);
            } catch (ValidationException e) {
                e.printStackTrace();
            }
            try {
                UsersDto usersDto = backendService.registerUser(user, textFieldMail.getValue());
                if (usersDto.getId() != null) {
                    Notification notification = new Notification("User created id: " + usersDto.getId(), 3000);
                    notification.open();
                } else {
                    Notification notification = new Notification("Error creating user", 3000);
                    notification.open();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        });

        Binder<Login> loginBinder = new Binder<>(Login.class);
        TextField textFieldLoginLogin = new TextField("Login");
        TextField textFieldPasswordLogin = new TextField("Password");
        Button loginButton = new Button("Login");

        loginButton.addClickListener(clickEvent -> {
            loginBinder.forField(textFieldLoginLogin).bind("login");
            loginBinder.forField(textFieldLoginLogin).bind("password");
            Login login = new Login();
            try {
                loginBinder.writeBean(login);
            } catch (ValidationException e) {
                e.printStackTrace();
            }
            try {
                LoggedInUser loggedInUser = backendService.loginUser(login.getLogin(), login.getPassword());
                if(loggedInUser.getStatus().equals("ok")) {
                    Cookie cookieId = new Cookie("id", String.valueOf(loggedInUser.getUserID()));
                    Cookie cookieSessionKey = new Cookie("sessionKey", loggedInUser.getSessionKey());

                    cookieId.setMaxAge(3600);
                    cookieSessionKey.setMaxAge(3600);

                    cookieId.setPath(VaadinService.getCurrentRequest().getContextPath());
                    cookieSessionKey.setPath(VaadinService.getCurrentRequest().getContextPath());

                    VaadinService.getCurrentResponse().addCookie(cookieId);
                    VaadinService.getCurrentResponse().addCookie(cookieSessionKey);

                    UI.getCurrent().navigate(getWeather.class);
                } else {
                    Notification notification = new Notification("Login error", 3000);
                    notification.open();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        verticalLayoutRegister.add(textFieldLogin, textFieldMail, textFieldPassword, textFieldName, textFieldSurname, textFieldPhoneNumber, registerButton);
        verticalLayoutLogin.add(textFieldLoginLogin, textFieldPasswordLogin, loginButton);
        add(horizontalLayout);
    }
}
