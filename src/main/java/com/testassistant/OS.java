package com.testassistant;

/**
 * OS class is used to get the current operating system. The class uses 'os.name' system property to obtain this
 * information
 */
class OS {

    private static final String OS_NAME = System.getProperty("os.name");

    static final boolean IS_LINUX = getOSMatches("Linux") || getOSMatches("LINUX");
    static final boolean IS_MAC = getOSMatches("Mac");
    static final boolean IS_WINDOWS = getOSMatches("Windows");

    private OS() {

    }

    private static boolean getOSMatches(String osNamePrefix) {
        return OS_NAME != null && OS_NAME.startsWith(osNamePrefix);
    }

}
