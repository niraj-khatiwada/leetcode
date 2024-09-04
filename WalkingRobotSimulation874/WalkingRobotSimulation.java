
package WalkingRobotSimulation874;

import java.util.HashSet;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        var obs = new HashSet<Integer>();
        for (var coord : obstacles) {
            obs.add(this._flat(coord));
        }
        var pos = new int[] { 0, 0 };
        var dir = 90;
        var max = 0;
        for (var comm : commands) {
            if (comm == -1 || comm == -2) {
                dir = _changeDirection(dir, comm);
            } else {
                for (var i = 0; i < comm; i++) {
                    var next = _move(pos, dir, 1);
                    if (obs.contains(this._flat(next))) {
                        break;
                    } else {
                        pos[0] = next[0];
                        pos[1] = next[1];
                    }
                }
                max = Math.max(max, pos[0] * pos[0] + pos[1] * pos[1]);
            }
        }
        return max;
    }

    private int _changeDirection(int dir, int turn) {
        if (turn == -1) {
            if (dir == 0) {
                return 270;
            }
            return dir - 90;
        }
        if (dir == 270) {
            return 0;
        }
        return dir + 90;
    }

    private int[] _move(int[] coord, int dir, int step) {
        var moved = new int[] { coord[0], coord[1] };
        if (dir == 90) {
            moved[1] += step;
            return moved;
        } else if (dir == 180) {
            moved[0] -= step;
            return moved;
        } else if (dir == 270) {
            moved[1] -= step;
            return moved;
        }
        moved[0] += step;
        return moved;
    }

    private int _flat(int[] coord) {
        var maxY = 2 * (int) 3e4 + 1;
        return coord[1] * maxY + coord[0];
    }
}