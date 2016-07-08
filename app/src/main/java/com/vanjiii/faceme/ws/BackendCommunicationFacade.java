package com.vanjiii.faceme.ws;

import com.vanjiii.faceme.beans.Person;
import com.vanjiii.faceme.ws.handlers.CommonHandler;
import com.vanjiii.faceme.ws.responses.SendAllPhotoResponse;
import com.vanjiii.faceme.ws.responses.SendPhotoResponse;

import java.util.List;

/**
 * Interface with declared all web service calls
 *
 * Created by vanjiii on 25.06.16.
 */
public interface BackendCommunicationFacade {

    /**
    * Call the SendPhoto rest service which store a photo-object to the server.
    *
    * @param person The photo-object itself.
    * @param handler The object that handles the response of the request.
    */
    void callSendPhoto(Person person, CommonHandler<SendPhotoResponse> handler);

    /**
    * Call the SendAllPhoto rest service which store all the photo-objects to the server.
    *
    * @param person The list of photo-objects itself.
    * @param handler The object that handles the response of the request.
    */
    void callSendAllPhotos(List<Person> person, CommonHandler<SendAllPhotoResponse> handler);

}

