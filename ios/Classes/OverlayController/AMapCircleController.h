//
//  AMapCircleController.h
//  amap_flutter_map
//
//  Created by Scott Wang on 2021/4/17.
//

#import <Foundation/Foundation.h>
#import <Flutter/Flutter.h>
#import <MAMapKit/MAMapKit.h>


@class AMapCircle;
NS_ASSUME_NONNULL_BEGIN

@interface AMapCircleController : NSObject

- (instancetype)init:(FlutterMethodChannel*)methodChannel
             mapView:(MAMapView*)mapView
           registrar:(NSObject<FlutterPluginRegistrar>*)registrar;


- (nullable AMapCircle *)circleForId:(NSString *)circleId;

- (void)addCircles:(NSArray*)circlesToAdd;

@end

NS_ASSUME_NONNULL_END
