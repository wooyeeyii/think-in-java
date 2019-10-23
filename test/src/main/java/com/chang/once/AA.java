package com.chang.once;


public class AA {

    private Long aa;

    private String bb;

    private Integer cc;

    public Long getAa() {
        return aa;
    }

    public void setAa(Long aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "AA{" +
                "aa=" + aa +
                ", bb='" + bb + '\'' +
                ", cc=" + cc +
                '}';
    }
}
