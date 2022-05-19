package com.example.organizer.screens;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.organizer.R;
import com.example.organizer.databinding.FragmentSecondBinding;
import android.view.MenuInflater;
import  android.annotation.SuppressLint;
import  android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.example.organizer.App;
import com.example.organizer.models.Note;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.Objects;



public class SecondFragment extends Fragment {


    private static final String EXTRA_NOTE= "Виключна ситуація";
    private Note note;
    private EditText editText;
    private FragmentActivity fragmentActivity;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        fragmentActivity=(FragmentActivity)getActivity();
        View view=binding.getRoot();

        editText =view.findViewById(R.id.text);
        if(fragmentActivity.getIntent().hasExtra(EXTRA_NOTE)){
           note=fragmentActivity.getIntent().getParcelableExtra(EXTRA_NOTE);
           editText.setText(note.text);
        }
        else
        {

            note=new Note();

        }

        return view;

    }




    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater){

        super.onCreateOptionsMenu(menu,inflater);
        FragmentActivity activity=getActivity();
        if(activity!=null){
            activity.getMenuInflater().inflate(R.menu.menu_save, menu);
        }

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){

        Toast.makeText(requireActivity().getBaseContext(),"Вибір пункту меню - Home",Toast.LENGTH_LONG).show();

        switch (item.getItemId()){
            case android.R.id.home:
                Snackbar.make(requireView(), R.string.home_info, Snackbar.LENGTH_LONG)
                        .setAction("Повідомлення",null).show();
                return false;
            case R.id.action_save:
                Toast.makeText(requireActivity()
                        .getBaseContext(),"Вибір пункту меню - Save",Toast.LENGTH_LONG).show();

                if(editText.getText().length()>0){
                    note.text=editText.getText().toString();
                    note.done=false;
                    note.timestamp= System.currentTimeMillis();

                    App.getInstance().getNotedao().insert(note);

                }
                return true;

        }


        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}





