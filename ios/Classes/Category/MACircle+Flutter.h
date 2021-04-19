//
//  MACircle+Flutter.h
//  amap_flutter_map
//
//  Created by Scott Wang on 2021/4/17.
//

#import <Foundation/Foundation.h>
#import <MAMapKit/MAMapKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface MACircle(Flutter)

@property (nonatomic,copy,readonly) NSString *circleId;

/// 使用circleId初始化对应的MACircle
/// @param circleId circle的唯一标识
- (instancetype)initWithCircleId:(NSString *)circleId;

@end

NS_ASSUME_NONNULL_END
