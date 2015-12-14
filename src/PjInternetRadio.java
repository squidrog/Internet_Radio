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
    protected GvIMediaPlayer mediaPlayer;  // media player
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
        // assign this app properties          //
        setLayout(null);
        setVisible(true);
        setWidth(940);
        setHeight(720);
        // add a clickable shape 200x200       //
        MyClickableShape myShape = new MyClickableShape();
        myShape.setWidth(200);
        myShape.setHeight(200);
        myShape.setLocation(100, 100);
        // myShape.playPause();
        // assign image paths to the shape     //
        myShape.setImagePaths(kRELATIVE_IMAGE_PATHS);

        // and add it to this app              //
        add(myShape);
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

            PjInternetRadio myRadio = new PjInternetRadio();

            myRadio.setLayout(null);

            GvIMediaPlayer player = myRadio.getMediaPlayer();

            myRadio.setWidth(940);
            myRadio.setHeight(720);


            myRadio.buildPlayButton();
            myRadio.buildRadioChannelButton();






            // start the player                    //
           // int pathIdx = Integer.parseInt(args[0]);
           // player.setURI(mediaPaths[pathIdx]);
            myRadio.setImage("themes/theme1.png");
            myRadio.setVisible(true);





        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void buildPlayButton() {
        // add a clickable shape 50x50       //
        PlayPauseButton myShape = new PlayPauseButton(mediaPlayer);

        myShape.setWidth(50);
        myShape.setHeight(50);
        myShape.setLocation(615, 260);


        // and add it to this app              //
        add(myShape);


    }
    protected void buildRadioChannelButton() {

        for (i = 0; i < mediaPaths.length; i++) {

            // add a clickable shape 50x50       //
            RadioChannelButton myShape = new RadioChannelButton(mediaPlayer, mediaPaths, channelNames, i);
            myShape.setWidth(40);
            myShape.setHeight(40);
            myShape.setLocation(150, 300+ (i) * 40);
            PjRectangle textBox = new PjRectangle();
            textBox.setOpaque(true);
            textBox.setHeight(40);
            textBox.setWidth(100);
            textBox.setLocation(50, myShape.getY());
            JTextArea radioName = new JTextArea();
            JScrollPane scroll = new JScrollPane(radioName);
            scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            textBox.add(scroll);
            add(textBox);
            add(myShape);


        }

    }


}//====================================// end PjInternetRadio ----------------//
