package com.javalab.tutorial;

import com.javalab.tutorial.utility.ChildClass;
import com.javalab.tutorial.utility.ParentClass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Test
    public void whenUpcastingObjects_thenObjectsShouldBehaveCorrectly() {
        ParentClass parent = new ChildClass();
        parent.parentName = "Parent name";

        Assertions.assertThat(parent.getName()).isEqualTo(null);
    }

    @Test
    public void whenDowncastingObjects_thenObjectsShouldBehaveCorrectly() {
        ParentClass parent = new ChildClass();
        ChildClass child = (ChildClass) parent;

        child.childName = "Child name";
        Assertions.assertThat(parent.getName()).isEqualTo("Child name");
    }
}