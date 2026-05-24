package app;

import model.Choice;
import model.Scene;
import model.Story;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Story story = createStory();

        playStory(story);
    }


    public static Story createStory() {
        Story story = new Story();
        story.setTitle("The Cabin in Blackwood Forest");

        story.setDescription(
                "A branching horror story about a cursed cabin."
        );
        Scene introScene = new Scene();

        introScene.setTitle("Abandoned Cabin");

        introScene.setContent(
                "You enter a cold abandoned cabin deep in the forest."
        );

        introScene.setStory(story);

        Scene basementScene = new Scene();

        basementScene.setTitle("Dark Basement");

        basementScene.setContent(
                "The basement smells like rotten flesh."
        );

        basementScene.setStory(story);

        Scene escapeScene = new Scene();

        escapeScene.setTitle("Forest Escape");

        escapeScene.setContent(
                "You sprint back into the forest while something follows you."
        );

        escapeScene.setStory(story);

        Choice basementChoice = new Choice();

        basementChoice.setChoiceText(
                "Open the basement door"
        );

        basementChoice.setNextScene(
                basementScene
        );

        List<Scene> scenes = new ArrayList<>();
        scenes.add(introScene);

        scenes.add(basementScene);

        scenes.add(escapeScene);

        story.setScenes(scenes);

        story.setStartingScene(introScene);


        Choice runChoice = new Choice();

        runChoice.setChoiceText(
                "Run outside"
        );

        runChoice.setNextScene(
                escapeScene
        );


        List<Choice> introChoices =
                new ArrayList<>();

        introChoices.add(basementChoice);

        introChoices.add(runChoice);


        introScene.setChoices(introChoices);

        return story;
    }

    public static void displayScene(Scene scene) {

        System.out.println("\nSCENE:");

        System.out.println(scene.getTitle());

        System.out.println(scene.getContent());

        if (scene.getChoices() == null ||
                scene.getChoices().isEmpty()) {

            System.out.println("\nTHE END");

            return;
        }

        System.out.println("\nCHOICES:");

        for (int i = 0;
             i < scene.getChoices().size();
             i++) {

            Choice choice =
                    scene.getChoices().get(i);

            System.out.println(
                    (i + 1) + ". " +
                            choice.getChoiceText()
            );
        }
    }

    public static void playStory(Story story) {
        Scanner sc = new Scanner(System.in);


        Scene currentScene = story.getStartingScene();

        while (currentScene != null) {

            displayScene(currentScene);

            if (currentScene.getChoices() == null ||
                    currentScene.getChoices().isEmpty()) {

                break;
            }

            System.out.println("\nChoose an option:");

            int userChoice = sc.nextInt();

            if (userChoice < 1 ||
                    userChoice > currentScene.getChoices().size()) {

                System.out.println("Invalid choice.");
                return;
            }

            Choice selectedChoice =
                    currentScene.getChoices().get(userChoice - 1);

            Scene nextScene =
                    selectedChoice.getNextScene();

            currentScene = nextScene;
        }
    }
}