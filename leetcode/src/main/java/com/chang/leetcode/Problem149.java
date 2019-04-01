package com.chang.leetcode;

import com.chang.common.MapUtil;
import com.chang.common.Point;

import java.util.HashMap;
import java.util.Map;

public class Problem149 {

    public int maxPoints(Point[] points) {
    /*
            遍历每个点，看它和后面的每个点构成的直线上有多少个点
            对每个点建立map，斜率是key
            斜率要用分数的形式，不要用double的形式存
            计算分数时先求分子分母的最大公约数gcd，再都除以gcd
            重合的点特殊处理
    */
    int l = points.length;
    if (l == 0) return 0;
    if (l <= 2) return l;
    int res = 0;
    for (int i = 0; i < l - 1; i++) {
        Map<String, Integer> map = new HashMap<>();
        int overlap = 0;
        int lineMax = 0;
        //计算点以后有多少个点和i点过线()
        for (int j = i + 1; j < l; j++) {
            int x = points[i].x - points[j].x;
            int y = points[i].y - points[j].y;
            if (x == 0 && y == 0) {
                overlap++;
                continue;
            }
            int gcd = generateGcd(x, y);
            x /= gcd;
            y /= gcd;
            // 用string来存储斜率
            String slope = String.valueOf(x) + "," + String.valueOf(y);
            //int count = map.getOrDefault(slope, 0);
            int count = MapUtil.getOrDefault(map, slope, 0);
            count++;
            map.put(slope, count);
            lineMax = Math.max(lineMax, count);
        }
        res = Math.max(res, lineMax + overlap + 1);
    }
    return res;
    }
    
    public int generateGcd(int x, int y) {
        if (y == 0) return x;
        return generateGcd(y, x % y);
    }
    
    public static void main(String[] args) {
        Point[] res = new Point[5];
        for(int i = 0; i < 3; i++) {
            Point point = new Point(i, i);
            res[i] = point;
        }
        Point point3 = new Point(0, 1);
        res[3] = point3;
        Point point4 = new Point(0, 1);
        res[4] = point4;
        
        Problem149 problem = new Problem149();
        //System.out.println(problem.maxPoints(res));
        
    }

}
