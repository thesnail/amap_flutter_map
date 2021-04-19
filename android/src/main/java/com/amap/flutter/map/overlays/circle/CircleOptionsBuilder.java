package com.amap.flutter.map.overlays.circle;

import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolylineOptions;

public class CircleOptionsBuilder implements CircleOptionsSink {

    final CircleOptions circleOptions;

    CircleOptionsBuilder() {
        circleOptions = new CircleOptions();
    }

    @Override
    public void setPosition(LatLng position) {
        circleOptions.center(position);
    }

    @Override
    public void setRadius(double radius) {
        circleOptions.radius(radius);
    }

    @Override
    public void setLineWidth(float lineWidth) {
        circleOptions.strokeWidth(lineWidth);
    }

    @Override
    public void setStrokeColor(Integer strokeColor) {
        circleOptions.strokeColor(strokeColor);
    }

    @Override
    public void setFillColor(Integer fillColor) {
        circleOptions.fillColor(fillColor);
    }

    public CircleOptions build(){
        return circleOptions;
    }
}
