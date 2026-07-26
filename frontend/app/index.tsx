import { Link } from "expo-router";
import { StyleSheet, Text, View } from "react-native";

export default function WelcomeScreen() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Convio</Text>
      <Text style={styles.subtitle}>Connect with people at your college.</Text>

      <Link href="/auth/login" style={styles.link}>
        Log in
      </Link>

      <Link href="/auth/register" style={styles.link}>
        Create account
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
    fontSize: 40,
    fontWeight: "bold",
  },
  subtitle: {
    fontSize: 16,
    marginTop: 8,
    marginBottom: 32,
    textAlign: "center",
  },
  link: {
    fontSize: 18,
    marginVertical: 10,
    color: "#7C3AED",
  },
});