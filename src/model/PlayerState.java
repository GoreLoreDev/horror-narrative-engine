package model;

public class PlayerState {
    private int fearLevel;

    public PlayerState(){

    }

    public PlayerState(int fearLevel){
        this.fearLevel=fearLevel;
    }

    public int getFearLevel() {
        return fearLevel;
    }

    public void setFearLevel(int fearLevel) {
        this.fearLevel = fearLevel;
    }

    @Override
    public String toString() {
        return "PlayerState{" + "fearLevel=" + fearLevel + '}';
    }
}
