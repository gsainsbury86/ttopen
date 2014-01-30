package com.howtodoinjava.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.howtodoinjava.model.Card;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "cards")
@Path("/cards")
public class CardService {

	static ArrayList<Card> allCards;
	static ArrayList<Card> deck;
	static ArrayList<Card> discard;
	static HashMap<String,ArrayList<Card>> players;

	public CardService(){

	}

	@GET
	@Path("/")
	@Produces("text/html;charset=UTF-8;version=1")
	public String hello() {
		return "Hello World";
	}

	@GET
	@Path("/getPlayers")
	@Produces("text/html;charset=UTF-8;version=1")
	public String getPlayers(){

		reset();


		String page = "<html><head></head><body>";

		for(String playerName : players.keySet()){
			page+="<a href=\""+playerName+"\">"+playerName+"</a>";
		}

		page+="</body></html>";
		return page;
	}


	private void reset() {
		players = new HashMap<String,ArrayList<Card>>();
		allCards = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		discard = new ArrayList<Card>();

		players.put("George",new ArrayList<Card>());
		players.put("Ben",new ArrayList<Card>());
		players.put("Tyson",new ArrayList<Card>());


		allCards.add(new Card(0, "A", "Do A"));
		allCards.add(new Card(1, "B", "Do B"));
		allCards.add(new Card(2, "C", "Do C"));
		allCards.add(new Card(3, "D", "Do D"));

		for(Card c : allCards){
			deck.add(c);
		}

		Collections.shuffle(deck);
	}

	@GET
	@Path("/addPlayer/{player}")
	public void addPlayer(@PathParam("player") String player){
		players.put(player, new ArrayList<Card>());
	}

	@GET
	@Path("/{player}/draw")
	@Produces("text/html;charset=UTF-8;version=1")
	public void drawCard(@PathParam("player") String player){
		if(deck.isEmpty()){
			deck.addAll(discard);
			discard.clear();
			Collections.shuffle(deck);
		}

		Card c = deck.remove(0);

		players.get(player).add(c);
	}

	@GET
	@Path("/{player}/discard/{id}")
	@Produces("text/html;charset=UTF-8;version=1")
	public void discardCard(@PathParam("player") String player, @PathParam("id") int id){

		ArrayList<Card> p = players.get(player);

		Card card = null;
		boolean exists = false;
		for(Card c: p){
			if(c.getId() == id){
				card = c;
				exists = true;
			}
		}

		if(exists){
			p.remove(card);
		}

		discard.add(card);
	}

	@GET
	@Path("{player}")
	@Produces("text/html;charset=UTF-8;version=1")
	public String player(@PathParam("player") String player){
		String page = "<html><head></head><body><script src=\"http://code.jquery.com/jquery-latest.min.js\" type=\"text/javascript\"></script>";
		page += "<link href=\"tant_styles.css\" rel=\"Stylesheet\" />";
		// change a to button which gets/posts then refreshes
		
		page += "<div class='name'>"+player+"</div>";

		page += "<button id='draw'>draw</button>";

		page+="<script>";
		page+="$('#draw').click(function(){";
		//page+="$.get( \"http://localhost:8080/TriumphAndTreachery/cards/"+player+"/draw\", function( data ) {";
		page+="$.get( \"/cards/"+player+"/draw\", function( data ) {";
		page+="location.reload();";
		page+="});";
		page+="});";
		page+="</script>";

		// add discard button

		for(Card c : players.get(player)){
			page += "<div class='card'><div class='cardname'>"+c.getName()+"</div><div class='carddesc'>" + c.getDescription() +"</div>";
			page += "<button id='play"+c.getId()+"'>Play/Discard</button></div>";
			page+="<script>";
			page+="$('#play"+c.getId()+"').click(function(){";
			//page+="$.get( \"http://localhost:8080/TriumphAndTreachery/cards/"+player+"/discard/"+c.getId()+"\", function( data ) {";
			page+="$.get( \"/cards/"+player+"/discard/"+c.getId()+"\", function( data ) {";
			page+="location.reload();";
			page+="});";
			page+="});";
			page+="</script>";
		}
		


		page+="</body></html>";
		return page;

	}
}
