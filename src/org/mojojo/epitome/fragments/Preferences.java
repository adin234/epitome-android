package org.mojojo.epitome.fragments;

import java.util.ArrayList;
import java.util.List;

import org.mojojo.epitome.R;
import org.mojojo.epitome.R.layout;
import org.mojojo.epitome.adapters.ArticleListAdapter;
import org.mojojo.epitome.models.Article;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the {@link Preferences.OnFragmentInteractionListener} interface
 * to handle interaction events. Use the {@link Preferences#newInstance} factory
 * method to create an instance of this fragment.
 * 
 */
public class Preferences extends Fragment {
	private OnFragmentInteractionListener mListener;
	private Context context;
	
	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 */
	// TODO: Rename and change types and number of parameters
	public static Preferences newInstance() {
		Preferences fragment = new Preferences();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public Preferences() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_preferences, container, false);
		
		return view;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;
		try {
			mListener = (OnFragmentInteractionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		public void onFragmentInteraction(Uri uri);
	}

}
