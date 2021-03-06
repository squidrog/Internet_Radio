/*==============================================================================

name:       PjInternetRadio.java

purpose:    An Internet Radio using the PumaJ Framework.
            
history:    Sun Nov 27, 2011 08:46:23 (LBM) created.

notes:
                        This program was created by PumaJ
             and is the confidential and proprietary product of PumaJ
        Any unauthorized use, reproduction or transfer is strictly prohibited.

                           COPYRIGHT 2011 BY PumaJ
          (Subject to limited distribution and restricted disclosure only).
                             All rights reserved.

==============================================================================*/
// package ----------------------------//

// imports ----------------------------//

import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.giavaneers.gui.elements.embedded.GvVLCMediaPlayer;
import com.pumaj.PjApplication;
import com.pumaj.PjRectangle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;




// PjInternetRadio ====================//
public class PjInternetRadio extends PjApplication {
    // class constants --------------------//
    protected static final String[] kRELATIVE_IMAGE_PATHS =
            {
                    "images/fish.jpg", "images/dog.jpg", "images/bird.jpg"
            };


    // package instance variables ---------//
    // (none)                              //
    // public instance variables ----------//
    // (none)                              //
    // protected instance variables -------//
   static protected GvIMediaPlayer mediaPlayer;  // media player
   static String[] mediaPaths =
            {
                    "http://streams.kqed.org/kqedradio",//kqed
                    "http://66.90.73.250:115/",//live-ireland
                    "",
                    "",
                    "",
                    "",
            };
    static String [] channelNames =
    {
        "KQED", "Live Ireland", "", "", "", "",
    };
    static int i = 0;
    static PlayPauseButton myShape;
    protected static final String [] themeImages = {
            "themes/theme1.png", "themes/theme2.png", "themes/theme3.png", "themes/theme4.png", "themes/theme5.png"
    };
    public static final String [] choose = {
            "buttons/choose1.png","buttons/choose2.png","buttons/choose3.png","buttons/choose4.png","buttons/choose5.png","buttons/choose6.png",
    };
    static PjInternetRadio myRadio = new PjInternetRadio();
    // private instance variables ---------//
    // (none)                              //
/*------------------------------------------------------------------------------

@name       PjInternetRadio - default constructor
                                                                              */

    /**
     * Default constructor
     *
     * @return An instance of PjInternetRadio if successful.
     * @history Sun Nov 27, 2011 08:46:23 (LBM) created.
     * @notes
     */
//------------------------------------------------------------------------------
    public PjInternetRadio() {

    }
/*------------------------------------------------------------------------------

@name       buildGUI - build the radio gui
                                                                              */

    /**
     * Build the radio graphical user interface.
     *
     * @return void
     * @history Sun Dec 06, 2015 08:46:23 (LBM) created.
     * @notes
     */
//------------------------------------------------------------------------------
    protected void buildGUI() {
        myShape = new PlayPauseButton();

        myShape.setWidth(50);
        myShape.setHeight(50);
        myShape.setLocation(655, 460);



        add(myShape);

        HelpButton help = new HelpButton();
        help.setLocation(1326, 0);
        help.setSize(40,40);
        help.setImage("buttons/help.png");

        add(help);

        ThemeButton theme = new ThemeButton();
        theme.setLocation(1316,688);
        theme.setSize(40,40);
        theme.setImage("buttons/choosetheme.jpg");


        add(theme);

        for (i = 0; i < mediaPaths.length; i++) {

            // add a clickable shape 50x50       //
            RadioChannelButton myShape = new RadioChannelButton( i);
            myShape.setWidth(40);
            myShape.setHeight(40);
            myShape.setLocation(170, 365 + (i) * 42);
            PjRectangle textBox = new PjRectangle();
            textBox.setOpaque(true);
            textBox.setHeight(40);
            textBox.setWidth(100);
            textBox.setLocation(70, myShape.getY());
            JTextArea radioName = new JTextArea(channelNames[i]);
            JScrollPane scroll = new JScrollPane(radioName);
            scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            textBox.add(scroll);
            add(textBox);
            myShape.setImage(choose[i]);
            add(myShape);
            ChangeRadioButton changeRadioButton = new ChangeRadioButton(i);
            changeRadioButton.setHeight(40);
            changeRadioButton.setWidth(40);
            changeRadioButton.setLocation(myShape.getX()+50, myShape.getY());
            add(changeRadioButton);


        }
    }


/*------------------------------------------------------------------------------

@name       getMediaPlayer - get media player
                                                                              */

    /**
     * Get media player instance.
     *
     * @return media player instance.
     * @history Sun Nov 27, 2011 08:46:23 (LBM) created.
     * @notes
     */
//------------------------------------------------------------------------------
    public GvIMediaPlayer getMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = new GvVLCMediaPlayer();
        }

        return (mediaPlayer);
    }
/*------------------------------------------------------------------------------

@name       main - project main routine
                                                                              */

    /**
     * Project main routine
     *
     * @param args command line arguments
     * @return void.
     * @history Sun Nov 27, 2011 08:46:23 (LBM) created.
     * @notes
     */
//------------------------------------------------------------------------------
    public static void main(
            String args[]) {
        try {

            System.out.println(
                    "Java VM running " + System.getProperty("java.version")
                            + ", " + System.getProperty("os.arch") + ", "
                            + System.getProperty("sun.arch.data.model") + " bit");



            myRadio.setLayout(null);

            myRadio.getMediaPlayer();


            myRadio.setWidth(1366);
            myRadio.setHeight(768);



            myRadio.setLocation(0,0);

            final JSlider audioSlider = new JSlider(0, 200);
            audioSlider.setBackground(Color.BLUE);
            audioSlider.setSize(300, 50);
            audioSlider.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    double volValue = audioSlider.getValue();
                    mediaPlayer.setAudioVolume(volValue/200);
                }



            });
            audioSlider.setLocation(600,650);
            myRadio.add(audioSlider);
            myRadio.buildGUI();










            myRadio.setImage(themeImages[0]);
            myRadio.setVisible(true);





        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}//====================================// end PjInternetRadio ----------------//
