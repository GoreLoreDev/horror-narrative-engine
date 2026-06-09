package service;
import model.*;

import java.util.HashSet;
import java.util.Set;



public class StoryValidator {

    //using DFS to see which scenes are not connected
    private void traverseScenes(
            Scene scene,
            Set<String> visited
    ) {
        if (scene == null) {

            return;
        }
        if (visited.contains(
                scene.getSceneId()
        )) {

            return;
        }
        visited.add(
                scene.getSceneId()
        );

        for (Choice choice :
                scene.getChoices()) {

            traverseScenes(
                    choice.getNextScene(),
                    visited
            );//visit every connected scene

        }




    }

    public ValidationReport validateStory(Story story) {
        ValidationReport report =
                new ValidationReport();

        Set<String> validSceneIds =
                new HashSet<>();

        for (Scene scene :
                story.getScenes()) {

            validSceneIds.add(
                    scene.getSceneId()
            );

        }
        for (Scene scene :
                story.getScenes()) {

            for (Choice choice :
                    scene.getChoices()) {
                Scene nextScene =
                        choice.getNextScene();

                if (nextScene == null) {

                    report.setBrokenLinks(
                            report.getBrokenLinks() + 1
                    );

                    report.getErrors().add(
                            "Broken scene reference in scene: "
                                    + scene.getSceneId()
                    );
                }

            }

        }

        Set<String> visited =
                new HashSet<>();

        traverseScenes(
                story.getStartingScene(),
                visited
        );

        for (Scene scene :
             story.getScenes()) {

            if (!visited.contains(
                    scene.getSceneId()
            )) {

                report.setUnreachableScenes(
                        report.getUnreachableScenes() + 1
                );
                report.getWarnings().add(
                        "Unreachable scene: "
                                + scene.getSceneId()
                );
            }

        }
        return report;
    }

}
