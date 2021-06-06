package com.example.a10118397_v4;
/*nama : bagas wirawan
  nim : 10118397
  kelas : IF9
  tgl : Juni-05-2021
* */

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class CatatanFragment extends Fragment {

    private FloatingActionButton fab_add;
    private ListView list_view;
    private ListViewAdapter adapter;
    private ArrayList<dataMahasiswa> listMahasiswa = new ArrayList<>();
    private SQLiteHelper helper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catatan, container, false);
        fab_add = view.findViewById(R.id.fab_add);
        list_view = view.findViewById(R.id.list_view);

        helper = new SQLiteHelper(this.getActivity());
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),InputActivity.class));
            }
        });

        menampilkanData();
        return view;

    }
        public void menampilkanData(){
            listMahasiswa.clear();
            Cursor res = helper.getDataAll();
            while (res.moveToNext()){
                String id = res.getString(0);
                String judul = res.getString(1);
                String kategori = res.getString(2);
                String isi = res.getString(3);

                listMahasiswa.add(new dataMahasiswa(id,
                        judul,
                        kategori,
                        isi ));


            }
            adapter = new ListViewAdapter(listMahasiswa, getActivity());
            list_view.setAdapter(adapter);
        }
}