package com.danielkeresztes.scout.ui.repolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.danielkeresztes.scout.repository.GithubRepository;
import com.danielkeresztes.scout.service.data.Repo;

import java.util.List;

import javax.inject.Inject;

public class RepoListViewModel extends ViewModel {

	private GithubRepository repository;

	public RepoListViewModel(GithubRepository repository) {
		this.repository = repository;
	}

	public LiveData<List<Repo>> getUserRepos(String user, int perPage, int page) {
		return repository.getUserRepos(user, perPage, page);
	}

	public static class RepoListViewModelFactory implements ViewModelProvider.Factory {

		private final GithubRepository repository;

		@Inject
		public RepoListViewModelFactory(GithubRepository repository) {
			this.repository = repository;
		}

		@NonNull
		@Override
		public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
			//noinspection unchecked
			return (T) new RepoListViewModel(repository);
		}
	}

}
