import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menucontroller {
    menuview mv;

    public menucontroller(menuview menuview) {
        this.mv = menuview;

        // lihat data ==========================================================
        menuview.btnLihat.addActionListener((ActionEvent ae) -> {
            AslabView lihatView = new AslabView();
            model lihatModel = new model();
            new controller(lihatView, lihatModel);
        });
    }

}
