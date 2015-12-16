import java.awt.event.MouseEvent;

/**
 * Created by coleobrien on 12/15/15.
 */
public class ThemeButton extends MyClickableShape {
    static int themeNumber = 0;
    protected static final String [] themeButtonImages = {
        "buttons/thumb5.png","buttons/thumb4.png","buttons/thumb3.png","buttons/thumb2.png", "buttons/thumb1.png"
    };
    public ThemeButton(){
        super();

    }
    public void mouseClicked(
            MouseEvent event){
        PjInternetRadio themeApp = new PjInternetRadio();
        themeApp.setWidth(100);
        themeApp.setHeight(200);
        themeApp.setLocation(1266,568);

        for (themeNumber = 0;themeNumber < PjInternetRadio.themeImages.length;themeNumber++){
            ThemeSelector theme = new ThemeSelector();
            theme.setWidth(40);
            theme.setHeight(40);
            if (themeNumber/2 == 0 ) {
                theme.setLocation(15, (themeNumber/2)*50 +10);
            }
            else{
             theme.setLocation(65, (themeNumber/2)*50 + 10);
            }
            themeApp.add(theme);
            theme.setImage(themeButtonImages[themeNumber]);

        }
        themeApp.setVisible(true);

    }
}
