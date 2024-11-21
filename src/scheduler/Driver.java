package scheduler;

public class Driver {

    public static void main(String[] args) {
        new Driver().runCode();
    }

    JobGenerator jG = new JobGenerator();
    Process[] jobList;

    public void runCode() {
        jobList = jG.generateProcesses(27, 50, 80, 0, 50, 10, 100);

        for (int index=0; index<jobList.length; index++) {
            jobList[index].printProcess();
        }
    }
}
