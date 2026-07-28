import { Link } from "expo-router";
import { StyleSheet, Text, View } from "react-native";

export default function LoginScreen() {
    return (
        <View style={styles.container}>
            <Text style={styles.title}>Log In</Text>

            <Link href="/auth/register">
                Don&apos;t have an account? Register
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