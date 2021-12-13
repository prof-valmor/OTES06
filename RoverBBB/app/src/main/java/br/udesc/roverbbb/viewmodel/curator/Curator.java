package br.udesc.roverbbb.viewmodel.curator;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import br.udesc.roverbbb.model.album.Album;
import br.udesc.roverbbb.model.album.AlbumObserver;

public class Curator implements AlbumObserver {
    private String url;
    private CuratorSearchObserver observer;

    public Curator(Context context) {
        Album.getInstance().init(context);
        Album.getInstance().setObserver(this);
    }

    public void setObserver(CuratorSearchObserver observer) {
        this.observer = observer;
    }

    /**
     * @param obj Request POJO
     */
    public void request(Request obj) throws JSONException {
        RoverName roverName = obj.roverName;
        CameraName camera = obj.cameraName;
        String date = obj.date;
        int page = obj.page;
        //
        String request = "";
        String prefix = "https://api.nasa.gov/mars-photos/api/v1/rovers/";
        request = prefix + roverName.getName() + "/photos?camera=" + camera.getName() + "&earth_date=" + date +"&page=" + page;
        request += "&api_key=HKMoEi0nVgCMuCJCuV87MOLI31c2DbJShQ1AnpUg";
       //
        Album.getInstance().requestData(request);
    }

    @Override
    public void onDataFound(JSONObject object) {
        Log.d("CURATOR", "onDataFound: " + object);
        //TODO seria criar a thread de processamento do dado bruto.
        // TODO quando a thread terminar o processamento, chamamos o observer.

    }
}
