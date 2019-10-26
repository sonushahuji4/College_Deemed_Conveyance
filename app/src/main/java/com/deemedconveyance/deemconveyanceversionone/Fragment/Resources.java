package com.deemedconveyance.deemconveyanceversionone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deemedconveyance.deemconveyanceversionone.Adapter.ResourceAdapter;
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

public class Resources extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private List<Titile> lstTitle;
    public Resources() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.resource_fragment,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.resource_recyclerview);
        ResourceAdapter resourceAdapter = new ResourceAdapter(getContext(),lstTitle);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        myrecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        myrecyclerview.setAdapter(resourceAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstTitle = new ArrayList<>();
        lstTitle.add(new Titile("Deemed Conveyance Gazette Notification"));
        lstTitle.add(new Titile("Deemed Conveyance Rules GR Notification"));
        lstTitle.add(new Titile("Deemed Conveyance Stamp Duty Registration GR Notification"));
        lstTitle.add(new Titile("Deemed Conveyance Transfer of Property GR Notification"));
        lstTitle.add(new Titile("Documents Required For Deemed Conveyance"));
        lstTitle.add(new Titile("Deemed Conveyance Application- Form VII"));
        lstTitle.add(new Titile("Deemed Conveyance Scrutiny Report- Form VIII"));
        lstTitle.add(new Titile("Deemed Conveyance Registration Circular"));
        lstTitle.add(new Titile("Deemed Conveyance Co-Ordination Committee GR"));
        lstTitle.add(new Titile("Deemed Conveyance LBT Circular"));
        lstTitle.add(new Titile("Deemed Conveyance Adalat GR"));
        lstTitle.add(new Titile("OC Not Required For Deemed Conveyance GR Dated September 18 2017"));
        lstTitle.add(new Titile("Deemed Conveyance New Procedure GR- June 22, 2018"));
    }
}
