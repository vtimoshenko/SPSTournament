package com.rzd.pktb.SPSTournament;

import com.rzd.pktb.SPSGame.gameSPS;
import com.rzd.pktb.SPSGame.playerSPS;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SimpleUser on 18.06.2016.
 */
public class arbitr {
    private List<playerSPS> players;

    public arbitr(List<playerSPS> players){
        this.players = players;
    }

    public result playAllVsAll(int gameCount) throws IllegalAccessException, InstantiationException {
        result results = new result(players);
        LinkedList<playerSPS> end = new LinkedList<>(); //Список уже играющих игроков, чтобы игрок не играл сам с собой и не было повторных игр

        for (playerSPS p1 : players){
            end.add(p1);
            for (playerSPS p2 : players){
                if (end.contains(p2)) continue;         //Не играть с собой и не играть повторно
                p1 = p1.getClass().newInstance();       //Новые экземпляры игроков, чтобы сбросить статистику, если она есть и начать новую игру для каждого
                p2 = p2.getClass().newInstance();
                for (int i=0;i<gameCount;i++){
                    //игроки делают ходы
                    int stepP1 = p1.fight();
                    int stepP2 = p2.fight();
                    //определяем результат
                    int resP1 = gameSPS.fight(stepP1, stepP2);
                    int resP2 = gameSPS.NONE;
                    if (resP1==gameSPS.LOSS) resP2 = gameSPS.WON;
                    if (resP1==gameSPS.WON) resP2 = gameSPS.LOSS;
                    //сохраняем результат
                    results.addGame(new resultGame(p1.getClass(), p2.getClass(), stepP1, stepP2, resP1, resP2, "All_vs_All"));
                }
            }
        }
        return results;
    }
}
