package com.danielkeresztes.scout.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.danielkeresztes.scout.service.GithubClient;
import com.danielkeresztes.scout.service.GithubService;
import com.danielkeresztes.scout.service.data.Repo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.schedulers.Schedulers;

@Singleton
public class GithubRepository {

	private final GithubService githubService;
	private final GithubClient githubClient;

	@Inject
	public GithubRepository(GithubClient githubClient) {
		this.githubClient = githubClient;
		githubService = this.githubClient.getService();
	}

	public LiveData<List<Repo>> getUserRepos(String user, int perPage, int page) {
		MutableLiveData<List<Repo>> listMutableLiveData = new MutableLiveData<>();
		githubService.getUserRepos(user, perPage, page)
				.subscribeOn(Schedulers.io())
		.subscribe(repos -> {
			listMutableLiveData.postValue(repos);
		});

		return listMutableLiveData;
	}
}
