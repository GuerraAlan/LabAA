package application.controller;

import application.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ViewPrincipalController {
	
    @FXML
    private TextField txtEntrada;

    @FXML
    private TextField txtComplexidade;

    @FXML
    private TextField txtProcessamento;

    @FXML
    private Button btnVerificar;

    @FXML
    private Label labelResultadoComplexidade;

    @FXML
    private TextField txtNumerosBusca;

    @FXML
    private TextField txtNumeroBuscado;

    @FXML
    private Button btnBuscar;

    @FXML
    private Label labelResultadoBusca;

    @FXML
    private TextField txtNumeroOrdenacao;

    @FXML
    private RadioButton radioInsertion;

    @FXML
    private ToggleGroup sort;

    @FXML
    private RadioButton radioBubble;

    @FXML
    private RadioButton radioSelection;

    @FXML
    private RadioButton radioRadix;

    @FXML
    private Button btnOrdenar;

    @FXML
    private Label labelResultadoOrdenacao;

    @FXML
    void buscar(ActionEvent event) {

    }
    
    @FXML
    void verificar(ActionEvent event) {

    }

    @FXML
    void ordenar(ActionEvent event) {
    	
    	Ordenacao ordenacao = null;
    	
    	if (this.radioInsertion.isSelected()) {
    		
    		ordenacao = new Insertion();
    		
    	}else if (this.radioBubble.isSelected()) {
    		
    		ordenacao = new Bubble();
    		
    	}else if (this.radioSelection.isSelected()) {
    		
    		ordenacao = new Selection();
    		
    	} else if (this.radioRadix.isSelected()){
    	    ordenacao = new Radix();
        }
    	
    	String[] ns = this.txtNumeroOrdenacao.getText().split(",");
    	int[] nums = this.parseIntArray(ns);
    	int[] resultado = ordenacao.executar(nums);
    	
    	StringBuilder stringArray = new StringBuilder();
    	for (int n: resultado) {
    		stringArray.append(n+" ");
    	}
    	this.labelResultadoOrdenacao.setText(stringArray.toString());
    	
    }

    private int[] parseIntArray(String[] numeros) {
    	int[] array = new int[numeros.length];
    	int i = 0;
    	for (String n: numeros) {
    		array[i] = Integer.parseInt(n);
    		i++;
    	}
    	return array;
    }

}
