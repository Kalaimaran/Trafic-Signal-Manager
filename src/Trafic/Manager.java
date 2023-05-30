package Trafic;
import java.util.List;

class Manager extends Thread {
	int n;
     List<Signals> t;
    int startIndex;

    public Manager(int n,List<Signals> t,int index ) {
        this.n=n;
        this.t=t;
        startIndex = index;
        t.get(startIndex).setSignalState("G");
    }
    public Manager() {
    	
    }
    public void print() {
        for (Signals signal : t) {
            System.out.println(signal.getId() + " -> " + signal.getSignalState());
        }
        System.out.println();
    }
    public void timeUpdate() {
        int time=t.get(startIndex).getTimer();
        time-=1;
        if (time == 10) {
            t.get(startIndex).setSignalState("O");
        } else if (time == 0) {
        	t.get(startIndex).setSignalState("R");
            time = 60;
        }
        t.get(startIndex).setTimer(time);
    }
    public void run() {
    	while (true) {
            try {
                Thread.sleep(1000);
                timeUpdate();
                if (t.get(startIndex).getSignalState().equals("R"))
                {
                    t.get(startIndex).setSignalState("R");
                    startIndex = (startIndex + 1);
                    if(startIndex>= n)
                    	startIndex=0;
                    t.get(startIndex).setSignalState("G");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    	
    }
}