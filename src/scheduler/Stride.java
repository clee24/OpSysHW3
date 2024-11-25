package scheduler;

public class Stride {
    int strideConstant = 10000;

    int tixToStride (Process process) {
        int tickets = process.getTickets();
        int stride = strideConstant / tickets;
        return stride;
    }


}

// New class for jobs that use stride scheduling that can keep track of their stride lengths and amount of stride they have
class strideProcess extends Process {
    // Value of each stride for this job
    public int Stride;
    // Total value made up by the number of strides taken by the job
    public int strideCount;

    public int getStride() {
        return Stride;
    }

    public void addStride() {
        strideCount += Stride;
    }
}