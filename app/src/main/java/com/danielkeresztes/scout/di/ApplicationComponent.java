package com.danielkeresztes.scout.di;

import com.danielkeresztes.scout.GithubApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class, AndroidSupportInjectionModule.class,
		ActivityBuilder.class})
public interface ApplicationComponent extends AndroidInjector<GithubApplication> {}
