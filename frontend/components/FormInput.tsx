import { StyleSheet, Text, TextInput, type TextInputProps, View } from "react-native";
import { borderRadius, colors, fontSizes, spacing } from "../constants/theme";

interface FormInputProps extends TextInputProps {
    label: string;
    error?: string;
}

export default function FormInput({
    // ...textInputProps just means you can add more properties
    // later and it will separate and accept each property.
    // Instead of manually listing all the different properties.
    label,
    error,
    style,
    ...textInputProps}: FormInputProps) {
        return (
            <View style={styles.container}>
                <Text style={styles.label}>{label}</Text>

                <TextInput
                    style={[
                        styles.input,
                        error ? styles.inputError: undefined, style,
                    ]}
                    placeholderTextColor={colors.secondaryText}
                    {...textInputProps} />
                    {error ? <Text style={styles.error}>{error}</Text> : null}
            </View>
    );
}

const styles = StyleSheet.create({
    container: {
        marginBottom: spacing.medium,
        width: "100%",
    },
    label: {
        color: colors.text,
        fontSize: fontSizes.body,
        fontWeight: "600",
        marginBottom: spacing.small,
    },
    input: {
        borderColor: colors.border,
        borderRadius: borderRadius.medium,
        borderWidth: 1,
        color: colors.text,
        fontSize: fontSizes.body,
        paddingHorizontal: spacing.medium,
        paddingVertical: spacing.medium,
    },
    inputError: {
        borderColor: colors.error,
    },
    error: {
        color: colors.error,
        fontSize: fontSizes.small,
        marginTop: spacing.extraSmall,
    },
});