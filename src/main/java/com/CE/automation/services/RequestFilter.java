package com.CE.automation.services;

import com.CE.automation.helpers.CEAPIEndPoints;
import io.restassured.filter.FilterContext;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.spi.AuthFilter;

/**
 * Created by Skatukam on 09/12/2018.
 */
public class RequestFilter implements AuthFilter {


    public Response filter(FilterableRequestSpecification requestSpecification,
                           FilterableResponseSpecification responseSpecification, FilterContext filterContext) {

        requestSpecification.header(new Header("Authorization",
                "User QkALNUwunVpsp3uzPvNgdHea2rDiDZ9/3po4UpAWN/U=, Organization 616c20d77b9774b1739852af12c3e9cf, Element 1383ZtL6Q93rT47s+O56K2WwLqh+/kW6Z2IA6M68Tuc="));
        requestSpecification.baseUri(CEAPIEndPoints.BASE_URL);
        return filterContext.next(requestSpecification, responseSpecification);
    }
}