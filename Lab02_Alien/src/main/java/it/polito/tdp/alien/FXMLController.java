package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button txtClear;

    @FXML
    void handleClear(ActionEvent event) {
    	txtResult.clear();
    	txtInsert.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String campo = txtInsert.getText().toLowerCase();
    	
    	//AGGIUNTA A STRUTTURA DATI
    	//(2 parole)
    	if(campo.contains(" ")) {
    		String[] arr = campo.split(" ");
    		//Controllo due parole massimo
    		if(arr.length > 2) {
    			txtResult.setText("Errore, puoi inserire massimo due parole");
    			return;
    		}
    		//Controllo solo lettere parola1
    		for(int i=0; i<arr[0].length(); i++) {
    			char[] ali = arr[0].toCharArray();
    			if(!Character.isLetter(ali[i])) {
    				txtResult.setText("Errore, puoi inserire solo lettere");
        			return;
    			}
    		}
    		//Controllo solo lettere parola2
    		for(int i=0; i<arr[1].length(); i++) {
    			char[] ita = arr[1].toCharArray();
    			if(!Character.isLetter(ita[i])) {
    				txtResult.setText("Errore, puoi inserire solo lettere");
        			return;
    			}
    		}
    		//Aggiungo
    		model.add(arr[0], arr[1]);
    		txtResult.setText("Aggiunto con successo!");
    	}
    	//RICERCA TRADUZIONE
    	//1 parola
    	else {
    		//Controllo solo lettere e punto
    		int cont = 0;
    		for(int i=0; i<campo.length(); i++) {
    			char[] parola = campo.toCharArray();
    			if(! (Character.isLetter(parola[i]) || parola[i]=='?' )) {
    				txtResult.setText("Errore, puoi inserire solo lettere e un punto di domanda");
        			return;
    			}
    			if(parola[i]=='?')
    				cont++;
    			if(cont>1) {
    				txtResult.setText("Errore, puoi inserire al massimo un punto di domanda");
        			return;
    			}
    		}
    		//ricerca
    		String trad = model.traduci(campo);
    		if(trad.equals("")) {
    			txtResult.setText("Traduzione sconosciuta");
    		}
    		else {
    			txtResult.setText(trad);
    		}
    	}
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtClear != null : "fx:id=\"txtClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Dizionario model) {
    	this.model = model;
    }
}
