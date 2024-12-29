package com.binayshaw7777.repeakt.styles

import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flex
import com.varabyte.kobweb.compose.ui.modifiers.flexBasis
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.font
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.css.*

val RepeaktContainerStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .overflow(Overflow.Hidden)
        .padding(34.px, 69.px, 118.px)
}
val RepeaktTitleStyle = CssStyle.base {
    Modifier
        .color(Color.rgb(0xffffff))
        .alignSelf(AlignSelf.Center)
//        .font(700, 50.px, Font.Space, Font.Grotesk, Font.SansSerif)
}
val MainContentStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .fillMaxWidth()
        .flexDirection(FlexDirection.Column)
        .justifyContent(JustifyContent.Center)
        .margin(top = 59.px)
}
val TextInputSectionStyle = CssStyle.base {
    Modifier
        .borderRadius(40.px)
        .display(DisplayStyle.Flex)
        .minHeight(355.px)
        .fillMaxWidth()
        .flexDirection(FlexDirection.Column)
        .overflow(Overflow.Hidden)
        .justifyContent(JustifyContent.Start)
        .padding(40.px, 30.px, 0.px)
}
val InputTextStyle = CssStyle.base {
    Modifier
        .gap(10.px)
        .color(Color.rgb(0x292929))
        .whiteSpace(WhiteSpace.NoWrap)
        .flex(1)
        .padding(10.px)
//        .font(400, 20.px, Font.Public, Font.Sans, Font.SansSerif)
        .fillMaxSize()
}
val CharacterCountStyle = CssStyle.base {
    Modifier
        .color(Color.rgba(0, 0, 0, 0.45f))
        .textAlign(TextAlign.Right)
//        .font(400, 16.px, Font.Public, Font.Sans, Font.SansSerif)
}
val ControlsContainerStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .fillMaxWidth()
        .flexDirection(FlexDirection.Column)
        .justifyContent(JustifyContent.Start)
        .padding(8.px, 0.px, 20.px, 20.px)
}
val SeparatorStyle = CssStyle.base {
    Modifier
        .minHeight(0.px)
        .fillMaxWidth()
        .border(2.px, LineStyle.Solid, Color.rgba(0, 0, 0, 0.05f))
}
val ActionButtonsStyle = CssStyle.base {
    Modifier
        .alignSelf(AlignSelf.Center)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .gap(20.px)
        .justifyContent(JustifyContent.Start)
        .margin(top = 20.px)
}
val ButtonGroupStyle = CssStyle.base {
    Modifier
        .alignSelf(AlignSelf.Stretch)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .gap(8.px)
        .color(Color.rgb(0x22215F))
        .justifyContent(JustifyContent.Center)
        .margin(autoLength, 0.px)
//        .font(400, 20.px, Font.Public, Font.Sans, Font.SansSerif)
}
val ButtonIconStyle = CssStyle.base {
    Modifier
        .alignSelf(AlignSelf.Stretch)
        .display(DisplayStyle.Flex)
        .margin(autoLength, 0.px)
        .border(3.px, LineStyle.Solid, Color.rgb(0x22215F))
        .size(20.px)
}
val SpaceIconContainerStyle = CssStyle.base {
    Modifier
        .alignSelf(AlignSelf.Stretch)
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .width(20.px)
        .margin(autoLength, 0.px)
}
val SpaceIconWrapperStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Column)
        .overflow(Overflow.Hidden)
        .justifyContent(JustifyContent.Center)
        .padding(5.px, 2.px)
        .border(3.px, LineStyle.Solid, Color.rgb(0x22215F))
}
val SpaceIconStyle = CssStyle.base {
    Modifier
        .backgroundColor(Color.rgb(0x22215F))
        .display(DisplayStyle.Flex)
        .size(10.px)
}
val SettingsSectionStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .fillMaxWidth()
        .alignItems(AlignItems.End)
        .gap(40.px, 80.px)
        .justifyContent(JustifyContent.Start)
        .flexWrap(FlexWrap.Wrap)
//        .font(20.px, Font.Public, Font.Sans, Font.SansSerif)
        .margin(top = 48.px)
}
val SettingsGroupStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .minWidth(240.px)
        .flexDirection(FlexDirection.Column)
        .whiteSpace(WhiteSpace.NoWrap)
        .justifyContent(JustifyContent.Center)
        .flex(1)
        .flexBasis(40.px)
}
val SettingsLabelStyle = CssStyle.base {
    Modifier
        .color(Color.rgb(0x274D0F))
        .fontWeight(700)
}
val SettingsInputStyle = CssStyle.base {
    Modifier
        .alignSelf(AlignSelf.Stretch)
        .borderRadius(20.px)
        .fillMaxWidth()
        .gap(10.px)
        .overflow(Overflow.Hidden)
        .color(Color.rgb(0x292929))
        .fontWeight(400)
        .padding(20.px)
        .margin(top = 10.px)
}
val ActionButtonStyle = CssStyle.base {
    Modifier
        .alignSelf(AlignSelf.Stretch)
        .borderRadius(20.px)
        .backgroundColor(Color.rgb(0x000000))
        .minWidth(240.px)
        .gap(10.px)
        .overflow(Overflow.Hidden)
        .color(Color.rgb(0xffffff))
        .fontWeight(700)
        .flex(1)
        .padding(20.px)
}
val OutputSectionStyle = CssStyle.base {
    Modifier
        .borderRadius(40.px)
        .display(DisplayStyle.Flex)
        .minHeight(200.px)
        .fillMaxWidth()
        .overflow(Overflow.Hidden)
        .justifyContent(JustifyContent.SpaceBetween)
        .flexWrap(FlexWrap.Wrap)
        .padding(32.px, 42.px)
        .margin(top = 48.px)
}
val OutputTextStyle = CssStyle.base {
    Modifier
        .color(Color.rgb(0x292929))
        .alignSelf(AlignSelf.Start)
//        .font(400, 20.px, Font.Public, Font.Sans, Font.SansSerif)
}
val IconContainerStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .minWidth(240.px)
        .alignItems(AlignItems.End)
        .gap(10.px)
        .justifyContent(JustifyContent.End)
        .fillMaxHeight()
        .flex(1)
        .flexBasis(0.percent)
}
