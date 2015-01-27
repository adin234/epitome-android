package org.mojojo.epitome.adapters;

import java.util.List;

import org.mojojo.epitome.R;
import org.mojojo.epitome.models.Article;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ArticleListAdapter extends ArrayAdapter<Article> {
    Context context;
    List<Article> articles;

    public ArticleListAdapter(Context context, List<Article> articles) {
        super(context, R.layout.list_article_item, articles);
        this.context = context;
        this.articles = articles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return articles.get(position)
        		.getListView(context, position, convertView, parent);
    }

}
