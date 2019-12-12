import java.util.*;
public class LOOK implements DiskScheduler{
	ArrayList<Integer> queue;
	int headPos, headmvmt;
	public LOOK(ArrayList<Integer> queue, int headPos){
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
		for (int x = i - 1; x >= 0; x--){
			headmvmt += Math.abs(headPos - queue.get(x));
			headPos = queue.get(x);
			System.out.print(" -> " + headPos);
        }
		for (int x = i + 1; x <queue.size(); x++){
			headmvmt += Math.abs(headPos - queue.get(x));
			headPos = queue.get(x);
			System.out.print(" -> " + headPos);
        }
		queue.clear();
		return headmvmt;
    }
}