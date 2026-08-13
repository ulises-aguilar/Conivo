import { useState } from "react";
import {
    KeyboardAvoidingView,
    Platform, // tells app if it's ios or android
    ScrollView, // makes the form scrollable
    StyleSheet,
    Text,
} from "react-native";

import FormInput from "../../components/FormInput";
import PrimaryButton from "../../components/PrimaryButton";
import ScreenContainer from "@/components/ScreenContainer";
import {
    colors,
    fontSizes,
    spacing,
} from "../../constants/theme";

interface RegistrationErrors {
    email?: string;
    password?: string;
    confirmPassword?: string;
}

export default function RegisterScreen() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [errors, setErrors] = useState<RegistrationErrors>({});

    function validateForm(): boolean {
        const newErrors: RegistrationErrors = {};
        const normalizedEmail = email.trim().toLowerCase();

        if (!normalizedEmail) {
            newErrors.email = "College email is required.";
        } else if (!normalizedEmail.endsWith(".edu")) {
            newErrors.email = "Enter a valid college email ending in .edu.";
        }

        if (!password) {
            newErrors.password = "Password is required.";
        } else if (password.length < 8) {
            newErrors.password = "Password must contain at least 8 characters."
        }

        if (!confirmPassword) {
            newErrors.confirmPassword = "Confirm your password.";
        } else if (confirmPassword !== password) {
            newErrors.confirmPassword = "Passwords do not match";
        }

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    }

    function handleRegistration() {
        if (!validateForm()) {
            return;
        }
        // backend stuff 
    }

    return (
        <ScreenContainer style={styles.screen}>
            <KeyboardAvoidingView
                behavior={Platform.OS === "ios" ? "padding" : undefined}
                style={styles.keyboardView}
            >
                <ScrollView
                    contentContainerStyle={styles.content}
                    keyboardShouldPersistTaps="handled"
                >
                    <Text style={styles.title}>Create your account</Text>
                    <Text style={styles.subtitle}>Register using your college email.</Text>
                    
                    <FormInput
                        autoCapitalize="none"
                        autoComplete="email"
                        error={errors.email}
                        keyboardType = "email-address"
                        label = "College email"
                        onChangeText={setEmail}
                        placeholder="student@college.edu"
                        value={email}
                    />

                    <FormInput
                        autoCapitalize="none"
                        autoComplete="new-password"
                        error={errors.password}
                        label="Password"
                        onChangeText={setPassword}
                        placeholder="At least 8 characters"
                        secureTextEntry
                        value={password}
                    />

                    <FormInput
                        autoCapitalize="none"
                        autoComplete="new-password"
                        error={errors.confirmPassword}
                        label="Confirm passwrod"
                        onChangeText={setConfirmPassword}
                        placeholder="Enter your password again"
                        secureTextEntry
                        value={confirmPassword}
                    />

                    <PrimaryButton
                        title="Create Account"
                        onPress={handleRegistration}
                    />
                    </ScrollView>
                    </KeyboardAvoidingView>
                    </ScreenContainer>
    );
}

const styles = StyleSheet.create({
    screen: {
        padding: 0,
    },
    keyboardView: {
        flex: 1,
    },
    content: {
        flexGrow: 1,
        justifyContent: "center",
        padding: spacing.large,
    },
    title: {
        color: colors.text,
        fontSize: fontSizes.title,
        fontWeight: "bold",
        marginBottom: spacing.small,
    },
    subtitle: {
        color: colors.secondaryText,
        fontSize: fontSizes.body,
        marginBottom: spacing.extraLarge,
    },
});