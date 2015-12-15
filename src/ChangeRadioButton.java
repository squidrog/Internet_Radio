import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.pumaj.PjApplication;
import com.pumaj.PjRectangle;

import javax.swing.*;
import java.awt.event.MouseEvent;


/**
 * Created by coleobrien on 12/10/15.
 */
public class ChangeRadioButton extends MyClickableShape {

protected int radioCount;


    public ChangeRadioButton ( int i){
        super();

        radioCount = i;

    }


    public void mouseClicked(
            MouseEvent event) {

        PjApplication radioURIApp = new PjApplication();
        radioURIApp.setHeight(110);
        radioURIApp.setWidth(170);
        //radioURIApp.setImage("put image link here");
        radioURIApp.setLayout(null);
        radioURIApp.setLocation(0,0);
        PjRectangle textBox = new PjRectangle();
        textBox.setOpaque(true);
        textBox.setHeight(50);
        textBox.setWidth(120);
        JTextArea radioName = new JTextArea("Current radio: " + PjInternetRadio.channelNames[radioCount] + "\nURI: "
                + PjInternetRadio.mediaPaths[radioCount]);
        radioName.setEditable(false);
        JScrollPane scroll = new JScrollPane(radioName);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        textBox.add(scroll);
        radioURIApp.add(textBox);

        PjRectangle insertBox = new PjRectangle();
        insertBox.setOpaque(true);
        insertBox.setHeight(40);
        insertBox.setWidth(120);
        insertBox.setLocation(0,60);
        JTextArea radioInsert = new JTextArea(PjInternetRadio.mediaPaths[radioCount]);
        JScrollPane insertScroll = new JScrollPane(radioInsert);
        insertScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        insertScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        insertBox.add(insertScroll);
        radioURIApp.add(insertBox);



        SaveRadioNameButton saveRadio = new SaveRadioNameButton(radioCount,radioInsert);
        saveRadio.setWidth(40);
        saveRadio.setHeight(40);
        radioURIApp.add(saveRadio);
        saveRadio.setLocation(130,0);

        radioURIApp.setVisible(true);
        // find a way to clsoe application once uri is saved
    }
}
