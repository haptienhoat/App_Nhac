package com.example.app_mobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.app_mobile.Adapter.ViewPagerPlaylistnhac;
import com.example.app_mobile.Fragment.DiaNhacFragment;
import com.example.app_mobile.Fragment.PlayDanhSachCacBaiHatFragment;
import com.example.app_mobile.Model.Baihat;
import com.example.app_mobile.Service.MyService;
import com.example.app_mobile.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlayNhacActivity extends AppCompatActivity {

    TextView txtTimesong, txtTotaltimesong, txtplaybaihat;
    SeekBar seekBartime;
    ImageButton imgplay, imgrepeat, imgnext, imgpre, imgrandom;
    ViewPager2 viewPagerplaynhac;
    public static ArrayList<Baihat> mangbaihat = new ArrayList<>();
    public static ViewPagerPlaylistnhac adapternhac;
    ImageView imageViewplaynhacback;
    public static MediaPlayer mediaPlayer;
    int position = 0;
    boolean repeat = false;
    boolean checkrandom = false;
    boolean next = false;
    DiaNhacFragment diaNhacFragment;

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle == null) {
                return;
            }

            int action = bundle.getInt("action");
            
            handleActionMusic(action);
        }
    };

    private void handleActionMusic(int action) {
        switch (action) {
            case 1:
                ActionPause();
                break;
            case 2:
                ActionPlay();
                break;
            case 3:
                ActionExit();
                break;
            case 4:
                ActionNext();
                break;
            case 5:
                ActionPre();
                break;
        }
    }

    private void ActionExit() {
        mediaPlayer.pause();
        imgplay.setImageResource(R.drawable.iconplay);
    }

    private void ActionPre() {
        if (mangbaihat.size() > 0) {
            if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            if (position < mangbaihat.size()) {
                imgplay.setImageResource(R.drawable.iconpause);
                position--;
                if (repeat == true) {
                    position += 1;
                }
                if (checkrandom == true) {
                    Random random = new Random();
                    int index = random.nextInt(mangbaihat.size() - 1);
                    position = index;
                }
                if (position < 0) {
                    position = mangbaihat.size() - 1;
                }
                PlayMp3(mangbaihat.get(position).getLinkbaihat());
                txtplaybaihat.setText(mangbaihat.get(position).getTenbaihat());
                diaNhacFragment.Playnhac(mangbaihat.get(position).getHinhbaihat());
            }
        }
    }

    private void ActionNext() {
        if (mangbaihat.size() > 0) {
            if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            if (position < mangbaihat.size()) {
                imgplay.setImageResource(R.drawable.iconpause);
                position++;
                if (repeat == true) {
                    position -= 1;
                }
                if (checkrandom == true) {
                    Random random = new Random();
                    int index = random.nextInt(mangbaihat.size() - 1);
                    position = index;
                }
                if (position >= mangbaihat.size()) {
                    position = 0;
                }
                PlayMp3(mangbaihat.get(position).getLinkbaihat());
                txtplaybaihat.setText(mangbaihat.get(position).getTenbaihat());
                diaNhacFragment.Playnhac(mangbaihat.get(position).getHinhbaihat());
            }
        }
    }

    private void ActionPlay() {
        mediaPlayer.start();
        imgplay.setImageResource(R.drawable.iconpause);
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("cakhuc", mangbaihat.get(position));
        startService(intent);
    }

    private void ActionPause() {
        mediaPlayer.pause();
        imgplay.setImageResource(R.drawable.iconplay);
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("cakhuc", mangbaihat.get(position));
        startService(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        getSupportActionBar().hide();

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter("send_data_activity"));

        GetIntent();
        init();
        eventClick();
    }

    private void GetIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();

        if (intent.hasExtra("cakhuc")) {
            Baihat baihat = (Baihat) intent.getSerializableExtra("cakhuc");
            mangbaihat.add(baihat);
        }

        if (intent.hasExtra("cacbaihat")) {
            ArrayList<Baihat> baihatArrayList = (ArrayList<Baihat>) intent.getSerializableExtra("cacbaihat");
            mangbaihat = baihatArrayList;
        }
    }

    private void init() {
        txtTimesong = findViewById(R.id.textviewtimesong);
        txtTotaltimesong = findViewById(R.id.textviewtotaltimesong);
        txtplaybaihat = findViewById(R.id.textviewplaybaihat);
        seekBartime = findViewById(R.id.seebarsong);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgrepeat = findViewById(R.id.imagebuttonrepeat);
        imgnext = findViewById(R.id.imagebuttonnext);
        imgrandom = findViewById(R.id.imagebuttonsuffle);
        imgpre = findViewById(R.id.imagebuttonpre);
        viewPagerplaynhac = findViewById(R.id.viewpagerplaynhac);
        adapternhac = new ViewPagerPlaylistnhac(getSupportFragmentManager(),getLifecycle());
        adapternhac.addFragment(new DiaNhacFragment());
        adapternhac.addFragment(new PlayDanhSachCacBaiHatFragment());
        viewPagerplaynhac.setAdapter(adapternhac);
        imageViewplaynhacback = findViewById(R.id.imageviewplaynhacback);
        imageViewplaynhacback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayNhacActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        diaNhacFragment = (DiaNhacFragment) adapternhac.getFragment(0);

        if (mangbaihat.size() > 0) {
            txtplaybaihat.setText(mangbaihat.get(position).getTenbaihat());
            PlayMp3(mangbaihat.get(position).getLinkbaihat());
            imgplay.setImageResource(R.drawable.iconpause);
        }
    }

    private void eventClick() {
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    ActionPause();
                } else {
                    ActionPlay();
                }
            }
        });
        imgrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeat == false) {
                    if (checkrandom == true) {
                        checkrandom = false;
                        imgrandom.setImageResource(R.drawable.iconsuffle);
                    }
                    imgrepeat.setImageResource(R.drawable.iconsyned);
                    repeat = true;
                } else {
                    imgrepeat.setImageResource(R.drawable.iconrepeat);
                    repeat = false;
                }
            }
        });
        imgrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkrandom == false) {
                    if (repeat == true) {
                        repeat = false;
                        imgrepeat.setImageResource(R.drawable.iconrepeat);
                    }
                    imgrandom.setImageResource(R.drawable.iconshuffled);
                    checkrandom = true;
                } else {
                    imgrandom.setImageResource(R.drawable.iconsuffle);
                    checkrandom = false;
                }
            }
        });
        seekBartime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionNext();
            }
        });

        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionPre();
            }
        });
    }

    public void PlayMp3 (String baihat) {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });
            mediaPlayer.setDataSource(baihat);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TimeSong();
        UpdateTime();
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("cakhuc", mangbaihat.get(position));
        startService(intent);
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTotaltimesong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBartime.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTime() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    seekBartime.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimesong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this,0);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            next = true;
                            try {
                                Thread.sleep(0);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        },0);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (next == true) {
                    if (mangbaihat.size() > 0) {
                        if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                        if (position < mangbaihat.size()) {
                            imgplay.setImageResource(R.drawable.iconpause);
                            position++;
                            if (repeat == true) {
                                position -= 1;
                            }
                            if (checkrandom == true) {
                                Random random = new Random();
                                int index = random.nextInt(mangbaihat.size() - 1);
                                position = index;
                            }
                            if (position >= mangbaihat.size()) {
                                position = 0;
                            }
                            PlayMp3(mangbaihat.get(position).getLinkbaihat());
                            txtplaybaihat.setText(mangbaihat.get(position).getTenbaihat());
                            diaNhacFragment.Playnhac(mangbaihat.get(position).getHinhbaihat());
                        }
                    }
                    next = false;
                } else {
                    handler1.postDelayed(this,0);
                }
            }
        },0);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PlayNhacActivity.this,MainActivity.class);
        startActivity(intent);
    }
}