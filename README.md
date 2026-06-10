# Story Narrative Engine

A Java-based interactive narrative engine that dynamically loads and runs branching horror stories using JSON-driven scene graphs, validation systems, runtime traversal, and persistent save/load functionality.

---

# Overview

Horror Narrative Engine is a desktop application built in Java that allows branching horror stories to be authored externally in JSON and executed dynamically at runtime.

The project focuses on:

* Object-Oriented Programming (OOP)
* Runtime graph reconstruction
* DFS graph traversal algorithms
* Validation systems
* Dynamic UI rendering
* Persistent save/load systems
* Separation of concerns
* Data-driven architecture

Instead of hardcoding stories directly into Java classes, stories are loaded from external JSON files and reconstructed into runtime scene graphs.

---

# Features

## Narrative Engine

* Branching story traversal
* Choice-driven gameplay
* Multiple endings
* Dynamic runtime scene transitions
* Fear level gameplay system
* Scene type support (NORMAL, ENDING, DEATH)

---

## JSON-Driven Story System

* External JSON story loading
* Runtime scene reconstruction
* Dynamic choice linking
* Scene graph generation
* Content-driven architecture
* Easily expandable stories without changing engine code

---

## Validation System

* Broken scene reference detection
* Unreachable scene detection
* DFS-based graph traversal
* Cycle detection
* Structured validation reporting
* Warning and error diagnostics

Example validation output:

```text
Validation Report
-----------------
Broken Links: 0
Unreachable Scenes: 1
Cycles Detected: 1
Status: INVALID
```

---

## Save / Load System

* Runtime persistence
* Save current scene
* Save player fear level
* Restore game state from JSON
* Dynamic runtime reconstruction after loading

---

## GUI System

* Java Swing desktop UI
* Dynamic button generation
* Dynamic scene rendering
* Runtime UI updates
* Persistent control panel
* Event-driven interaction system

---

# Technologies Used

* Java
* Java Swing
* Gson
* IntelliJ IDEA

---

# Project Architecture

```text
story.json
    ↓
JsonLoader
    ↓
Runtime Story Graph
    ↓
StoryValidator
    ↓
StoryEngine
    ↓
Swing GUI
```

---

# Core Engineering Concepts

This project implements several important software engineering concepts:

* Graph reconstruction
* DFS traversal
* Recursive algorithms
* Cycle detection
* State management
* Serialization / deserialization
* Runtime persistence
* Layered architecture
* Separation of concerns
* Dynamic UI rendering
* Data-driven systems

---

# Project Structure

```text
src/
│
├── app/
│   └── Main.java
│
├── model/
│   ├── Story.java
│   ├── Scene.java
│   ├── Choice.java
│   ├── PlayerState.java
│   ├── SceneType.java
│   ├── SaveData.java
│   ├── ValidationReport.java
│   ├── StoryData.java
│   ├── SceneData.java
│   └── ChoiceData.java
│
├── service/
│   ├── StoryEngine.java
│   ├── JsonLoader.java
│   ├── StoryValidator.java
│   └── SaveService.java
│
└── ui/
    └── MainWindow.java

resources/
├── story.json
└── save.json
```

---

# Example JSON Scene

```json
{
  "id": "basement",

  "title": "Dark Basement",

  "content": "The basement smells like rotten flesh.",

  "sceneType": "NORMAL",

  "fearEffect": 20,

  "choices": [
    {
      "text": "Walk deeper into the darkness",
      "nextScene": "ritual_room"
    }
  ]
}
```

---

# Save File Example

```json
{
  "currentSceneId": "basement",
  "fearLevel": 35
}
```

---

# Current Capabilities

Implemented:

* Dynamic branching narrative engine
* Runtime graph reconstruction
* JSON story loading
* Validation subsystem
* Cycle detection
* Save/load persistence
* Swing GUI
* Dynamic UI generation
* Fear level system

---

# Learning Goals

This project was built to explore:

* Java software architecture
* Runtime systems
* Graph algorithms
* GUI programming
* Persistence systems
* Validation systems
* Recursive traversal algorithms
* Data-driven application design

---

# Future Improvements

Potential future improvements:

* Story editor GUI
* Audio system
* Procedural event generation
* Better UI styling
* Story analytics
* Multiple save slots
* Undo/rollback system

---

# Screenshots

![Screenshot 2026-06-10 200024.png](..%2F..%2FOneDrive%2FPictures%2FScreenshots%2FScreenshot%202026-06-10%20200024.png)
![Screenshot 2026-06-10 195953.png](..%2F..%2FOneDrive%2FPictures%2FScreenshots%2FScreenshot%202026-06-10%20195953.png)
![Screenshot 2026-06-10 200006.png](..%2F..%2FOneDrive%2FPictures%2FScreenshots%2FScreenshot%202026-06-10%20200006.png)---
# Author

Anuran Paul
