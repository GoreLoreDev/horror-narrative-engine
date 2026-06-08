package model;


public class ValidationReport {
    private int brokenLinks;

    private int unreachableScenes;

    private int cyclesDetected;

    public int getBrokenLinks() {
        return brokenLinks;
    }

    public void setBrokenLinks(int brokenLinks) {
        this.brokenLinks = brokenLinks;
    }

    public int getUnreachableScenes() {
        return unreachableScenes;
    }

    public void setUnreachableScenes(int unreachableScenes) {
        this.unreachableScenes = unreachableScenes;
    }

    public int getCyclesDetected() {
        return cyclesDetected;
    }

    public void setCyclesDetected(int cyclesDetected) {
        this.cyclesDetected = cyclesDetected;
    }
    @Override
    public String toString() {

        String status =
                (brokenLinks == 0
                        && unreachableScenes == 0)
                        ? "VALID"
                        : "INVALID";

        return "\nValidation Report\n"
                + "-----------------\n"
                + "Broken Links: "
                + brokenLinks + "\n"
                + "Unreachable Scenes: "
                + unreachableScenes + "\n"
                + "Cycles Detected: "
                + cyclesDetected + "\n"
                + "Status: "
                + status;
    }
}
