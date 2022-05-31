import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuController {
    menuView mv;

    public menuController(menuView menuView) {
        this.mv = menuView;

        // lihat data ==========================================================
        menuView.btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                View lihatView = new View();
                Model lihatModel = new Model();
                new Controller(lihatView, lihatModel);
            }
        });
    }

}
