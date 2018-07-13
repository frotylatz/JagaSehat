package com.oop.android.jagasehat;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class MateriTokohActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private TextView titleMateri;
    private Button buttonPrev, buttonNext, buttonFinish;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        CircleIndicator indicator = findViewById(R.id.indicator);

        titleMateri = findViewById(R.id.titleMateriTokoh);
        titleMateri.setVisibility(View.VISIBLE);
        titleMateri.setText("Pengenalan Tokoh");

        buttonNext = findViewById(R.id.btnNext);

            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }
            });
        buttonPrev = findViewById(R.id.btnPrev);
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        buttonFinish = findViewById(R.id.btnFinish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MateriTokohActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        mSlideViewPager.setAdapter(new TokohAdapter(this));
        mSlideViewPager.addOnPageChangeListener(viewListener);
        indicator.setViewPager(mSlideViewPager);

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            mCurrentPage = i;
            if(i == 0){
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(false);
                buttonFinish.setEnabled(false);
                buttonPrev.setVisibility(View.INVISIBLE);
                buttonFinish.setVisibility(View.INVISIBLE);
                buttonNext.setVisibility(View.VISIBLE);

                buttonNext.setText("Next");
                buttonPrev.setText("");
                buttonFinish.setText("");
            } else if(i == 1){
                buttonNext.setEnabled(false);
                buttonPrev.setEnabled(true);
                buttonFinish.setEnabled(true);
                buttonNext.setVisibility(View.INVISIBLE);
                buttonPrev.setVisibility(View.VISIBLE);
                buttonFinish.setVisibility(View.VISIBLE);

                buttonNext.setText("");
                buttonPrev.setText("Previous");
                buttonFinish.setText("Finish");
            }

            /*else{
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                buttonPrev.setVisibility(View.VISIBLE);

                buttonNext.setText("Next");
                buttonPrev.setText("Previouse");
            }*/
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
