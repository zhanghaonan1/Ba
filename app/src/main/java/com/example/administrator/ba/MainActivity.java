package com.example.administrator.ba;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener  {
    private VideoView mVvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //得到布局里面的内容
        setContentView(R.layout.activity_main);
        //一定要初始化
        Vitamio.initialize(this);

        mVvv = (VideoView)findViewById(R.id.vv);
        mVvv.setVideoURI(Uri.parse("http://qiubai-video.qiushibaike.com/91B2TEYP9D300XXH_3g.mp4"));
        mVvv.setMediaController(new MediaController(this));

        //设置监听
        mVvv.setOnPreparedListener(this);
        mVvv.setOnErrorListener(this);
        mVvv.setOnCompletionListener(this);
    }
@Override
    public void onPrepared(MediaPlayer mp) {
        Toast.makeText(this,"准备好了", Toast.LENGTH_LONG).show();
        mVvv.start();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();
//        return false;
//          返回 true
        return true;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Toast.makeText(this,"播放完成", Toast.LENGTH_LONG).show();
    }
}
