package com.danielkeresztes.scout.ui.repolist;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.danielkeresztes.scout.R;
import com.danielkeresztes.scout.ui.BaseActivity;

import javax.inject.Inject;

public class RepoListActivity extends BaseActivity {

	RecyclerView recyclerView;
	RepoAdapter adapter;

	@Inject
	RepoListViewModel.RepoListViewModelFactory viewModelFactory;
	RepoListViewModel viewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = findViewById(R.id.repoListRecyclerView);

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
		recyclerView.setHasFixedSize(true);

		viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoListViewModel.class);
		viewModel.getUserRepos("google", 20, 1)
				.observe(this, repos -> {
					adapter = new RepoAdapter(repos);
					recyclerView.setAdapter(adapter);
		});
	}
}
