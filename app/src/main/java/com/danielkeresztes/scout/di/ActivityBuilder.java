package com.danielkeresztes.scout.di;

import com.danielkeresztes.scout.ui.repolist.RepoListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {

	@ContributesAndroidInjector
	RepoListActivity contributeRepoListActivity();
}
