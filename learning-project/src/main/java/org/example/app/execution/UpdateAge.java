package org.example.app.execution;

import org.example.app.thread.StudentAgeAdder;

public class UpdateAge {
    public UpdateAge(){
    }

    public static void ageAdding(){
        StudentAgeAdder studentAgeAdder = new StudentAgeAdder();
        studentAgeAdder.start();

    }
}
