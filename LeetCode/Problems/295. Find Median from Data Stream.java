// https://leetcode.com/problems/find-median-from-data-stream/
class MedianFinder {

    /** initialize your data structure here. */

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }

    public void balanceHeaps() {

        if (maxHeap.size() == minHeap.size())
            return;

        int diff = Math.abs(maxHeap.size() - minHeap.size());

        if (diff > 1) {

            if (maxHeap.size() > minHeap.size()) {

                minHeap.add(maxHeap.remove());

            } else {

                maxHeap.add(minHeap.remove());

            }
        }

    }

    public void addNum(int num) {

        if (maxHeap.isEmpty()) {

            maxHeap.add(num);
            return;

        }

        if (num >= maxHeap.peek()) {

            minHeap.add(num);

        } else {

            maxHeap.add(num);
        }

        balanceHeaps();

    }

    public double findMedian() {

        if (minHeap.isEmpty() && maxHeap.isEmpty())
            return -1;

        if (minHeap.size() == maxHeap.size()) {

            return (minHeap.peek() + maxHeap.peek()) / 2.0;

        }

        if (maxHeap.size() > minHeap.size()) {

            return maxHeap.peek();

        }

        return minHeap.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */