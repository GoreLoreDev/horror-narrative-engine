package model;


import java.util.List;
import java.util.ArrayList;

public class ValidationReport {


    private int brokenLinks;

    private List <String> errors=new ArrayList<>();

    private List<String> warnings=new ArrayList<>();

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
                + status
                + "\n\nErrors:\n"
                + errors
                + "\n\nWarnings:\n"
                + warnings;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }
}
