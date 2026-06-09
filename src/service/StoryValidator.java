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

    private void detectCycles(//to detect whether the same scene is active in the current iteration or no
            Scene scene,
            Set<String> visited,
            Set<String> recursionStack,
            ValidationReport report
    ) {

        if (scene == null) {

            return;
        }

        if (recursionStack.contains(
                scene.getSceneId()
        )) {

            report.setCyclesDetected(
                    report.getCyclesDetected() + 1
            );

            report.getWarnings().add(
                    "Cycle detected involving scene: "
                            + scene.getSceneId()
            ); //using recursion stack, to detect active DFS path RIGHT NOW not labeling it as "visited"(fully explored)

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

        recursionStack.add(
                scene.getSceneId()
        );

        for (Choice choice :
                scene.getChoices()) {

            detectCycles(
                    choice.getNextScene(),
                    visited,
                    recursionStack,
                    report
            );

        }

        recursionStack.remove(
                scene.getSceneId()
        );//done exploring this DFS branch

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
