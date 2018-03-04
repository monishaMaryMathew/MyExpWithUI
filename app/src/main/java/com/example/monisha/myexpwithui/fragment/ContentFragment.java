package com.example.monisha.myexpwithui.fragment;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monisha.myexpwithui.R;
import com.example.monisha.myexpwithui.activity.ContentActivity;
import com.example.monisha.myexpwithui.adapter.AlbumAdapter;
import com.example.monisha.myexpwithui.databinding.FragmentContentBinding;
import com.example.monisha.myexpwithui.model.AlbumModel;
import com.example.monisha.myexpwithui.model.Handlers;
import com.example.monisha.myexpwithui.model.SongModel;
import com.example.monisha.myexpwithui.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContentFragment.OnContentFragmentInteractionListener} interfaces
 * to handle interaction events.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnContentFragmentInteractionListener mListener;

    private List<AlbumModel> albumList = new ArrayList<>();
    private RecyclerView albumRecyclerView;
    private AlbumAdapter adapter;

    public ContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String param1, String param2) {
        ContentFragment fragment = new ContentFragment();
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
//        FragmentContentBinding fragmentContentBinding = FragmentContentBinding.inflate(getActivity().getLayoutInflater());
//        User user = new User("TestUser", "LastName");
//        fragmentContentBinding.setUser(user);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        FragmentContentBinding binding = FragmentContentBinding.inflate(inflater, container, false);
        User user = new User("TestUser", "LastName");
        binding.setUser(user);
        binding.setHandlers(new Handlers());
        view = binding.getRoot();

        //set the recycler view
        albumRecyclerView = (RecyclerView) view.findViewById(R.id.albumRecyclervieLayout);

        //set the album list
        albumList = getData();

        //define the adapter
        adapter = new AlbumAdapter(albumList, getActivity());

        //define a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        //set the layout manager, the animator, the adapter to the recylerview
        albumRecyclerView.setLayoutManager(layoutManager);
        albumRecyclerView.setItemAnimator(new DefaultItemAnimator()); // default animator
        albumRecyclerView.setAdapter(adapter);

        return view;
    }

    private List<AlbumModel> getData(){
        List<AlbumModel> list = new ArrayList<>();
        List<SongModel> songList = new ArrayList<>();
        songList.add(new SongModel("abc song", 3));
        songList.add(new SongModel("def song", 4));
        list.add(new AlbumModel("AAA album", "Pop", songList, false));
        list.add(new AlbumModel("BBB album", "Pop", songList, false));
        list.add(new AlbumModel("CCC album", "Classical", songList, false));
        list.add(new AlbumModel("DDD album", "Opera", songList, true));
        list.add(new AlbumModel("EEE album", "Hiphop", songList, false));
        list.add(new AlbumModel("FFF album", "Pop", songList, false));
        list.add(new AlbumModel("GGG album", "Pop", songList, true));
        list.add(new AlbumModel("HHH album", "Rap", songList, false));
        list.add(new AlbumModel("III album", "Pop", songList, false));
        list.add(new AlbumModel("JJJ album", "Bollywood", songList, false));
        list.add(new AlbumModel("KKK album", "Pop", songList, false));
        return list;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onContentFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnContentFragmentInteractionListener) {
            mListener = (OnContentFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interfaces must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnContentFragmentInteractionListener {
        // TODO: Update argument type and name
        void onContentFragmentInteraction(Uri uri);
    }
}
