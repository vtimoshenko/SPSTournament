package com.rzd.pktb;

import com.rzd.pktb.SPSTournament.arbitr;
import com.rzd.pktb.SPSTournament.playersLoader;

public class Main {

    public static void main(String[] args) {
        arbitr a = new arbitr(new playersLoader("players").getPlayers());
        System.out.println(a.playAllVsAll(10).getMainStatistics());
    }
}
