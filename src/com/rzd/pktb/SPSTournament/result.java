package com.rzd.pktb.SPSTournament;

import com.rzd.pktb.SPSGame.playerSPS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SimpleUser on 18.06.2016.
 */
public class result {
    private LinkedList<resultGame> games;
    private List<playerSPS> players;

    private HashMap<String, Integer> none = new HashMap<>();
    private HashMap<String, Integer> won = new HashMap<>();
    private HashMap<String, Integer> loss = new HashMap<>();

    public result(List<playerSPS> players) {
        this.players = players;
        for (playerSPS player : players){
            none.put(player.getClass().getSimpleName(), 0);
            won.put(player.getClass().getSimpleName(), 0);
            loss.put(player.getClass().getSimpleName(), 0);
        }

        this.games = new LinkedList<>();
    }
    public void addGame(resultGame result){
        games.add(result);

        if (result.getResultPlayer1().equals("NONE")){
            none.replace(result.getPlayer1(), none.get(result.getPlayer1()) + 1);
            none.replace(result.getPlayer2(), none.get(result.getPlayer2()) + 1);
        }
        if (result.getResultPlayer1().equals("WON")){
            won.replace(result.getPlayer1(), won.get(result.getPlayer1()) + 1);
            loss.replace(result.getPlayer2(), loss.get(result.getPlayer2()) + 1);
        }
        if (result.getResultPlayer1().equals("LOSS")){
            loss.replace(result.getPlayer1(), loss.get(result.getPlayer1()) + 1);
            won.replace(result.getPlayer2(), won.get(result.getPlayer2()) + 1);
        }



    }

    public String getMainStatistics(){
        StringBuffer buf = new StringBuffer();
        buf.append("Games total: " + games.size() + "\n");

        for (playerSPS player : players){
            buf.append("Statistics for " + player.getClass().getSimpleName() + ":\n");
            buf.append("\tnones: " + none.get(player.getClass().getSimpleName()) + ":\n");
            buf.append("\twons " + won.get(player.getClass().getSimpleName()) + ":\n");
            buf.append("\tlosses " + loss.get(player.getClass().getSimpleName()) + ":\n");
        }

        buf.append("\n\nAllGames:");
        for (resultGame game : games)
        {
            buf.append("\n" + game.getTimestamp() + " : " + game.getPlayer1() + " with " + game.getStepPlayer1() + "(" + game.getResultPlayer1() + ") vs " + game.getPlayer2() + " with " + game.getStepPlayer2() + "(" + game.getResultPlayer2() + ")");
        }
        return buf.toString();
    }
}
