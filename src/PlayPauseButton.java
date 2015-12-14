import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;

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
    protected GvIMediaPlayer player;
    protected String[] playPauseImages = kPlayPauseImages;





    public PlayPauseButton(GvIMediaPlayer mediaPlayer)
    {

        super();
        this.player = mediaPlayer;
        playPause();
        this.setOpaque(false);
        setImage(playPauseImages[1]);


    }
    public void mouseClicked(
            MouseEvent event)

    {
        playPause();
    }
    public void playPause () {
        // performs play and pause functions
        if (playPauseImages != null) {
            if (player.getPlaying()) {
                player.setPaused(true);
                setImage(playPauseImages[0]);
            } else if (player.getPaused()) {
                player.setPlaying(true);
                setImage(playPauseImages[1]);
            }

        }

    }
}
