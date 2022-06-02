public class Main {
    public static void main(String[] args) {
        loginModel model = new loginModel();
        loginView view = new loginView();
        new loginController(view,model);
    }
}
