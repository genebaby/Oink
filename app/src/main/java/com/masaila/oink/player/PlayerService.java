package com.masaila.oink.player;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.masaila.oink.event.PlayEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PlayerService extends Service {

    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Subscribe
    public void onEvent(PlayEvent playEvent) {
        switch (playEvent.getAction()) {
            case PLAY:
                MusicPlayer.getPlayer().setQueue(playEvent.getQueue(), 0);
                break;
            case NEXT:
                MusicPlayer.getPlayer().next();
                break;
        }
    }
}
