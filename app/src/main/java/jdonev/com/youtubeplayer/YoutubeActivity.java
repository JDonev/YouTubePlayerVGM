package jdonev.com.youtubeplayer;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import jdonev.com.youtubeplayer.R;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "YoutubeActivity";
    static final String GOOGLE_API_KEY = "AIzaSyBK7REeg-PjzgiKi6ZjyPImOoFvn7aGc6A";
    static final String YOUTUBE_VIDEO_ID = "GF256NDINhk";
    static final String YOUTUBE_PLAYLIST = "PL9325D8D7E5979B1B";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_youtube);
        //ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.activity_youtube);

        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_youtube, null);
        setContentView(layout);

        //   Button button1 = new Button(this);
        //   button1.setLayoutParams(new ConstraintLayout.LayoutParams(350,120));
        //   button1.setText("Button Added");
        //   layout.addView(button1);

        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(GOOGLE_API_KEY, this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        // Log.d(TAG, "onInitializationSuccess: provider is " +provider.getClass().toString());
        // Toast.makeText(this,"Initialized YouTube Player successfully", Toast.LENGTH_LONG).show();

        // youTubePlayer.setPlaybackEventListener(playbackEventListener);
        // youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if (!wasRestored) {
            youTubePlayer.cuePlaylist(YOUTUBE_PLAYLIST);
        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE = 1;

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
        } else {
            String errorMessage = String.format("There was an error initializing the YouTube player (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }

    }

    // private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
    //     @Override
    //     public void onPlaying() {
    //     Toast.makeText(YoutubeActivity.this,"Good, video is playing OK",Toast.LENGTH_LONG).show();
    //     }

    //   @Override
    //   public void onPaused() {
    //       Toast.makeText(YoutubeActivity.this,"Video has paused",Toast.LENGTH_LONG).show();
    //   }
    //
    //   @Override
    //   public void onStopped() {
    //       Toast.makeText(YoutubeActivity.this,"Good, video has stopped",Toast.LENGTH_LONG).show();
    //   }

    //   @Override
    //   public void onBuffering(boolean b) {
    //
    //   }

    //   @Override
    //   public void onSeekTo(int i) {
    //
    //   }
    // };

    // private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
    //     @Override
    //     public void onLoading() {

    //     }

    //     @Override
    //     public void onLoaded(String s) {

    //     }

    //     @Override
    //     public void onAdStarted() {
    //         Toast.makeText(YoutubeActivity.this,"Click Ad now, make the video creater rich!",Toast.LENGTH_LONG).show();
    //     }

    //     @Override
    //     public void onVideoStarted() {
    //         Toast.makeText(YoutubeActivity.this,"Video has started",Toast.LENGTH_LONG).show();
    //     }

    //     @Override
    //     public void onVideoEnded() {
    //         Toast.makeText(YoutubeActivity.this,"Video has ended",Toast.LENGTH_LONG).show();
    //     }

    //     @Override
    //     public void onError(YouTubePlayer.ErrorReason errorReason) {

    //     }
    // };
}

