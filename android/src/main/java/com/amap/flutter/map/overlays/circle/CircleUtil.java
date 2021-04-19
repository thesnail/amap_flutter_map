package com.amap.flutter.map.overlays.circle;

import android.text.TextUtils;
import android.util.Log;

import com.amap.flutter.map.utils.ConvertUtil;

import java.util.Map;

public class CircleUtil {
    private static final String CLASS_NAME = "CircleUtil";

    public static String interpretOptions(Object o,CircleOptionsBuilder sink) {
        final Map<?, ?> data = ConvertUtil.toMap(o);
        final Object position = data.get("position");
        if (position != null) {
            sink.setPosition(ConvertUtil.toLatLng(position));
        }

        final Object radius = data.get("radius");
        if (radius != null) {
            sink.setRadius(ConvertUtil.toDouble(radius));
        }

        final Object lineWidth = data.get("lineWidth");
        if (lineWidth != null) {
            //sink.setLineWidth(ConvertUtil.toFloat(lineWidth));
        }

        final Object strokeColor = data.get("strokeColor");
        if (strokeColor != null) {
            sink.setStrokeColor(ConvertUtil.toInt(strokeColor));
        }

        final Object fillColor = data.get("fillColor");
        if (fillColor != null) {
            sink.setFillColor(ConvertUtil.toInt(fillColor));
        }

        final String dartId = (String) data.get("id");
        if(TextUtils.isEmpty(dartId)) {
            Log.w(CLASS_NAME, "没有传入正确的dart层ID, 请确认对应的key值是否正确！！！");
        }
        return dartId;
    }
}
