package com.chang.prototype.example.sage;

import java.io.Serializable;

public class GoldRingedStaff implements Serializable {

    private static final long serialVersionUID = -8336494749477006718L;
    private float height = 100.0f;
    private float diameter = 10.0f;

    /**
     * ������Ϊ��ÿ�ε��ó��ȺͰ뾶����һ��
     */
    public void grow() {
        this.diameter *= 2;
        this.height *= 2;
    }

    /**
     * ��С��Ϊ��ÿ�ε��ó��ȺͰ뾶����һ��
     */
    public void shrink() {
        this.diameter /= 2;
        this.height /= 2;
    }

}
