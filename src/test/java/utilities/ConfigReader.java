package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

    //bu bir java class'ıdır

    //olşturduğumuz proporties file'ına ulaşabilmek için bu class'ı kullanacağız
    //bundan dolayı properties object'i oluştururuz
    static Properties properties;
    //main method'a ihtiyacımız olmadan değer ataması yapmamız gerekmektedir
    //bu class çalışır çalışmaz properties object'ine bir değer atması için,
    //herkesten önce çalışması için stactic block oluştururuz.
    //bu bloklar main method'dan da önce çalışırlar
    //static block'un amacı proporties object'ine configuration.proporties'deki bilgileri yüklemektir

    static {

        String dosyaYolu = "configuration.properties";

        try { //dosyayı okuyamama ihtimaline karşı try/catch ile çevreleriz

            FileInputStream fis = new FileInputStream(dosyaYolu);
            //fileInput ile conf.prop file'ındaki tüm bilgileri yükleriz

            properties = new Properties();
            properties.load(fis);


        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");

        }
        //buraya oradaki ayırmadan tüm bilgiler yüklendi
        //alt kısımda yüklenen tüm bilgilerden gönderdiğimiz key ile ilgili ne varsa
        //bize onun karşılığını döndürecek
    }
    public static String getProperty(String key){

        return properties.getProperty(key);
        //proporties'te yüklediğimiz key'in karşılığını bize döndürür
    }
}
