import { StyleSheet, Text, View } from "react-native";

export default function VerifyEmailScreen() {
    return (
        <View style={styles.container}>
            <Text style={styles.title}>Verify your email</Text>
            <Text style={styles.message}>
                Check your college email for a verification link.
            </Text>
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
    },
    message: {
        fontSize: 16,
        marginTop: 12,
        textAlign: "center",
    },
});