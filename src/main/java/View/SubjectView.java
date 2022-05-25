package View;

import controller.SubjectController;
import javafx.scene.layout.AnchorPane;
import model.Subject;

public class SubjectView extends AnchorPane {
    private SubjectController controller;

    private Subject subject;

    public SubjectController getController() {
        return controller;
    }

    public SubjectView(Subject subject) {
        controller = SubjectController.getInstance();
        setSubject(subject);
        subject.setView(this);
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
        controller.setSubject(subject);
    }
}
