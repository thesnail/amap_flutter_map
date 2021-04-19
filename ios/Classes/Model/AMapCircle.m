//
//  AMapCircle.m
//  amap_flutter_map
//
//  Created by Scott Wang on 2021/4/17.
//

#import "AMapCircle.h"
#import "MACircle+Flutter.h"

@interface AMapCircle ()

@property (nonatomic, strong,readwrite) MACircle *circle;

@end

@implementation AMapCircle

- (instancetype)init {
    self = [super init];
    if (self) {}
    return self;
}

- (MACircle *)circle {
    if (_circle == nil) {
        _circle = [[MACircle alloc] initWithCircleId:self.id_];
    }
    return _circle;
}

@end
