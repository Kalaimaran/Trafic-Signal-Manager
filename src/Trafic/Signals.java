package Trafic;

class Signals {
    private String id;
    private String signalState; 
    private int timer;

    public Signals(String id) {
        this.id = id;
        this.signalState = "R";
        this.timer = 60;
    }

    public String getId() {
        return id;
    }

    public String getSignalState() {
        return signalState;
    }
    public int getTimer() {
        return timer;
    }

    public void setSignalState(String signalState) {
        this.signalState = signalState;
    }
    public void setTimer(int n) {
        this.timer = n;
    }
}