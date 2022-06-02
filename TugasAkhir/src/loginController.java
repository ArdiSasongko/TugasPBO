import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginController{
    loginModel model;
    loginView view;

    public loginController(loginView loginView, loginModel loginModel){
        this.view = loginView;
        this.model = loginModel;

        view.btn_masuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = view.getUser();
                String pass = view.getPass();
                model.login(user,pass);
            }
        });

        view.btn_pembeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilanView tp = new tampilanView();
                tampilanModel tm = new tampilanModel();
                new tampilanController(tp,tm);
            }
        });
    }


}
