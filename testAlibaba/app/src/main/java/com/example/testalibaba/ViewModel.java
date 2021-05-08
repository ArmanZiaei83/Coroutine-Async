package com.example.testalibaba;

import android.content.Context;

import com.example.testalibaba.DataBase.DataBase;
import com.example.testalibaba.Models.GetRepo;
import com.example.testalibaba.Models.Repo;
import com.google.android.material.progressindicator.BaseProgressIndicator;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ViewModel extends androidx.lifecycle.ViewModel {

    RxRepo rxRepo = new RxRepo();
    RxGetRepo getRepo = new RxGetRepo();

    Handler handler;

    public void prepareHandler(Context context){
        handler = new Handler(context);
    }

    public Handler getHandler(){
        return handler;
    }

    public void repoSubscriber(Observable<Repo> repoObservable){
        repoObservable.subscribe(new Observer<Repo>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {
                System.out.println("<< Started >>" + "\n" );
            }

            @Override
            public void onNext(@NotNull Repo repo) {
                System.out.println("repo info : " + repo.getId());
                detailSubscriber(getRepo.getRepoObservable(repo.getFull_name().replace("/" + repo.getName(), "")
                        , repo.getName()));
            }

            @Override
            public void onError(@NotNull Throwable e) {
                System.out.println("Error >>> " + e.getMessage() + "\n" );
            }

            @Override
            public void onComplete() {
                System.out.println("\n" + "<< Finished >>");
            }
        });
    }

    public void detailSubscriber(Observable<GetRepo> getRepoObservable){
        getRepoObservable.subscribe(new Observer<GetRepo>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {
                makeSout("<< Detail Started >>");
            }

            @Override
            public void onNext(@NotNull GetRepo getRepo) {
                if(handler.getDataBase().repoDao().isExist(getRepo.getId())){
                    handler.deleteData(getRepo.getId());
                    handler.addToDb(getRepo.getId(), getRepo.getForks_count() , getRepo.getStargazers_count() , getRepo.getDescription() ,
                            getRepo.getCollaborators_url(), getRepo.getFull_name() , getRepo.getHtml_url());

                }else {
                    handler.addToDb(getRepo.getId(), getRepo.getForks_count() , getRepo.getStargazers_count() , getRepo.getDescription() ,
                            getRepo.getCollaborators_url(), getRepo.getFull_name() , getRepo.getHtml_url());
                }
            }

            @Override
            public void onError(@NotNull Throwable e) {
                makeSout("Error >>> " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void lastStep(){
        repoSubscriber(rxRepo.getRepo());
    }

    public void makeSout(String message){
        System.out.println(message);
    }
}
