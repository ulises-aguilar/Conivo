import { router } from "expo-router";
import { StyleSheet, Text, View } from "react-native";
import { colors, fontSizes, spacing } from "../constants/theme";
import PrimaryButton from "@/components/PrimaryButton";
import ScreenContainer from "@/components/ScreenContainer";

export default function WelcomeScreen() {
  return (
    <ScreenContainer style={styles.container}>
      <Text style={styles.title}>Convio</Text>
      <Text style={styles.subtitle}>Connect with people at your college.</Text>
      
      <PrimaryButton
        title= "Create Account"
        onPress={() => router.push("/auth/register")}
      />

      <Text
        style={styles.login}
        onPress={() => router.push("/auth/login")}
      >
        Already have an account? Log in
      </Text>
    </ScreenContainer>
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
    color: colors.secondaryText,
    fontSize: fontSizes.body,
    marginTop: spacing.small,
    marginBottom: spacing.extraLarge,
    textAlign: "center",
  },
  login: {
    color: colors.primary,
    fontSize: fontSizes.body,
    marginTop: spacing.large,
  },
});