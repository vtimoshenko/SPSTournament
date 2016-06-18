package com.rzd.pktb.SPSTournament;

import com.rzd.pktb.SPSGame.SPSResult;
import com.rzd.pktb.SPSGame.SPSStep;
import com.rzd.pktb.SPSGame.gameSPS;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by SimpleUser on 18.06.2016.
 */
public class resultGame {
    private Class player1;
    private Class player2;
    private int stepPlayer1;
    private int stepPlayer2;
    private int resultPlayer1;
    private int resultPlayer2;
    private Date timestamp;
    private String identifier;

    public resultGame(Class player1, Class player2, int stepPlayer1, int stepPlayer2, int resultPlayer1, int resultPlayer2, String identifier) {
        this.player1 = player1;
        this.player2 = player2;
        this.stepPlayer1 = stepPlayer1;
        this.stepPlayer2 = stepPlayer2;
        this.resultPlayer1 = resultPlayer1;
        this.resultPlayer2 = resultPlayer2;
        this.timestamp = new Date();
        this.identifier = identifier;
    }

    public String getPlayer1() {
        return player1.getSimpleName();
    }

    public void setPlayer1(Class player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2.getSimpleName();
    }

    public void setPlayer2(Class player2) {
        this.player2 = player2;
    }

    public String getStepPlayer1() {
        return step(stepPlayer1);
    }

    public void setStepPlayer1(int stepPlayer1) {
        this.stepPlayer1 = stepPlayer1;
    }

    public String getStepPlayer2() {
        return step(stepPlayer2);
    }

    public void setStepPlayer2(int stepPlayer2) {
        this.stepPlayer2 = stepPlayer2;
    }

    public String getResultPlayer1() {
        return result(resultPlayer1);
    }

    public void setResultPlayer1(int resultPlayer1) {
        this.resultPlayer1 = resultPlayer1;
    }

    public String getResultPlayer2() {
        return result(resultPlayer2);
    }

    public void setResultPlayer2(int resultPlayer2) {
        this.resultPlayer2 = resultPlayer2;
    }

    public String getTimestamp() {
        return timestamp.toString();
    }

    public void setTimestamp() {
        this.timestamp = new Date();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


    private String step(int step) {
        try{
            Field[] fld = gameSPS.class.getDeclaredFields();
            for (Field f : fld) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(SPSStep.class) && f.getInt(new gameSPS()) == step)  return f.getName();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "UNKNOWN";
    }
    private String result(int res) {
        try{
            Field[] fld = gameSPS.class.getDeclaredFields();
            for (Field f : fld) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(SPSResult.class) && f.getInt(new gameSPS())==res)  return f.getName();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "UNKNOWN";
    }
}
