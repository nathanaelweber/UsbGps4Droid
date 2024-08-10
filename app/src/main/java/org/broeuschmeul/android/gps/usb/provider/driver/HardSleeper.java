package org.broeuschmeul.android.gps.usb.provider.driver;

import android.os.SystemClock;

import java.sql.Timestamp;

public class HardSleeper {
    public static void sleepHardMillisThrowing(int milliseconds_to_wait) throws InterruptedException {
        Thread.sleep(milliseconds_to_wait);
    }

    public static void sleepHardMillis(int milliseconds_to_wait) {
        SystemClock.sleep(milliseconds_to_wait);
    }

    public static void debuggableHardSleep(int milliseconds_to_wait, boolean use_standard_log) {
        if(use_standard_log) {
            System.out.println("START WAIT FOR "+milliseconds_to_wait+" MILLISECONDS");
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long start_milliseconds = timestamp.getTime();
        long end_milliseconds = start_milliseconds + milliseconds_to_wait;
        while (true) {
            Timestamp endtime = new Timestamp(System.currentTimeMillis());
            if ((endtime.getTime()) >= end_milliseconds) {
                break;
            }
        }
        if(use_standard_log) {
            System.out.println("END WAIT");
        }
    }
}
