package com.chang.generator.id;

public class SnowFlakeTest {

    public static void main(String[] args) {
/*        for(int i = 0; i < 1; i++) {
            System.out.println(SnowFlake.nextId());
        }*/
        String id = getUserOrderId();
        System.out.println(id);
    }

    private static String getUserOrderId() {
        try {
            long newId = SnowFlake.nextId();
            String id = String.valueOf(newId);
            long head = 8;
            if(id.length() < 18) {
                head = (long)(8 * Math.pow(10, 18 - id.length()));
            }
            return String.valueOf(String.valueOf(head) + id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
