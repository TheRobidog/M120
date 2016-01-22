package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

import control.ReadCard;

public class cardController {

	@FXML protected Label lblStatus;
	@FXML protected Pane pnlQuestion;
	@FXML protected Pane pnlAnswer;
	@FXML protected Label lblQuestion;
	@FXML protected Label lblAnswer;
	@FXML protected Button cmdPrev;
	@FXML protected Button cmdNext;
	@FXML protected Button cmdRand;
	@FXML protected Button cmdEdit;
	
	public String username;
	public String[] setArray;
	public Integer cardId;
	public Integer minId = 0;
	public Integer maxId;
	
	public void set(String userString) {
		// TODO Auto-generated method stub
		lblStatus.setText("Welcome " + userString);
		username = userString;
	}
	
	public void getPrev(ActionEvent event) throws Exception{
		GetCardById(cardId - 1);
	}
	
	public void getNext(ActionEvent event) throws Exception{
		GetCardById(cardId + 1);
	}
	
	public void getRandom(ActionEvent event) throws Exception{
		Random rand = new Random();
		int randId = rand.nextInt(maxId);
		
		GetCardById(randId);
	}
	
	public void getMax(ActionEvent event) throws Exception{
		GetCardById(maxId);
	}
	
	public void getMin(ActionEvent event) throws Exception{
		GetCardById(minId);
	}
	
	public void switchtoEdit(ActionEvent event) throws Exception{
		
	}
	
	public void getSet(String setName) throws IOException{
		setArray = ReadCard.main(username, setName);
		
		String[] cardArray = setArray[0].split(":");
		cardId = Integer.valueOf(cardArray[0]);
		maxId = setArray.length - 1;
		lblQuestion.setText(cardArray[1]);
		lblAnswer.setText(cardArray[2]);
	}
	
	public void GetCardById(Integer id){
		for(String card : setArray){
			String[] cardArray = card.split(":");
			if(id.equals(Integer.valueOf(cardArray[0]))){
				cardId = Integer.valueOf(cardArray[0]);
				lblQuestion.setText(cardArray[1]);
				lblAnswer.setText(cardArray[2]);
				return;
			}
		}
	}

}
