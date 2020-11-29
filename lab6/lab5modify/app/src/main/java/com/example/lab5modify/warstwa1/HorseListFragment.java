package com.example.lab5modify.warstwa1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.lab5modify.DatabaseHelper;
import com.example.lab5modify.model.Horse;

import java.util.List;

public class HorseListFragment extends ListFragment {
    static interface Listener {
        void itemClicked(long id);
    }

    private Listener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
        List<Horse> insertList;
        insertList=databaseHelper.getHorsesFromHorseTable();
        String[] names = new String[insertList.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = insertList.get(i).getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
