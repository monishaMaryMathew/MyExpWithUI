package com.example.monisha.myexpwithui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monisha.myexpwithui.R;
import com.example.monisha.myexpwithui.activity.ContentActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.jar.Manifest;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BitmapCheckFragment.OnFragmentInteractionListener} interfaces
 * to handle interaction events.
 * Use the {@link BitmapCheckFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BitmapCheckFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button selectFromGallerBtn;
    private TextView tempTextView;
    private Uri pathUri;
    private String pathString;

    private OnFragmentInteractionListener mListener;

    public BitmapCheckFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BitmapCheckFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BitmapCheckFragment newInstance(String param1, String param2) {
        BitmapCheckFragment fragment = new BitmapCheckFragment();
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
            pathString = getArguments().getString("path");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bitmap_check, container, false);
        selectFromGallerBtn = (Button) view.findViewById(R.id.select_image_button);
        tempTextView = (TextView) view.findViewById(R.id.temp_textView);
        tempTextView.setText(pathString);
        selectFromGallerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImageFromGallery();
            }
        });
        writeBitmapToFile();
        return view;
    }

    private void writeBitmapToFile() {
        if(!pathString.equals("Nothing")) {


                Bitmap bitmap = BitmapFactory.decodeFile(pathString, new BitmapFactory.Options());
                String root = Environment.getExternalStorageDirectory().getAbsolutePath();
                File myDir = new File(root + "/saved_images");

                myDir.mkdirs();

                String fname = "Image-temp" + ".jpg";
                File file = new File(myDir, fname);
                if (file.exists()) file.delete();
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                    out.flush();
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(getActivity().getApplicationContext(), "Written to: " + root + "/saved_images", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Not written", Toast.LENGTH_SHORT).show();
        }
    }

    private void getImageFromGallery(){
        if (mListener != null) {
            mListener.intentToGallery();
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
        void intentToGallery();
    }
}
