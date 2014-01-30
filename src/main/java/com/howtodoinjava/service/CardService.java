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


		allCards.add(new Card(0, "Alliance", "Play if a player with an army of the same alignment (see the Warhammer rulebook) picks you as the enemy player. That player must pick a different enemy player."));
		allCards.add(new Card(1, "Sabotage", "Play in the Shooting phase when a war machine is picked to make a shooting attack. It may not shoot that phase."));
		allCards.add(new Card(2, "Bribe", "Play this card in the Shooting phase when a unit is nominated to shoot. Discard 1 brass Victory Token to stop the unit from shooting in that phase."));
		allCards.add(new Card(3, "Clandestine Aid", "Play if you are a neutral player when a combat is drawn within 12\" of one of your units, before the effects of musicians are applied. You may select one side to win the combat by 1."));
		allCards.add(new Card(4,"Secret Agenda","Play if the player that deployed on your left wins a combat. You receive one brass Victory Token."));
		allCards.add(new Card(5,"Misdirection","Play when a Wizard is nominated to cast a spell. Discard one brass Victory Token to pick the target for the spell."));
		allCards.add(new Card(6,"Don't List to Him!","Play if you are a neutral player when a unit takes a Leadership test within 12\" of your General. The unit uses your General's unmodified Leadership for that test."));
		allCards.add(new Card(7,"Underdog","Play if the player with the least valuable paychest wins a combat. You recieve 1 brass Victory Token. If no single player has the least valuable paychest, this card cannot be used."));
		allCards.add(new Card(8,"Gas Bomb","Play at the start of the Close Combat phase. Pick one unit within 12\" of one of your units. That unit is Disrupted for that phase."));
		allCards.add(new Card(9,"Inspire Fury","Play at the start of the Close Combat phase. Pick one of your units. All models in that unit have +1 Strength for that phase."));
		allCards.add(new Card(10,"Hidden Trap","Play this card when a player announces that one of their units is going to march. The unit may not march."));
		allCards.add(new Card(11,"Trickster's Ring","Play when a Wizard nominates a spell to cast. That spell will be miscast on any double."));
		allCards.add(new Card(12,"Traitor in the Ranks","Play at the start of a round of combat. Discard 1 brass Victory Token to stop one unit of your choice from using the Steadfast of Horde rules for that phase."));
		allCards.add(new Card(13,"Secret Agenda","Play if the player that deployed on your right wins a combat. You receive one brass Victory Token."));
		allCards.add(new Card(14,"Scratching Powder","Play in the Shooting phase when a unit is picked to make a shooting attack. The unit counts as having moved in the preceding Movement phase."));
		allCards.add(new Card(15,"Better part of Valour","Play when a player declares that they will attempt to rally a unit. Discard two brass Victory Tokens to cause the unit to automatically fail the rally test."));
		allCards.add(new Card(16,"Sorcerous Aid","Play if you are a neutral player when a Wizard fails a casting attempt. The spell is cast with irresistible force; the Wizard suffers the effects of broken concentration and a miscast."));
		allCards.add(new Card(17,"Retribution","Play if you win a combat in your turn against the last player that chose you as the enemy player. You receive 2 extra brass Victory Tokens."));
		allCards.add(new Card(18,"Secret Raid","Play in the Shooting phase when a unit is picked to make a shooting attack. The unit must re-roll successul To Hit rolls. Shooting attacks that do not roll To Hit are not affected by this card."));
		allCards.add(new Card(19,"Forgery","Play when a unit declares a charge reaction. The unit must make a Hold charge reaction."));
		allCards.add(new Card(20,"\"Bad Luck Sir!\"","Discard two brass Victory Tokens to change a successful \"Look Out Sir!\" roll into an unsuccessful roll."));
		allCards.add(new Card(21,"Null Stone","Play in the Magic phase to remove D3 dice from both the power and dispel pools (roll once and apply the result to both pools.)"));
		allCards.add(new Card(22,"Caltrops","Play when a player nominates one of your units at the target of a charge. Halve the charge range of all units charging your unit."));
		allCards.add(new Card(23,"Ambush Fire","Play if you are a neutral player in a Shooting phase. One of your units may immediately shoot at a unit belonging to the player chosen as the enemy player this phase."));
		allCards.add(new Card(24,"Secret Information","Play at the start of the Close Combat phase. Pick one of your units. All models in that unit have +1 Weapon Skill for that phase."));
		allCards.add(new Card(25,"Surprise Attack","Play at the start of your Movement phase. Pick one of your units. That unit has +D3 Movement for that phase."));
		allCards.add(new Card(26,"Duplicitous Mage","Play in the Magic phase when a Wizard is nominated to cast a spell. Discard two brass Victory Tokens to stop the Wizard from casting any spells for the remainder of that phase."));
		allCards.add(new Card(27,"Oil Slick","Play at the start of a round of combat that takes place within 12\" of one of your units. All models involved in that combat must re-roll successful To Hit rolls."));
		allCards.add(new Card(28,"Cunning Ruse","Play at the start of the Close Combat phase. Pick one of your units. All models in that Unit have +1 Initative for that phase."));
		allCards.add(new Card(29,"Look Behind You!","Play at the start of the Shooting of Close Combat phase. Nominate one non-friendly unit. All models in that unit must re-roll successful armour saves that phase."));
		allCards.add(new Card(30,"Dirty Trick","Play when the combat result score is being calculated for a combat. Add +1 to the combat result score fof the side of your choice."));
		allCards.add(new Card(31,"Ancient Enmity","Play if a player with an army of the same alignment or a non-aligned army (see the Warhammer rulebook) picks you as the enemy player. The player must pick a different enemy player."));
		allCards.add(new Card(32,"Paranoia","Play if a player picks you as the enemy player. The player must pick a different enemy player."));
		allCards.add(new Card(33,"Masterstroke","Play if you win a combat against the player that deployed on your right. You receive two extra brass Victory Tokens."));
		allCards.add(new Card(34,"Riches","Play in the Close Combat phase when a unit is nominated to pursue. Discard one brass Victory Token to halve the Pursuit roll for that unit."));
		allCards.add(new Card(35,"Masterstroke","Play if you win a combat against the player that deployed on your left. You receive two extra brass Victory Tokens."));		

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
	@Path("/{player}/give/{to}/{id}")
	@Produces("text/html;charset=UTF-8;version=1")
	public void giveCard(@PathParam("player") String player, @PathParam("id") int id, @PathParam("to") String to){

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

		ArrayList<Card> t = players.get(to);
		
		t.add(card);

	}

	@GET
	@Path("tant_styles.css")
	@Produces("text/html")
	public String css(){
		return ".card{position:relative;float:left;width:200px;height:350px;background-color:#FFFCDF;border-width:2px;border-style:solid;margin:0px 2px 0px 2px;border-radius:10px;}.cardname{text-align:center;font: 1.1em \"Lucida Grande\", \"Trebuchet MS\", Verdana, sans-serif;}.carddesc{margin-top:20px;margin-left:20px;font: 0.9em \"Lucida Grande\", \"Trebuchet MS\", Verdana, sans-serif;}.card button{width:90px;position:absolute;bottom:10px;right:5px;}";
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

			page += "<button id='play"+c.getId()+"'>Play/Discard</button>";
			page+="<script>";
			page+="$('#play"+c.getId()+"').click(function(){";
			//page+="$.get( \"http://localhost:8080/TriumphAndTreachery/cards/"+player+"/discard/"+c.getId()+"\", function( data ) {";
			page+="$.get( \"/cards/"+player+"/discard/"+c.getId()+"\", function( data ) {";
			page+="location.reload();";
			page+="});";
			page+="});";
			page+="</script>";

			for(String p : players.keySet()){
				if(!p.equals(player)){
					page += "<button id='give_"+p+"_"+c.getId()+"'>Give to "+p+"</button>";
					page+="<script>";
					page+="$('#give_"+p+"_"+c.getId()+"').click(function(){";
					page+="$.get( \"/cards/"+player+"/give/"+p+"/"+c.getId()+"\", function( data ) {";
					page+="location.reload();";
					page+="});";
					page+="});";
					page+="</script>";
				}
			}
			
			page+="</div>";
		}



		page+="</body></html>";
		return page;

	}
}
