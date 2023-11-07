import java.util.*;

class Process {
    int priority;
    int index;
    
    public Process (int priority,int index) {
        this.priority = priority;
        this.index = index;
    }

}

class Solution {
    public int solution(int[] priorities, int location) {
    
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(priorities[i],i));
        }
        int playCount = 0;
        
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            boolean isMaxPriority = true;
            
             for (Process process : queue) {
                if (process.priority > current.priority) {
                    isMaxPriority = false;
                    break;
                }
            }
             if (!isMaxPriority) {
                queue.add(current);
            } else {
                playCount++;

                if (current.index == location) {
                    System.out.println(playCount);
                    break;
                }
            }
            

        }
        return  playCount ;
    }
}