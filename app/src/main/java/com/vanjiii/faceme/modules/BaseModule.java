package com.vanjiii.faceme.modules;

import android.content.Context;

import com.vanjiii.faceme.activities.MainScreenActivity;
import com.vanjiii.faceme.managers.DialogManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Base module to link future modules together.
 * <p/>
 * Created by vanjiii on 3/23/16.
 */
@Module(complete = true, library = true,
        injects = {
                MainScreenActivity.class
        }
)
public class BaseModule {

    private final Context application;

    public BaseModule(Context application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    public DialogManager provideDialogManager() {
        return new DialogManager();
    }
}
