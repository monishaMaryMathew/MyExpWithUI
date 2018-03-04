package com.example.monisha.myexpwithui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monisha.myexpwithui.R;
import com.example.monisha.myexpwithui.service.MyIntentService;
import com.example.monisha.myexpwithui.util.Constants;
import com.example.monisha.myexpwithui.util.StateReceiver;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ServiceTestFragment.OnFragmentInteractionListener} interfaces
 * to handle interaction events.
 * Use the {@link ServiceTestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceTestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ServiceTestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiceTestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceTestFragment newInstance(String param1, String param2) {
        ServiceTestFragment fragment = new ServiceTestFragment();
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
        //Create service
        Intent intentToService = new Intent(getActivity().getApplicationContext(), MyIntentService.class);
        intentToService.putExtra(Constants.EXTRA_DATA, "Service Intent extra data");
        getActivity().startService(intentToService);

        //Create a intentfilter
        IntentFilter statusIntentFilter = new IntentFilter(Constants.BROADCAST_ACTION);
        //statusIntentFilter.addDataScheme("http");
        //Create an instance of the receiver
        StateReceiver receiver = new StateReceiver();
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext())
                .registerReceiver(
                        receiver,
                        statusIntentFilter
                );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service_test, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
