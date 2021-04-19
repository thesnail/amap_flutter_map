package com.amap.flutter.map.overlays.circle;

import com.amap.api.maps.model.LatLng;

public interface CircleOptionsSink {

    //绘制点
    void setPosition(LatLng position);

    //圆的半径
    void setRadius(double radius);

    // 边框的宽度
    void setLineWidth(float lineWidth);

    //边框的颜色
    void setStrokeColor(Integer strokeColor);

    //边框的颜色
    void setFillColor(Integer fillColor);
}
