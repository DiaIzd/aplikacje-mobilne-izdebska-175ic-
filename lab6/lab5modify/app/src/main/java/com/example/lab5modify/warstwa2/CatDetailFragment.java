package com.example.lab5modify.warstwa2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab5modify.R;
import com.example.lab5modify.DatabaseHelper;
import com.example.lab5modify.model.Cat;
import com.example.lab5modify.warstwa.StopwatchFragment;

import java.util.List;

public class CatDetailFragment extends Fragment {
    public long catId;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StopwatchFragment stopwatch=new StopwatchFragment();
        FragmentTransaction ft=getChildFragmentManager().beginTransaction();
        ft.add(R.id.stopwatch_container,stopwatch);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }
    DatabaseHelper databaseHelper;
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cat_detail, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        if(view!=null){
            TextView name=view.findViewById(R.id.catName);
            List<Cat> insertList;
            insertList= databaseHelper.getCatFromCatTable();
            Cat cake=insertList.get((int)catId);
            name.setText(cake.getName());

            ImageView photo=view.findViewById(R.id.catPhoto);
            String iconName = cake.getImageResourceId();
            int resId=getResources().getIdentifier(iconName,"drawable",getActivity().getPackageName());
            photo.setImageResource(resId);
            TextView description=view.findViewById(R.id.catDescription);
            description.setText(cake.getDescription());
        }
    }
    public void setCat(long id){
        this.catId=id;
    }
}
