/**
 * 468. Validate IP Address
 * <p>
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * <p>
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
 * each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * <p>
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * <p>
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
 * The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
 * so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * <p>
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity.
 * For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * <p>
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * <p>
 * Note: You may assume there is no extra space or special characters in the input string.
 * <p>
 * Example 1:
 * <p>
 * Input: "172.16.254.1"
 * <p>
 * Output: "IPv4"
 * <p>
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * <p>
 * Example 2:
 * <p>
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>
 * Output: "IPv6"
 * <p>
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * <p>
 * Example 3:
 * <p>
 * Input: "256.256.256.256"
 * <p>
 * Output: "Neither"
 * <p>
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
package com.chang.leetcode;

public class Problem468 {

    public String validIPAddress(String IP) {
        if (IP.endsWith(".") || IP.endsWith(":")) {
            return "Neither";
        }
        String[] splitDot = IP.split("[.]");
        String[] splitColon = IP.split("[:]");
        if (4 != splitDot.length && 8 != splitColon.length) {
            return "Neither";
        }

        if (4 == splitDot.length) {
            try {
                for (String s : splitDot) {
                    int parsedInt = Integer.valueOf(s);
                    if ((s.startsWith("0") && s.length() > 1) || s.length() == 0 ||
                            parsedInt < 0 || parsedInt > 255 ||
                            (parsedInt == 0 && s.charAt(0) != '0')) {
                        return "Neither";
                    }
                }
                return "IPv4";
            } catch (NumberFormatException ex) {
                return "Neither";
            }
        }

        if (8 == splitColon.length) {
            for (String s : splitColon) {
                if (s.length() > 4 || 0 == s.length() || null == str2HexStr(s)) {
                    return "Neither";
                }
            }
            return "IPv6";
        }

        return "Neither";
    }

    public String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        for (char c : str.toCharArray()) {
            if (!((c <= '9' && c >= '0') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                return null;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Problem468 problem = new Problem468();
        System.out.println("IPv4".equals(problem.validIPAddress("172.16.254.255")));
        System.out.println("IPv6".equals(problem.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")));
        System.out.println("Neither".equals(problem.validIPAddress("256.256.256.256")));
        System.out.println("Neither".equals(problem.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:")));
        System.out.println("Neither".equals(problem.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334")));
        System.out.println("Neither".equals(problem.validIPAddress("15.16.-0.1")));
        System.out.println("Neither".equals(problem.validIPAddress("0.0.0.-0")));
    }


}
