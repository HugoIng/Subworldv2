package com.deepred.subworld.injection.component;

import com.deepred.subworld.injection.module.ActivityModule;

import dagger.Subcomponent;
import com.deepred.subworld.injection.PerActivity;
import com.deepred.subworld.ui.init.InitActivity;
import com.deepred.subworld.ui.login.LoginActivity;
import com.deepred.subworld.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(InitActivity initActivity);
    void inject(LoginActivity loginActivity);
}
