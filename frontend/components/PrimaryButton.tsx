import { Pressable, StyleSheet, Text } from "react-native";
import { borderRadius, colors, fontSizes, spacing } from "../constants/theme";

interface PrimaryButtonProps {
    title: string;
    onPress: () => void;
    disabled?: boolean;
}

export default function PrimaryButton({
    title,
    onPress,
    disabled = false,
}:  PrimaryButtonProps) {
    return (
        <Pressable
            disabled={disabled}
            onPress={onPress}
            style={({ pressed }) => [
                styles.button,
                pressed && styles.pressed,
                disabled && styles.disabled,
            ]}
            >
                <Text style={styles.text}>{title}</Text>
            </Pressable>
    );
}

const styles = StyleSheet.create({
    button: {
        alignItems: "center",
        backgroundColor: colors.primary,
        borderRadius: borderRadius.medium,
        paddingHorizontal: spacing.large,
        paddingVertical: spacing.medium,
        width: "100%",
    },
    pressed: {
        backgroundColor: colors.primaryPressed,
    },
    disabled: {
        opacity: 0.5,
    },
    text: {
        color: colors.white,
        fontSize: fontSizes.body,
        fontWeight: "600",
    },
});