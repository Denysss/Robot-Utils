package com.testassistant;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class RobotUtils {

    private static Robot robot;
    private static final int DEFAULT_AUTO_DELAY = 50; // milliseconds
    private static final boolean DEFAULT_AUTO_WAIT_FOR_IDLE = true;

    private RobotUtils() {

    }

    public static void setCustomRobot(Robot awtRobot) {
        if (awtRobot == null) {
            throw new NullPointerException("Custom AWT Robot was not provided");
        }

        robot = awtRobot;
    }

    public static void setDefaultRobot() {
        robot = null;
        // init() will be done in a following method that client calls
    }

    public static void setAutoDelay(int delay) {
        init();
        robot.setAutoDelay(delay);
    }

    public static int getAutoDelay() {
        init();
        return robot.getAutoDelay();
    }

    public static void setAutoWaitForIdle(boolean isOn) {
        init();
        robot.setAutoWaitForIdle(isOn);
    }

    public static boolean isAutoWaitForIdle() {
        init();
        return robot.isAutoWaitForIdle();
    }

    public static void delay(int ms) {
        init();
        robot.delay(ms);
    }

    public static void sendKeys(int keyCode) {
        init();
        sendKey(keyCode);
    }

    public static void sendKeys(String text) {
        init();
        for(char c : text.toCharArray()) {
            sendKey(c);
        }
    }

    public static void sendKeys(int keyCode, int numberTimes) {
        init();
        for (int i = 0; i < numberTimes; i++) {
            sendKey(keyCode);
        }
    }

    public static void sendKeys(String text, int numberTimes) {
        init();
        for (int i = 0; i < numberTimes; i++) {
            for(char c : text.toCharArray()) {
                sendKey(c);
            }
        }
    }

    public static void sendShortcutKeys(Shortcuts shortcut) {
        // init() will be done in sendShortcutKeys(int[])
        sendShortcutKeys(shortcut.get());
    }

    public static void sendShortcutKeys(int[] keyCodes) {
        init();

        // It's required for the event to be registered
        sendKey(keyCodes[0]);

        // Press the sequence of keyCodes
        for (int keyCode : keyCodes) {
            robot.keyPress(keyCode);
        }

        // Release the sequence of keyCodes
        for (int i = keyCodes.length - 1; i >= 0; i--) {
            robot.keyRelease(keyCodes[i]);
        }
    }

    public static boolean isKeyLocked(int keyCode) {
        return Toolkit.getDefaultToolkit().getLockingKeyState(keyCode);
    }

    public static void paste(String text) {
        init();

        // Put text to clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, stringSelection);

        // Paste text from clipboard
        sendShortcutKeys(Shortcuts.PASTE_FROM_CLIPBOARD);
    }

    public static void sendMouseKeys(int mouseButtonCode) {
        init();
        sendMouseKey(mouseButtonCode);
    }

    public static void sendMouseKeys(int mouseButtonCode, int numberTimes) {
        init();
        for (int i = 0; i < numberTimes; i++) {
            sendMouseKey(mouseButtonCode);
        }
    }

    public static void moveMouse(int x, int y) {
        init();
        robot.mouseMove(x, y);
    }

    public static void wheelMouse(int wheelAmt) {
        init();
        robot.mouseWheel(wheelAmt);
    }

    private static void init() {
        if (robot == null) {
            try {
                // Init new instance of AWT Robot class
                robot = new Robot();

                // Set a delay in milliseconds after each Robot's event
                robot.setAutoDelay(DEFAULT_AUTO_DELAY);

                // Set value if Robot will call waitForIdle after each Robot's event
                robot.setAutoWaitForIdle(DEFAULT_AUTO_WAIT_FOR_IDLE);
            } catch (AWTException e) {
                // TODO Log AWTException
                e.printStackTrace();
            }
        }
    }

    private static void sendKey(int keyCode) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    private static void sendKey(char c) {
        sendKey(KeyStroke.getKeyStroke(c, 0).getKeyCode());
    }

    private static void sendMouseKey(int mouseKeyCode) {
        robot.mousePress(mouseKeyCode);
        robot.mouseRelease(mouseKeyCode);
    }
}
