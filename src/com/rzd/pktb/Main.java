package com.rzd.pktb;

import com.rzd.pktb.SPSGame.SPSStep;
import com.rzd.pktb.SPSGame.gameSPS;
import com.rzd.pktb.SPSTournament.arbitr;
import com.rzd.pktb.SPSTournament.playersLoader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        arbitr a = new arbitr(new playersLoader("players").getPlayers());
        System.out.println(a.playAllVsAll(10).getMainStatistics());
    }
}
