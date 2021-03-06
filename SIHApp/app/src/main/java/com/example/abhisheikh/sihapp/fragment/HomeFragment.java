package com.example.abhisheikh.sihapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhisheikh.sihapp.R;
import com.example.abhisheikh.sihapp.activity.MainActivity;
import com.example.abhisheikh.sihapp.adapter.AnnouncementAdapter;
import com.example.abhisheikh.sihapp.other.Announcement;
import com.example.abhisheikh.sihapp.pop.AnnouncementPop;

import java.util.ArrayList;

import static com.example.abhisheikh.sihapp.R.mipmap.tasks;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    ImageButton announcementImageButton,meetingsImageButton,fundsImageButton;
    ImageButton taskImageButton, schoolImageButton;
    private String memberStatus;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        memberStatus = getArguments().getString("status");
        //Toast.makeText(getContext(), memberStatus, Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle(R.string.nav_home);

        announcementImageButton = (ImageButton)view.findViewById(R.id.announcementImageButton);
        meetingsImageButton = (ImageButton)view.findViewById(R.id.meetingsImageButton);
        fundsImageButton = (ImageButton)view.findViewById(R.id.fundsImageButton);
        taskImageButton = (ImageButton)view.findViewById(R.id.taskImageButton);
        schoolImageButton = (ImageButton)view.findViewById(R.id.schoolImageButton);

        setOnClickListeners();

        return view;
    }

    private void setOnClickListeners(){
        announcementImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnnouncementFragment newFragment = new AnnouncementFragment();
                Bundle bundle = new Bundle();
                bundle.putString("status",memberStatus);
                newFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction= getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                getActivity().setTitle(R.string.nav_announcement);
            }
        });

        meetingsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeetingsFragment newFragment = new MeetingsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("status",memberStatus);
                newFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction= getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                getActivity().setTitle(R.string.nav_meetings);
            }
        });

        taskImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TasksFragment newFragment = new TasksFragment();
                Bundle bundle = new Bundle();
                bundle.putString("status",memberStatus);
                newFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction= getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                getActivity().setTitle(R.string.nav_tasks);
            }
        });

        fundsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FundsFragment newFragment = new FundsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("status",memberStatus);
                newFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction= getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                getActivity().setTitle(R.string.nav_funds);
            }
        });

        schoolImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SchoolFragment newFragment = new SchoolFragment();
                Bundle bundle = new Bundle();
                bundle.putString("status",memberStatus);
                newFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction= getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                getActivity().setTitle(R.string.nav_school);
            }
        });

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

    /*@Override
    public void onResume() {
        super.onResume();
        // Set title
        getActivity().getActionBar()
                .setTitle(R.string.nav_home);
    }*/

    /**
     * This interface must be implemented by activities that contain this
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
