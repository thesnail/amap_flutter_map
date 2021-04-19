import 'package:amap_flutter_base/amap_flutter_base.dart';
import 'package:flutter/material.dart';
import 'base_overlay.dart';

///绘制圆,圆是由中心点（经纬度）和半径（米）构成。
class Circle extends BaseOverlay {
  Circle({
    @required this.position,
    @required this.radius,
    double lineWidth = 1,
    this.strokeColor = const Color(0xCC00BFFF),
    this.fillColor = const Color(0xC487CEFA),
  }) : assert(position != null), assert(position != null),
  this.lineWidth =
            lineWidth == null ? 1 : (lineWidth <= 0 ? 1 : lineWidth),
  super();

  /// 位置,不能为空
  final LatLng position;

  /// 绘制圆的半径
  final double radius;
  
  /// 边框宽度,单位为逻辑像素，同Android中的dp，iOS中的point
  final double lineWidth;
  /// 边框颜色,默认值为(0xCCC4E0F0)
  final Color strokeColor;
  /// 填充颜色,默认值为(0xC4E0F0CC)
  final Color fillColor;

  Circle copyWith({
    double positionParam,
    double radiusParam,
    double lineWidthParam,
    Color strokeColorParam,
    Color fillColorParam,
  }){
    Circle copyCircle = Circle(
      position: positionParam ?? position,
      radius: radiusParam?? radius,
      lineWidth: lineWidthParam ?? lineWidth,
      strokeColor: strokeColorParam ?? strokeColor,
      fillColor: fillColorParam ?? fillColor,
    );
    copyCircle.setIdForCopy(id);
    return copyCircle;
  }
  
  Circle clone() => copyWith();

  @override
  Map<String, dynamic> toMap() {
    final Map<String, dynamic> json = <String, dynamic>{};

    void addIfPresent(String fieldName, dynamic value) {
      if (value != null) {
        json[fieldName] = value;
      }
    }

    addIfPresent('id', id);
    addIfPresent('position', position?.toJson());
    addIfPresent('radius', radius);
    addIfPresent('lineWidth', lineWidth);
    addIfPresent('strokeColor', strokeColor?.value);
    addIfPresent('fillColor', fillColor?.value);
    return json;
  }

@override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    if (other.runtimeType != runtimeType) return false;
    final Circle typedOther = other;
    return id == typedOther.id &&
      position == typedOther.position &&
      lineWidth == typedOther.lineWidth &&
      strokeColor == typedOther.strokeColor &&
      fillColor == typedOther.fillColor &&
      radius == typedOther.radius;
  }


  @override
  int get hashCode => super.hashCode;

  @override
  String toString() {
    return 'Circle{id: $id, position: $position'
        'radius: $radius, lineWidth: $lineWidth}';
  }
}


Map<String, Circle> keyByCircleId(Iterable<Circle> circles) {
  if (circles == null) {
    return <String, Circle>{};
  }
  return Map<String, Circle>.fromEntries(circles.map(
      (Circle circle) => MapEntry<String, Circle>(circle.id, circle.clone())));
}