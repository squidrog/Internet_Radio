import com.pumaj.PjApplication;

import java.awt.event.MouseEvent;

/**
 * Created by coleobrien on 12/15/15.
 */
public class HelpButton extends MyClickableShape {
    public HelpButton(){
        super();
    }
    public void mouseClicked(
            MouseEvent event){
        PjApplication helpApp = new PjApplication();
        helpApp.setHeight(1000);
        helpApp.setWidth(1000);
        helpApp.setLocation(0,0);
        //helpApp.setImage();
        helpApp.setVisible(true);
    }
}
