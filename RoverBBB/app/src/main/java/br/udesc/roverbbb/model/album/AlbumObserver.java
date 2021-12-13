package br.udesc.roverbbb.model.album;

import org.json.JSONObject;

public interface AlbumObserver {
    void onDataFound(JSONObject object);
}
