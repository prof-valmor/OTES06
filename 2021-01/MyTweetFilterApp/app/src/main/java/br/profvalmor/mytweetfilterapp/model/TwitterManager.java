package br.profvalmor.mytweetfilterapp.model;

import android.util.Log;

import com.google.android.material.badge.BadgeDrawable;

public class TwitterManager implements AuthenticatorListener {

    private Authenticator authenticator;
    private TwitterManagerListener listener;

    public TwitterManager() {
        prevState = STATE.INIT;
        state = STATE.INIT;
        authenticator = new Authenticator(this);
        requestState(STATE.AUTHENTIC);
    }

    @Override
    public void onAuthenticationResponse(boolean okay) {
        if(okay) {
            this.requestState(STATE.RUNNING);
        }
    }

    public enum STATE {
        INIT, AUTHENTIC, RUNNING;
    }

    private STATE state;
    private STATE prevState;

    public void requestState(STATE state) {
        switch (state) {
            case INIT:
                break;
            case AUTHENTIC:
                this.state = STATE.AUTHENTIC;
                authenticator.requestAccessToken();
                break;
            case RUNNING:
                this.state = STATE.RUNNING;
                Log.d("twittermanager", "requestState: " + this.state);
                break;
        }
        if(prevState != state) {
            if(this.listener != null)
                this.listener.onStateChange(this.state);

            prevState = this.state;
        }
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public void setListener(TwitterManagerListener l) {
        this.listener = l;
    }
}
