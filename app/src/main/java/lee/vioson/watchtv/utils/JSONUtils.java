package lee.vioson.watchtv.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 包含操作 {@code JSON} 数据的常用方法的工具类。
 * <p/>
 * 该工具类使用的 {@code JSON} 转换引擎是 {@code Google Gson}</a>。 下面是工具类的使用案例：
 */
public class JSONUtils {
    /**
     * 空的 {@code JSON} 数据 -
     * <p/>
     * <pre>
     * &quot;{}&quot;
     * </pre>
     * <p/>
     * 。
     */
    public static final String EMPTY_JSON = "{}";

    /** 空的 {@code JSON} 数组(集合)数据 - {@code "[]"}。 */
    public static final String EMPTY_JSON_ARRAY = "[]";

    /** 默认的 {@code JSON} 日期/时间字段的格式化模式。 */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss SSS";

    /**
     * {@code Google Gson} 的 注解常用的版本号常量 - {@code 1.0}。
     */
    public static final double SINCE_VERSION_10 = 1.0d;
    /**
     * {@code Google Gson} 的 注解常用的版本号常量 - {@code 1.0}。
     */
    public static final double UNTIL_VERSION_10 = SINCE_VERSION_10;
    /**
     * {@code Google Gson} 的 注解常用的版本号常量 - {@code 1.1}。
     */
    public static final double SINCE_VERSION_11 = 1.1d;
    /**
     * {@code Google Gson} 的 注解常用的版本号常量 - {@code 1.1}。
     */
    public static final double UNTIL_VERSION_11 = SINCE_VERSION_11;
    /**
     * {@code Google Gson} 的 注解常用的版本号常量 - {@code 1.2}。
     */
    public static final double SINCE_VERSION_12 = 1.2d;
    /**
     * {@code Google Gson} 的 注解常用的版本号常量 - {@code 1.2}。
     */
    public static final double UNTIL_VERSION_12 = SINCE_VERSION_12;

    public JSONUtils() {
        super();
    }

    /**
     * 将给定的目标对象根据指定的条件参数转换成 {@code JSON} 格式的字符串。
     * <p/>
     * <strong>该方法转换发生错误时，不会抛出任何异常。若发生错误时，曾通对象返回
     * <p/>
     * <pre>
     * &quot;{}&quot;
     * </pre>
     * <p/>
     * ； 集合或数组对象返回
     * <p/>
     * <pre>
     * &quot;[]&quot;
     * </pre>
     * <p/>
     * </strong>
     *
     * @param target
     *         目标对象。
     * @param targetType
     *         目标对象的类型。
     * @param isSerializeNulls
     *         是否序列化 {@code null} 值字段。
     * @param version
     *         字段的版本号注解。
     * @param datePattern
     *         日期字段的格式化模式。
     * @param excludesFieldsWithoutExpose
     *         是否排除未标注 {@literal @Expose} 注解的字段。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, Type targetType, boolean isSerializeNulls, Double version,
                                String datePattern, boolean excludesFieldsWithoutExpose) {
        if (target == null) {
            return EMPTY_JSON;
        }
        GsonBuilder builder = new GsonBuilder();
        if (isSerializeNulls) {
            builder.serializeNulls();
        }
        if (version != null) {
            builder.setVersion(version);
        }
        if (isBlank(datePattern)) {
            datePattern = DEFAULT_DATE_PATTERN;
        }
        builder.setDateFormat(datePattern);
        if (excludesFieldsWithoutExpose) {
            builder.excludeFieldsWithoutExposeAnnotation();
        }
        return toJson(target, targetType, builder);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的
     * {@code JavaBean} 对象。</strong>
     * <ul>
     * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法会转换所有未标注或已标注 {@literal since} 的字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSS}；</li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target) {
        return toJson(target, null, false, null, null, true);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的
     * {@code JavaBean} 对象。</strong>
     * <ul>
     * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法会转换所有未标注或已标注 {@literal since} 的字段；</li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param datePattern
     *         日期字段的格式化模式。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, String datePattern) {
        return toJson(target, null, false, null, datePattern, true);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的
     * {@code JavaBean} 对象。</strong>
     * <ul>
     * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSS}；</li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param version
     *         字段的版本号注解({@literal since})。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, Double version) {
        return toJson(target, null, false, version, null, true);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的
     * {@code JavaBean} 对象。</strong>
     * <ul>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法会转换所有未标注或已标注 {@literal since} 的字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSS}；</li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param excludesFieldsWithoutExpose
     *         是否排除未标注 {@literal @Expose} 注解的字段。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, boolean excludesFieldsWithoutExpose) {
        return toJson(target, null, false, null, null, excludesFieldsWithoutExpose);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的
     * {@code JavaBean} 对象。</strong>
     * <ul>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSS}；</li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param version
     *         字段的版本号注解({@literal since})。
     * @param excludesFieldsWithoutExpose
     *         是否排除未标注 {@literal @Expose} 注解的字段。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, Double version, boolean excludesFieldsWithoutExpose) {
        return toJson(target, null, false, version, null, excludesFieldsWithoutExpose);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON}
     * 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
     * <ul>
     * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法会转换所有未标注或已标注 {@literal since} 的字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSSS}；
     * </li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param targetType
     *         目标对象的类型。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, Type targetType) {
        return toJson(target, targetType, false, null, null, true);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON}
     * 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
     * <ul>
     * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSSS}；
     * </li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param targetType
     *         目标对象的类型。
     * @param version
     *         字段的版本号注解({@literal since})。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, Type targetType, Double version) {
        return toJson(target, targetType, false, version, null, true);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON}
     * 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
     * <ul>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法会转换所有未标注或已标注 {@literal since} 的字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSS}；</li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param targetType
     *         目标对象的类型。
     * @param excludesFieldsWithoutExpose
     *         是否排除未标注 {@literal @Expose} 注解的字段。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, Type targetType, boolean excludesFieldsWithoutExpose) {
        return toJson(target, targetType, false, null, null, excludesFieldsWithoutExpose);
    }

    /**
     * 将给定的目标对象转换成 {@code JSON}
     * 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
     * <ul>
     * <li>该方法不会转换 {@code null} 值字段；</li>
     * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSS}；</li>
     * </ul>
     *
     * @param target
     *         要转换成 {@code JSON} 的目标对象。
     * @param targetType
     *         目标对象的类型。
     * @param version
     *         字段的版本号注解({@literal since})。
     * @param excludesFieldsWithoutExpose
     *         是否排除未标注 {@literal @Expose} 注解的字段。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.0
     */
    public static String toJson(Object target, Type targetType, Double version, boolean excludesFieldsWithoutExpose) {
        return toJson(target, targetType, false, version, null, excludesFieldsWithoutExpose);
    }

