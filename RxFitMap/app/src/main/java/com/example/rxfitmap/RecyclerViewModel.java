package com.example.rxfitmap;

public class RecyclerViewModel {

    String text ;

    public RecyclerViewModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
