package com.example.roooom.AccessDataBase;

import android.content.Context;

import androidx.room.Room;

import com.example.roooom.Data.User;
import com.example.roooom.Data.UserDataBase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxForData {

    private Context context;
    UserDataBase userDataBase;

    public RxForData(Context context) {
        this.context = context;
        userDataBase = Room.databaseBuilder(context , UserDataBase.class , "userinfo.db").build();
    }

    public void addToDb(final DataManager dataManager ,final String email ,final String pass){

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                User user = new User(email , pass);
                userDataBase.daoClass().insertUser(user);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        makeSout("<--- Started --- >");
                    }

                    @Override
                    public void onComplete() {
                        makeSout("<--- Completed --- >");
                    }

                    @Override
                    public void onError(Throwable e) {
                        makeSout("Error : " + e.getMessage() + " Reason : " + e.getCause());
                    }
                });
    }

    public void getAllData(){

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                userDataBase.daoClass().getAllUsers().subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        for (int i = 0; i < users.size(); i++) {
                            System.out.println("User Email : " + users.get(i).getPass());
                        }
                    }

                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        makeSout("<--- Started --- >");
                    }

                    @Override
                    public void onComplete() {
                        makeSout("<--- Completed --->");
                    }

                    @Override
                    public void onError(Throwable e) {
                        makeSout("Error : " + e.getMessage() + "Reason : " + e.getCause());
                    }
                });
    }
    public void makeSout(String message){
        System.out.println(message);
    }
}
