/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.userapplication.service;

import entity.HotelRoom;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author KAMINI
 */
@Path("/hotel")
@RegisterRestClient(configKey = "myClient")
@ClientHeaderParam(name = "Authorization", value = "{authHeader}")
public interface hotelClient {

    @GET
    @Path("/searchHotels")
    @Produces(MediaType.APPLICATION_JSON)
    List<HotelRoom> getHotels(@QueryParam("city") String city,
                              @QueryParam("tname") String tname);

    default String authHeader() {
        return "Bearer " + ConfigProvider.getConfig().getValue("jwt-string", String.class);
    }
}