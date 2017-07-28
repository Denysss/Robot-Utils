package com.testassistant;

import java.awt.event.KeyEvent;

public enum Shortcuts {

    COPY_TO_CLIPBOARD, CUT_TO_CLIPBOARD, PASTE_FROM_CLIPBOARD, SELECT_ALL;

    static {
        if (OS.IS_WINDOWS) {
            COPY_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_C }); // Ctrl+C
            CUT_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_X }); // Ctrl+X
            PASTE_FROM_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_V }); // Ctrl+V
            SELECT_ALL.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_A }); // Ctrl+A
        } else if (OS.IS_MAC) {
            COPY_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_C }); // Meta+C
            CUT_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_X }); // Meta+X
            PASTE_FROM_CLIPBOARD.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_V }); // Meta+V
            SELECT_ALL.set(new int[] { KeyEvent.VK_META, KeyEvent.VK_A }); // Meta+A
        } else if (OS.IS_LINUX) {
            COPY_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_C }); // Ctrl+C
            CUT_TO_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_X }); // Ctrl+X
            PASTE_FROM_CLIPBOARD.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_V }); // Ctrl+V
            SELECT_ALL.set(new int[] { KeyEvent.VK_CONTROL, KeyEvent.VK_A }); // Ctrl+A
        } else {
            COPY_TO_CLIPBOARD.set(new int[] {});
            CUT_TO_CLIPBOARD.set(new int[] {});
            PASTE_FROM_CLIPBOARD.set(new int[] {});
            SELECT_ALL.set(new int[] {});
        }
    }

    private int[] shortcut;

    private void set(int[] shortcut) {
        this.shortcut = shortcut;
    }

    public int[] get() {
        return shortcut;
    }
}
