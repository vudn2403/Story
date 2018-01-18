package com.vudn.mystory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 25/11/2017.
 */

public class StoryContentActivity extends AppCompatActivity {
    private ViewPager vpgStoryContents;
    private List<Story> stories;
    private StoryContentAdapter storyContentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_content);
        initializeComponents();
    }

    private void initializeComponents() {
        stories = new ArrayList<>();
        stories = StoryListActivity.getStories();
        vpgStoryContents = findViewById(R.id.vpg_story_content);
        storyContentAdapter = new StoryContentAdapter(this, stories);
        vpgStoryContents.setAdapter(storyContentAdapter);
        Intent intent = getIntent();
        String position = intent.getStringExtra(StoryListActivity.KEY_ITEM_SELECT);
        vpgStoryContents.setCurrentItem(Integer.parseInt(position));
    }
}
