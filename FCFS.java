import java.util.*;
public class FCFS implements DiskScheduler{
	ArrayList<Integer> queue;
	int headPos, headmvmt;
	public FCFS(ArrayList<Integer> queue, int headPos){
		this.queue = queue;
		this.headPos = headPos;
	}
	public int serviceRequests(){
		System.out.print("\nProcessing order:\n\n" + headPos);
		while (queue.size() > 0) {
			int nextHeadPos = 0;
			headmvmt += Math.abs(headPos - queue.get(nextHeadPos));
			headPos = queue.get(nextHeadPos);
			System.out.print(" -> " + headPos);
			queue.remove(nextHeadPos);
		}
		return headmvmt;
    }
}
