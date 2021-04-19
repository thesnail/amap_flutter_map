//
//  AMapCircle.h
//  amap_flutter_map
//
//  Created by Scott Wang on 2021/4/17.
//

#import <Foundation/Foundation.h>
#import <CoreLocation/CoreLocation.h>
#import <MAMapKit/MAMapKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface AMapCircle : NSObject

@property (nonatomic, copy) NSString *id_;

@property (nonatomic, assign) CLLocationCoordinate2D position;

/// 显示的半径
@property (nonatomic, assign) CGFloat radius;

/// 边框宽度
@property (nonatomic, assign) CGFloat lineWidth;

/// 边框颜色
@property (nonatomic, strong) UIColor *strokeColor;

/// 填充颜色
@property (nonatomic, strong) UIColor *fillColor;

/// 由以上数据生成的Circle对象
@property (nonatomic, strong,readonly) MACircle *circle;

@end

NS_ASSUME_NONNULL_END
