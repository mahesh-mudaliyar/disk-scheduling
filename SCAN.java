import java.util.*;
public class SCAN implements DiskScheduler{
	ArrayList<Integer> queue;
	int headPos, headmvmt;
	public SCAN(ArrayList<Integer> queue, int headPos){
		this.queue = queue;
		this.headPos = headPos;
		queue.add(headPos);
	}
	public int serviceRequests(){
		int i = 0, j = 0, temp;
		for (i = 0; i<queue.size(); i++){
			for (j = 0; j <queue.size() - 1; j++){
				if (queue.get(j) >queue.get(i)){
					temp = queue.get(j);
					queue.set(j, queue.get(i));
					queue.set(i, temp);
				}
			}
		}//sorting End
		for (i = 0; i<queue.size(); i++){
		if (queue.get(i) == headPos){
				break;	
			}
		}//Find headPos
		System.out.print("\nProcessing order:\n\n" + headPos);
		for (int x = i - 1; x >= 0; x--){
			headmvmt += Math.abs(headPos - queue.get(x));
			headPos = queue.get(x);
			System.out.print(" -> " + headPos);
		}
		headmvmt += headPos;
		headPos = 0;
		System.out.print(" -> " + headPos);
		for (int x = i + 1; x <queue.size(); x++){
			headmvmt += Math.abs(headPos - queue.get(x));
			headPos = queue.get(x);
			System.out.print(" -> " + headPos);
		}
		queue.clear();
		return headmvmt;
	}
}
