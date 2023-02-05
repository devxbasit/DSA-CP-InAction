// https://leetcode.com/problems/gas-station/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int remainingPetrol = 0;

        int shortOf = 0;

        int front = 0;
        int rear = 0;

        while (rear < gas.length) {

            if (remainingPetrol + gas[rear] >= cost[rear]) {

                remainingPetrol += gas[rear] - cost[rear];

                rear++;
                continue;

            }

            shortOf += (remainingPetrol + gas[rear]) - cost[rear];

            front = rear + 1;
            rear = rear + 1;

            // reset
            remainingPetrol = 0;

        }

        return (shortOf + remainingPetrol >= 0) ? front : -1;

    }
}