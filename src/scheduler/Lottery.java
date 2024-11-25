package scheduler;

import java.util.Random;

public class Lottery {

    private Random rand = new Random();
    private int totalTickets;

    public Lottery() {
        totalTickets = 0;
    }

    public void calculateTotalTickets(Process[] processes) {
        totalTickets = 0;
        for (Process p : processes) {
            if (!p.isFinished()) {
                totalTickets += p.getTickets();
            }
        }
    }

    public Process pickWinner(Process[] processes) {
        calculateTotalTickets(processes);

        if (totalTickets == 0) {
            return null;
        }

        int winningTicket = rand.nextInt(totalTickets) + 1;

        int ticketSum = 0;
        
        for (Process p : processes) {
            if (!p.isFinished()) {
                ticketSum += p.getTickets();
                if (ticketSum >= winningTicket) {
                    return p;
                }
            }
        }

        return null;
    }
}

class LotteryProcess extends Process {

    public LotteryProcess(int minLength, int maxLength,
                          int earliestArrival, int latestArrival,
                          int minTickets, int maxTickets) {
        super(minLength, maxLength, earliestArrival, latestArrival, minTickets, maxTickets);
    }
}
