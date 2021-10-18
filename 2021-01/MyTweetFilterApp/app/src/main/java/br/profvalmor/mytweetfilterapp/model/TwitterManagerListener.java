package br.profvalmor.mytweetfilterapp.model;

public interface TwitterManagerListener {
    void onStateChange(TwitterManager.STATE newState);
}
