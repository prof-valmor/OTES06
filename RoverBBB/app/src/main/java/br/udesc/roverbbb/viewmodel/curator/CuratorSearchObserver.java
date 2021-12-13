package br.udesc.roverbbb.viewmodel.curator;

import java.util.List;

public interface CuratorSearchObserver {
    void onSearchFinished(List<Photo> photos);
}
