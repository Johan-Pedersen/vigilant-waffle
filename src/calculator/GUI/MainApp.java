package calculator.GUI;

import java.util.ArrayList;

import calculator.Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MainApp extends Application{
	
	private Controller controller = new Controller();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("BinCalculator");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane,600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
	private TextField txfResultBin, txfNum1Bin, txfNum2Bin, txfNum1Dec, txfNum2Dec, txfResultDec;
	private Label lbResultBin, lbResultDec, lbBin, lbDec; 
	private Button btnAdd, btnSub, btnMulti, btnHistory;
	
	private void setTextFields(String result) {
		txfNum1Dec.setText("" +controller.convertBase2To10(txfNum1Bin.getText()));
		txfNum2Dec.setText("" +controller.convertBase2To10(txfNum2Bin.getText()));
		
		txfResultDec.setText("" +controller.convertBase2To10(result));
		txfResultBin.setText(result);
	}
	
	private void initContent(GridPane pane) {
		// TODO Auto-generated method stub
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);


		// ---------------------------------------------------------------------
		
		
		lbResultBin = new Label("Binary:");
		txfResultBin = new TextField();
		txfResultBin.setEditable(false);
		
		lbResultDec = new Label("Decimal:");
		txfResultDec= new TextField();
		txfResultDec.setEditable(false);
		
		lbBin = new Label("Binary:");
		txfNum1Bin = new TextField();
		txfNum2Bin = new TextField();
		
		lbDec = new Label("Decimal");
		txfNum1Dec = new TextField();
		txfNum1Dec.setEditable(false);
		txfNum2Dec= new TextField();
		txfNum2Dec.setEditable(false);
		
		
		btnAdd = new Button("+");
		btnAdd.setOnAction(event ->{
			String result = controller.add(Long.parseLong(txfNum1Bin.getText()), Long.parseLong(txfNum2Bin.getText()));
			
			setTextFields(result);
		});
		
		
	
		btnSub = new Button("-");
		
		btnSub.setOnAction(event ->{
			String result = controller.subtract(Long.parseLong(txfNum2Bin.getText()), Long.parseLong(txfNum1Bin.getText()));
			
			setTextFields(result);
		});
		
		btnMulti = new Button("*");
		btnMulti.setOnAction(event ->{
			String result = controller.multiply(Long.parseLong(txfNum1Bin.getText()),Long.parseLong(txfNum2Bin.getText()));
			
			setTextFields(result);
		});
		
		btnHistory = new Button("History");
		btnHistory.setOnAction(event ->{
			ListView<String> lwHirstory = new ListView<String>();
			
			lwHirstory.getItems().addAll(controller.getStorage().getCalculations());
			
			Stage stage = new Stage();
			
			VBox box = new VBox();
	        box.setPadding(new Insets(10));
	        box.setAlignment(Pos.CENTER);
			
	        box.getChildren().add(lwHirstory);
	        Scene scene = new Scene(box, 250, 150);
	        stage.setScene(scene);
	        stage.show();
		});
		
		
		HBox hbButtons = new HBox();
		hbButtons.setSpacing(20.0);
		hbButtons.getChildren().addAll(btnAdd, btnSub, btnMulti);
		
		
		pane.add(lbResultBin, 0, 0);
		pane.add(txfResultBin, 0, 1,4,1);
		pane.add(lbResultDec, 0, 2);
		pane.add(txfResultDec, 0, 3, 4,1);
		
		pane.add(lbBin, 0, 4);
		pane.add(txfNum1Bin, 1, 4);
		pane.add(txfNum2Bin, 2, 4);

		pane.add(lbDec, 0, 5);
		pane.add(txfNum1Dec, 1, 5);
		pane.add(txfNum2Dec, 2, 5);


		pane.add(btnHistory, 5, 1);
		pane.add(hbButtons, 0, 6, 4, 2);
		
	
	}

}
