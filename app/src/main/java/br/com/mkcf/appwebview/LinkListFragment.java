package br.com.mkcf.appwebview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import br.com.mkcf.appwebview.modelo.LinkData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LinkListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LinkListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static List<LinkData> linkDataList = new ArrayList<LinkData>();
    private LinkAdapter la;

    static {
        linkDataList.add(new LinkData("SwA", "http://www.survivingwithandroid.com"));

        linkDataList.add(new LinkData("Android" , "http://www.android.com"));
        linkDataList.add(new LinkData("Google Mail", "http://mail.google.com"));
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LinkListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LinkListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinkListFragment newInstance(String param1, String param2) {
        LinkListFragment fragment = new LinkListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("SwA", "LV onCreateView");
        View v = inflater.inflate(R.layout.linklist_layout, container, false);
        ListView lv = (ListView) v.findViewById(R.id.urls);
        la = new LinkAdapter(linkDataList, getActivity());
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                LinkData data = ( (LinkAdapter) la ).getItem(position);
                ( (ChangeLinkListener)  getActivity()).onLinkChange(data.getLink());
            }

        });
        return v;
    }



}