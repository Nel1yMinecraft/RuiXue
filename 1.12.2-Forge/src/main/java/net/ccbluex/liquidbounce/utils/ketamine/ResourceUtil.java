package net.ccbluex.liquidbounce.utils.ketamine;

import java.awt.*;
import java.io.InputStream;

public final class ResourceUtil {

    private ResourceUtil() {
    }

    public static Font createFontTTF(final String path) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, getResourceStream(path));
        } catch (Exception ignored) {
            // TODO :: Error log
            return null;
        }
    }

    public static InputStream getResourceStream(final String path) {
        final String s = "/assets/minecraft/liquidwing/" + path;
        return ResourceUtil.class.getResourceAsStream(s);
    }
}
