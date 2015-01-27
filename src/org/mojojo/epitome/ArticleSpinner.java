package org.mojojo.epitome;

import java.util.ArrayList;
import java.util.Locale;

import org.mojojo.epitome.models.Article;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleSpinner extends Activity {
	SectionsPagerAdapter mSectionsPagerAdapter;

	ViewPager mViewPager;
	
	ArrayList<Article> articles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article_spinner);
		
		articles = new ArrayList<Article>();
		articles.add(new Article("Aldrin Bautista", "http://placehold.it/750x400", "title1", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Jerome", "http://placehold.it/750x400", "title2", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Sherwin", "http://placehold.it/750x400", "title3", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Mando", "http://placehold.it/750x400", "title4", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Kurdapya", "http://placehold.it/750x400", "title5", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Berting", "http://placehold.it/750x400", "title6", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Arlene", "http://placehold.it/750x400", "title7", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Timong", "http://placehold.it/750x400", "title8", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Benjo", "http://placehold.it/750x400", "title9", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Raul", "http://placehold.it/750x400", "title10", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Segundo", "http://placehold.it/750x400", "title11", "http://www.google.com", "one plus one equals two"));
        articles.add(new Article("Stepan", "http://placehold.it/750x400", "title12", "http://www.google.com", "one plus one equals two"));

		mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager(), articles);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.article_spinner, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		ArrayList<Article> articles;
		
		public SectionsPagerAdapter(FragmentManager fm, ArrayList<Article> articles) {
			super(fm);
			this.articles = articles;
		}

		@Override
		public Fragment getItem(int position) {
			return PlaceholderFragment.newInstance(position + 1, articles.get(position));
		}

		@Override
		public int getCount() {
			return articles.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

	public static class PlaceholderFragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";
	
		public static PlaceholderFragment newInstance(int sectionNumber, Article article) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			args.putSerializable("article", article);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_article_spinner,
					container, false);
			
			Article article = (Article) getArguments().getSerializable("article");
			
			((TextView) rootView.findViewById(R.id.title)).setText(article.getTitle());
			((TextView) rootView.findViewById(R.id.source)).setText(article.getSource());
			
			
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(rootView.getContext())
		        .threadPriority(Thread.NORM_PRIORITY - 2)
		        .denyCacheImageMultipleSizesInMemory()
		        .diskCacheFileNameGenerator(new Md5FileNameGenerator())
		        .diskCacheSize(50 * 1024 * 1024) // 50 Mb
		        .tasksProcessingOrder(QueueProcessingType.LIFO)
		        .build();
			ImageLoader.getInstance().init(config);
			ImageLoader.getInstance().displayImage(article.getThumb(), (ImageView) rootView.findViewById(R.id.thumb));
			
			
			return rootView;
		}
	}

}
