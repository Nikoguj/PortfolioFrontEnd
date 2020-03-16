package com.portfolio.frontend;

import com.portfolio.frontend.domain.*;
import com.portfolio.frontend.service.BackendService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.validator.IntegerRangeValidator;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Route("weather")
public class getWeather  extends VerticalLayout {

    @Autowired
    private BackendService backendService;

    public getWeather() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        Binder<Travel> binder = new Binder<>(Travel.class);
        TextField textFieldDestination = new TextField("Destination");
        TextField textFieldOrigin = new TextField("Origin");
        TextField textFieldDistance = new TextField("Distance between points");
        Button pointsButton = new Button("Show points with weather");

        pointsButton.addClickListener(clickEvent -> {
            Travel travel = new Travel();

            Cookie idCookie = getCookieByName("id");
            Cookie sessionKeyCookie = getCookieByName("sessionKey");

            travel.setUserId(Long.valueOf(idCookie.getValue()));
            travel.setUserSessionKey(sessionKeyCookie.getValue());
            travel.setStartTime(LocalDateTime.now());
            binder.forField(textFieldDestination).bind("destination");
            binder.forField(textFieldOrigin).bind("origin");
            binder.forField(textFieldDistance)
                    .withConverter(new StringToIntegerConverter("Distance needs"))
                    .withValidator(new IntegerRangeValidator("Distance needs to be at least 1000", 1000, 50000))
                    .bind("distance");

            try {
                binder.writeBean(travel);
            } catch (ValidationException e) {
                e.printStackTrace();
            }

            try {
                Weather weather = backendService.getWeather(travel.getDestination(), travel.getOrigin(), travel.getDistance(), (int) travel.getStartTime().atZone(ZoneId.systemDefault()).toEpochSecond(), travel.getUserSessionKey(), travel.getUserId());
                List<ListOfAllPoint> listOfAllPoints = new ArrayList<>();
                for(ListOfAllPoint point: weather.getListOfAllPoints()) {
                    listOfAllPoints.add(point);
                }
                Grid<ListOfAllPoint> grid = new Grid<>(ListOfAllPoint.class);
                grid.removeAllColumns();
                grid.addColumn(ListOfAllPoint::getLat).setHeader("LAT");
                grid.addColumn(ListOfAllPoint::getLng).setHeader("LNG");
                grid.addColumn(ListOfAllPoint::getTimeFromLastPoint).setHeader("Time From Last Point");
                grid.addColumn(ListOfAllPoint::getArrivalTime).setHeader("Arrival Time");
                grid.addColumn(ListOfAllPoint::getWeatherDto).setHeader("Weather");
                grid.setItems(listOfAllPoints);
                add(grid);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        horizontalLayout.add(textFieldDestination, textFieldOrigin, textFieldDistance, pointsButton);

        add(horizontalLayout);
    }

    private Cookie getCookieByName(String name) {
        // Fetch all cookies from the request
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();

        // Iterate to find cookie by its name
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }

}
