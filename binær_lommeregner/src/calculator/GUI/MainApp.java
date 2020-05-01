package calculator.GUI;

import calculator.Controller.Controller;
import javafx.scene.control.TextFormatter;	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private Button btnSum, btnSub, btnMulti, btnHistory;
	
	
	private void setTextFields(String result) {
		
		
		txfNum1Dec.setText("" +controller.convertBase2To10(txfNum1Bin.getText()));
		txfNum2Dec.setText("" +controller.convertBase2To10(txfNum2Bin.getText()));

		txfResultDec.setText("" +controller.convertBase2To10(result));
		txfResultBin.setText(result);
	}
	/**
	 * validerer input
	 * @param input1
	 * @param input2
	 * @return
	 */
	private boolean isValid(String input1, String input2) {
		boolean valid = true;
		if(input1.length()<2 || input2.length()<2) {
			valid = false;
		}
		
		if(valid) {
			//validerer input
			for(int i = 0; i<input1.length(); i++) {
				if(input1.charAt(i) != ' ' && input1.charAt(i) !='1' && input1.charAt(i) != '0') {
					valid = false;
					break;
				}
			}
		}
		
		if(valid) {
			for(int i = 0; i<input2.length(); i++) {
				if(input2.charAt(i) != ' ' && input2.charAt(i) !='1' && input2.charAt(i) != '0') {
					valid = false;
					break;
				}
			}
	
		}
				return valid;
	}

	
	private void initContent(GridPane pane) {
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
		txfNum2Dec= new TextField();
		
		
		txfNum1Dec.textProperty().addListener((observable, oldValue, newValue) -> {
			txfNum1Bin.setText(controller.convertBase10to2(newValue));
			
		});
		
		
		txfNum2Dec.textProperty().addListener((observable, oldValue, newValue) -> {
			txfNum2Bin.setText(controller.convertBase10to2(newValue));
		});
		
		btnSum= new Button("=");
		btnSum.setOnAction(event ->{
			
			String input1 = txfNum1Bin.getText();
			String input2 = txfNum2Bin.getText();
			
			if(isValid(input1, input2)) {
				String result = controller.Sum(input1, input2);
				
				setTextFields(result);
				
			}else {
				Alert a = new Alert(AlertType.WARNING);
				a.setContentText("Du har indtastet invalide tal");
				 
				 
				 a.showAndWait();
			}
		});
		
	/**

		btnSub = new Button("-");
		
		btnSub.setOnAction(event ->{
			long input1, input2;

			input1 = Long.parseLong(txfNum2Bin.getText());
			input2 = Long.parseLong(txfNum1Bin.getText());
			
			String result = controller.subtract(input1, input2);
			
			setTextFields(result);
		});
		*/
		btnMulti = new Button("*");
		btnMulti.setOnAction(event ->{

			
			String input1 = txfNum1Bin.getText();
			String input2 = txfNum2Bin.getText();
			
			if(isValid(input1, input2)) {
				String result = controller.multiply(txfNum1Bin.getText(),txfNum2Bin.getText());
				
				setTextFields(result);
				
			}else {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText("Du har indtastet invalide tal");
			 
			 
			 a.showAndWait();
		}
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
		hbButtons.getChildren().addAll(btnSum, btnMulti);
		
		
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
