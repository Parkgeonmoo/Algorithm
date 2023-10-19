
import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Task> pq = new PriorityQueue<>((e1, e2) -> e1.start - e2.start);
        for(String[] plan : plans){
            String[] time = plan[1].split(":");
            int hour = Integer.parseInt(time[0]) * 60;
            int minute = Integer.parseInt(time[1]);
            pq.add(new Task(plan[0], hour + minute, Integer.parseInt(plan[2])));
        }

        Stack<Task> stack = new Stack<>();
        ArrayDeque<Task> q = new ArrayDeque<>();
        int now = 0;
        int index = 0;
        String[] result = new String[plans.length];
        while(!pq.isEmpty() || !stack.isEmpty()){
            //현재 작업중인 과제가 없다면 -> 현재 과제를 채움
            if(q.isEmpty()){
                //pq만 없다면
                if(pq.isEmpty()){
                    q.add(stack.pop());
                    //스택만 없다면
                }else if(stack.isEmpty()){
                    Task t = pq.poll();
                    now = t.start;
                    q.add(t);
                    //pq와 stack 둘다 있다면
                }else{
                    if(now >= pq.peek().start){
                        q.add(pq.poll());
                    }else{
                        q.add(stack.pop());
                    }
                }
            }
            //현재 작업중인 과제가 있다면 -> 현재 과제를 비움
            else{
                //pq가 비었거나 현재 작업을 완료해도 다음작업 시작시간이 안된경우
                if(pq.isEmpty() || now + q.peek().playtime <= pq.peek().start){
                    Task t = q.poll();
                    result[index++] = t.name;
                    now += t.playtime;
                }else{
                    Task t = q.poll();
                    t.playtime -= (pq.peek().start - now);
                    stack.push(t);
                    now = pq.peek().start;
                }
            }
        }
        result[index] = q.poll().name;
        return result;
    }

    static class Task{
        String name;
        int start, playtime;
        public Task(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}



