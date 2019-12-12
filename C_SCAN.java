import java.util.*;
public class C_SCAN implements DiskScheduler{
	ArrayList<Integer> queue;
	int headPos, headmvmt, last_track = 199;
	public C_SCAN(ArrayList<Integer> queue, int headPos){
		this.queue = queue;
		this.headPos = headPos;
		queue.add(headPos);
    }
	public int serviceRequests(){
		int i = 0, j = 0, temp;
		for (i = 0; i<queue.size(); i++){
			for (j = 0; j <queue.size() - 1; j++){
				if (queue.get(j) >queue.get(j + 1)){
					temp = queue.get(j);
					queue.set(j, queue.get(j + 1));
					queue.set(j + 1, temp);
				}
            }
        }
		for (i = 0; i<queue.size(); i++){
			if (queue.get(i) == headPos){
				break;
            }
        }
		System.out.print("\nProcessing order:\n\n" + headPos);
		queue.remove(i);
		for (int x = i - 1; x >= 0; x--){
			headmvmt += Math.abs(headPos - queue.get(x));
			headPos = queue.get(x);
			System.out.print(" -> " + headPos);
			queue.remove(x);
		}
		headmvmt += headPos+last_track;
		headPos = 199;
		System.out.print("-> 0 -> " + last_track);
		for (int x = queue.size()-1; x >= 0; x--){
			headmvmt += Math.abs(queue.get(x)-headPos);
			headPos = queue.get(x);
			System.out.print(" -> " + headPos);
        }
		queue.clear();
		return headmvmt;
    }
}