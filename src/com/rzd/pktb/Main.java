package com.rzd.pktb;

import com.rzd.pktb.SPSTournament.arbitr;
import com.rzd.pktb.SPSTournament.playersLoader;


public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //В файле players лежит список участников
        arbitr a = new arbitr(new playersLoader("players").getPlayers());
        //Сыграть по 100 конов между каждым участником
        System.out.println(a.playAllVsAll(100).getMainStatistics());
    }
}
