package com.example.organizer;
import androidx.fragment.app.Fragment;
import  android.app.Application;
import  androidx.room.Room;
import com.example.organizer.data.NoteDao;
import com.example.organizer.data.AppDatabase;

public class App extends Application {

    private AppDatabase database;
    private NoteDao notedao;
    private static App instance;
    public static App getInstance(){
        return instance;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        instance=this;
        database=Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "app_db-name")
                .allowMainThreadQueries().build();

        notedao=database.noteDao();
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public NoteDao getNotedao() {
        return notedao;
    }

    public void setNotedao(NoteDao notedao) {
        this.notedao = notedao;
    }

    public static void setInstance(App instance) {
        App.instance = instance;
    }
}