    /**
     * 将给定的 {@code JSON} 字符串转换成指定的类型对象。
     *
     * @param <T>
     *         要转换的目标类型。
     * @param json
     *         给定的 {@code JSON} 字符串。
     * @param token
     *         {@code com.google.gson.reflect.TypeToken} 的类型指示类对象。
     * @param datePattern
     *         日期格式模式。
     * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
     * since 1.0
     */
    public static < T > T fromJson(String json, TypeToken< T > token, String datePattern) {
        try {
            if (isBlank(json)) {
                return null;
            }
            GsonBuilder builder = new GsonBuilder();
            if (isBlank(datePattern)) {
                datePattern = DEFAULT_DATE_PATTERN;
            }
            Gson gson = builder.create();
            return gson.fromJson(json, token.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将给定的 {@code JSON} 字符串转换成指定的类型对象。
     *
     * @param <T>
     *         要转换的目标类型。
     * @param json
     *         给定的 {@code JSON} 字符串。
     * @param token
     *         {@code com.google.gson.reflect.TypeToken} 的类型指示类对象。
     * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
     * since 1.0
     */
    public static < T > T fromJson(String json, TypeToken< T > token) {
        return fromJson(json, token, null);
    }

    /**
     * 将给定的 {@code JSON} 字符串转换成指定的类型对象。<strong>此方法通常用来转换普通的
     * {@code JavaBean} 对象。</strong>
     *
     * @param <T>
     *         要转换的目标类型。
     * @param json
     *         给定的 {@code JSON} 字符串。
     * @param clazz
     *         要转换的目标类。
     * @param datePattern
     *         日期格式模式。
     * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
     * since 1.0
     */
    public static < T > T fromJson(String json, Class< T > clazz, String datePattern) {
        try {
            if (isBlank(json)) {
                return null;
            }
            GsonBuilder builder = new GsonBuilder();
            if (isBlank(datePattern)) {
                datePattern = DEFAULT_DATE_PATTERN;
            }
            Gson gson = builder.create();
            return gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将给定的 {@code JSON} 字符串转换成指定的类型对象。<strong>此方法通常用来转换普通的
     * {@code JavaBean} 对象。</strong>
     *
     * @param <T>
     *         要转换的目标类型。
     * @param json
     *         给定的 {@code JSON} 字符串。
     * @param clazz
     *         要转换的目标类。
     * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
     * since 1.0
     */
    public static < T > T fromJson(String json, Class< T > clazz) {
        return fromJson(json, clazz, null);
    }

    /**
     * 将给定的目标对象根据{@code GsonBuilder} 所指定的条件参数转换成 {@code JSON} 格式的字符串。
     * <p/>
     * 该方法转换发生错误时，不会抛出任何异常。若发生错误时，{@code JavaBean} 对象返回
     * <p/>
     * <pre>
     * &quot;{}&quot;
     * </pre>
     * <p/>
     * ； 集合或数组对象返回
     * <p/>
     * <pre>
     * &quot;[]&quot;
     * </pre>
     * <p/>
     * 。 其本基本类型，返回相应的基本值。
     *
     * @param target
     *         目标对象。
     * @param targetType
     *         目标对象的类型。
     * @param builder
     *         可定制的{@code Gson} 构建器。
     * @return 目标对象的 {@code JSON} 格式的字符串。
     * since 1.1
     */
    public static String toJson(Object target, Type targetType, GsonBuilder builder) {
        if (target == null) {
            return EMPTY_JSON;
        }
        Gson gson;
        if (builder == null) {
            gson = new Gson();
        } else {
            gson = builder.create();
        }
        String result = EMPTY_JSON;
        try {
            if (targetType == null) {
                result = gson.toJson(target);
            } else {
                result = gson.toJson(target, targetType);
            }
        } catch (Exception ex) {
            if (target instanceof Collection< ? > || target instanceof Iterator< ? > || target instanceof Enumeration< ? >
                    || target.getClass().isArray()) {
                result = EMPTY_JSON_ARRAY;
            }
        }
        return result;
    }

    private static boolean isBlank(String text) {
        return null == text || "".equals(text.trim());
    }

    /** 将指定的json数据转成 {@link java.util.HashMap}<String, Object>对象 */
    public static HashMap< String, Object > fromJson(String jsonStr) {
        try {
            if (jsonStr.startsWith("[") && jsonStr.endsWith("]")) {
                jsonStr = "{\"fakelist\":" + jsonStr + "}";
            }

            JSONObject json = new JSONObject(jsonStr);
            return fromJson(json);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return new HashMap< String, Object >();
    }

    private static HashMap< String, Object > fromJson(JSONObject json) throws JSONException {
        HashMap< String, Object > map = new HashMap< String, Object >();
        @SuppressWarnings("unchecked")
        Iterator< String > iKey = json.keys();
        while (iKey.hasNext()) {
            String key = iKey.next();
            Object value = json.opt(key);
            if (JSONObject.NULL.equals(value)) {
                value = null;
            }
            if (value != null) {
                if (value instanceof JSONObject) {
                    value = fromJson((JSONObject) value);
                } else if (value instanceof JSONArray) {
                    value = fromJson((JSONArray) value);
                }
                map.put(key, value);
            }
        }
        return map;
    }

    private static ArrayList< Object > fromJson(JSONArray array) throws JSONException {
        ArrayList< Object > list = new ArrayList< Object >();
        for (int i = 0, size = array.length(); i < size; i++) {
            Object value = array.opt(i);
            if (value instanceof JSONObject) {
                value = fromJson((JSONObject) value);
            } else if (value instanceof JSONArray) {
                value = fromJson((JSONArray) value);
            }
            list.add(value);
        }
        return list;
    }

    /** 将指定的 {@link java.util.HashMap}<String, Object>对象转成json数据 */
    public static String fromHashMap(HashMap< String, Object > map) {
        try {
            return getJSONObject(map).toString();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    private static JSONObject getJSONObject(HashMap< String, Object > map) throws JSONException {
        JSONObject json = new JSONObject();
        for (Entry< String, Object > entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof HashMap< ?, ? >) {
                value = getJSONObject((HashMap< String, Object >) value);
            } else if (value instanceof ArrayList< ? >) {
                value = getJSONArray((ArrayList< Object >) value);
            }
            json.put(entry.getKey(), value);
        }
        return json;
    }

    @SuppressWarnings("unchecked")
    private static JSONArray getJSONArray(ArrayList< Object > list) throws JSONException {
        JSONArray array = new JSONArray();
        for (Object value : list) {
            if (value instanceof HashMap< ?, ? >) {
                value = getJSONObject((HashMap< String, Object >) value);
            } else if (value instanceof ArrayList< ? >) {
                value = getJSONArray((ArrayList< Object >) value);
            }
            array.put(value);
        }
        return array;
    }

    /** 格式化一个json串 */
    public static String format(String jsonStr) {
        try {
            return format("", fromJson(jsonStr));
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    private static String format(String sepStr, HashMap< String, Object > map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        String mySepStr = sepStr + "\t";
        int i = 0;
        for (Entry< String, Object > entry : map.entrySet()) {
            if (i > 0) {
                sb.append(",\n");
            }
            sb.append(mySepStr).append('\"').append(entry.getKey()).append("\":");
            Object value = entry.getValue();
            if (value instanceof HashMap< ?, ? >) {
                sb.append(format(mySepStr, (HashMap< String, Object >) value));
            } else if (value instanceof ArrayList< ? >) {
                sb.append(format(mySepStr, (ArrayList< Object >) value));
            } else if (value instanceof String) {
                sb.append('\"').append(value).append('\"');
            } else {
                sb.append(value);
            }
            i++;
        }
        sb.append('\n').append(sepStr).append('}');
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static String format(String sepStr, ArrayList< Object > list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        String mySepStr = sepStr + "\t";
        int i = 0;
        for (Object value : list) {
            if (i > 0) {
                sb.append(",\n");
            }
            sb.append(mySepStr);
            if (value instanceof HashMap< ?, ? >) {
                sb.append(format(mySepStr, (HashMap< String, Object >) value));
            } else if (value instanceof ArrayList< ? >) {
                sb.append(format(mySepStr, (ArrayList< Object >) value));
            } else if (value instanceof String) {
                sb.append('\"').append(value).append('\"');
            } else {
                sb.append(value);
            }
            i++;
        }
        sb.append('\n').append(sepStr).append(']');
        return sb.toString();
    }
}
