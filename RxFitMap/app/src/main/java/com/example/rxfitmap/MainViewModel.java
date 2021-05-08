package com.example.rxfitmap;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel<jsonPlaceHolderApi> extends ViewModel {

    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();

    public Observable<Object> postObservable (){

        //appearing Post in recView
        // Is What this Class Does .. .. ..
        return RetrofitBuilder.getApi()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<List<Post>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(@NonNull List<Post> posts) throws Exception {

                        recyclerViewAdapter.setPost(posts);
                        return Observable.fromIterable(posts).subscribeOn(Schedulers.io());
                    }
                });
    }
}
