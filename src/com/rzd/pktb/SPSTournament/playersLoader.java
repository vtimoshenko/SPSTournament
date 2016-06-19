package com.rzd.pktb.SPSTournament;

import com.rzd.pktb.SPSGame.playerSPS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Загрузчик классов игроков в камень/ножницы/бумага
 * Created by SimpleUser on 18.06.2016.
 */
public class playersLoader {
    private LinkedList<playerSPS> players;
    public playersLoader(String fname){
        players = new LinkedList<>();
        try {
            List<String> sList;
            sList = Files.readAllLines(Paths.get(fname));
            for (String str : sList){
                Class PlayerClass = Class.forName(str);
                players.add((playerSPS)PlayerClass.newInstance());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * Получить всех игроков
     * @return классы-игроки
     */
    public List<playerSPS> getPlayers(){
        return players;
    }
}
