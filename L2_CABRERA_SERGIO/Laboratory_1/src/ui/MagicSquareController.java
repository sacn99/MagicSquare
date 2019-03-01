package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import model.MagicSquare;

public class MagicSquareController {
	
	private MagicSquare sacn;
	private char startPosition;
	private char direction;
	
	@FXML
    private Label txtMatrix;
	
	@FXML
    private MenuButton Dd;
	
	@FXML
    private MenuItem btNorthwest;

    @FXML
    private MenuItem btNortheasth;

    @FXML
    private MenuItem btSouthwest;

    @FXML
    private MenuItem btSoutheasth;
    
    @FXML
    private MenuButton Sp;
    
    @FXML
    private MenuItem btTop;

    @FXML
    private MenuItem btRight;

    @FXML
    private MenuItem btLeft;

    @FXML
    private MenuItem btBot;

    @FXML
    private TextField sideSize;
    
    @FXML
    void top(ActionEvent event) {
    	startPosition = 't';
    	Dd.setVisible(true);
    	btNorthwest.setVisible(true);
    	btNortheasth.setVisible(true);
    }

    @FXML
    void bot(ActionEvent event) {
    	startPosition = 'b';
    	Dd.setVisible(true);
    	btSouthwest.setVisible(true);
    	btSoutheasth.setVisible(true);
    }
    
    @FXML
    void left(ActionEvent event) {
    	startPosition = 'l';
    	Dd.setVisible(true);
    	btSouthwest.setVisible(true);
    	btNorthwest.setVisible(true);
    }
    
    @FXML
    void right(ActionEvent event) {
    	startPosition = 'r';
    	Dd.setVisible(true);
    	btNortheasth.setVisible(true);
    	btSoutheasth.setVisible(true);
    }
   
    @FXML
    void ne(ActionEvent event) {
    	direction = '2';
    }

    @FXML
    void nw(ActionEvent event) {
    	direction = '1';
    }

    @FXML
    void se(ActionEvent event) {
    	direction = '4';
    }

    @FXML
    void sw(ActionEvent event) {
    	direction = '3';
    }

    @FXML
    void generateMagicSquare(ActionEvent event) {
    	int a = Integer.parseInt(sideSize.getText());
    	String msg = "";
    	if(a%2 !=0) {
    		sacn = new MagicSquare(a, startPosition, direction);
    	}
    	for(int i=0; i< a; i++) {
    		for(int j=0; j< a; j++) {
    			msg += sacn.getSquare()[i][j]+" ";
    		}
    		msg += "\n";
    	}
    	txtMatrix.setText("Cualquier pendejada");
    }
}

