package com.rzd.pktb.SPSTournament;

import com.rzd.pktb.SPSGame.gameSPS;
import com.rzd.pktb.SPSGame.playerSPS;

import java.util.List;

/**
 * Created by SimpleUser on 18.06.2016.
 */
public class arbitr {
    private List<playerSPS> players;

    public arbitr(List<playerSPS> players){
        this.players = players;
    }

    public result playAllVsAll(int gameCount) {
        result results = new result(players);
        for (playerSPS p1 : players){
            for (playerSPS p2 : players){
                for (int i=0;i<gameCount;i++){
                    int stepP1 = p1.fight();
                    int stepP2 = p2.fight();
                    int resP1 = gameSPS.fight(stepP1, stepP2);
                    int resP2 = gameSPS.NONE;
                    if (resP1==gameSPS.LOSS) resP2 = gameSPS.WON;
                    if (resP1==gameSPS.WON) resP2 = gameSPS.LOSS;
                    results.addGame(new resultGame(p1.getClass(), p2.getClass(), stepP1, stepP2, resP1, resP2, "All_vs_All"));
                }
            }
        }
        return results;
    }



}
