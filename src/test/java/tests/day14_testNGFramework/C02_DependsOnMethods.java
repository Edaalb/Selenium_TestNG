package tests.day14_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    //sıra kendisine geldiğinde önce bağlı olduğu methodları test eder
    //eğer bağlı olduğu method çalışmıyorsa o da çalışmaz

    //normalde TestNG harf sırasına göre çalışır ancak dependsOn dediğimizde
    //bağımlılık sırasına göre çalışır

    //başka bir teste bağlı olan testi tek başına çalıştıramayız

    //bağlı olunan test failed olursa diğeri ignore edilir, hiç çalıştırılmayı denemez
""
    @Test(priority = -3)
    public void ilkTest(){
        System.out.println("Ilk test calisti");
        Assert.assertTrue(5>9);
    }

    @Test(dependsOnMethods = "ilkTest")
    public void ikinciTest(){
        System.out.println("Ikinci test calisti");
    }

    @Test(dependsOnMethods = "ikinciTest")
    public void ucuncuTest(){
        System.out.println("Ucuncu test calisti");
    }
}
