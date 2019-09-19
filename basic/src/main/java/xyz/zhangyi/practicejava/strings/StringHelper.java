package xyz.zhangyi.practicejava.strings;

public class StringHelper {
    private final StringBuffer sb;

    private StringHelper() {
        sb = new StringBuffer();
    }

    public static StringHelper toStringHelper(Object obj) {
        StringHelper stringHelper = new StringHelper();
        stringHelper.appendClassName(obj);
        return stringHelper;
    }

    public StringHelper add(String fieldName, Object fieldValue) {
        sb.append(String.format("%s: %s\n", fieldName, fieldValue));
        return this;
    }

    private void appendClassName(Object obj) {
        sb.append(String.format("Class is %s\n", obj.getClass().getTypeName()));
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
