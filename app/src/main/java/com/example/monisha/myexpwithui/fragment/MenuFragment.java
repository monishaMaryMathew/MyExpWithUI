package com.example.monisha.myexpwithui.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.monisha.myexpwithui.ImageModel;
import com.example.monisha.myexpwithui.R;
import com.example.monisha.myexpwithui.activity.ContentActivity;
import com.example.monisha.myexpwithui.adapter.CircularAdapter;
import com.jpardogo.listbuddies.lib.views.ListBuddiesLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interfaces
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 *
 * Reference : https://github.com/jpardogo/ListBuddies
 *
*/
public class MenuFragment extends Fragment implements ListBuddiesLayout.OnBuddyItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnMenuFragmentInteractionListener mListener;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        String url = "https:////www.google.com//url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjvtrq5ldXRAhVn5YMKHdHTAxUQjRwIBw&url=https%3A%2F%2Fwww.appannie.com%2Fapps%2Fgoogle-play%2Fapp%2Fcom.seibundoshinkosha.origami4s%2F&bvm=bv.144224172,d.amc&psig=AFQjCNHjU6sZRZ7iEuc2UnE7PkLZ8CfLxw&ust=1485154398809876";
        Drawable drawable1 = getResources().getDrawable(R.drawable.image1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.image2);
        List<ImageModel> urls1 = new ArrayList<>();
        urls1.add(new ImageModel(drawable1, url));
        List<ImageModel> urls2 = new ArrayList<>();
        urls2.add(new ImageModel(drawable2, url));
        ListBuddiesLayout listBuddies = (ListBuddiesLayout) rootView.findViewById(R.id.listbuddies);
        CircularAdapter adapter = new CircularAdapter(getActivity(), getResources().getDimensionPixelSize(R.dimen.item_height_small), urls1);
        CircularAdapter adapter2 = new CircularAdapter(getActivity(), getResources().getDimensionPixelSize(R.dimen.item_height_tall), urls2);
        listBuddies.setAdapters(adapter, adapter2);
        listBuddies.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuFragmentInteractionListener) {
            mListener = (OnMenuFragmentInteractionListener) context;
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

    @Override
    public void onBuddyItemClicked(AdapterView<?> parent, View view, int buddy, int position, long id) {
        //int buddy indicate the list where the item is contain.
        // 0 - left
        // 1 - right
        ((ContentActivity)getActivity()).setFragment(2, "");
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
    public interface OnMenuFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onMenuFragmentInteraction();
    }
}
