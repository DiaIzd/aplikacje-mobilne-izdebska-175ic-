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
import com.example.lab5modify.model.Dog;
import com.example.lab5modify.warstwa.StopwatchFragment;

import java.util.List;

public class DogDetailFragment extends Fragment {
    public long dogId;


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

        return inflater.inflate(R.layout.fragment_dog_detail, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        if(view!=null){
            TextView name=view.findViewById(R.id.dogName);
            List<Dog> insertList;
            insertList=databaseHelper.getDogsFromDogTable();
            Dog dog=insertList.get((int)dogId);
            name.setText(dog.getName());

            ImageView photo=view.findViewById(R.id.dogPhoto);
            String iconName = dog.getImageResourceId();
            int resId=getResources().getIdentifier(iconName,"drawable",getActivity().getPackageName());
            photo.setImageResource(resId);
            TextView description=view.findViewById(R.id.dogDescription);
            description.setText(dog.getDescription());
        }
    }
    public void setDog(long id){
        this.dogId=id;
    }
}
