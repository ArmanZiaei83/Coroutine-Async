package com.example.testalibaba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.testalibaba.DataBase.RepoEntity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.prepareHandler(this);
        viewModel.lastStep();

        getAllData();
    }

    public void getAllData(){

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                viewModel.getHandler().getDataBase().repoDao().getAllData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<RepoEntity>>() {
                    @Override
                    public void accept(List<RepoEntity> repoEntities) throws Exception {
                        for (int i = 0; i < repoEntities.size(); i++) {
                            System.out.println("Repo Id : " + repoEntities.get(i).getId());
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Got Data");
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        System.out.println("Error in getting data : " + e.getMessage());
                    }
                });
    }
}