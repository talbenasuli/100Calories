package com.example.talbe.a100calories.Main.Main.Models;

class Model {

    // Parameters:
    private static final Model ourInstance = new Model();

    // Constractors:
    private Model() {
    }

    // Functions:
    static Model getInstance() {
        return ourInstance;
    }
}
