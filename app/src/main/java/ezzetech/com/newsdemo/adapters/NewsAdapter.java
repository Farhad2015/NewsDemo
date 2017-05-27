package ezzetech.com.newsdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import ezzetech.com.newsdemo.R;
import ezzetech.com.newsdemo.model.NewsItem;

/**
 * Created by ETL-1605 on 5/27/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<NewsItem> nItem;
    Context context;

    public NewsAdapter(List<NewsItem> nItem, Context context) {
        this.nItem = nItem;
        this.context = context;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewNewsSource;

        public NewsViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_rownews);
            textViewTitle = (TextView) itemView.findViewById(R.id.txt_rowTitle);
            textViewDescription = (TextView) itemView.findViewById(R.id.txt_rowDescription);
            textViewNewsSource = (TextView) itemView.findViewById(R.id.txt_rowNewsSource);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsItem newsItem = nItem.get(position);
        Glide.with(context).load(newsItem.getImageofNews()).placeholder(R.drawable.placeholder_icon).into(holder.imageView);
        holder.textViewTitle.setText(newsItem.getNewsTitle());
        holder.textViewDescription.setText(newsItem.getNewsDetails());
        holder.textViewNewsSource.setText("more at " + newsItem.getProviderName());
    }

    @Override
    public int getItemCount() {
        return nItem.size();
    }
}
