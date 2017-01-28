package lesson09_threads.thrqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by IEvgen Boldyr on 24.06.16.
 * Project: OOP - Base002
 */

public class ThreadSafe {

    private static class Safe {
        private Queue<String> queue = new ArrayDeque<String>();
        private static Safe safe;

        public static Safe getSafe() {
            if (safe == null) {
                safe = new Safe();
                return safe;
            }
            return safe;
        }

        public Queue<String> getSafeQueue() {
            return queue;
        }
    }

    public synchronized void add(String value) {
        Safe safe = Safe.getSafe();
        Queue<String> queue = safe.getSafeQueue();
        queue.add(value);
    }

    public synchronized String get() {
        Safe safe = Safe.getSafe();
        Queue<String> queue = safe.getSafeQueue();
        return queue.poll();
    }

    public synchronized Integer size() {
        Safe safe = Safe.getSafe();
        Queue<String> queue = safe.getSafeQueue();
        return queue.size();
    }
}
