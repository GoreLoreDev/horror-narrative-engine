package model;


public class Choice {

    private int id;
    private String choiceText;
    private Scene nextScene;

    public Choice() {
    }

    public Choice(int id, String choiceText, Scene nextScene) {
        this.id = id;
        this.choiceText = choiceText;
        this.nextScene = nextScene;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public Scene getNextScene() {
        return nextScene;
    }

    public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", choiceText='" + choiceText + '\'' +
                '}';
    }
}