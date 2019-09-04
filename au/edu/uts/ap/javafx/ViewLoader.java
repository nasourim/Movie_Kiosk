package au.edu.uts.ap.javafx;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.util.BuilderFactory;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.Catalogue;
import model.Kiosk;

public class ViewLoader extends Controller<Catalogue> {
    public ViewLoader() {
        super();
    }
    public static <Kiosk> void showStage(final Kiosk t, final String s, final String title, final Stage stage) throws IOException {
        final Parent parent = FXMLLoader.load(controller.KioskController.class.getResource(s));
        stage.setTitle(title);
        stage.setScene(new Scene(parent));
        stage.sizeToScene();
        stage.show();

    }

//    private static /* synthetic */ Object lambda$showStage$0(final Object model, final Stage stage, final Class clazz) {
//        try {
//            final Controller controller = clazz.newInstance();
//            controller.model = model;
//            controller.stage = stage;
//            return controller;
//        }
//        catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
}