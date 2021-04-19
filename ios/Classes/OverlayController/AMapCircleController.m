//
//  AMapCircleController.m
//  amap_flutter_map
//
//  Created by Scott Wang on 2021/4/17.
//

#import "AMapCircleController.h"
#import "AMapCircle.h"
#import "AMapJsonUtils.h"


@interface AMapCircleController ()

@property (nonatomic,strong) NSMutableDictionary<NSString*,AMapCircle*> *circleDict;
@property (nonatomic,strong) FlutterMethodChannel *methodChannel;
@property (nonatomic,strong) NSObject<FlutterPluginRegistrar> *registrar;
@property (nonatomic,strong) MAMapView *mapView;

@end

@implementation AMapCircleController

- (instancetype)init:(FlutterMethodChannel*)methodChannel
             mapView:(MAMapView*)mapView
           registrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    self = [super init];
    if (self) {
        _methodChannel = methodChannel;
        _mapView = mapView;
        _circleDict = [NSMutableDictionary dictionaryWithCapacity:1];
        _registrar = registrar;
        //__weak typeof(self) weakSelf = self;
        
    }
    return self;
}

- (AMapCircle *)circleForId:(NSString *)circleId{
    return _circleDict[circleId];
}

- (void)addCircles:(NSArray *)circlesToAdd{
    for (NSDictionary* circle in circlesToAdd) {
        AMapCircle *circleModel = [AMapJsonUtils modelFromDict:circle modelClass:[AMapCircle class]];
        // 先加入到字段中，避免后续的地图回到里，取不到对应的marker数据
        if (circleModel.id_) {
            _circleDict[circleModel.id_] = circleModel;
        }
        CLLocationCoordinate2D coordinate = [circleModel position];
        CLLocationDistance distance = circleModel.radius;
        
        MACircle *maCircle = [circleModel circle];
        [maCircle setCircleWithCenterCoordinate:coordinate radius:distance];
        [self.mapView addOverlay:maCircle];
    }
}

@end
