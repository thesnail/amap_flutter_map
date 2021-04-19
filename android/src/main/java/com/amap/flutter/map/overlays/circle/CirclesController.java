package com.amap.flutter.map.overlays.circle;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.flutter.map.MyMethodCallHandler;
import com.amap.flutter.map.overlays.AbstractOverlayController;
import com.amap.flutter.map.utils.Const;

import java.util.List;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class CirclesController extends AbstractOverlayController<CircleController>
        implements MyMethodCallHandler {

    private static final String CLASS_NAME = "CirclesController";

    public CirclesController(MethodChannel methodChannel, AMap amap) {
        super(methodChannel, amap);
    }

    @Override
    public void doMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        String methodId = call.method;
        switch (methodId) {
            case Const.METHOD_CIRCLE_UPDATE:
                invokeCircleOptions(call, result);
                break;
        }
    }

    private void invokeCircleOptions(MethodCall methodCall, MethodChannel.Result result) {
        if (null == methodCall) {
            return;
        }
        Object listToAdd = methodCall.argument("circlesToAdd");
        addByList((List<Object>) listToAdd);
    }

    public void addByList(List<Object> circlesToAdd) {
        if (circlesToAdd != null) {
            for (Object circleToAdd : circlesToAdd) {
                addCircle(circleToAdd);
            }
        }
    }

    private void addCircle(Object circleObj) {
        if (null != amap) {
            CircleOptionsBuilder builder = new CircleOptionsBuilder();
            String dartId = CircleUtil.interpretOptions(circleObj,builder);
            if (!TextUtils.isEmpty(dartId)) {
                CircleOptions circleOptions = builder.build();
                final Circle circle = amap.addCircle(circleOptions);
                CircleController polylineController = new CircleController(circle);
                controllerMapByDartId.put(dartId, polylineController);
                idMapByOverlyId.put(circle.getId(), dartId);
            }
        }
    }

    @Override
    public String[] getRegisterMethodIdArray() {
        return Const.METHOD_ID_LIST_FOR_CIRCLE;
    }
}
