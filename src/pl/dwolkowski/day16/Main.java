package pl.dwolkowski.day16;

import pl.dwolkowski.InputFileReader;

import java.util.*;

public class Main {
    private static int versionSum = 0;

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day16/input.txt");
        String line = hexToBin(file.loadStringList().get(0));
        Queue<Character> packet = new LinkedList<>(line.chars().mapToObj(c -> (char) c).toList());

        long packetValue = findValue(packet);
        System.out.println("Part 1: " + versionSum);
        System.out.println("Part 2: " + packetValue);
    }

    private static long findValue(Queue<Character> packet) {
        List<Long> packetValues = new ArrayList<>();
        int version = Integer.parseInt(getBits(packet, 3), 2);
        int typeId = Integer.parseInt(getBits(packet, 3), 2);
        versionSum += version;

        if (typeId == 4) {
            StringBuilder value = new StringBuilder();
            while (packet.poll() == '1')
                value.append(getBits(packet, 4));
            value.append(getBits(packet, 4));

            return Long.parseLong(value.toString(), 2);
        }
        else {
            char typeIdLength = packet.poll();

            if (typeIdLength == '0') {
                int packetLength = Integer.parseInt(getBits(packet, 15), 2);

                Queue<Character> innerPacket = new LinkedList<>();
                for (int i = 0; i < packetLength; i++)
                    innerPacket.add(packet.poll());

                while (!innerPacket.isEmpty())
                    packetValues.add(findValue(innerPacket));
            }
            else {
                int packetAmount = Integer.parseInt(getBits(packet, 11), 2);
                for (int i = 0; i < packetAmount; i++)
                    packetValues.add(findValue(packet));
            }
        }

        if (typeId == 0)
            return packetValues.stream().mapToLong(Long::longValue).sum();
        else if (typeId == 1) {
            long result = 1;
            for (long value : packetValues)
                result *= value;
            return result;
        }
        else if (typeId == 2)
            return Collections.min(packetValues);
        else if (typeId == 3)
            return Collections.max(packetValues);
        else if (typeId == 5)
            return packetValues.get(0) > packetValues.get(1) ? 1 : 0;
        else if (typeId == 6)
            return packetValues.get(0) < packetValues.get(1) ? 1 : 0;
        else if (typeId == 7)
            return packetValues.get(0).equals(packetValues.get(1)) ? 1 : 0;
        return 0;
    }

    private static String getBits(Queue<Character> packet, int amount) {
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < amount; i++)
            bits.append(packet.poll());

        return bits.toString();
    }

    private static String hexToBin(String line) {
        // Keep the leading zeros
        line = line.replaceAll("0", "0000");
        line = line.replaceAll("1", "0001");
        line = line.replaceAll("2", "0010");
        line = line.replaceAll("3", "0011");
        line = line.replaceAll("4", "0100");
        line = line.replaceAll("5", "0101");
        line = line.replaceAll("6", "0110");
        line = line.replaceAll("7", "0111");
        line = line.replaceAll("8", "1000");
        line = line.replaceAll("9", "1001");
        line = line.replaceAll("A", "1010");
        line = line.replaceAll("B", "1011");
        line = line.replaceAll("C", "1100");
        line = line.replaceAll("D", "1101");
        line = line.replaceAll("E", "1110");
        line = line.replaceAll("F", "1111");
        return line;
    }
}