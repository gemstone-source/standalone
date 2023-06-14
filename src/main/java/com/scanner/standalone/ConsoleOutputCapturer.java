package com.scanner.standalone;

import javafx.application.Platform;
import javafx.scene.control.Label;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleOutputCapturer {
    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    public static void setOutput(Label outputLabel) {
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Update the label with the captured output
        Platform.runLater(() -> outputLabel.setText(outputStream.toString()));
    }

    public static void restoreOutput() {
        System.setOut(originalOut);
    }
}
