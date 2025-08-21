public class haunted {
    public static void main(String[] args) throws InterruptedException {
        String[] messages = {
                "👁️ You shouldn't be here...",
                "💡 The lights are flickering...",
                "👀 Something is watching you...",
                "🏃 RUN.",
                "⏳ It's too late now."
        };

        String ghost =
                "     .-'      '-.\n" +
                        "   .' 👁️      👁️ '.\n" +
                        "  /   O      O     \\\n" +
                        " :           `    :\n" +
                        " |   👻            |\n" +
                        " :    .------.    :\n" +
                        "  \\  '        '  /\n" +
                        "   '.          .'\n" +
                        "     '-......-'";

//        clearConsole();
        System.out.println("🕯️ Welcome to the Haunted Terminal 🕯️\n");
        Thread.sleep(1500);

        for (String msg : messages) {
            flickerText(msg);
            Thread.sleep(1000 + (int)(Math.random() * 500));
        }

        System.out.println("\n" + ghost);
        System.out.println("\n👻 The ghost has appeared...");
    }

    private static void flickerText(String message) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println(message);
            Thread.sleep(150);
//            clearConsole();
            Thread.sleep(150);
        }
        System.out.println(message);
    }

//    private static void clearConsole() {
//        // Works on most terminals and IDEs
//        for (int i = 0; i < 30; ++i) System.out.println();
//    }
}
