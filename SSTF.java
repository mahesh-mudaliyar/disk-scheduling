import java.util.*;
public class SSTF implements DiskScheduler{
	ArrayList<Integer> queue;
	int headPos, headmvmt;
	public SSTF(ArrayList<Integer> queue, int headPos){
		this.queue = queue;
		this.headPos = headPos;
	}
	public int serviceRequests(){
		System.out.print("\nProcessing order:\n\n" + headPos);
		while (queue.size() > 0){
			int closestPos = 0;
			for (int j = 1; j <queue.size(); j++) {
				if (Math.abs(headPos - queue.get(j)) < Math.abs(headPos - queue.get(closestPos))){
					closestPos = j;
				}
			}
			headmvmt += Math.abs(headPos - queue.get(closestPos));
			headPos = queue.get(closestPos);
			System.out.print(" -> " + headPos);
			queue.remove(closestPos);
			}
		return headmvmt;
	}
}
