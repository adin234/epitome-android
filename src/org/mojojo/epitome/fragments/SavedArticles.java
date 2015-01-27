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
 * must implement the {@link SavedArticles.OnFragmentInteractionListener} interface
 * to handle interaction events. Use the {@link SavedArticles#newInstance} factory
 * method to create an instance of this fragment.
 * 
 */
public class SavedArticles extends Fragment {
	private OnFragmentInteractionListener mListener;
	private Context context;
	
	private List<Article> articles;
	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 */
	// TODO: Rename and change types and number of parameters
	public static SavedArticles newInstance() {
		SavedArticles fragment = new SavedArticles();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public SavedArticles() {
		articles = new ArrayList<Article>();
		articles.add(new Article("Aldrin Bautista", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Jerome", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Sherwin", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Mando", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Kurdapya", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Berting", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Arlene", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Timong", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Benjo", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Raul", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Segundo", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
		articles.add(new Article("Stepan", "http://placehold.it/350x150", "title", "http://www.google.com", "one plus one equals two"));
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
		View view =  inflater.inflate(R.layout.fragment_news_feed, container, false);
		
		((ListView) view.findViewById(R.id.articles_list)).setAdapter(new ArticleListAdapter(context, articles));
		
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
