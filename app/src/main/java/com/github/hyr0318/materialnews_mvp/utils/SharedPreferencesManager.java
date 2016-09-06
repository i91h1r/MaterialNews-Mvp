package com.github.hyr0318.materialnews_mvp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.internal.Primitives;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Juan Pablo Proverbio <proverbio@nowcreatives.co>
 *
 *  Centralises the app SharedPreferences access
 */
public class SharedPreferencesManager
{
    /**
     * The Shared Preferences file name
     */
    private static final String PREFS_FILE_NAME = "prefs";

    private SharedPreferencesManager()
    {
        super();
    }

    /**
     * Returns the value of the received key from Shared Preferences
     * @param key
     * @param returnType
     * @return
     */
    public static <T> T getPreferenceValue(Context context, String key, Class<T> returnType)
    {
        if (String.class.getSimpleName().equals(returnType.getSimpleName()))
        {
            return Primitives.wrap(returnType).cast(getSharedPreferences(context).getString(key, ""));
        }
        else if (Boolean.class.getSimpleName().equals(returnType.getSimpleName()))
        {
            return Primitives.wrap(returnType).cast(getSharedPreferences(context).getBoolean(key, false));
        }
        else if (Float.class.getSimpleName().equals(returnType.getSimpleName()))
        {
            return Primitives.wrap(returnType).cast(getSharedPreferences(context).getFloat(key, 0f));
        }
        else if (Integer.class.getSimpleName().equals(returnType.getSimpleName()))
        {
            return Primitives.wrap(returnType).cast(getSharedPreferences(context).getInt(key, 0));
        }
        else if (Long.class.getSimpleName().equals(returnType.getSimpleName()))
        {
            return Primitives.wrap(returnType).cast(getSharedPreferences(context).getLong(key, 0l));
        }

        throw new IllegalArgumentException( "This type is not supported yet." );
    }

    public static Set<String> getSetPreferenceValue(Context context, String key)
    {
        return getSharedPreferences(context).getStringSet(key, new LinkedHashSet<String>());
    }

    /**
     * Removes a shared preference value from by received key
     * @param key
     * @return
     */
    public static void removePreferenceKey(Context context, String key)
    {
        getSharedPreferences(context).edit().remove(key).commit();
    }

    /**
     * Set the value of a key from the Shared Preferences
     * @param key
     * @param value
     * @return
     */
    public static void setPreferenceValue(Context context, String key, Object value)
    {
        if (String.class.isInstance(value))
        {
            getSharedPreferences(context).edit().putString(key, (String) value).commit();
        }
        else if (Boolean.class.isInstance(value))
        {
            getSharedPreferences(context).edit().putBoolean(key, (Boolean) value).commit();
        }
        else if (Float.class.isInstance(value))
        {
            getSharedPreferences(context).edit().putFloat(key, (Float) value).commit();
        }
        else if (Integer.class.isInstance(value))
        {
            getSharedPreferences(context).edit().putInt(key, (Integer) value).commit();
        }
        else if (Long.class.isInstance(value))
        {
            getSharedPreferences(context).edit().putLong(key, (Long) value).commit();
        }
        else if (Set.class.isInstance(value))
        {
            getSharedPreferences(context).edit().putStringSet(key, (Set<String>) value).commit();
        }
    }

    public static void setPreferenceValue(Context context, String key, Set<String> value)
    {
        getSharedPreferences(context).edit().putStringSet(key, value).commit();
    }

    private static SharedPreferences getSharedPreferences(Context context)
    {
        return context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }
}
