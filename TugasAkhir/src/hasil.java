import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hasil extends javax.swing.JFrame {

    loginView lg;

    public hasil(loginView loginView){
        this.lg = loginView;

        loginView.btn_masuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView adminView = new adminView();
                modelAdmin modelAdmin = new modelAdmin();
                new controllerAdmin(adminView,modelAdmin);
            }
        });

            }
}
