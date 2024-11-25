package scheduler;

public class Driver {

    public static void main(String[] args) {
        new Driver().runCode();
    }

    JobGenerator jG = new JobGenerator();
    Process[] jobList;
    Lottery lottery = new Lottery();  // Create an instance of Lottery

    public void runCode() {
        jobList = jG.generateProcesses(27, 50, 80, 0, 50, 10, 100);

        System.out.println("Job List:");
        for (int index = 0; index < jobList.length; index++) {
            jobList[index].printProcess();
        }

        while (true) {
            Process winner = lottery.pickWinner(jobList);

            if (winner == null) {
                System.out.println("\nAll processes have finished.");
                break;
            }

            winner.runProcess();
            //winner.printProcess();
        }
    }
}
