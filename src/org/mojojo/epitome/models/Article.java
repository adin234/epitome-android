package org.mojojo.epitome.models;

import java.io.Serializable;

import org.mojojo.epitome.ArticleSpinner;
import org.mojojo.epitome.MainActivity;
import org.mojojo.epitome.R;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Article implements Serializable{
	private String sharer;
	private String thumb;
	private String title;
	private String source;
	private String summary;
	
	public Article(String sharer, String thumb, String title, String source, String summary) {
		this.sharer = sharer;
		this.source = source;
		this.thumb = thumb;
		this.title = title;
		this.summary = summary;
	}

	public String getSharer() {
		return sharer;
	}

	public void setSharer(String sharer) {
		this.sharer = sharer;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public View getListView(final Context context, int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.list_article_item, parent, false);
		}
		
		((TextView) convertView.findViewById(R.id.title)).setText(this.title);
		((TextView) convertView.findViewById(R.id.source)).setText(this.source);
		((TextView) convertView.findViewById(R.id.name)).setText(this.sharer);
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(convertView.getContext())
	        .threadPriority(Thread.NORM_PRIORITY - 2)
	        .denyCacheImageMultipleSizesInMemory()
	        .diskCacheFileNameGenerator(new Md5FileNameGenerator())
	        .diskCacheSize(50 * 1024 * 1024) // 50 Mb
	        .tasksProcessingOrder(QueueProcessingType.LIFO)
	        .build();
		ImageLoader.getInstance().init(config);
		ImageLoader.getInstance().displayImage(this.thumb, (ImageView) convertView.findViewById(R.id.image));
		
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, ArticleSpinner.class);
				context.startActivity(intent);
			}
		});
		
		return convertView;
	}
}
