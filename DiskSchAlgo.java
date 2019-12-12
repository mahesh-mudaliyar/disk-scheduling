import java.io.*;
import java.util.*;
public class DiskSchAlgo{
	public static void main(String[] args) throws Exception{
		int headmvmt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter disk frame sequence(separated by space): ");
        Scanner input = new Scanner(br.readLine());
		ArrayList<Integer> queue = new ArrayList<>();
		while (input.hasNextInt()) 
		{
			queue.add(input.nextInt());
		}
		System.out.print("\nEnter disk scheduling algorithm(1=FCFS,2=SSTF,3=SCAN,4=C-SCAN,5=LOOK): ");
		int dsa = Integer.parseInt(br.readLine());
		System.out.print("\nEnter starting track number : ");
		int headPos = Integer.parseInt(br.readLine());
		if(dsa==1)
			headmvmt = new FCFS(queue, headPos).serviceRequests();
		else if(dsa==2)
			headmvmt = new SSTF(queue, headPos).serviceRequests();
		else if(dsa==3)
			headmvmt = new SCAN(queue, headPos).serviceRequests();
		else if(dsa==4)
			headmvmt = new C_SCAN(queue, headPos).serviceRequests();
		else if(dsa==5)
			headmvmt = new LOOK(queue, headPos).serviceRequests();
		else
			System.out.println("Enter appropriate no. as shown above.");	
		System.out.println("\n\n" + headmvmt + " cylinders traversed.");
	}
}
