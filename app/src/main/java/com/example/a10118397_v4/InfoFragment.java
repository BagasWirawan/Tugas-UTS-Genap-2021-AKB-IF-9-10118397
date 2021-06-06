package com.example.a10118397_v4;
/*nama : bagas wirawan
  nim : 10118397
  kelas : IF9
  tgl : Juni-05-2021
* */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_info, container, false);
        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        pager = root.findViewById(R.id.pager);

        pagerAdapter = new SliderPagerAdapter(getActivity().getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);

        return root;
    }
}