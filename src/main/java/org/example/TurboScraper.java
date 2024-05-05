package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TurboScraper {
    private static int rowNum = 0;
    private static int count = 0;

    public static void main(String[] args) {

        StringBuilder url = new StringBuilder("https://turbo.az/autos");
//        List<Car> cars=new ArrayList<>();
        try {

            if (Files.exists(Path.of("count.txt"))) {
                BufferedReader reader = new BufferedReader(new FileReader("count.txt"));
                count = Integer.parseInt(reader.readLine());
                rowNum = Integer.parseInt(reader.readLine());
                reader.close();
            }
            for (int i = 0; i < 5; i++) {
                count++;
                if (count != 1) {
                    url.append("?page=").append(count);
                }
                Document document = Jsoup.connect(String.valueOf(url)).get();
                Elements cars = document.select(".products-i");

                for (Element car : cars) {
                    String carLink = car.select(".products-i__link").attr("href");
                    System.out.println(carLink);

                    Document carDetails = Jsoup.connect("https://turbo.az" + carLink).get();

                    Elements details = carDetails.select(".product-properties__column");

                    Car newCar = new Car();

                    for (Element detail : details) {
                        Elements labelTags = detail.select("label");

                        for (Element label : labelTags) {
                            String value = label.parent().select(".product-properties__i-value").text();
                            newCar.setPrice(car.select(".product-price").text());
                            newCar.setLink(carLink);
                            switch (label.text()) {
                                case "Şəhər":
                                    newCar.setCity(value);
                                    break;
                                case "Marka":
                                    newCar.setBrand(value);
                                case "Model":
                                    newCar.setModel(value);
                                    break;
                                case "Buraxılış ili":
                                    newCar.setReleaseYear(value);
                                    break;
                                case "Ban növü":
                                    newCar.setCategory(value);
                                    break;
                                case "Rəng":
                                    newCar.setColor(value);
                                    break;
                                case "Mühərrik":
                                    newCar.setEngine(value);
                                    break;
                                case "Yürüş":
                                    newCar.setMileage(value);
                                    break;
                                case "Sürətlər qutusu":
                                    newCar.setTransmission(value);
                                    break;
                                case "Ötürücü":
                                    newCar.setGear(value);
                                    break;
                                case "Yeni":
                                    newCar.setNew_(value);
                                    break;
                                case "Yerlərin sayı":
                                    newCar.setSeatCount(value);
                                    break;
                                case "Sahiblər":
                                    newCar.setOwners(value);
                                    break;
                                case "Vəziyyəti":
                                    newCar.setCondition(value);
                                    break;
                                case "Hansı bazar üçün yığılıb":
                                    newCar.setMarket(value);
                            }
                        }
                    }


                    //NOTE:Car obyektlerini bir-bir elave elemeyimin sebebi sehifeye gore Liste atib etdikde
                    //1 sehife tamamlanmamis kodu saxladiqda excele yazmir
                    writeToExcel(newCar, "cars.xlsx");
                    BufferedWriter writer = new BufferedWriter(new FileWriter("count.txt"));

                    writer.write(Integer.toString(count));
                    writer.newLine();
                    writer.write(Integer.toString(rowNum));
                    writer.close();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeToExcel(Car car, String fileName) throws IOException {
        Workbook workbook = null;
        Sheet sheet = null;
        if (Files.exists(Path.of(fileName))) {
            FileInputStream inputStream = new FileInputStream(new File(fileName));
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(0);
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Cars");
            Row headerRow = sheet.createRow(rowNum++);
            String[] headers = {"Link", "Şəhər", "Marka", "Model", "Buraxılış ili", "Ban növü", "Rəng", "Mühərrik", "Yürüş(km)",
                    "Sürət qutusu", "Ötürücü", "Yeni", "Yerlərin Sayı", "Sahiblər", "Bazar", "Vəziyyət", "Qiymət",};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }
        }

        Row row = sheet.createRow(rowNum++);
        int cellNum = 0;
        boolean check = true;
        for (int i = 1; i < row.getRowNum(); i++) {

            if (sheet.getRow(1).getCell(0)==null) {
                check = true;
            } else {
                if (sheet.getRow(i).getCell(0).getStringCellValue().equals(car.getLink())) {
                    check = false;
                    rowNum--;
                    break;
                }
            }
        }
        if (check) {
            row.createCell(cellNum++).setCellValue(car.getLink());
            row.createCell(cellNum++).setCellValue(car.getCity());
            row.createCell(cellNum++).setCellValue(car.getBrand());
            row.createCell(cellNum++).setCellValue(car.getModel());
            row.createCell(cellNum++).setCellValue(car.getReleaseYear());
            row.createCell(cellNum++).setCellValue(car.getCategory());
            row.createCell(cellNum++).setCellValue(car.getColor());
            row.createCell(cellNum++).setCellValue(car.getEngine());
            row.createCell(cellNum++).setCellValue(car.getMileage());
            row.createCell(cellNum++).setCellValue(car.getTransmission());
            row.createCell(cellNum++).setCellValue(car.getGear());
            row.createCell(cellNum++).setCellValue(car.getNew_());
            row.createCell(cellNum++).setCellValue(car.getSeatCount());
            row.createCell(cellNum++).setCellValue(car.getOwners());
            row.createCell(cellNum++).setCellValue(car.getMarket());
            row.createCell(cellNum++).setCellValue(car.getCondition());
            row.createCell(cellNum++).setCellValue(car.getPrice());
        }
        try {
            OutputStream outputStream = new FileOutputStream(new File(fileName));
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
//