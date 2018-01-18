package com.vudn.mystory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 28/11/2017.
 */

public class StoryContentAdapter extends PagerAdapter {
    private List<Story> stories;
    private Context context;
    private LayoutInflater layoutInflater;

    public StoryContentAdapter(Context context, List<Story> stories) {
        this.stories = stories;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stories.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object.equals(view);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // Tạo ra đối tượng view
        //Sử dụng layoutInflater để chuyển đổi 1 file .xml thành một view cho phép tác động lên nó
        View itemView = layoutInflater.inflate(R.layout.item_content, container, false);

        //Khai báo các đối tượng
        ImageView imgDescription;
        TextView txtName;
        TextView txtAuthor;
        TextView txtCategory;
        TextView txtStatus;
        TextView txtNumberOfChapter;
        TextView txtTimeHadUpload;
        TextView txtTimeUpdate;
        TextView txtDetailContent;

        // Ánh xạ các đối tượng sang java
        imgDescription = itemView.findViewById(R.id.img_description);
        txtName = itemView.findViewById(R.id.txt_name);
        txtAuthor = itemView.findViewById(R.id.txt_author);
        txtCategory = itemView.findViewById(R.id.txt_category);
        txtStatus = itemView.findViewById(R.id.txt_status);
        txtNumberOfChapter = itemView.findViewById(R.id.txt_number_of_chapter);
        txtTimeHadUpload = itemView.findViewById(R.id.txt_time_had_upload);
        txtTimeUpdate = itemView.findViewById(R.id.txt_time_update);
        txtDetailContent = itemView.findViewById(R.id.txt_detail_content);

        // Tạo ra một thực thể story
        // Gán giá trị cho các đối tượng trong view
        Story story = stories.get(position);
        imgDescription.setImageResource(story.getResImg());
        txtName.setText(story.getName());
        txtAuthor.setText("Tác giả: " + story.getAuthor());
        txtCategory.setText("Thể loại " + story.getCategory());
        txtStatus.setText("Trạng thái: " + story.getStatus());
        txtNumberOfChapter.setText("Số chương: " + story.getNumberOfChapter());
        txtTimeHadUpload.setText("Thời gian tải lên: " + story.getTimeHadUpload());
        txtTimeUpdate.setText("Thời gian cập nhật: " + story.getTimeUpdate());
        txtDetailContent.setText(story.getDetailContent());

        // Gán itemView bên trên vào viewGroup(ViewPager) để hiển thị lên màn hình
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
