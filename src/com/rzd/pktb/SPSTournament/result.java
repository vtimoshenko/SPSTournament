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

    public result(List<playerSPS> players) {
        this.players = players;
        this.games = new LinkedList<>();
    }
    public void addGame(resultGame result){
        games.add(result);
    }

    public String getMainStatistics(){
        StringBuffer buf = new StringBuffer();
        buf.append("Games total: " + games.size() + "\n");
        HashMap<String, Integer> none = new HashMap<>();
        HashMap<String, Integer> won = new HashMap<>();
        HashMap<String, Integer> loss = new HashMap<>();
        for (playerSPS player : players){
            none.put(player.getClass().getName(), 0);
            won.put(player.getClass().getName(), 0);
            loss.put(player.getClass().getName(), 0);
        }
        for (resultGame gm : games){
            if (gm.getResultPlayer1().equals("NONE")){
                none.replace(gm.getPlayer1(), none.get(gm.getPlayer1()) + 1);
                none.replace(gm.getPlayer2(), none.get(gm.getPlayer2()) + 1);
            }
            if (gm.getResultPlayer1().equals("WON")){
                won.replace(gm.getPlayer1(), won.get(gm.getPlayer1()) + 1);
                loss.replace(gm.getPlayer2(), loss.get(gm.getPlayer2()) + 1);
            }
            if (gm.getResultPlayer1().equals("LOSS")){
                loss.replace(gm.getPlayer1(), loss.get(gm.getPlayer1()) + 1);
                won.replace(gm.getPlayer2(), won.get(gm.getPlayer2()) + 1);
            }
        }
        for (playerSPS player : players){
            buf.append("Statistics for " + players.getClass().getName() + ":\n");
            buf.append("\tnones: " + none.get(player.getClass().getName()) + ":\n");
            buf.append("\twons " + won.get(player.getClass().getName()) + ":\n");
            buf.append("\tlosses " + loss.get(player.getClass().getName()) + ":\n");
        }
        buf.append("\n\nAllGames:");
        for (resultGame game : games)
        {
            buf.append("\n" + game.getTimestamp() + " : " + game.getPlayer1() + " with " + game.getStepPlayer1() + "(" + game.getResultPlayer1() + ") vs " + game.getPlayer2() + " with " + game.getStepPlayer2() + "(" + game.getResultPlayer2() + ")");
        }
        return buf.toString();
    }
}
