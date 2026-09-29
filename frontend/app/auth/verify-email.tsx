import { StyleSheet, Text, Alert } from "react-native";
import { Link, useLocalSearchParams } from "expo-router";
import PrimaryButton from "@/components/PrimaryButton";
import ScreenContainer from "@/components/ScreenContainer";

import { colors, fontSizes, spacing } from "@/constants/theme";


export default function VerifyEmailScreen() {
    const { email } = useLocalSearchParams<{ email?: string }>();
    function handleResendLogin() {
        // Actual backend resend request will go here later.
        Alert.alert("Soon to be implemented.");
    }

    return (
        <ScreenContainer style={styles.container}>
            <Text style={styles.title}> Verify your email </Text>
            <Text style={styles.message}>
                We sent a verification link to: 
            </Text>

            <Text style={styles.email}>
                {email ?? "college email"}
            </Text>
            <Text style={styles.instructions}>
                Open the email and follow the link to verify your Convio account.
            </Text>

            <PrimaryButton
                title="Resend Verification Email"
                onPress={handleResendLogin} />
            
            <Link href="/auth/register" style={styles.link}>
                Change email
            </Link>

            <Link href="/auth/login" style={styles.link}>
                Back to Log In
            </Link>
        </ScreenContainer>
    );
}

const styles = StyleSheet.create({
    container: {
        justifyContent: "center",
        alignItems: "center",
    },
    title: {
        color: colors.text,
        fontSize: fontSizes.title,
        fontWeight: "bold",
        marginBottom: spacing.medium,
        textAlign: "center",
    },
    message: {
        color: colors.secondaryText,
        fontSize: fontSizes.body,
        textAlign: "center",
    },
    email: {
        color: colors.primary,
        fontSize: fontSizes.body,
        fontWeight: "600",
        marginTop: spacing.small,
    },
    instructions: {
        color: colors.secondaryText,
        fontSize: fontSizes.body,
        marginBottom: spacing.extraLarge,
        marginTop: spacing.medium,
        textAlign: "center",
    },
    link: {
        color: colors.primary,
        fontSize: fontSizes.body,
        marginTop: spacing.medium,
    },
});