package com.example.getgithubapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.getgithubapi.Adapters.Adapter;
import com.example.getgithubapi.DataBase.DataBase;
import com.example.getgithubapi.DataBase.RepoDao;
import com.example.getgithubapi.DataBase.RepoEntity;
import com.example.getgithubapi.Retrofit.Repo;
import com.example.getgithubapi.ViewModels.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements SetOnClick{

    DataBase dataBase;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager  manager;
    Adapter adapter = new Adapter(this);
    List<RepoEntity> list = new ArrayList<>();

    ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        viewModel.createRoomDb(this);

        dataBase = viewModel.getDataBase();

        initRecyclerView();

        getAllData();
    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.reposView);
        manager = new LinearLayoutManager(this);
        adapter = new Adapter(this);

        //Not Yet:
        recyclerView.setLayoutManager(manager);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull @NotNull RecyclerView rv, @NonNull @NotNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull @NotNull RecyclerView rv, @NonNull @NotNull MotionEvent e) {
                Intent toUserInfo = new Intent(MainActivity.this , UserInfo.class);
                startActivity(toUserInfo);
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                if(disallowIntercept){
                    makeToast("Can not load the page");
                }
            }
        });
    }

    public void makeToast(String message){

        Toast.makeText(this , message , Toast.LENGTH_SHORT).show();
    }

    public void getAllData(){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                dataBase.repoDao().getAllData().observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io()).subscribe(new Consumer<List<RepoEntity>>() {@Override
                public void accept(List<RepoEntity> repoEntities) throws Exception {
                            viewModel.prepareRepo();
                            adapter.setEntities(repoEntities);
                            recyclerView.setAdapter(adapter);

                            list = repoEntities;
                        }
               });
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {
                        makeSout("Getting Data");
                    }

                        @Override
                        public void onComplete() {
                            makeSout("Getting Data Finished");
                        }

                        @Override
                        public void onError(@NotNull Throwable e) {

                    }
                });

    }

    private void makeSout(String s) {
        System.out.println(s);;
    }

    @Override
    public void onClick(int position) {

        list.get(position);

        RepoEntity entity = list.get(position);

        Intent intent = new Intent(this , UserInfo.class);

        intent.putExtra("stars" , entity.getStars());
        intent.putExtra("forks" , entity.getForks());
        intent.putExtra("desc" , entity.getDescription());
        intent.putExtra("coll" , entity.getCollaborators());
        intent.putExtra("url" , entity.getUrl());
        intent.putExtra("userOwner" , entity.getUserOwner());

        startActivity(intent);
    }
}