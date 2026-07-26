import { Link } from "expo-router";
import { StyleSheet, Text, View } from "react-native";

export default function RegisterScreen() {
    return (
        <View style={styles.container}>
            <Text style={styles.title}>Create account</Text>

            <Link href="/auth/verify-email">
                Continue to email verification
            </Link>

            <Link href="/" style={styles.backLink}>
                Back to Welcome
            </Link>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        padding: 24,
    },
    title: {
        fontSize: 32,
        fontWeight: "bold",
        marginBottom: 24,
    },
    link: {
        color: "#7C3AED",
        marginBottom: 16,
    },
    backLink: {
        color: "#55555",
    },
});