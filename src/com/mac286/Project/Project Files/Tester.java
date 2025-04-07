package com.mac286.project;

import java.util.Vector;

public class Tester {

    public static void main(String[] args) {
        //create a symbol tester for AAPL
        Vector<Trade> Trades = new Vector<Trade>(3000);
        symbolTester tester = new symbolTester("AAPL", "/Users/joseortiz/Desktop/Data/" , 2);
        tester.test();
        Trades.addAll(tester.getTrades());
        tester = new symbolTester("BAC", "/Users/joseortiz/Desktop/Data/", 2);
        tester.test();
        Trades.addAll(tester.getTrades());

        for(int i= 0; i<Trades.size(); i++) {
            System.out.println(Trades.elementAt(i).toString());
        }

        //compute the average profit per trade:
        double TotalProfit = 0;
        int numWinners = 0;
        int numLongWinners = 0, numShortWinners = 0;
        int numLong = 0;
        for(int i= 0; i<Trades.size(); i++) {
            TotalProfit = Trades.elementAt(i).percentPL();
            if(Trades.elementAt(i).getDir() == Direction.LONG)
                numLong++;
            if(Trades.elementAt(i).percentPL() >= 0) {
                numWinners++;
                if(Trades.elementAt(i).getDir() == Direction.LONG)
                    numLongWinners++;
                else //short trade
                    numShortWinners++;
            }
        }
        int numShort = Trades.size() - numLong;
        double averageProfit = TotalProfit/Trades.size();
        //Compute the stats
        System.out.println("Average profit pertrade: " + TotalProfit);
        System.out.println( (double)numWinners/(double)Trades.size()*100 + "% winners");
        System.out.println("There are " + (double) numLongWinners/(double) numLong*100 + "% long winners");
        System.out.println("There are " + (double) numShortWinners/(double) numShort*100 + "% short winners");
    }

}