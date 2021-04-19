package com.amap.flutter.map.overlays.circle;

import com.amap.api.maps.model.AMapPara;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;

public class CircleController implements CircleOptionsSink{

    final Circle circle;
    final String circleId;

    CircleController(Circle circle) {
        this.circle = circle;
        this.circleId = circle.getId();
    }

    public String getCircleId() {
        return circleId;
    }

    public void remove() {
        if(null != circle) {
            circle.remove();
        }
    }

    @Override
    public void setPosition(LatLng position) {
        circle.setCenter(position);
    }

    @Override
    public void setRadius(double radius) {
        circle.setRadius(radius);
    }

    @Override
    public void setLineWidth(float lineWidth) {
        circle.setStrokeWidth(lineWidth);
    }

    @Override
    public void setStrokeColor(Integer strokeColor) {
        circle.setStrokeColor(strokeColor);
        circle.setStrokeDottedLineType(AMapPara.DOTTEDLINE_TYPE_CIRCLE);
    }

    @Override
    public void setFillColor(Integer fillColor) {
        circle.setFillColor(fillColor);
    }
}
