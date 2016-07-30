package com.deepred.subworld.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;

import com.deepred.subworld.test.common.injection.module.ApplicationTestModule;
import com.deepred.subworld.injection.component.ApplicationComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
