package com.vanjiii.faceme.applications;

import android.app.Application;

import com.vanjiii.faceme.modules.BaseModule;

import dagger.ObjectGraph;

/**
 * The main application class of Face Me app.
 * Created by vanjiii on 3/26/16.
 */
public class BaseApplication extends Application {

    private static ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        graph = ObjectGraph.create(getApplicationModules());
    }

    /**
     * used for mocking the dependency injection in unit tests
     *
     * @param objectGraph passed object graph
     */
    public static void setObjectGraph(ObjectGraph objectGraph) {
        graph = objectGraph;
    }

    /**
     * The graph allowing to inject DI configurations in classes.
     */
    public static ObjectGraph getObjectGraph() {
        return graph;
    }

    /**
     * provides the application modules of this application
     *
     * @return all modules
     */
    protected Object[] getApplicationModules() {
        return new Object[]{new BaseModule(this)};
    }

}
