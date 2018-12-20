package com.danielkeresztes.scout.service;

import com.danielkeresztes.scout.service.data.Repo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

	@GET("users/{user}/repos")
	Single<List<Repo>> getUserRepos(@Path("user") String user, @Query
			("per_page") int perPage, @Query("page") int page);
}
