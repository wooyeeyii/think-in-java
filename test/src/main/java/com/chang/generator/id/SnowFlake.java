package com.chang.generator.id;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SnowFlake {

    private final static long timestampBegin = 1564416000000L; // 2019-07-30 0:0:0

    // machine id bits
    private final static long machineIdBits = 5L;
    private static long machineIdMask = -1L ^ (-1L << machineIdBits);

    // process id bits
    private final static long threadIdBits = 5L;
    private static long threadIdMask = -1L ^ (-1L << threadIdBits);

    // sequence bits
    private final static long sequenceBits = 12L;
    private final static long sequenceMask = -1L ^ (-1L << sequenceBits);

    private final static long machineIdShift = sequenceBits;
    private final static long processIdShift = sequenceBits + machineIdBits;
    private final static long timestampLeftShift = sequenceBits + machineIdBits + threadIdBits;

    // last timestamp being used
    private static long lastTimestamp = -1L;
    private long machineId = 1L;
    private long threadId = 1L;
    private long sequence = 0L;

    private static SnowFlake snowFlake = null;

    static {
        snowFlake = new SnowFlake();
    }

    public static synchronized long nextId() {
        return snowFlake.getNextId();
    }

    private SnowFlake() {
        this.machineId = this.getMachineId();
        this.machineId = machineId & machineIdMask;

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.threadId = Long.valueOf(runtimeMXBean.getName().split("@")[0]).longValue();
        this.threadId = threadId & threadIdMask;
    }

    public synchronized long getNextId() {
        // get timestamp
        long timestamp = timeGen();
        // current timestamp must be larger than last timestamp
        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // if still in the same timestamp
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {    // sequence id has run out
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;

        // generate id
        long nextId = ((timestamp - timestampBegin) << timestampLeftShift) | (threadId << processIdShift) | (machineId << machineIdShift) | sequence;
        System.out.printf("timestamp = %d, threadId = %d, machineId = %d, sequence = %d",
                (timestamp - timestampBegin), (threadId), (machineId), sequence);
        System.out.println();
        return nextId;
    }

    /**
     * pause till next millisecond
     */
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }


    private long getMachineId() {
        long machinePiece;
        StringBuilder sb = new StringBuilder();
        Enumeration<NetworkInterface> e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        while (e.hasMoreElements()) {
            NetworkInterface ni = e.nextElement();
            sb.append(ni.toString());
        }
        machinePiece = sb.toString().hashCode();
        return machinePiece;
    }


}
