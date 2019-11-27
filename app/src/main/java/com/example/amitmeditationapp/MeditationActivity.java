package com.example.amitmeditationapp;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MeditationActivity extends AppCompatActivity {
    SimpleExoPlayerView exoPlayerView;
    SimpleExoPlayer exoPlayer;
    String audioUrl =
            "https://firebasestorage.googleapis.com/v0/b/blissful-ly.appspot.com/o" +
                    "/audio%2FAcceptance.mp3?alt=media&token=7ff1a857-24db-4483-9f45-65b398274799";
    String imageUrl =
            "https://firebasestorage.googleapis.com/v0/b/blissful-ly.appspot.com/o" +
                    "/image%2FEcstasy.jpeg?alt=media&token=7d43b06d-15e1-47c2-8dcb-813d845f0176";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.video_view);
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        Uri audioUri = Uri.parse(audioUrl);
        final ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        TrackSelection.Factory trackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), "exoplayer audio"));
        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .setExtractorsFactory(extractorsFactory)
                .createMediaSource(audioUri);  // replace Uri with your song url
        exoPlayer = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector(trackSelectionFactory));
        exoPlayer.prepare(mediaSource);
        exoPlayer.setPlayWhenReady(true);
        exoPlayerView.setPlayer(exoPlayer);

    }
}
