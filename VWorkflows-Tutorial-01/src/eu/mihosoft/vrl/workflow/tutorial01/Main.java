/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.workflow.tutorial01;

import javafx.application.Application;
import javafx.stage.Stage;

import eu.mihosoft.vrl.workflow.FlowFactory;
import eu.mihosoft.vrl.workflow.VFlow;
import eu.mihosoft.vrl.workflow.VNode;
import eu.mihosoft.vrl.workflow.fx.FXSkinFactory;
import javafx.scene.Scene;
import jfxtras.labs.scene.layout.ScalableContentPane;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class Main extends Application {

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ScalableContentPane canvas = new ScalableContentPane();
        canvas.setStyle("-fx-background-color: linear-gradient(to bottom, rgb(10,32,60), rgb(42,52,120));");

        VFlow flow = FlowFactory.newFlow();

        flow.getModel().setVisible(true);

        VNode n1 = flow.newNode();
        VFlow n2 = flow.newSubFlow();

        n1.setInput(true, "data");
        n1.setOutput(true, "data");
        n2.setInput(true, "data");
        n2.setOutput(true, "data");

        flow.connect(n1, n2, "data");

        VNode sn1 = n2.newNode();
        VNode sn2 = n2.newNode();

        sn1.setInput(true, "data");
        sn1.setOutput(true, "data");
        sn2.setInput(true, "data");
        sn2.setOutput(true, "data");

        flow.setSkinFactory(new FXSkinFactory(canvas.getContentPane()));

        Scene scene = new Scene(canvas, 800, 800);
        primaryStage.setTitle("VWorkflows Tutorial 01");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
