import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by coleobrien on 12/8/15.

 */

public class PlayPauseButton extends MyClickableShape
{
    protected static final String[] kPlayPauseImages =
            {
                    "images/play.png", "images/pause.png"
            };






    public PlayPauseButton()
    {

        super();
        playPause();
        this.setOpaque(false);
        setImage(kPlayPauseImages[0]);

    }
    public void mouseClicked(
            MouseEvent event)

    {
        playPause();
    }
    public void playPause () {
        // performs play and pause functions
        if (kPlayPauseImages != null) {
            if (PjInternetRadio.mediaPlayer.getPlaying()) {
                PjInternetRadio.mediaPlayer.setPaused(true);
                setImage(kPlayPauseImages[0]);
            } else if (PjInternetRadio.mediaPlayer.getPaused()) {
                PjInternetRadio.mediaPlayer.setPlaying(true);
                setImage(kPlayPauseImages[1]);
            }

        }

    }

}
