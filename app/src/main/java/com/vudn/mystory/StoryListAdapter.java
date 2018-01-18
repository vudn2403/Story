package com.vudn.mystory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 25/11/2017.
 */

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.ViewHolder> {
    List<Story> stories;
    Context context;
    LayoutInflater layoutInflater;
    OnItemClickListener onItemClickListener;

    public StoryListAdapter(List<Story> stories, Context context) {
        this.stories = stories;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Story story = stories.get(position);
        holder.imgDescriptionPicture.setImageResource(story.getResImg());
        holder.txtName.setText(story.getName());
        holder.txtAuthor.setText(story.getAuthor());
        holder.txtUpdateTime.setText(story.getTimeUpdate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public Story getItem(int position){
        return stories.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDescriptionPicture;
        TextView txtName;
        TextView txtAuthor;
        TextView txtUpdateTime;

        public ViewHolder(View itemView) {
            super(itemView);
            imgDescriptionPicture = itemView.findViewById(R.id.img_description);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAuthor = itemView.findViewById(R.id.txt_author);
            txtUpdateTime = itemView.findViewById(R.id.txt_time_update);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
