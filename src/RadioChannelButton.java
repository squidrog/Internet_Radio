import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;

import java.awt.event.MouseEvent;
import java.net.URISyntaxException;


/**
 * Created by coleobrien on 12/10/15.
 */
public class RadioChannelButton extends MyClickableShape {
    public int channelCount;

    protected static final String[] kPlayPauseImages =
            {
                    "images/play.png", "images/pause.png"
            };
    protected String[] radioUrls;
    protected GvIMediaPlayer player;
    protected String[] playPauseImages = kPlayPauseImages;
    public RadioChannelButton(GvIMediaPlayer mediaPlayer, String[] mediaPaths, String [] channelNames, int i){
        super();
        this.player = mediaPlayer;
        this.radioUrls = mediaPaths;
        player.setAudioVolume(0.1);
        channelCount = i;
    }
    public void mouseClicked(
            MouseEvent event)
    {
        try {
            player.setURI(radioUrls[channelCount]);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
