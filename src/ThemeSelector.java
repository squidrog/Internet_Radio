import java.awt.event.MouseEvent;

/**
 * Created by coleobrien on 12/15/15.
 */
public class ThemeSelector extends MyClickableShape {
    protected int themeCount;
    public ThemeSelector(){
        super();
        themeCount = ThemeButton.themeNumber;
    }
    public void mouseClicked(
            MouseEvent event){
        PjInternetRadio.myRadio.setImage(PjInternetRadio.themeImages[themeCount]);
    }
}
