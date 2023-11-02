import java.util.*;

class HandshakeCalculator {
    private static final Map<Integer, Signal> SIGNALS = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(1, Signal.WINK),
            new AbstractMap.SimpleEntry<>(10, Signal.DOUBLE_BLINK),
            new AbstractMap.SimpleEntry<>(100, Signal.CLOSE_YOUR_EYES),
            new AbstractMap.SimpleEntry<>(1000, Signal.JUMP)
    );

    List<Signal> calculateHandshake(int number) {
        String binaryString = Integer.toBinaryString(number);
        int binaryNumber = Integer.parseInt(binaryString);
        List<Signal> signals = new ArrayList<>();
        while (binaryNumber % 10_000 != 0) {
            int signalValue = findFirstSignalValue(binaryNumber);
            Signal signal = SIGNALS.get(signalValue);
            signals.add(signal);
            binaryNumber -= signalValue;
        }
        if (binaryNumber % 100_000 == 10_000) {
            Collections.reverse(signals);
        }
        return signals;
    }

    private int findFirstSignalValue(int binaryNumber) {
        if (binaryNumber % 10 == 1) {
            return 1;
        } else if (binaryNumber % 100 == 10) {
            return 10;
        } else if (binaryNumber % 1000 == 100) {
            return 100;
        } else if (binaryNumber % 10_000 == 1000) {
            return 1000;
        } else {
            return 0;
        }
    }



}
