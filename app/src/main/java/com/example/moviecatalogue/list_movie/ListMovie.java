package com.example.moviecatalogue.list_movie;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.detail_movie.DetailMovie;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListMovieAdapter mAdapter;

    private ArrayList<MovieModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selcted_movie";

    @Override
    protected void onCreate(Bundle savedINstanceState) {
        super.onCreate(savedINstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }

    private void findViews(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setAdapter() {
        modelList.add(new MovieModel(getResources().getString(R.string.title_a_star), getString(R.string.overview_a_star),R.drawable.poster_a_star));
        modelList.add(new MovieModel(getResources().getString(R.string.title_aquaman), getString(R.string.overview_aquaman),R.drawable.poster_aquaman));
        modelList.add(new MovieModel(getResources().getString(R.string.title_nun), getString(R.string.overview_nun),R.drawable.poster_nun));
        modelList.add(new MovieModel(getResources().getString(R.string.title_meg), getString(R.string.overview_meg),R.drawable.poster_meg));
        modelList.add(new MovieModel(getResources().getString(R.string.title_tombraider), getString(R.string.overview_tombraider),R.drawable.poster_tombraider));
        modelList.add(new MovieModel(getResources().getString(R.string.title_incredibles2), getString(R.string.overview_incredibles2),R.drawable.poster_incredibles2));
        modelList.add(new MovieModel(getResources().getString(R.string.title_toall), getString(R.string.overview_toall),R.drawable.poster_toall));
        modelList.add(new MovieModel(getResources().getString(R.string.title_ready), getString(R.string.overview_ready),R.drawable.poster_ready));
        modelList.add(new MovieModel(getResources().getString(R.string.title_commuter), getString(R.string.overview_commuter),R.drawable.poster_commuter));
        modelList.add(new MovieModel(getResources().getString(R.string.title_predator), getString(R.string.overview_predator),R.drawable.poster_predator));
        modelList.add(new MovieModel(getResources().getString(R.string.title_firstman), getString(R.string.overview_firstman),R.drawable.poster_firstman));
        modelList.add(new MovieModel(getResources().getString(R.string.title_avengersinfinity), getString(R.string.overview_avengersinfinity),R.drawable.poster_avengerinfinity));
        modelList.add(new MovieModel(getResources().getString(R.string.title_hereditary), getString(R.string.overview_hereditary),R.drawable.poster_hereditary));

        mAdapter = new ListMovieAdapter(ListMovie.this, modelList);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, MovieModel model) {
                Intent goToDetailMovie = new Intent(ListMovie.this, DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });
    }
}
