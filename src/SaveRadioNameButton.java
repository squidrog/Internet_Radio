import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;

/**
 * Created by Douglas OBrien on 12/13/2015.
 */
public class SaveRadioNameButton extends MyClickableShape {
    int i;

    JTextArea radioInsert;



    public SaveRadioNameButton ( int radioCount, JTextArea enteredRadio){
        super();
        //setImage("save image file directory");

        int i = radioCount;

        radioInsert = enteredRadio;
    }
    public void mouseClicked(
            MouseEvent event)
    {
        String radioInsertString = radioInsert.getText();
        PjInternetRadio.mediaPaths[i] = radioInsertString;
    }
}
