package com.vudn.mystory;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by admin on 25/11/2017.
 */

public class StoryListActivity extends AppCompatActivity implements StoryListAdapter.OnItemClickListener {
    public static final String KEY_ITEM_SELECT = "key_item_select";
    private DrawerLayout drlMenu;
    private RecyclerView rcvListStory;
    private StoryListAdapter storyAdapter;
    private static List<Story> stories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        initializeComponents();
        showListStory();
    }

    private void showListStory() {
        stories = new ArrayList<>();
        createStory();
        storyAdapter = new StoryListAdapter(stories, getBaseContext());
        storyAdapter.setOnItemClickListener(this);
        rcvListStory.setAdapter(storyAdapter);
    }

    private void createStory() {
        for (int i = 1; i < 20; i++) {
            Story story = new Story(
                    R.mipmap.img_ba_luoi_riu_round,
                    "Ba cây rìu " + i,
                    "Dân gian",
                    "Truyện cổ tích ",
                    "Hoàn thành",
                    String.valueOf(i),
                    String.valueOf(2000 + i),
                    Calendar.getInstance().getTime().toString(),
                    readStoryContent("BaCayRiu.txt")
            );
            stories.add(story);
        }
    }

    private String readStoryContent(String name) {
        String storyContent = "";
        try {
            AssetManager assetManager = getBaseContext().getAssets();
            InputStream inputStream = assetManager.open(name);
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            while (length != -1) {
                String value = new String(bytes, 0, length);
                storyContent += value;
                length = inputStream.read(bytes);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storyContent;
    }

    private void initializeComponents() {
        rcvListStory = findViewById(R.id.rcv_list_story);
        drlMenu = findViewById(R.id.drl_menu);
        rcvListStory.setLayoutManager(
                new LinearLayoutManager(
                        getBaseContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, StoryContentActivity.class);
        Story story = storyAdapter.getItem(position);
        intent.putExtra(KEY_ITEM_SELECT, String.valueOf(position));
        startActivity(intent);
    }

    public static List<Story> getStories() {
        return stories;
    }
}
