package com.danielkeresztes.scout;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import com.danielkeresztes.scout.di.ApplicationComponent;
import com.danielkeresztes.scout.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class GithubApplication extends Application implements HasActivityInjector {

	@Inject
	DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

	@Override
	public void onCreate() {
		super.onCreate();
		createComponent().inject(this);
	}

	@NonNull
	protected ApplicationComponent createComponent() {
		return DaggerApplicationComponent.builder()
				.build();
	}

	@Override
	public AndroidInjector<Activity> activityInjector() {
		return dispatchingActivityInjector;
	}
}
