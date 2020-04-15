package com.chang.prototype.example.sage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Monkey implements Cloneable, Serializable {

    private static final long serialVersionUID = 5710803629060239236L;
    //���
    private int height;
    //����
    private int weight;
    //����
    private Date birthDate;
    //�𹿰�
    private GoldRingedStaff staff;

    /**
     * ���캯��
     */
    public Monkey() {
        this.birthDate = new Date();
        this.staff = new GoldRingedStaff();
    }

    /**
     * ��¡����
     */
    public Object clone() {
        Monkey temp = null;
        try {
            temp = (Monkey) super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return temp;
    }

    //�������л�ʵ����ȿ�¡
    public Object deepClone() throws IOException, ClassNotFoundException {
        //������д������
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //�����������
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public GoldRingedStaff getStaff() {
        return staff;
    }

    public void setStaff(GoldRingedStaff staff) {
        this.staff = staff;
    }

}
