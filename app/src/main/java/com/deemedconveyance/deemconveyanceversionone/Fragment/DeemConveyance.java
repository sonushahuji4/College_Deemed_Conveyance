package com.deemedconveyance.deemconveyanceversionone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deemedconveyance.deemconveyanceversionone.Adapter.TitleAdapter;
import com.deemedconveyance.deemconveyanceversionone.Model.Titile;
import com.deemedconveyance.deemconveyanceversionone.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DeemConveyance extends Fragment
{
    View v;
    private RecyclerView myrecyclerview;
    private List<Titile> lstTitle;

    public DeemConveyance() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.deemconveyance_fragment,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.deemconveyance_recyclerview);
        TitleAdapter titleAdapter = new TitleAdapter(getContext(),lstTitle);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        myrecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        myrecyclerview.setAdapter(titleAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        lstTitle = new ArrayList<>();
        lstTitle.add(new Titile("Conveyance of Co- Operative Housing Society"));
        lstTitle.add(new Titile("Need for Deemed Conveyance"));
        lstTitle.add(new Titile("All About Deemed Conveyance"));
        lstTitle.add(new Titile("Advantages of Deemed Conveyance"));
        lstTitle.add(new Titile("Procedure for Deemed Conveyance"));
        lstTitle.add(new Titile("Preparation for Deemed Conveyance"));
        lstTitle.add(new Titile("Documentation for Deemed Conveyance"));
        lstTitle.add(new Titile("Legal Case for Deemed Conveyance"));
        lstTitle.add(new Titile("Registration of Deemed Conveyance"));
        lstTitle.add(new Titile("Transfer of Property after Deemed Conveyance"));
        lstTitle.add(new Titile("Deemed Conveyance & ReDevelopment"));
    }
}
