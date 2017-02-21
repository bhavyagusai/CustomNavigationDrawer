package com.example.androiddev.customnavigationdrawer.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.androiddev.customnavigationdrawer.AddClearanceNoticeActivity;
import com.example.androiddev.customnavigationdrawer.R;

public class ClearanceNoticeFragment extends android.support.v4.app.Fragment {
    private OnFragmentInteractionListener mListener;

    public ClearanceNoticeFragment() {
    }

    public static ClearanceNoticeFragment newInstance(String param1, String param2) {
        ClearanceNoticeFragment fragment = new ClearanceNoticeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        //NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        //View header = navigationView.getHeaderView(0);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clearance_notice, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        //toolbar.setTitle("Clearance");
        super.onActivityCreated(savedInstanceState);
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
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_clearance_notices, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_archive:

                return false;

            case R.id.action_add:
                Intent intent_add_action = new Intent(getActivity(), AddClearanceNoticeActivity.class);
                startActivity(intent_add_action);
                return true;

            default:
                break;
        }
       return false;
    }
}
