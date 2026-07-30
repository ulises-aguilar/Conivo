import type { ReactNode } from "react";
import { colors, spacing } from "../constants/theme";
import { StyleProp, StyleSheet, View, ViewStyle } from "react-native";

interface ScreenContainerProps {
    children: ReactNode; // contents inside the container
    style?: StyleProp<ViewStyle>; // additional style
}

export default function ScreenContainer({ children, style }: ScreenContainerProps) {
    return (
        <View style={[styles.container, style]}>
            {children}
        </View>
    )
}

const styles = StyleSheet.create({
    container: { // screen
        flex: 1,
        backgroundColor: colors.background,
        padding: spacing.large,
    },
});