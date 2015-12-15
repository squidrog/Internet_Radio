import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;

import java.awt.event.MouseEvent;
import java.net.URISyntaxException;


/**
 * Created by coleobrien on 12/10/15.
 */
public class RadioChannelButton extends MyClickableShape {
    public int channelCount;

    public RadioChannelButton( int i){
        super();
        channelCount = i;
    }
    public void mouseClicked(
            MouseEvent event)
    {
        try {
            PjInternetRadio.mediaPlayer.setURI(PjInternetRadio.mediaPaths[channelCount]);
            PjInternetRadio.myShape.setImage(PlayPauseButton.kPlayPauseImages[1]);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
