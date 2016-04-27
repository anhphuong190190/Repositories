package vn.coderschool.thorgroup.travelling.view.timeline.home;

import android.view.View;

/**
 * Created by Boo on 4/13/2016.
 */
public interface EventListener extends View.OnClickListener{
    void clickUser();
    void clickPhoto();
    void clickFavoriteIcon();
    void clickPinIcon();
}
