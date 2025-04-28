package org.example.recources;

public class Validator {
    public static boolean validateLabWork(LabWork labWork) {
        return labWork != null
                && labWork.getName() != null
                && !labWork.getName().isEmpty()
                && labWork.getDifficulty() != null;
    }
}