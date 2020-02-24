package fr.oukonmange.data.test.entity;


import fr.oukonmange.data.entity.Bus;
import fr.oukonmange.data.entity.User;
import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsForAll;

public class EntityTest {

    @Test
    public void getterAndSetterCorrectness() throws Exception {

        final Class[] classesUnderTest = {Bus.class, User.class};

        assertPojoMethodsForAll(classesUnderTest).testing(Method.GETTER, Method.SETTER).areWellImplemented();
    }
}