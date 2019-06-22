package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop
{
    public int count = 0;
    public Goods goods;
    public String[] secretData;
    public double profit = 0;


    static class Goods
    {
        List<String> names = new ArrayList<>();
    }
}