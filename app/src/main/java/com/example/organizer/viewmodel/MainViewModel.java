package com.example.organizer.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.organizer.App;
import com.example.organizer.models.Note;

import java.util.List;

public class MainViewModel extends ViewModel {

    private  final LiveData<List<Note>>  noteLiveData = App.getInstance().getNotedao().getAllLiveData();

    public LiveData<List<Note>>  getNoteLiveData(){
        return noteLiveData;
    }



}
