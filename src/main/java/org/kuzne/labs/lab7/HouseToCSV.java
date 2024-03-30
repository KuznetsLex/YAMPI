package org.kuzne.labs.lab7;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HouseToCSV {
    private static final String CSV_SEPARATOR = ";";
    public static void writeToCSV(House house)
    {
        try
        {
            String filename = String.format("src/main/java/org/kuzne/labs/lab7/house_%d.csv", house.getCadastralNumber());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8));

            StringBuilder oneLine = new StringBuilder();
            oneLine.append("Данные о доме");
            bw.write(oneLine.toString());
            bw.newLine();

            oneLine = new StringBuilder();
            oneLine.append("Кадастровый номер: ");
            oneLine.append(house.getCadastralNumber());
            bw.write(oneLine.toString());
            bw.newLine();

            oneLine = new StringBuilder();
            oneLine.append("Адрес: ");
            oneLine.append(house.getAdress());
            bw.write(oneLine.toString());
            bw.newLine();

            oneLine = new StringBuilder();
            oneLine.append("Старший по дому: ");
            oneLine.append(house.getHouseElder().getSurname());
            oneLine.append(" ");
            oneLine.append(house.getHouseElder().getName());
            oneLine.append(" ");
            oneLine.append(house.getHouseElder().getPatronimic());
            bw.write(oneLine.toString());
            bw.newLine();

            oneLine = new StringBuilder();
            bw.write(oneLine.toString());
            bw.newLine();

            oneLine = new StringBuilder();
            oneLine.append("Данные о квартирах");
            bw.write(oneLine.toString());
            bw.newLine();

            oneLine = new StringBuilder();
            oneLine.append("№");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Площадь, кв. м");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Владельцы");
            bw.write(oneLine.toString());
            bw.newLine();

            for (Flat flat : house.getFlatList()) {
                oneLine = new StringBuilder();
                oneLine.append(flat.getNumber());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(flat.getSquare());
                oneLine.append(CSV_SEPARATOR);
                for (int i = 0; i < flat.getOwners().size(); i++) {
                    oneLine.append(flat.getOwners().get(i).getSurname());
                    oneLine.append(" ");
                    oneLine.append(flat.getOwners().get(i).getName());
                    oneLine.append(" ");
                    oneLine.append(flat.getOwners().get(i).getPatronimic());
                    if (i < flat.getOwners().size()-1) {
                        oneLine.append(", ");
                    }
                }
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
