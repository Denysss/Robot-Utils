package com.testassistant;

import com.testassistant.Shortcuts;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShortcutsTest {

    @Test(dataProvider = "getShortcuts")
    public void Shortcuts_defined(Shortcuts shortcuts) {
        Assert.assertNotNull(shortcuts.get(), "Verify that keyCodes are defined for all shortcuts");
    }

    @Test(dataProvider = "getShortcuts")
    public void Shortcuts_length(Shortcuts shortcuts) {
        int expectedLength = 2;
        Assert.assertEquals(shortcuts.get().length, expectedLength, "Verify number of keyCodes in all shortcuts");
    }

    @DataProvider
    public Object[][] getShortcuts() {
        Object[][] shortcuts = new Object[Shortcuts.values().length][1];

        for (int i = 0; i < Shortcuts.values().length; i++) {
            shortcuts[i][0] = Shortcuts.values()[i];
        }

        return shortcuts;
    }
}
