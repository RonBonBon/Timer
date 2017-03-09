package com.arichafamily.java;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

    class GamePlay {
        private Timer timer;
        private Team mcb = new Team();
        private Team jru = new Team();
        private int mcbScore = 0;
        private int jruScore = 0;

    GamePlay() {
        //Creating Macabi Fox Tel-Aviv Team
        mcb.addPlayer(new DefencePlayer("Yuval Zusman", 67));
        mcb.addPlayer(new DefencePlayer("Trevor Mbakwe", 56));
        mcb.addPlayer(new OffencePlayer("Guy Pnini", 49, 39));
        mcb.addPlayer(new OffencePlayer("Yogev Ohayon", 38, 35));
        mcb.addPlayer(new OffencePlayer("Taylor Rochestie", 44, 41));

        //Creating Hapoel Bank Yahav Jerusalem Team
        jru.addPlayer(new DefencePlayer("D'or Fischer", 69));
        jru.addPlayer(new DefencePlayer("Lior Eliyahu", 51));
        jru.addPlayer(new OffencePlayer("Yotam Halperin", 58,57));
        jru.addPlayer(new OffencePlayer("Bar Timor", 52,44));
        jru.addPlayer(new OffencePlayer("E. J. Rowland", 48,38));

        timer = new Timer();
        timer.schedule(new RemindTask(),0,1000);

    }

        class RemindTask extends TimerTask {
        int numOfShots = 20;
        public void run() {
            if (numOfShots > 0) {
                if (mcb.shoot()) mcbScore += 2;
                if (jru.shoot()) jruScore += 2;
                numOfShots--;
            } else {
                new StopTask(timer).run();
                System.out.println("\nGame Over!!!");
                System.out.println("\nMaccabi Fox Tel-Aviv scored: " + mcbScore);
                System.out.println("\nHapoel Bank Yahav Jerusalem scored: " + jruScore);
                System.out.println((mcbScore > jruScore) ? "\nMaccabi Wins" : "\nHapoel Wins");
            }
        }
    }
}
