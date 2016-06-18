package com.rzd.pktb.SPSTournament;

import com.rzd.pktb.SPSGame.playerSPS;

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
        return "";
    }
}
