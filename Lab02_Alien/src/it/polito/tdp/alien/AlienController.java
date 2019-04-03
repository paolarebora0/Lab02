package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

	private AlienDictionary alienDictionary = new AlienDictionary();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField lblTesto;

	@FXML
	private Button btnTranslate;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doReset(ActionEvent event) {
		lblTesto.clear();
		txtResult.clear();
		alienDictionary.resetDictionary();
	}

	@FXML
	void doTranslate(ActionEvent event) {

		txtResult.clear();
		String riga = lblTesto.getText().toLowerCase();

		// Controllo sull'input
		if (riga == null || riga.length() == 0) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}

		StringTokenizer st = new StringTokenizer(riga, " ");
		
		// Controllo su String Tokenizer (superfluo)
		if (!st.hasMoreElements()) {
			txtResult.setText("Inserire una o due parole.");
			return;
		}

		// Estraggo la prima parola
		String alienWord = st.nextToken();

		if (st.hasMoreTokens()) {
			// Devo inserire nel dizionario

			// Estraggo la seconda parola
			String translation = st.nextToken();

			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			// Aggiungo la parola aliena e traduzione nel dizionario
			alienDictionary.addWord(alienWord, translation);

			txtResult.setText("La parola: " + alienWord + " traduzione: " + translation + " è stata inserita.");

		} else {

			// Controllo che non ci siano caratteri non ammessi
			if (!alienWord.matches("[a-zA-Z?]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			String translation;

			if (alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {

				// Traduzione con WildCard
				translation = alienDictionary.translateWordWildCard(alienWord);

			} else {

				// Traduzione classica
				translation = alienDictionary.translateWord(alienWord);
			}

			if (translation != null) {
				txtResult.setText(translation);
			} else {
				txtResult.setText("La parola cercata non esiste nel dizionario.");
			}
		}
	}

	@FXML
	void initialize() {
		assert lblTesto != null : "fx:id=\"lblTesto\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
	}
}
