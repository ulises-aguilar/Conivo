import { Link } from "expo-router";
import { useState } from "react";
import { StyleSheet, Text, Alert } from "react-native";
import FormInput from "@/components/FormInput";
import PrimaryButton from "@/components/PrimaryButton";
import ScreenContainer from "@/components/ScreenContainer";
import { colors, fontSizes, spacing } from "@/constants/theme";

interface LoginErrors {
    email?: string;
    password?: string;
}

export default function LoginScreen() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [errors, setErrors] = useState<LoginErrors>({});

    function validateForm(): boolean {
        const newErrors: LoginErrors = {};
        const normalizedEmail = email.trim().toLowerCase();

        if (!normalizedEmail) {
            newErrors.email = "College email is required.";
        } else if (!normalizedEmail.endsWith(".edu")) {
            newErrors.email = "Enter a valid college email ending in .edu";
        }
        if (!password) {
            newErrors.password = "Password is required.";
        }
        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    }
    
    function handleLogin() {
        if (!validateForm()) {
            return;
        }
        const normalizedEmail = email.trim().toLowerCase();

        // This is temporary till the endpoint on the backend is ready.......

        Alert.alert(
            "Form valid",
            `Ready to log in as ${normalizedEmail}`,
        );
    }
    return (
        <ScreenContainer style={styles.container}>
            <Text style={styles.title}>Log In</Text>

            <FormInput
                label="College email"
                placeholder="student@college.edu"
                value={email}
                onChangeText={setEmail}
                error={errors.email}
                keyboardType="email-address"
                autoCapitalize="none"
                autoCorrect={false}
            />
            <FormInput
                label="Password"
                placeholder="Enter your password"
                value={password}
                onChangeText={setPassword}
                error={errors.password}
                secureTextEntry
                autoCapitalize="none"
            />

            <PrimaryButton
                title="Log In"
                onPress={handleLogin}
            />

            <Link href="/auth/login" style={styles.link}>
                Don&apos;t have an account? Register
            </Link>

            <Link href="/" style={styles.backLink}>
                Back to Welcome
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
        marginBottom: spacing.large,
    },
    link: {
        color: colors.primary,
        marginTop: spacing.large,
    },
    backLink: {
        color: colors.secondaryText,
        marginTop: spacing.medium,
    },
});