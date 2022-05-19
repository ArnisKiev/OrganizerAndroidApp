package com.example.organizer.screens;
import androidx.lifecycle.Observer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.organizer.models.Note;
import com.example.organizer.viewmodel.MainViewModel;
import com.example.organizer.viewmodel.ViewModelAdapter;


import com.example.organizer.R;

import com.example.organizer.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        RecyclerView recyclerView= binding.getRoot();

        RecyclerView.LayoutManager layoutManager=
                new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL));

        final ViewModelAdapter adapter=new ViewModelAdapter();
        recyclerView.setAdapter(adapter);
        MainViewModel mainViewModel=new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getNoteLiveData().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setItems(notes);
            }
        });

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}








