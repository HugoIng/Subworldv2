package com.deepred.subworld.injection.component;

import android.app.Application;
import android.content.Context;

import com.deepred.subworld.data.SyncService;
import com.deepred.subworld.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import com.deepred.subworld.data.DataManager;
import com.deepred.subworld.data.local.DatabaseHelper;
import com.deepred.subworld.data.local.PreferencesHelper;
import com.deepred.subworld.data.remote.RibotsService;
import com.deepred.subworld.injection.ApplicationContext;
import com.deepred.subworld.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext Context context();
    Application application();
    RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
