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

public val Gitlab: ImageVector
    get() {
        if (_gitlab != null) {
            return _gitlab!!
        }
        _gitlab = Builder(name = "Gitlab", defaultWidth = 24.0.dp, defaultHeight = 23.0.dp,
                viewportWidth = 24.0f, viewportHeight = 23.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFE24329)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(12.0071f, 22.132f)
                    lineTo(16.4231f, 8.541f)
                    horizontalLineTo(7.5911f)
                    lineTo(12.0071f, 22.132f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFC6D26)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(12.007f, 22.132f)
                    lineTo(7.591f, 8.541f)
                    horizontalLineTo(1.4021f)
                    lineTo(12.007f, 22.132f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFCA326)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(1.4021f, 8.541f)
                    lineTo(0.0602f, 12.6712f)
                    curveTo(-0.0622f, 13.0479f, 0.0719f, 13.4606f, 0.3923f, 13.6934f)
                    lineTo(12.0071f, 22.132f)
                    lineTo(1.4021f, 8.541f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFE24329)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(1.4022f, 8.541f)
                    horizontalLineTo(7.5911f)
                    lineTo(4.9313f, 0.3553f)
                    curveTo(4.7945f, -0.0659f, 4.1986f, -0.0658f, 4.0618f, 0.3553f)
                    lineTo(1.4022f, 8.541f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFC6D26)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(12.007f, 22.132f)
                    lineTo(16.423f, 8.541f)
                    horizontalLineTo(22.6119f)
                    lineTo(12.007f, 22.132f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFCA326)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(22.6119f, 8.541f)
                    lineTo(23.9539f, 12.6712f)
                    curveTo(24.0763f, 13.0479f, 23.9422f, 13.4606f, 23.6218f, 13.6934f)
                    lineTo(12.007f, 22.132f)
                    lineTo(22.6119f, 8.541f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFE24329)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(22.6119f, 8.541f)
                    horizontalLineTo(16.423f)
                    lineTo(19.0828f, 0.3553f)
                    curveTo(19.2196f, -0.0659f, 19.8155f, -0.0658f, 19.9523f, 0.3553f)
                    lineTo(22.6119f, 8.541f)
                    close()
                }
            }
        }
        .build()
        return _gitlab!!
    }

private var _gitlab: ImageVector? = null
