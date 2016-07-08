package com.vanjiii.faceme.ws;

import com.vanjiii.faceme.beans.Person;
import com.vanjiii.faceme.constants.EndPoints;
import com.vanjiii.faceme.ws.handlers.CommonHandler;
import com.vanjiii.faceme.ws.infrastructure.RequestMethod;
import com.vanjiii.faceme.ws.requests.SendPhotoRequest;
import com.vanjiii.faceme.ws.responses.SendAllPhotoResponse;
import com.vanjiii.faceme.ws.responses.SendPhotoResponse;
import com.vanjiii.faceme.ws.async.WebRequestAsyncTask;

import java.util.List;

/**
 * Created by vanjiii on 25.06.16.
 */
public class BackendCommunicationFacadeImpl implements BackendCommunicationFacade {
    @Override
    public void callSendPhoto(Person person, CommonHandler<SendPhotoResponse> handler) {
        SendPhotoRequest request = new SendPhotoRequest();
        WebRequestAsyncTask<SendPhotoResponse> task = new WebRequestAsyncTask<>(EndPoints.SEND_PHOTO_URL,
                RequestMethod.POST, handler, SendPhotoResponse.class);

        task.execute(request);
    }

    @Override
    public void callSendAllPhotos(List<Person> person, CommonHandler<SendAllPhotoResponse> handler) {

    }
}
