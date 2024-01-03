package com.jinkyu.tv.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Github: ImageVector
    get() {
        if (_github != null) {
            return _github!!
        }
        _github = Builder(name = "Github", defaultWidth = 23.0.dp, defaultHeight = 23.0.dp,
                viewportWidth = 23.0f, viewportHeight = 23.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(11.5f, 0.0f)
                    curveTo(5.1501f, 0.0f, 0.0f, 5.1491f, 0.0f, 11.5f)
                    curveTo(0.0f, 16.5811f, 3.2947f, 20.8917f, 7.865f, 22.4125f)
                    curveTo(8.4391f, 22.5189f, 8.625f, 22.1624f, 8.625f, 21.8596f)
                    verticalLineTo(19.7187f)
                    curveTo(5.4261f, 20.4144f, 4.76f, 18.3617f, 4.76f, 18.3617f)
                    curveTo(4.2368f, 17.0325f, 3.4826f, 16.6788f, 3.4826f, 16.6788f)
                    curveTo(2.439f, 15.9649f, 3.5621f, 15.9802f, 3.5621f, 15.9802f)
                    curveTo(4.7169f, 16.0607f, 5.3245f, 17.1657f, 5.3245f, 17.1657f)
                    curveTo(6.3499f, 18.9233f, 8.0145f, 18.4153f, 8.671f, 18.1211f)
                    curveTo(8.7735f, 17.3784f, 9.0716f, 16.8705f, 9.4012f, 16.584f)
                    curveTo(6.8473f, 16.2917f, 4.162f, 15.3055f, 4.162f, 10.9001f)
                    curveTo(4.162f, 9.6437f, 4.6115f, 8.6183f, 5.3465f, 7.8133f)
                    curveTo(5.2277f, 7.5229f, 4.8338f, 6.3528f, 5.4587f, 4.7696f)
                    curveTo(5.4587f, 4.7696f, 6.4247f, 4.461f, 8.6221f, 5.9484f)
                    curveTo(9.5393f, 5.6935f, 10.5225f, 5.566f, 11.5f, 5.5612f)
                    curveTo(12.4775f, 5.566f, 13.4617f, 5.6935f, 14.3807f, 5.9484f)
                    curveTo(16.5763f, 4.461f, 17.5404f, 4.7696f, 17.5404f, 4.7696f)
                    curveTo(18.1662f, 6.3538f, 17.7723f, 7.5239f, 17.6535f, 7.8133f)
                    curveTo(18.3914f, 8.6183f, 18.837f, 9.6447f, 18.837f, 10.9001f)
                    curveTo(18.837f, 15.317f, 16.147f, 16.2897f, 13.5863f, 16.5744f)
                    curveTo(13.9984f, 16.9309f, 14.375f, 17.6305f, 14.375f, 18.7038f)
                    verticalLineTo(21.8596f)
                    curveTo(14.375f, 22.1653f, 14.559f, 22.5247f, 15.1426f, 22.4116f)
                    curveTo(19.7091f, 20.8888f, 23.0f, 16.5792f, 23.0f, 11.5f)
                    curveTo(23.0f, 5.1491f, 17.8509f, 0.0f, 11.5f, 0.0f)
                    close()
                }
            }
        }
        .build()
        return _github!!
    }

private var _github: ImageVector? = null
