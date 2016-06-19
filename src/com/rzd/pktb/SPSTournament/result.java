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

    //количество ничьих для каждого игрока
    private HashMap<String, Integer> none = new HashMap<>();
    //количество побед для каждого игрока
    private HashMap<String, Integer> won = new HashMap<>();
    //количество поражений для каждого игрока
    private HashMap<String, Integer> loss = new HashMap<>();
    //счет для каждой пары игроков
    private HashMap<String, score> scores = new HashMap<>();

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

        //создать пару игроков в списке счетов, если её еще нет
        if (!scores.containsKey(result.getPlayer1() + "/" + result.getPlayer2()))
            scores.put(result.getPlayer1() + "/" + result.getPlayer2(), new score());
        //считаем ничьи
        if (result.getResultPlayer1().equals("NONE")){
            none.replace(result.getPlayer1(), none.get(result.getPlayer1()) + 1);
            none.replace(result.getPlayer2(), none.get(result.getPlayer2()) + 1);
        }
        //считаем победы первого игрока
        if (result.getResultPlayer1().equals("WON")){
            scores.replace(result.getPlayer1() + "/" + result.getPlayer2(), scores.get(result.getPlayer1() + "/" + result.getPlayer2()).add1());
            won.replace(result.getPlayer1(), won.get(result.getPlayer1()) + 1);
            loss.replace(result.getPlayer2(), loss.get(result.getPlayer2()) + 1);
        }
        //считаем победы второго игрока
        if (result.getResultPlayer1().equals("LOSS")){
            scores.replace(result.getPlayer1() + "/" + result.getPlayer2(), scores.get(result.getPlayer1() + "/" + result.getPlayer2()).add2());
            loss.replace(result.getPlayer1(), loss.get(result.getPlayer1()) + 1);
            won.replace(result.getPlayer2(), won.get(result.getPlayer2()) + 1);
        }
    }

    /**
     * Получение статистики игры
     * @return
     */
    public String getMainStatistics(){
        StringBuffer buf = new StringBuffer();
        buf.append("AllGames:");
        for (resultGame game : games)
        {
            buf.append("\n" + game.getTimestamp() + " : " + game.getPlayer1() + " with " + game.getStepPlayer1() + "(" + game.getResultPlayer1() + ") vs " + game.getPlayer2() + " with " + game.getStepPlayer2() + "(" + game.getResultPlayer2() + ")");
        }

        buf.append("\n\nGames total: " + games.size() + "\n");

        for (playerSPS player : players){
            buf.append("Statistics for " + player.getClass().getSimpleName() + ":\n");
            buf.append("\tnones: " + none.get(player.getClass().getSimpleName()) + ":\n");
            buf.append("\twons " + won.get(player.getClass().getSimpleName()) + ":\n");
            buf.append("\tlosses " + loss.get(player.getClass().getSimpleName()) + ":\n");
        }

        for (String key : scores.keySet())
        {
            buf.append("\n" + key + "\t\t" + scores.get(key).wins1 + ":" + scores.get(key).wins2);
        }
        return buf.toString();
    }
}

/**
 * счет для одной пары игроков
 */
class score{
    int wins1;
    int wins2;
    public score(){
        wins1 = 0;
        wins2 = 0;
    }
    public score add1(){
        wins1++;
        return this;
    }
    public score add2(){
        wins2++;
        return this;
    }

}
