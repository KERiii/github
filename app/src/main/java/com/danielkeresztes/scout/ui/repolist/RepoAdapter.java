package com.danielkeresztes.scout.ui.repolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielkeresztes.scout.R;
import com.danielkeresztes.scout.service.data.Repo;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

	private List<Repo> repoList;

	public RepoAdapter(List<Repo> repoList) {
		this.repoList = repoList;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_list_item,
				viewGroup, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		final Repo repo = repoList.get(position);
		viewHolder.title.setText(repo.getName());
		viewHolder.language.setText(repo.getLanguage());
		viewHolder.watchers.setText(String.valueOf(repo.getWatchersCount()));
	}

	@Override
	public int getItemCount() {
		return repoList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		TextView title;
		TextView language;
		TextView watchers;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			title = itemView.findViewById(R.id.repoItemTitle);
			language = itemView.findViewById(R.id.repoItemLanguage);
			watchers = itemView.findViewById(R.id.repoItemWatchers);
		}
	}
}
