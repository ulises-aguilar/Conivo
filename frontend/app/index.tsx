import { Link } from "expo-router";
import { StyleSheet, Text, View } from "react-native";
import { colors, fontSizes, spacing } from "../constants/theme";

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
    backgroundColor: colors.background,
    padding: spacing.large,
  },
  title: {
    color: colors.primary,
    fontSize: fontSizes.display,
    fontWeight: "bold",
  },
  subtitle: {
    color: colors.mutedText,
    fontSize: fontSizes.body,
    marginTop: spacing.small,
    marginBottom: spacing.extraLarge,
    textAlign: "center",
  },
  link: {
    color: colors.primary,
    fontSize: fontSizes.subtitle,
    marginBottom: spacing.medium,
  },
});