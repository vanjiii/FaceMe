package com.vanjiii.faceme.ws.async;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.vanjiii.faceme.applications.BaseApplication;
import com.vanjiii.faceme.ws.handlers.CommonHandler;
import com.vanjiii.faceme.ws.infrastructure.HttpClient;
import com.vanjiii.faceme.ws.infrastructure.RequestMethod;
import com.vanjiii.faceme.ws.requests.BaseRequest;
import com.vanjiii.faceme.ws.responses.AsyncTaskResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vanjiii on 25.06.16.
 */
public class WebRequestAsyncTask<TResponse> extends AsyncTask<BaseRequest, Void, AsyncTaskResponse<TResponse>> {

    protected static List<AsyncTask> activeTasksList = new ArrayList<AsyncTask>();

    private static String AUTH_TOKEN_EXPIRED = "502";

    protected final Class<TResponse> typeParameterClass;

    @Inject
    protected Gson gson;
    @Inject
    protected HttpClient httpClient;

    protected CommonHandler<TResponse> handler;
    protected String serviceEndpoint;
    protected RequestMethod requestMethod;

    public WebRequestAsyncTask(String serviceEndpoint, RequestMethod requestMethod, CommonHandler<TResponse> handler, Class<TResponse> typeParameterClass) {
        this.handler = handler;
        this.typeParameterClass = typeParameterClass;
        this.serviceEndpoint = serviceEndpoint;
        this.requestMethod = requestMethod;

        BaseApplication.getObjectGraph().inject(this);
    }

    @Override
    protected AsyncTaskResponse<TResponse> doInBackground(BaseRequest... params) {
        return null;
    }
}
